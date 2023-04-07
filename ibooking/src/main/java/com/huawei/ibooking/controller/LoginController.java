package com.huawei.ibooking.controller;

import com.huawei.ibooking.business.ManagerBusiness;
import com.huawei.ibooking.business.StudentBusiness;
import com.huawei.ibooking.business.StudyRoomBusiness;
import com.huawei.ibooking.model.StudentDO;
import com.huawei.ibooking.model.StudyRoomDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private StudentBusiness stuBus;
    @Autowired
    private ManagerBusiness managerBus;
    @Autowired
    private StudyRoomBusiness studyRoomBus;
    @PostMapping(value = {"login"})
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("identity") String identity,
            Model model, HttpSession session) {
        System.out.println(username+password+identity);
        if (identity.equals("student")){
            if(!stuBus.getStudent(username).isPresent())
            {
                model.addAttribute("msg","account doesn't exist!");
                return "index";
            }
            if(!stuBus.getStudent(username).get().getPassword().equals(password))
            {
                model.addAttribute("msg","wrong password!");
                return "index";
            }
            List<StudyRoomDO> studyRoomDOList=studyRoomBus.getStudyRooms();
            model.addAttribute("studyrooms",studyRoomDOList);
            session.setAttribute("stuNum",username);
            return "student/studentPage";
        }
        else if (identity.equals("manager")){
            if(!managerBus.getManager(username).isPresent())
            {
                model.addAttribute("msg","account doesn't exist!");
                return "index";
            }
            if(!managerBus.getManager(username).get().getPassword().equals(password))
            {
                model.addAttribute("msg","wrong password!");
                return "index";
            }
            List<StudyRoomDO> studyRoomDOList=studyRoomBus.getStudyRooms();
            model.addAttribute("studyrooms",studyRoomDOList);
            session.setAttribute("managerNum",username);
            return "manager/manager";
        }

        return "index";
    }
}
