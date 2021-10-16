package pojo.assignment2;

public class Address {
    private String street;

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public Address setSuite(String suite) {
        this.suite = suite;
        return this;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public Address setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Geo getGeo() {
        return geo;
    }

    private String suite;
    private String city;
    private String zipCode;
    private Geo geo;
}
