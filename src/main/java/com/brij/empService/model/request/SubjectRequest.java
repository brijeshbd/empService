package com.brij.empService.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRequest {
    String subjectName;
    Long semester;
    //TODO
    Long courseId;
}
