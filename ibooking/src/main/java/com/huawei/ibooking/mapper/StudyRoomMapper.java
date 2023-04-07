package com.huawei.ibooking.mapper;

import com.huawei.ibooking.model.StudyRoomDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudyRoomMapper {
    List<StudyRoomDO> getStudyRooms();

    List<StudyRoomDO> getStudyRoom(@Param("studyroomNum") String studyroomNum);

    int saveStudyRoom(@Param("studyroom") StudyRoomDO studyroom);

    int updateStudyRoom(@Param("studyroom") StudyRoomDO studyroom);

    int deleteStudyRoom(@Param("studyroomNum") String studyroomNum);
}
