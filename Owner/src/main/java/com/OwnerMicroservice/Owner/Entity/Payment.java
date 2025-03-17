package com.OwnerMicroservice.Owner.Entity;
import javax.persistence.*;

@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "RoomNo")
    private int roomNo;
    @Column(name = "CreditCard")
    private Long creditcard;
    @Column(name = "Total")
    private int total;
    @Column(name ="PayTime")
    private String paytime;

    public Payment(int id, int roomNo, Long creditcard, int total, String paytime) {
        this.id = id;
        this.roomNo = roomNo;
        this.creditcard = creditcard;
        this.total = total;
        this.paytime = paytime;
    }
    public Payment(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public Long getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(Long creditcard) {
        this.creditcard = creditcard;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime;
    }
}
