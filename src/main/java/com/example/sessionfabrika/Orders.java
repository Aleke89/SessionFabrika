package com.example.sessionfabrika;

public class Orders {
    private int id;
    private String number;
    private String date;
    private String finish_date;
    private String zakazchik;
    private String manager;
    private String status;
    private String furniture;
    private String tkan;
    private String okontovka;
    public Orders(int id,String number, String date, String finish_date, String zakazchik, String manager, String status, String furniture, String tkan, String okontovka) {
        this.id = id;
        this.number = number;
        this.date = date;
        this.finish_date = finish_date;
        this.zakazchik = zakazchik;
        this.manager = manager;
        this.status = status;
        this.furniture = furniture;
        this.tkan = tkan;
        this.okontovka = okontovka;
    }

    public String getFurniture() {
        return furniture;
    }

    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }

    public String getTkan() {
        return tkan;
    }

    public void setTkan(String tkan) {
        this.tkan = tkan;
    }

    public String getOkontovka() {
        return okontovka;
    }

    public void setOkontovka(String okontovka) {
        this.okontovka = okontovka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(String finish_date) {
        this.finish_date = finish_date;
    }

    public String getZakazchik() {
        return zakazchik;
    }

    public void setZakazchik(String zakazchik) {
        this.zakazchik = zakazchik;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
