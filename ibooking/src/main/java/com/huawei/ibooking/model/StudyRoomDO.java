package com.huawei.ibooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudyRoomDO {
    private int id;
    private String studyRoomNum;
    private int openTime;
    private int closeTime;
    private boolean isOpen;

    public boolean getIsOpen(){
        return this.isOpen;
    }
    public void setIsOpen(boolean isOpen){
        this.isOpen=isOpen;
    }
    public StudyRoomDO(String studyRoomNum,int openTime,int closeTime){
        this.id=0;
        this.studyRoomNum=studyRoomNum;
        this.openTime=openTime;
        this.closeTime=closeTime;
        this.isOpen=true;
    }
}