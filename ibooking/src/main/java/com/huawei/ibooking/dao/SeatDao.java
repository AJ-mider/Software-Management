package com.huawei.ibooking.dao;

import com.huawei.ibooking.mapper.SeatMapper;
import com.huawei.ibooking.model.SeatDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeatDao {
    @Autowired
    private SeatMapper seatMapper;
    public List<SeatDO> getSeat(String studyroomNum,int seatNum) {
        return seatMapper.getSeat(studyroomNum,seatNum);
    }
    public List<SeatDO> getSeats(String studyroomNum) {
        return seatMapper.getSeats(studyroomNum);
    }
    public List<SeatDO> getSeatsOpen(String studyroomNum) {
        return seatMapper.getSeatsOpen(studyroomNum);
    }


    public  String getEmptyRoom(){return seatMapper.getEmptyRoom();}
    public  int getEmptySeat(String studyroomNum){return seatMapper.getEmptySeat(studyroomNum);}

    public boolean saveSeat(SeatDO seat) {
        return seatMapper.saveSeat(seat) > 0;
    }

    public boolean deleteSeat(String studyroomNum, int seatNum) {
        return seatMapper.deleteSeat(studyroomNum, seatNum) > 0;
    }

    public boolean updateSeat(int seatNum) {
        return seatMapper.updateSeat(seatNum)>0;
    }
}
