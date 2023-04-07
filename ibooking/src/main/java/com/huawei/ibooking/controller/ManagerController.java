package com.huawei.ibooking.controller;

import com.huawei.ibooking.business.StudyRoomBusiness;
import com.huawei.ibooking.model.StudyRoomDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    private StudyRoomBusiness studyRoomBus;
    @RequestMapping(value = {"manager"})
    public String index(Model model) {
        List<StudyRoomDO> studyRoomDOList=studyRoomBus.getStudyRooms();
        model.addAttribute("studyrooms",studyRoomDOList);
        return "manager/manager";
    }
}
