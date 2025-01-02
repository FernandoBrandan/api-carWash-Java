package com.api.rest.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointment")
public class appointmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private Date date;
    private String status;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false) // customer_id será la FK.
    private customerModel customer;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false) // service_id será la FK.
    private serviceModel service;

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public customerModel getCustomer() {
        return customer;
    }

    public serviceModel getService() {
        return service;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCustomer(customerModel customer) {
        this.customer = customer;
    }

    public void setService(serviceModel service) {
        this.service = service;
    }

}
