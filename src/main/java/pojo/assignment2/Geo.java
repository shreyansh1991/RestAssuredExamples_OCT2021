package pojo.assignment2;

public class Geo {
    private String lat;
    private String lng;

    public Geo setLat(String lat) {
        this.lat = lat;
        return this;
    }

    public Geo setLng(String lng) {
        this.lng = lng;
        return this;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }
}
