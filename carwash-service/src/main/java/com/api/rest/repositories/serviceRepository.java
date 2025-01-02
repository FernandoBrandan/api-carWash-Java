package com.api.rest.repositories;

import com.api.rest.models.serviceModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface serviceRepository extends CrudRepository<serviceModel, Long> {
    // This is a placeholder for the customerRepository interface
}