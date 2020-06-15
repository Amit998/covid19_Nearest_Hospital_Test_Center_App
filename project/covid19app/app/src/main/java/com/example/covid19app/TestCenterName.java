package com.example.covid19app;

public class TestCenterName {
    private String testCenterId,tcName,availability,cost,tested,email,phno,address,successRate;
    public TestCenterName(){

    }

    public TestCenterName(String testCenterId, String tcName, String availability, String cost, String tested, String email, String phno, String address, String successRate) {
        this.testCenterId = testCenterId;
        this.tcName = tcName;
        this.availability = availability;
        this.cost = cost;
        this.tested = tested;
        this.email = email;
        this.phno = phno;
        this.address = address;
        this.successRate = successRate;
    }

    public String getTestCenterId() {
        return testCenterId;
    }

    public void setTestCenterId(String testCenterId) {
        this.testCenterId = testCenterId;
    }

    public String getTcName() {
        return tcName;
    }

    public void setTcName(String tcName) {
        this.tcName = tcName;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getTested() {
        return tested;
    }

    public void setTested(String tested) {
        this.tested = tested;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(String successRate) {
        this.successRate = successRate;
    }
}
