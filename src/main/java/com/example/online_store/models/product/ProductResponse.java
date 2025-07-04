package com.example.online_store.models.product;

public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private Integer count;

    public ProductResponse() {}

    public ProductResponse(Long id, String name, String description, Integer count) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
