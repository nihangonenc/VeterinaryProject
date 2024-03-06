package com.java.veterinary.api;

import com.java.veterinary.business.abstracts.IAppointmentService;
import com.java.veterinary.core.config.modelMapper.IModelMapperService;
import com.java.veterinary.core.result.Result;
import com.java.veterinary.core.result.ResultData;
import com.java.veterinary.core.utilies.ResultHelper;
import com.java.veterinary.dto.request.appointment.AppointmentSaveRequest;
import com.java.veterinary.dto.request.appointment.AppointmentUpdateRequest;
import com.java.veterinary.dto.response.AppointmentResponse;
import com.java.veterinary.dto.response.CursorResponse;
import com.java.veterinary.entity.Appointment;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/appointments")
public class AppointmentController {
    private final IAppointmentService appointmentService;
    private final IModelMapperService modelMapper;

    public AppointmentController(IAppointmentService appointmentService, IModelMapperService modelMapper) {
        this.appointmentService = appointmentService;
        this.modelMapper = modelMapper;
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AppointmentResponse> save(@Valid @RequestBody AppointmentSaveRequest appointmentSaveRequest) {
        Appointment saveAppointment = this.modelMapper.forRequest().map(appointmentSaveRequest, Appointment.class);
        this.appointmentService.save(saveAppointment);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveAppointment, AppointmentResponse.class));
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AppointmentResponse> get(@PathVariable("id") int id) {
        Appointment appointment = this.appointmentService.get(id);
        AppointmentResponse appointmentResponse = this.modelMapper.forResponse().map(appointment, AppointmentResponse.class);
        return ResultHelper.success(appointmentResponse);
    }
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AppointmentResponse> update(@Valid @RequestBody AppointmentUpdateRequest appointmentUpdateRequest){
        this.appointmentService.get(appointmentUpdateRequest.getId());
        Appointment updateAppointment = this.modelMapper.forRequest().map(appointmentUpdateRequest, Appointment.class);
        this.appointmentService.update(updateAppointment);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateAppointment, AppointmentResponse.class));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.appointmentService.delete(id);
        return ResultHelper.ok();
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<AppointmentResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "7") int pageSize){

        Page<Appointment> appointmentPage = this.appointmentService.cursor(page,pageSize);
        Page<AppointmentResponse> appointmentResponsePage = appointmentPage
                .map(appointment -> this.modelMapper.forResponse().map(appointment, AppointmentResponse.class));
        return ResultHelper.cursor(appointmentResponsePage);
    }
    @GetMapping("/searchByDoctorAndDate")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<AppointmentResponse>> getByDoctorAndDate(@RequestParam Long doctorId,
                                                                    @RequestParam LocalDateTime startDate,
                                                                    @RequestParam LocalDateTime finishDate) {
        return this.appointmentService.getByDoctorAndDate(doctorId,startDate,finishDate);
    }
    @GetMapping("/searchByAnimalAndDate")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<AppointmentResponse>> getByAnimalAndDate(@RequestParam Long animalId,
                                                                    @RequestParam LocalDateTime startDate,
                                                                    @RequestParam LocalDateTime finishDate) {
        return this.appointmentService.getByAnimalAndDate(animalId,startDate,finishDate);
    }

}
