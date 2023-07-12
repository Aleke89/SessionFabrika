package com.example.sessionfabrika;

public class Zakaz {
    private int id;
    private String vysota;
    private String shirina;

    public Zakaz(int id,String vysota, String shirina) {
        this.id = id;
        this.vysota = vysota;
        this.shirina = shirina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVysota() {
        return vysota;
    }

    public void setVysota(String vysota) {
        this.vysota = vysota;
    }

    public String getShirina() {
        return shirina;
    }

    public void setShirina(String shirina) {
        this.shirina = shirina;
    }
}
