package com.huawei.ibooking.controller;

import com.huawei.ibooking.business.StudyRoomBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudyRoomController {
    @Autowired
    private StudyRoomBusiness studyRoomBus;
    @GetMapping(value = "/studyroom")
    public String studyroom() {
        return "studyroom";
    }

}
