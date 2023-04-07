package com.huawei.ibooking.mapper;

import com.huawei.ibooking.model.BookingDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookingMapper {
    List<BookingDO> getBookings(@Param("stuNum") String stuNum);

    int saveBooking(@Param("bookingDO") BookingDO bookingDO);
    //List<BookingDO> getBooking(@Param("stuNum") String stuNum, @Param("seatId") int seatId);
}
