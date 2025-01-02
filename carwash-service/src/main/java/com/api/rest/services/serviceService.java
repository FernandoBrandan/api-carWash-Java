package com.api.rest.services;

import com.api.rest.models.serviceModel;
import com.api.rest.repositories.serviceRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviceService {
    @Autowired
    serviceRepository serviceRepository;   

    /**
     * List of endpoints
     * 
     * GET /services: Obtener todos los servicios.
     * GET /services/:id: Obtener un servicio específico.
     * POST /services: Crear un nuevo servicio.
     * PUT /services/:id: Actualizar un servicio.
     * DELETE /services/:id: Eliminar un servicio.
     * 
     */

    public ArrayList<serviceModel> getServices() {
        return (ArrayList<serviceModel>) serviceRepository.findAll();
    }

    public Optional <serviceModel> getServiceById(Long id) {
        return serviceRepository.findById(id);
    }

    public serviceModel createService(serviceModel service) {
        if (service.getId() != null) {
            throw new IllegalArgumentException("New services should not have an ID");
        }
        return serviceRepository.save(service);
    }

    public serviceModel updateService(serviceModel service) {
        if (service.getId() == null || !serviceRepository.existsById(service.getId())) {
            throw new Error("Service not found with id: " + service.getId());
        }
        return serviceRepository.save(service);
    }

    public boolean deleteService(Long id) {
        try {
            serviceRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}