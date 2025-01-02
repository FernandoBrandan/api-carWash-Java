package com.api.rest.controllers;

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

import com.api.rest.models.serviceModel;
import com.api.rest.services.serviceService;

@RestController
@RequestMapping("/service")
@CrossOrigin(origins = "*") // Permite solicitudes de cualquier origen
public class serviceController {
    @Autowired
    serviceService serviceService;

    @GetMapping()
    public ArrayList<serviceModel> getServices() {
        return serviceService.getServices();
    }

    @GetMapping(path = "{id}")
    public Optional <serviceModel> getServiceById(@PathVariable("id") Long id) {
        return this.serviceService.getServiceById(id);
    }

    @PostMapping()
    public serviceModel createService(@RequestBody serviceModel service) {
        return this.serviceService.createService(service);
    }

    @PutMapping()
    public serviceModel updateService(@RequestBody serviceModel service) {
        return this.serviceService.updateService(service);
    }

    @DeleteMapping(path = "{id}")
    public String deleteService(@PathVariable("id") Long id) {
        boolean ok = this.serviceService.deleteService(id);
        if (ok) {
            return "Service deleted";
        } else {
            return "Service not deleted";
        }
    }
}