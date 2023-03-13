package org.example.model;

public class Data {
    String country;
    String region;
    String href;
    Location location;
    Lifts lifts;
    private String name;

    public Data() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Lifts getLifts() {
        return lifts;
    }

    public void setLifts(Lifts lifts) {
        this.lifts = lifts;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", href='" + href + '\'' +
                ", location=" + location +
                ", lifts=" + lifts +
                '}';
    }
}