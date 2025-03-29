package com.simsys.warehouse.dto;

public class LocationDTO {
    private Integer id;
    private String locationName;
    private String address;
    private String description;
    private String phoneNumber;

    // Constructors
    public LocationDTO() {
    }

    public LocationDTO(Integer id, String locationName, String address, String description, String phoneNumber) {
        this.id = id;
        this.locationName = locationName;
        this.address = address;
        this.description = description;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
