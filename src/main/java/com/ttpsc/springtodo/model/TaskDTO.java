package com.ttpsc.springtodo.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskDTO {

    private String summary;
    private String description;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private String categoryName;
    private String statusName;
}
