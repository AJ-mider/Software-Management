package com.huawei.ibooking.mapper;

import com.huawei.ibooking.model.SeatDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SeatMapper {
    List<SeatDO> getSeats(@Param("studyroomNum") String studyroomNum);
    List<SeatDO> getSeat(@Param("studyroomNum") String studyroomNum,@Param("seatNum") int seatNum);
    List<SeatDO> getSeatsOpen(@Param("studyroomNum") String studyroomNum);
    int saveSeat(@Param("seat") SeatDO seat);


    String getEmptyRoom();
    int getEmptySeat(@Param("studyroomNum") String studyroomNum);

    int deleteSeat(@Param("studyroomNum") String studyroomNum,@Param("seatNum") int seatNum);

    int updateSeat(@Param("seatNum") int seatNum);
}
