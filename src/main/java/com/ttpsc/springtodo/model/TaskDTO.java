package com.ttpsc.springtodo.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskDTO {

    @Size(min = 2, max = 20)
    private String summary;
    private String description;

    private String startDate;
    private String endDate;

    private String categoryName;
    private String statusName;
}
