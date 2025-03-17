package com.ReceptionistMicroservice.Receptionist.Entity;


import javax.persistence.*;

@Entity
@Table(name = "IssueBills")
public class IssueBills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billNO;
    @Column(name = "RoomNo")
    private int roomNo;
    @Column(name="Price")
    private int price;
    @Column(name="Taxes")
    private int taxes;
    @Column(name = "Date")
    private String date;
    @Column(name = "Service")
    private int service;
    @Column(name="Total")
    private int total;

    public IssueBills(int billNO, int roomNo, int price, int taxes, String date, int service, int total) {
        this.billNO = billNO;
        this.roomNo = roomNo;
        this.price = price;
        this.taxes = taxes;
        this.date = date;
        this.service = service;
        this.total = total;
    }
    public IssueBills(){
        super();
    }

    public int getBillNO() {
        return billNO;
    }

    public void setBillNO(int billNO) {
        this.billNO = billNO;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTaxes() {
        return taxes;
    }

    public void setTaxes(int taxes) {
        this.taxes = taxes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
