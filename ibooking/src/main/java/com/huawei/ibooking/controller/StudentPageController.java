package com.huawei.ibooking.controller;

import com.huawei.ibooking.business.SeatBusiness;
import com.huawei.ibooking.business.StudyRoomBusiness;
import com.huawei.ibooking.model.SeatDO;
import com.huawei.ibooking.model.StudyRoomDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentPageController {
    @Autowired
    SeatBusiness seatBusiness;
    @Autowired
    StudyRoomBusiness studyRoomBus;


//    @RequestMapping(value = "/studentPage")
//    public String index() {
//        return "student/studentPage";
//    }

    @RequestMapping(value="/back/studentPage")
    public String backward(Model model, HttpSession session)
    {
        List<StudyRoomDO> studyRoomDOList=studyRoomBus.getStudyRooms();
        model.addAttribute("studyrooms",studyRoomDOList);
        return "student/studentPage";
    }

    @GetMapping(value = "/student/getSeatList/{studyroomId}")
    public String getSeatList(@PathVariable("studyroomId") String studyroomNum, Model model) {
        System.out.println(studyroomNum);
        List<SeatDO> seats = seatBusiness.getSeats(studyroomNum);
        model.addAttribute("seats", seats);
        return "student/seatList";
    }

    @GetMapping(value = "/student/getSeatListOpen/{studyroomId}")
    public String getSeatListOpen(@PathVariable("studyroomId") String studyroomNum, Model model) {
        System.out.println(studyroomNum);
        List<SeatDO> seats = seatBusiness.getSeatsOpen(studyroomNum);
        model.addAttribute("seats", seats);
        return "student/seatList";
    }

    @GetMapping(value = "/student/studyroomList")
    public String studyroomList(Model model) {
        model.addAttribute("studyrooms", studyRoomBus.getStudyRooms());
        return "student/studyroomList";

    }
}
