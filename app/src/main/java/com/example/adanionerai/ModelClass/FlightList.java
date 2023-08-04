package com.example.adanionerai.ModelClass;

import android.widget.ImageView;

public class FlightList {
    int img;
    String departureTime, arrivalTime, totalTime, Stops, ticketCost;

    public FlightList(int img, String departureTime, String arrivalTime, String totalTime, String stops, String ticketCost) {
        this.img = img;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalTime = totalTime;
        Stops = stops;
        this.ticketCost = ticketCost;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getStops() {
        return Stops;
    }

    public void setStops(String stops) {
        Stops = stops;
    }

    public String getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(String ticketCost) {
        this.ticketCost = ticketCost;
    }
}
