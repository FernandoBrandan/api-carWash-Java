package com.api.rest.services;

import com.api.rest.models.customerModel;
import com.api.rest.repositories.customerRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class customerService {
    @Autowired
    customerRepository customerRepository;

    /**
     * List of endpoints
     * 
     * GET /customers: Obtener todos los clientes.
     * GET /customers/:id: Obtener un cliente específico.
     * POST /customers: Crear un nuevo cliente.
     * PUT /customers/:id: Actualizar un cliente.
     * DELETE /customers/:id: Eliminar un cliente.
     * 
     */

    public ArrayList<customerModel> getCustomers() {
        return (ArrayList<customerModel>) customerRepository.findAll();
    }

    public Optional <customerModel> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public customerModel createCustomer(customerModel customer) {
        if (customer.getId() != null) {
            throw new IllegalArgumentException("New customers should not have an ID");
        }
        return customerRepository.save(customer);
    }

    public customerModel updateCustomer(customerModel customer) {
        if (customer.getId() == null || !customerRepository.existsById(customer.getId())) {
            throw new Error("Customer not found with id: " + customer.getId());
        }
        return customerRepository.save(customer);
    }

    public boolean deleteCustomer(Long id) {
        try {
            customerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}