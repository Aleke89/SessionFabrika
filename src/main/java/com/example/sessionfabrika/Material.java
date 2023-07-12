package com.example.sessionfabrika;

public class Material {
    private int id;
    private String name;
    private String amount;
    private String cause;

    public Material(int id, String name, String amount, String cause) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.cause = cause;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
