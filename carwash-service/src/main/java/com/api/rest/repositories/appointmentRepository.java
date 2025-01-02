package com.api.rest.repositories;

import com.api.rest.models.appointmentModel;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface appointmentRepository extends CrudRepository<appointmentModel, Long> {
    public abstract ArrayList<appointmentModel> findByStatus(String status);
}
