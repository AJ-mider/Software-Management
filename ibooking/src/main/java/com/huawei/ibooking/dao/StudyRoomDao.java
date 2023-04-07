package com.huawei.ibooking.dao;

import com.huawei.ibooking.mapper.StudyRoomMapper;
import com.huawei.ibooking.model.StudyRoomDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudyRoomDao {
    @Autowired
    private StudyRoomMapper studyRoomMapper;

    public List<StudyRoomDO> getStudyRooms() {
        return studyRoomMapper.getStudyRooms();
    }

    public List<StudyRoomDO> getStudyRoom(final String studyroomNum) {
        return studyRoomMapper.getStudyRoom(studyroomNum);
    }

    public boolean saveStudyRoom(final StudyRoomDO studyroom) {
        return studyRoomMapper.saveStudyRoom(studyroom) > 0;
    }

    public boolean updateStudyRoom(final StudyRoomDO studyRoomDO) {
        return studyRoomMapper.updateStudyRoom(studyRoomDO) > 0;
    }

    public boolean deleteStudyRoom(final String studyroomNum) {
        return studyRoomMapper.deleteStudyRoom(studyroomNum) > 0;
    }

}
