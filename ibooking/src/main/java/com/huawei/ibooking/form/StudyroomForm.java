package com.huawei.ibooking.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class StudyroomForm {
    @NotNull
    @Size(min=2,max=15)
    private String studyroomNum;

    @NotNull
    @Min(0)
    @Max(23)
    private int openTime;

    @NotNull
    @Min(0)
    @Max(23)
    private int closeTime;
}
