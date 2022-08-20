package com.coder.platzimarket.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Purchase {

    private int purchaseId;
    private String clienteId;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private String state;



    private List<PurchaseItem> items;


    //Getters y Setters
    public int getPurchaseId() {
        return purchaseId;
    }
    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }


    public String getClienteId() {
        return clienteId;
    }
    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }


    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }


    public String getState() {return state;}
    public void setState(String state) {this.state = state;}

    public List<PurchaseItem> getItems() {
        return items;
    }
    public void setItems(List<PurchaseItem> items) {
        this.items = items;
    }


}
