package com.huawei.ibooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingDO {

    private int id;

    private String stuNum;

    //re
    private String studyroomNum;

    private int seatId;

    private String bookingPeriodStartTime;

    private String bookingPeriodEndTime;

    public BookingDO(String stuNum, String studyroomNum, int seatId, String bookingPeriodStartTime, String bookingPeriodEndTime) {
        this.id = 0;
        this.stuNum = stuNum;

        //re
        this.studyroomNum = studyroomNum;

        this.seatId = seatId;
        this.bookingPeriodStartTime = bookingPeriodStartTime;
        this.bookingPeriodEndTime = bookingPeriodEndTime;



    }
}
