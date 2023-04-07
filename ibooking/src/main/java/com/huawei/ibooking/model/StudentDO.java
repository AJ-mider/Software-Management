package com.huawei.ibooking.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDO {
    private int id;
    private String stuNum;
    private String name;
    private String password;

    public StudentDO(String stuNum,String password)
    {
        this.id=0;
        this.stuNum=stuNum;
        this.name="test";
        this.password=password;
    }

}
