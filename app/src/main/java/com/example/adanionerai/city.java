package com.example.adanionerai;

public class city {
    String city;
    String country;
    String airport;
    String cityCode;

    public city(String city, String country, String airport, String cityCode) {
        this.city = city;
        this.country = country;
        this.airport = airport;
        this.cityCode = cityCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
