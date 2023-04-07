package com.huawei.ibooking.business;

import com.huawei.ibooking.dao.SeatDao;
import com.huawei.ibooking.model.SeatDO;
import com.huawei.ibooking.model.StudentDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeatBusiness {
    @Autowired
    private SeatDao seatDao;
    public List<SeatDO> getSeat(String studyroomNum,int seatNum){
        return seatDao.getSeat(studyroomNum,seatNum);
    }
    public List<SeatDO> getSeats(String studyroomNum){
        return seatDao.getSeats(studyroomNum);
    }
    public List<SeatDO> getSeatsOpen(String studyroomNum){
        return seatDao.getSeatsOpen(studyroomNum);
    }

    public String getEmptyRoom() {
        return seatDao.getEmptyRoom();
    }
    public int  getEmptySeat(String studyroomNum) {return seatDao.getEmptySeat(studyroomNum);}



    public boolean saveSeat(SeatDO seat){
        return seatDao.saveSeat(seat);
    }

    public boolean deleteSeat(String studyroomNum,int seatNum){
        return seatDao.deleteSeat(studyroomNum,seatNum);
    }

    public boolean updateSeat(int seatNum) {
        return seatDao.updateSeat(seatNum);
    }
}
