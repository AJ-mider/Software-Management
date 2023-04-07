package com.huawei.ibooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeatDO {
    private int Id;
    private String studyroomNum;
    private int seatNum;
    private boolean isBooking;
    public boolean getIsBooking(){
        return this.isBooking;
    }
    public void setIsBooking(boolean isBooking){
        this.isBooking=isBooking;
    }
    public SeatDO(String studyroomNum,int seatNum){
        this.Id=0;
        this.studyroomNum=studyroomNum;
        this.seatNum=seatNum;
        this.isBooking=false;
    }
}
