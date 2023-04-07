package com.huawei.ibooking.model;

import javafx.scene.input.Mnemonic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ManagerDO {
    private int id;
    private String managerNum;
    private String name;
    private String password;

    public ManagerDO(String managerNum,String password){
        this.id=0;
        this.managerNum=managerNum;
        this.name="test";
        this.password=password;
    }
}
