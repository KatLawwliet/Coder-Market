package com.coder.platzimarket.domain;

public class Category {

    private int categoryId;
    private String category;
    private Boolean active;


    //Getters y Setters
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {return category;}
    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
}
