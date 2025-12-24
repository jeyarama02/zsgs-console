package tki.WebmasterInterview.dto;

import java.util.List;

public class Salesforce {
    private int id;
    private String name;
    private List<String> products;
    private List<String> countries;
    boolean isActive;
    int totallimit;
    int currentlimit=0;

    public Salesforce(int id, String name, List<String> countries,List<String> products, boolean isActive, int totallimit, int currentlimit) {
        this.id = id;
        this.name = name;
        this.products = products;
        this.countries = countries;
        this.isActive = isActive;
        this.totallimit = totallimit;
        this.currentlimit = currentlimit;
    }

    public Salesforce(int id, String name, List<String> products, List<String> countries, boolean isActive) {
        this.id = id;
        this.name = name;
        this.products = products;
        this.countries = countries;
        this.isActive = isActive;
    }

    public int getTotallimit() {
        return totallimit;
    }

    public void setTotallimit(int totallimit) {
        this.totallimit = totallimit;
    }

    public int getCurrentlimit() {
        return currentlimit;
    }

    public void setCurrentlimit(int currentlimit) {
        this.currentlimit = currentlimit;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "Salesforce{" +
                "id=" + id +
                ", name='" + name + '\'' ;
    }
    public void print()
    {
        System.out.println("Salesforce{" +
                "id=" + id +
                ", name='" + name + '\'' +" products : "+products+" countries: "+countries);
    }
}
