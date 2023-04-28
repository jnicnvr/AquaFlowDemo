package com.example.h2oflow;

public class MyListData {
    // variables for our course
    // name and description.
    private String idCustomer;
    private String idMeterNo;
    private String idStatus;

    // creating constructor for our variables.
    public MyListData(String idCustomer, String idMeterNo, String idStatus) {
        this.idCustomer = idCustomer;
        this.idMeterNo = idMeterNo;
        this.idStatus = idStatus;
    }

    // creating getter and setter methods.
    public String getCustomer() {
        return idCustomer;
    }
    public String getMeterNo() {
        return idMeterNo;
    }
    public String getStatus() {
        return idStatus;
    }

    public void setCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }
    public void setMeterNo(String idMeterNo) {
        this.idMeterNo = idMeterNo;
    }
    public void setStatus(String idStatus) { this.idStatus = idStatus; }
}
