package com.example.adanionerai.ModelClass;

public class NameModel {
    String title;
    String name;
    String travellerType;

    public NameModel(String title, String name, String travellerType) {
        this.title = title;
        this.name = name;
        this.travellerType = travellerType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(String travellerType) {
        this.travellerType = travellerType;
    }
}
