package com.api.rest.repositories;

import com.api.rest.models.customerModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface customerRepository extends CrudRepository<customerModel, Long> {
    // This is a placeholder for the customerRepository interface
}