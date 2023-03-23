package com.doctorhere.base.appointment;

import com.doctorhere.base.appointment.enums.EnumAppointmentStatus;
import com.doctorhere.base.appointment.model.dto.AppointmentRequest;
import com.doctorhere.base.appointment.model.dto.AppointmentResponse;
import com.doctorhere.base.appointment.model.mapper.AppointmentMapper;
import com.doctorhere.base.appointment.service.AppointmentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
@RequiredArgsConstructor
@Validated
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;

    @PostMapping("patient/save")
    public ResponseEntity createPatient(@RequestBody AppointmentRequest appointmentRequest) {
        appointmentService.create(appointmentRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PutMapping("patient/cancel")
    public void delete(@RequestBody AppointmentRequest appointmentRequest){
        appointmentService.delete(appointmentRequest);
    }


    @ApiOperation(value = "hasta randevu listesi", response = AppointmentResponse.class, responseContainer = "List")
    @RequestMapping(value = "patient/list/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity listAllPatientAppointments(
            @RequestParam(name = "status", required = false) EnumAppointmentStatus status,
            @RequestParam(name = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize,
            @RequestParam(name = "sortingDirection", required = false, defaultValue = "ASC") String sortingDirection,
            @RequestParam(name = "sortingName", required = false, defaultValue = "id") String sortingName,
            @RequestParam(name = "pageable", required = false, defaultValue = "true") Boolean pageable
    ) {
        //TODO patient için id tokenden alınacak
        if (pageable) {
            Page<AppointmentResponse> appointmentResponses = appointmentService.findAllPageable(pageNumber, pageSize, sortingDirection, sortingName, status, 1L, null).map(appointmentMapper::toResponse);
            return new ResponseEntity(appointmentResponses, HttpStatus.OK);
        } else {
            List<AppointmentResponse> appointmentResponses = appointmentMapper.toResponse(appointmentService.findAllList(sortingDirection, sortingName, status, 1L, null));
            return new ResponseEntity(appointmentResponses, HttpStatus.OK);
        }
    }

    @ApiOperation(value = "doktor randevu listesi", response = AppointmentResponse.class, responseContainer = "List")
    @RequestMapping(value = "doctor/list/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity listAllDoctorAppointments(
            @RequestParam(name = "status", required = false) EnumAppointmentStatus status,
            @RequestParam(name = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize,
            @RequestParam(name = "sortingDirection", required = false, defaultValue = "ASC") String sortingDirection,
            @RequestParam(name = "sortingName", required = false, defaultValue = "id") String sortingName,
            @RequestParam(name = "pageable", required = false, defaultValue = "true") Boolean pageable
    ) {
        //TODO patient için id tokenden alınacak
        if (pageable) {
            Page<AppointmentResponse> appointmentResponses = appointmentService.findAllPageable(pageNumber, pageSize, sortingDirection, sortingName, status, null, 1L).map(appointmentMapper::toResponse);
            return new ResponseEntity(appointmentResponses, HttpStatus.OK);
        } else {
            List<AppointmentResponse> appointmentResponses = appointmentMapper.toResponse(appointmentService.findAllList(sortingDirection, sortingName, status, null, 1L));
            return new ResponseEntity(appointmentResponses, HttpStatus.OK);
        }
    }
}
