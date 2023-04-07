package com.huawei.ibooking.business;

import com.huawei.ibooking.dao.BookingDao;
import com.huawei.ibooking.model.BookingDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingBusiness {
    @Autowired
    private BookingDao bookingDao;
    public List<BookingDO> getBookings(final String stuNum){
        return bookingDao.getBookings(stuNum);
    }
    public boolean saveBooking(BookingDO bookingDO){
        return bookingDao.saveBooking(bookingDO);
    }
}
