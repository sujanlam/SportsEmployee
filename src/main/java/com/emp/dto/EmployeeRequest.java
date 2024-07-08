package com.emp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class EmployeeRequest {
    @NotNull(message="First Name shouldn't be null!!")
    private String fname;
    @NotNull(message="Last Name shouldn't be null!!")
    private String lname;
    @NotNull
    @Max(120)
    @Min(12)
    private Integer age;
    @NotNull(message = "Club shouldn't be null!!")
    private String club;
    @NotNull
    private Integer goals_scored;
    @NotNull(message = "Club shouldn't be null!!")
    @NotBlank
    private String nationality;
}
