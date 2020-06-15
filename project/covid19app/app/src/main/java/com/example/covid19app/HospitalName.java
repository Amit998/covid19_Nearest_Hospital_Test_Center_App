package com.example.covid19app;

public class HospitalName {
    private String id, hp_name, costs, beds, location,admitted,email,phno,recovered,total_death,availability;

    public HospitalName() {

    }

    public HospitalName(String id, String hp_name, String costs, String beds, String location, String admitted, String email, String phno, String recovered, String total_death, String availability) {
        this.id = id;
        this.hp_name = hp_name;
        this.costs = costs;
        this.beds = beds;
        this.location = location;
        this.admitted = admitted;
        this.email = email;
        this.phno = phno;
        this.recovered = recovered;
        this.total_death = total_death;
        this.availability = availability;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHp_name() {
        return hp_name;
    }

    public void setHp_name(String hp_name) {
        this.hp_name = hp_name;
    }

    public String getCosts() {
        return costs;
    }

    public void setCosts(String costs) {
        this.costs = costs;
    }

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAdmitted() {
        return admitted;
    }

    public void setAdmitted(String admitted) {
        this.admitted = admitted;
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

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getTotal_death() {
        return total_death;
    }

    public void setTotal_death(String total_death) {
        this.total_death = total_death;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}