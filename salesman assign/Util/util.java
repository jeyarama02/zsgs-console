package tki.WebmasterInterview.Util;

import tki.WebmasterInterview.dto.Lead;
import tki.WebmasterInterview.dto.Salesforce;

import java.util.*;

public class util {
    private  Scanner sc;
   public List<Salesforce> salesforces;
   public  List<Lead> lead;
    static int capacity=0;
    static int id=1;
    static int lid=1;
    public util(Scanner sc)
    {
        this.sc=sc;
        salesforces=new ArrayList<>();
        lead=new ArrayList<>();
    }

    Map<Integer,List<String>> productmap=new HashMap<>();
    Map<Integer,List<String>> countrymap=new HashMap<>();
    Map<Integer,Salesforce> salesforceMap=new HashMap<>();


    public void getInputSales(int ns)
    {


        System.out.println("salesforce");

        for(int i=1;i<=ns;i++)
        {
            System.out.println("enter anything to continue");
            sc.nextLine();
            System.out.println("enter the name");
            String name=sc.nextLine();
            List<String> countries=new ArrayList<>();
            String country="";
            while(!country.equals("exit")) {
                System.out.println("enter the country or exit");
                country = sc.nextLine().toLowerCase();
                countries.add(country);
            }
            countries.remove(countries.size()-1);

            List<String> products=new ArrayList<>();
            String product="";
            while(!product.equals("exit")) {
                System.out.println("enter the product or exit");
                product = sc.nextLine().toLowerCase();
                products.add(product);
            }
             products.remove(products.size()-1);

            if(products.isEmpty()||countries.isEmpty())
            {
                i--;
                continue;
            }
            countrymap.put(id,countries);
            productmap.put(id,products);
            boolean isActive=true;
            System.out.println("enter the active status 0 / any number");
            int n=sc.nextInt();
            if(n==0) isActive=false;
            int limit=-1;
            while(limit<0||limit>100) {
                System.out.println("enter the total limit");
                limit = sc.nextInt();
                limit=limit/10;
            }
            sc.nextLine();

            salesforceMap.put(id,new Salesforce(id,name,countries,products,isActive,limit,0));
            salesforces.add(new Salesforce(id++,name,countries,products,isActive,limit,0));
        }
        capacity=id-1;


    }

    public void getInputLead(int nl)
    {

        System.out.println("lead");

        for(int i=1;i<=nl;i++)
        {
            System.out.println("enter anything to continue");
            sc.nextLine();
            System.out.println("enter the name");
            String name=sc.nextLine();

            System.out.println("enter the country");
            String country = sc.nextLine().toLowerCase();
            System.out.println("enter the product");
            String product = sc.nextLine().toLowerCase();
            lead.add(new Lead(lid++,name,product,country));
//            System.out.println("success");
        }

    }
    public void sales()
    {

        salesforces.add(new Salesforce(1,"s1",new ArrayList<>(Arrays.asList("crm","desk")),new ArrayList<>(Arrays.asList("india","usa")),true,2,0));
        countrymap.put(1,new ArrayList<>(Arrays.asList("india","usa")));
        productmap.put(1,new ArrayList<>(Arrays.asList("crm","desk")));
        salesforceMap.put(1,new Salesforce(1,"s1",new ArrayList<>(Arrays.asList("crm","desk")),new ArrayList<>(Arrays.asList("india","usa")),true,2,0));

        salesforces.add(new Salesforce(2,"s2",new ArrayList<>(Arrays.asList("crm","desk")),new ArrayList<>(Arrays.asList("india")),true,2,0));
        countrymap.put(2,new ArrayList<>(Arrays.asList("india")));
        productmap.put(2,new ArrayList<>(Arrays.asList("crm","desk")));
        salesforceMap.put(2,new Salesforce(2,"s2",new ArrayList<>(Arrays.asList("crm","desk")),new ArrayList<>(Arrays.asList("india")),true,2,0));

        salesforces.add(new Salesforce(3,"s3",new ArrayList<>(Arrays.asList("webmaste","desk")),new ArrayList<>(Arrays.asList("india","usa","australia")),true,1,0));
        countrymap.put(3,new ArrayList<>(Arrays.asList("india","usa","australia")));
        productmap.put(3,new ArrayList<>(Arrays.asList("webmaster","desk")));
        salesforceMap.put(3,new Salesforce(3,"s3",new ArrayList<>(Arrays.asList("webmaste","desk")),new ArrayList<>(Arrays.asList("india","usa","australia")),true,1,0));
        capacity=3;
    }
    public void leads()
    {

        lead.add(new Lead(1,"p1","desk","india"));
        lead.add(new Lead(2,"p2","crm","usa"));
        lead.add(new Lead(3,"p3","crm","india"));
        lead.add(new Lead(4,"p4","webmaster","australia"));
        lead.add(new Lead(5,"p5","desk","usa"));

    }
    public void assignRoundRobin() {
       // System.out.println(capacity);
        if(capacity==0)
        {
            System.out.println("no sales available");
            return;
        }

        int pointer=1;

        for (int i = 0; i < lead.size(); i++)
        {
            String country=lead.get(i).getCountry();
            String product=lead.get(i).getProduct();

            if(capacity==1)
            {
                int index=1;
                if(salesforceMap.get(index).isActive()&&productmap.get(index).contains(product)&&countrymap.get(index).contains(country))
                {
                    lead.get(i).setSalesforce(salesforceMap.get(index));
                }
                continue;

            }
            int before=pointer;
            int after=-1;
            System.out.println(pointer);
            while(before!=after)
            {
                int index=before;
                if(before==0)
                    index=capacity;
                if(salesforceMap.get(index).isActive()&&productmap.get(index).contains(product)&&countrymap.get(index).contains(country))
                {
                    lead.get(i).setSalesforce(salesforceMap.get(index));
                    pointer=(before+1)%capacity;
                    break;
                }
                before=(before+1)%capacity;
                after=pointer;
            }
        }
        //System.out.println("exiting/..");
    }

    public void print()
    {
        for(int i=0;i<lead.size();i++)
        {
            System.out.println(lead.get(i).toString());
        }
    }

    public void assignPercentage()
    {
        if(capacity==0)
        {
            return;
        }
        int pointer=1;

        for (int i = 0; i < lead.size(); i++)
        {
            String country=lead.get(i).getCountry();
            String product=lead.get(i).getProduct();

            if(capacity==1)
            {
                int index=1;
                if(salesforceMap.get(index).isActive()&&salesforceMap.get(index).getCurrentlimit()!=salesforceMap.get(index).getTotallimit()&&productmap.get(index).contains(product)&&countrymap.get(index).contains(country))
                {
                    lead.get(i).setSalesforce(salesforceMap.get(index));
                    salesforceMap.get(index).setCurrentlimit(salesforceMap.get(index).getCurrentlimit()+1);
                    if(salesforceMap.get(index).getCurrentlimit()==salesforceMap.get(index).getTotallimit()) {
                        salesforceMap.get(index).setCurrentlimit(0);

                    }

                }
                continue;

            }
            int before=pointer;
            int after=-1;

            while(before!=after)
            {
                int index=before;
                if(before==0)
                    index=capacity;
                if(salesforceMap.get(index).isActive()&&salesforceMap.get(index).getCurrentlimit()!=salesforceMap.get(index).getTotallimit()&&productmap.get(index).contains(product)&&countrymap.get(index).contains(country))
                {
                    lead.get(i).setSalesforce(salesforceMap.get(index));
                    salesforceMap.get(index).setCurrentlimit(salesforceMap.get(index).getCurrentlimit()+1);
                    if(salesforceMap.get(index).getCurrentlimit()==salesforceMap.get(index).getTotallimit()) {
                        pointer = (before + 1) % capacity;
                        salesforceMap.get(index).setCurrentlimit(0);

                    }
                    break;
                }
                before=(before+1)%capacity;
                after=pointer;
            }

        }

    }
    public Lead assignDirect()
    {
        getInputLead(1);
        Lead leads=lead.get(0);
        int salesid=-1;
        while(true) {
            System.out.println("enter the salesid");
             salesid = sc.nextInt();
            if(salesid>0)break;
        }

        if(salesforceMap.get(salesid)==null) {
            System.out.println("output assignment");
            System.out.println(leads.toString()+" selected salesid: "+salesid);
            lead = new ArrayList<>();
            return leads;
        }

            String country=leads.getCountry();
            String product=leads.getProduct();

            if(salesforceMap.get(salesid).isActive()&&salesforceMap.get(salesid).getProducts().contains(product)&&salesforceMap.get(salesid).getCountries().contains(country))
                leads.setSalesforce(salesforceMap.get(salesid));
        System.out.println("output assignment");
        System.out.println(leads.toString());

        lead=new ArrayList<>();
        return leads;
    }



}
