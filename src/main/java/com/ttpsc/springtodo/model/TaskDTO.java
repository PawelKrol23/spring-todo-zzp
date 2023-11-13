package com.ttpsc.springtodo.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskDTO {

    private String summary;
    private String description;

    private String startDate;
    private String endDate;

    private String categoryName;
    private String statusName;
}
