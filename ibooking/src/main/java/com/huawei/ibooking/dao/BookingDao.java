package com.huawei.ibooking.dao;

import com.huawei.ibooking.mapper.BookingMapper;
import com.huawei.ibooking.model.BookingDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingDao {

    @Autowired
    private BookingMapper bookingMapper;

    public List<BookingDO> getBookings(final String stuNum) {
        return bookingMapper.getBookings(stuNum);
    }
    public boolean saveBooking(BookingDO bookingDO) {
        return bookingMapper.saveBooking(bookingDO) > 0;
    }
//    public List<BookingDO> getBooking(final String stuNum,final int seatId){
//        return bookingMapper.getBooking(stuNum,seatId);
//    }
}
