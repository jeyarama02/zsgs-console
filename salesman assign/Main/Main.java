package tki.WebmasterInterview.Main;

import tki.WebmasterInterview.Util.util;
import tki.WebmasterInterview.dto.Lead;
import tki.WebmasterInterview.dto.Salesforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        util ur=new util(sc);
       List<Lead> leadList=new ArrayList<>();


        while(true) {
            System.out.println("enter the choice");
            System.out.println("1.direct 2.round robin 3.percentage 4.add salesforce 5.show salesforce 6.show leads 7.exit");
            int choice= sc.nextInt();
            if (choice == 1) {

//                System.out.println("enter the number of salesforce");
//                int ns= sc.nextInt();
//                util u=new util();
//              u.getInputSales(ns);

                leadList.add(ur.assignDirect());

             } else if (choice==2) {

//                System.out.println("enter the number of salesforce");
//                int ns= sc.nextInt();
                System.out.println("enter the number of lead");
                int nl= sc.nextInt();
                sc.nextLine();
//                u.getInputSales(ns);
                ur.getInputLead(nl);
//                ur.sales();
//                ur.leads();
                ur.assignRoundRobin();

                ur.print();

                leadList.addAll(ur.lead);

                ur.lead=new ArrayList<>();

            } else if (choice==3) {

//                System.out.println("enter the number of salesforce");
//                int ns= sc.nextInt();
//                System.out.println("enter the number of lead");
//                int nl= sc.nextInt();
//                util u=new util();
//                u.sales();
//                u.leads();
//                u.assignPercentage();
//                u.print();

                System.out.println("enter the number of lead");
                int nl= sc.nextInt();
                ur.getInputLead(nl);
                ur.assignPercentage();
                ur.print();
                leadList.addAll(ur.lead);
                ur.lead=new ArrayList<>();


            }
            else if(choice==4)
            {
                System.out.println("enter the number of salesforce");
                int ns= sc.nextInt();
                ur.getInputSales(ns);
            } else if (choice==5) {
                System.out.println("Salesforce");
                for(Salesforce s: ur.salesforces)
                s.print();

            } else if (choice==6) {
                for(int i=0;i<leadList.size();i++)
                {
                    System.out.println(leadList.get(i).toString());
                }

            } else if (choice==7) {
                break;
            }
            else
                System.out.println("invalid choice");
        }
    }
}
