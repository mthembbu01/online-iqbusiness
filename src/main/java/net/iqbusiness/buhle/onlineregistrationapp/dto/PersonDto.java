package net.iqbusiness.buhle.onlineregistrationapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String idNumber;

    @NotNull
    private String contactNumber;

}