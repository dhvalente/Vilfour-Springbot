package com.dhvalente.vilfoursystem.dtos;

import com.dhvalente.vilfoursystem.enums.PeriodEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    private Long id;
    private String name;
    private PeriodEnum period;

}
