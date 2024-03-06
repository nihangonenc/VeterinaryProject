package com.java.veterinary.api;

import com.java.veterinary.business.abstracts.IAvailableDateService;
import com.java.veterinary.core.config.modelMapper.IModelMapperService;
import com.java.veterinary.core.result.Result;
import com.java.veterinary.core.result.ResultData;
import com.java.veterinary.core.utilies.ResultHelper;
import com.java.veterinary.dto.request.availableDate.AvailableDateSaveRequest;
import com.java.veterinary.dto.request.availableDate.AvailableDateUpdateRequest;
import com.java.veterinary.dto.response.AvailableDateResponse;
import com.java.veterinary.dto.response.CursorResponse;
import com.java.veterinary.entity.AvailableDate;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/availableDates")
public class AvailableDateController {
    private final IAvailableDateService availableDateService;
    private final IModelMapperService modelMapper;

    public AvailableDateController(IAvailableDateService availableDateService, IModelMapperService modelMapper) {
        this.availableDateService = availableDateService;
        this.modelMapper = modelMapper;
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AvailableDateResponse> save(@Valid @RequestBody AvailableDateSaveRequest availableDateSaveRequest) {
        AvailableDate saveDate = this.modelMapper.forRequest().map(availableDateSaveRequest, AvailableDate.class);
        this.availableDateService.save(saveDate);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveDate, AvailableDateResponse.class));
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AvailableDateResponse> get(@PathVariable("id") int id) {
        AvailableDate availableDate = this.availableDateService.get(id);
        AvailableDateResponse AvailableDateResponse = this.modelMapper.forResponse().map(availableDate, AvailableDateResponse.class);
        return ResultHelper.success(AvailableDateResponse);
    }
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AvailableDateResponse> update(@Valid @RequestBody AvailableDateUpdateRequest availableDateUpdateRequest){
        this.availableDateService.get(availableDateUpdateRequest.getId());
        AvailableDate updateDate = this.modelMapper.forRequest().map(availableDateUpdateRequest, AvailableDate.class);
        this.availableDateService.update(updateDate);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateDate, AvailableDateResponse.class));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.availableDateService.delete(id);
        return ResultHelper.ok();
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<AvailableDateResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "7") int pageSize){

        Page<AvailableDate> datePage = this.availableDateService.cursor(page,pageSize);
        Page<AvailableDateResponse> dateResponsePage = datePage
                .map(availableDate -> this.modelMapper.forResponse().map(availableDate, AvailableDateResponse.class));
        return ResultHelper.cursor(dateResponsePage);
    }

}
