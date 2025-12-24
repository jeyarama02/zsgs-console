package tki.WebmasterInterview.dto;

public class Lead {
    private int id;
    private String name;
    private String product;
    private String country;
    private Salesforce salesforce;

    public Lead(int id, String name, String product, String country) {
        this.id = id;
        this.name = name;
        this.product = product;
        this.country = country;
        this.salesforce = salesforce;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Salesforce getSalesforce() {
        return salesforce;
    }

    public void setSalesforce(Salesforce salesforce) {
        this.salesforce = salesforce;
    }

    @Override
    public String toString() {
        if(salesforce==null)
            return "Lead{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", product='" + product + '\'' +
                    ", country='" + country + '\'' +
                    ", salesforce= not assigned"  +
                    '}';
        return "Lead{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", product='" + product + '\'' +
                ", country='" + country + '\'' +
                ", salesforce=" + salesforce.toString() +
                '}';
    }
}
