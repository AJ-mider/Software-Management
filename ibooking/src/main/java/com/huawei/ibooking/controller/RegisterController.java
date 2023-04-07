package com.huawei.ibooking.controller;

import com.huawei.ibooking.business.ManagerBusiness;
import com.huawei.ibooking.business.StudentBusiness;
import com.huawei.ibooking.model.ManagerDO;
import com.huawei.ibooking.model.StudentDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {
    @Autowired
    private StudentBusiness stuBus;
    @Autowired
    private ManagerBusiness managerBus;

    private  boolean isUsernameLegal(String username){
        String regex="^[0-9]+$";
        return username.matches(regex) && username.length()>=6 && username.length()<=10;
    }
    private boolean isPasswordLegal(String password){
        String regex="^[0-9]+$";
        return password.matches(regex) && password.length()>=6 && password.length()<=10;
    }
    @RequestMapping(value = {"/register"})
    public String index() {
        return "register";
    }
    @PostMapping(value={"/registerAccount"})
    public String register(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model){
        if (!isUsernameLegal(username)){
            model.addAttribute("msg","username illegal!");
            return "register";
        }
        if(!isPasswordLegal(password)){
            model.addAttribute("msg","password illegal!");
            return "register";
        }
        if (stuBus.getStudent(username).isPresent()){
            model.addAttribute("msg","stu id already exists!");
            return "register";
        }
        else{
            StudentDO stu=new StudentDO(username,password);
            stuBus.saveStudent(stu);
            model.addAttribute("registerMsg","register successfully!");
            return "index";
        }

    }
//    @PostMapping(value={"/registerAccount"})
//    public String register(
//            @RequestParam("username") String username,
//            @RequestParam("password") String password,
//            @RequestParam("identity") String identity,
//            Model model){
//        if (identity.equals("student"))
//        {
//        if (stuBus.getStudent(username).isPresent()){
//            model.addAttribute("msg","stu id already exists!");
//            return "register";
//        }
//        else{
//            StudentDO stu=new StudentDO(username,password);
//            stuBus.saveStudent(stu);
//            model.addAttribute("registerMsg","register successfully!");
//            return "index";
//        }
//        }
//        else if (identity.equals("manager"))
//        {
//            if (managerBus.getManager(username).isPresent()){
//                return "manager id already exists!";
//            }
//            else{
//                ManagerDO manager=new ManagerDO(username,password);
//                managerBus.saveManager(manager);
//                return "register ok!";
//            }
//        }
//        return "unknown mistake";
//    }
}
