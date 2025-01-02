package com.api.rest.controllers;

import com.api.rest.models.customerModel;
import com.api.rest.services.customerService;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*") // Permite solicitudes de cualquier origen
public class customerController {
    @Autowired
    customerService customerService;

    @GetMapping()
    public ArrayList<customerModel> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping(path = "{id}")
    public Optional <customerModel> getCustomerById(@PathVariable("id") Long id) {
        return this.customerService.getCustomerById(id);
    }

    @PostMapping()
    public customerModel createCustomer(@RequestBody customerModel customer) {
        return this.customerService.createCustomer(customer);
    }

    @PutMapping()
    public customerModel updateCustomer(@RequestBody customerModel customer) {
        return this.customerService.updateCustomer(customer);
    }

    @DeleteMapping(path = "{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        boolean ok = this.customerService.deleteCustomer(id);
        if (ok) {
            return "Customer deleted";
        } else {
            return "Customer not deleted";
        }
    }
    
}