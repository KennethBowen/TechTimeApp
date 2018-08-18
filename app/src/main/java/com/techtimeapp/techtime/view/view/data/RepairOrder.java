package com.techtimeapp.techtime.view.view.data;

public class RepairOrder {
    private int repairOrderNumber;
    private String writer;
    private String vehicle;
    private double laborRate;
    private double hours;

    public RepairOrder(int repairOrder, String writer, String vehicle, double laborRate, double hours) {
        this.repairOrderNumber = repairOrder;
        this.writer = writer;
        this.vehicle = vehicle;
        this.laborRate = laborRate;
        this.hours = hours;
    }
}
