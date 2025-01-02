package com.api.rest.services;

import com.api.rest.models.appointmentModel;
import com.api.rest.repositories.appointmentRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class appointmentService {

    @Autowired
    appointmentRepository appointmentRepository;

    /**
     * List of endpoints
     * 
     * GET /appointments: Obtener todos los turnos.
     * GET /appointments/:id: Obtener un turno específico.
     * POST /appointments: Crear un nuevo turno.
     * PUT /appointments/:id: Actualizar un turno.
     * GET /appointments/status/:status: Obtener todos los turnos con un estado
     * específico.
     * DELETE /appointments/:id: Eliminar un turno.
     * 
     */

    public ArrayList<appointmentModel> getAppointments() {
        return (ArrayList<appointmentModel>) appointmentRepository.findAll();
    }

    public Optional<appointmentModel> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public appointmentModel createAppointment(appointmentModel appointment) {
        if (appointment.getId() != null) {
            throw new IllegalArgumentException("New appointments should not have an ID");
        }
        return appointmentRepository.save(appointment);
    }

    public appointmentModel updateAppointment(appointmentModel appointment) {
        if (appointment.getId() == null || !appointmentRepository.existsById(appointment.getId())) {
            throw new Error("Appointment not found with id: " + appointment.getId());
        }
        return appointmentRepository.save(appointment);
    }

    public ArrayList<appointmentModel> getAppointmentsByStatus(String status) {
        return appointmentRepository.findByStatus(status);
    }

    public boolean deleteAppointment(Long id) {
        try {
            appointmentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
