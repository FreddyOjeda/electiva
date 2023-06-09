package com.uptc.electiva.Entities;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "bills")
public class BillEntity {
    @Id
    private String number;
    private LocalDate date;

    /*@Enumerated(EnumType.STRING)
    private Pay typePay;*/

    private String typePay;

    private BigDecimal total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer")
    private CustomerEntity customer;



    public BillEntity() {
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTypePay() {
        return typePay;
    }

    public void setTypePay(String typePay) {
        this.typePay = typePay;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
}
