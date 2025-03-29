package com.simsys.warehouse.dto;

public class SystemConfigDTO {
    private Integer id;
    private String name;
    private String configValue;
    private String description;

    // Constructors
    public SystemConfigDTO() {
    }

    public SystemConfigDTO(Integer id, String name, String configValue, String description) {
        this.id = id;
        this.name = name;
        this.configValue = configValue;
        this.description = description;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
