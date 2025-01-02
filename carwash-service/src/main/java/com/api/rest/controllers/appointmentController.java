package com.api.rest.controllers;

import com.api.rest.models.appointmentModel;
import com.api.rest.services.appointmentService;

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
@RequestMapping("/appointment")
@CrossOrigin(origins = "*") // Permite solicitudes de cualquier origen
public class appointmentController {
    @Autowired
    appointmentService appointmentService;

    @GetMapping()
    public ArrayList<appointmentModel> getAppointments() {
        return appointmentService.getAppointments();
    }

    @GetMapping(path = "{id}")
    public Optional<appointmentModel> getAppointmentById(@PathVariable("id") Long id) {
        return this.appointmentService.getAppointmentById(id);
    }

    @PostMapping()
    public appointmentModel createAppointment(@RequestBody appointmentModel appointment) {
        return this.appointmentService.createAppointment(appointment);
    }

    @PutMapping()
    public appointmentModel updateAppointment(@RequestBody appointmentModel appointment) {
        return this.appointmentService.updateAppointment(appointment);
    }

    @GetMapping(path = "/query")
    public ArrayList<appointmentModel> getAppointmentsByStatus(@RequestBody String status) {
        return this.appointmentService.getAppointmentsByStatus(status);
    }

    @DeleteMapping(path = "{id}")
    public String deleteAppointment(@PathVariable("id") Long id) {
        boolean ok = this.appointmentService.deleteAppointment(id);
        if (ok) {
            return "Appointment deleted";
        } else {
            return "Appointment not deleted";
        }
    }

}
