package com.brij.empService.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectResponse {
    String subjectCode;
    String subjectName;
    Long semester;
    //TODO
    String courseName;
}
