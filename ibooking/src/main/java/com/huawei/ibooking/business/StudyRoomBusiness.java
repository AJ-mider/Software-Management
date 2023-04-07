package com.huawei.ibooking.business;

import com.huawei.ibooking.dao.StudyRoomDao;
import com.huawei.ibooking.model.StudentDO;
import com.huawei.ibooking.model.StudyRoomDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudyRoomBusiness {
    @Autowired
    private StudyRoomDao studyRoomDao;

    public List<StudyRoomDO> getStudyRooms(){
        return studyRoomDao.getStudyRooms();
    }


    public Optional<StudyRoomDO> getStudyRoom(final String studyroomNum){
        List<StudyRoomDO> studyrooms=studyRoomDao.getStudyRoom(studyroomNum);
        if (studyrooms.isEmpty())
        {
            return Optional.empty();
        }
        return Optional.ofNullable(studyrooms.get(0));
    }

    public boolean saveStudyRoom(final StudyRoomDO studyroom){
        return studyRoomDao.saveStudyRoom(studyroom);
    }
    public boolean updateStudyRoom(final StudyRoomDO studyRoomDO){
        return studyRoomDao.updateStudyRoom(studyRoomDO);
    }
    public boolean deleteStudyRoom(final String studyroomNum){
        return studyRoomDao.deleteStudyRoom(studyroomNum);
    }
}
