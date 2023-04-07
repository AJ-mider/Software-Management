package com.huawei.ibooking.controller;

import com.huawei.ibooking.business.SeatBusiness;
import com.huawei.ibooking.business.StudentBusiness;
import com.huawei.ibooking.business.StudyRoomBusiness;
import com.huawei.ibooking.model.SeatDO;
import com.huawei.ibooking.model.StudyRoomDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.List;

@Controller
public class StudyRoomManagementController {
    @Autowired
    private StudyRoomBusiness studyRoomBus;
    @Autowired
    private StudentBusiness studentBus;
    @Autowired
    private SeatBusiness seatBusiness;

    private boolean isTimeLegal(int time){
        if (time<0 || time>24){
            return false;
        }
        return  true;
    }
    private boolean isSeatNumLegal(int seatNum){
        if(seatNum<0||seatNum>100){
            return false;
        }
        return true;
    }

    @GetMapping(value = "/manager/studyroomManagement")
    public String studyroom(Model model) {
        List<StudyRoomDO> studyRoomDOList=studyRoomBus.getStudyRooms();
        for (int i=0;i<studyRoomDOList.size();i++) {
            System.out.println(studyRoomDOList.get(i).getStudyRoomNum());
            System.out.println(studyRoomDOList.get(i).getIsOpen());
        }
        model.addAttribute("studyrooms",studyRoomDOList);
        return "manager/studyroomManagement";
    }
    @GetMapping(value="/manager/addStudyroom")
    public String addStudyroom(Model model){
        return "manager/addStudyroom";
    }

    @PostMapping(value="/manager/addStudyroomSubmit")
    public String addStudyroomSubmit(@RequestParam("studyroomNum") String studyroomNum,
                                     @RequestParam("openTime") int openTime,
                                     @RequestParam("closeTime") int closeTime,
                                     Model model){
        if (studyroomNum.isEmpty()){
            model.addAttribute("msg","wrong studyroomNum!");
            return "manager/addStudyroom";
        }
        if(closeTime<=openTime || !isTimeLegal(openTime) || !isTimeLegal(closeTime)){
            model.addAttribute("msg","wrong time!");
            return "manager/addStudyroom";
        }
        StudyRoomDO studyroom=new StudyRoomDO(studyroomNum,openTime,closeTime);
        studyRoomBus.saveStudyRoom(studyroom);
        return "redirect:/manager";
    }

    @GetMapping(value="/manager/getSeat/{studyroomId}")
    public String getSeat(@PathVariable("studyroomId") String studyroomNum,Model model){
        System.out.println(studyroomNum);
        List<SeatDO> seats=seatBusiness.getSeats(studyroomNum);
        model.addAttribute("seats",seats);

        return "manager/seat";
    }
//    @GetMapping(value="/manager/getSeatOpen/{studyroomId}")
//    public String getSeatOpen(@PathVariable("studyroomId") String studyroomNum,Model model){
//        System.out.println(studyroomNum);
//        List<SeatDO> seats=seatBusiness.getSeatsOpen(studyroomNum);
//        model.addAttribute("seats",seats);
//
//        return "/manager/seat";
//    }
    @GetMapping(value="/manager/getSeatList/{studyroomId}")
    public String getSeatList(@PathVariable("studyroomId") String studyroomNum,Model model){
        System.out.println(studyroomNum);
        List<SeatDO> seats=seatBusiness.getSeats(studyroomNum);
        model.addAttribute("seats",seats);
        return "manager/seatList";
    }
    @GetMapping(value="/manager/getSeatListOpen/{studyroomId}")
    public String getSeatListOpen(@PathVariable("studyroomId") String studyroomNum,Model model){
        System.out.println(studyroomNum);
        List<SeatDO> seats=seatBusiness.getSeatsOpen(studyroomNum);
        model.addAttribute("seats",seats);
        return "manager/seatList";
    }
    @GetMapping(value="/manager/addSeat/{studyroomNum}")
    public String addSeat(@PathVariable("studyroomNum") String studyroomNum,
                          Model model){
        model.addAttribute("studyroomNumToEdit",studyroomNum);
        return "manager/addSeat";
    }
    @GetMapping(value="/manager/deleteSeat/{studyroomNum}/{seatNum}")
    public String deleteSeat(@PathVariable("studyroomNum") String studyroomNum,@PathVariable("seatNum") int seatNum,
                          Model model){
        seatBusiness.deleteSeat(studyroomNum,seatNum);
        return "redirect:/manager/getSeat/"+studyroomNum;
    }
    @PostMapping(value="/manager/addSeatSubmit")
    public String addSeatSubmit(@RequestParam("studyroomNum") String studyroomNum,
                                @RequestParam("seatNum") int seatNum,
                                Model model){
        SeatDO seat=new SeatDO(studyroomNum,seatNum);
        model.addAttribute("studyroomNumToEdit",studyroomNum);
        if(!studyRoomBus.getStudyRoom(studyroomNum).isPresent()){
            model.addAttribute("msg","studyroom doesn't exist!");
            return "manager/addSeat";
        }
        if (!seatBusiness.getSeat(studyroomNum,seatNum).isEmpty()){
            model.addAttribute("msg","seat already exist!");
            return "manager/addSeat";
        }
        if(!isSeatNumLegal(seatNum)){
            model.addAttribute("msg","wrong seat num!");
            return "manager/addSeat";
        }
        seatBusiness.saveSeat(seat);
        model.addAttribute("msg","add seat successfully!");
        return "manager/addSeat";
    }

    @GetMapping(value="/manager/deleteStudyroom/{studyroomNum}")
    public String deleteStudyroom(@PathVariable("studyroomNum") String studyroomNum)
    {
        studyRoomBus.deleteStudyRoom(studyroomNum);
        return "redirect:/manager";
    }

    @GetMapping(value="/manager/openStudyroom/{studyroomNum}")
    public String openStudyroom(@PathVariable("studyroomNum") String studyroomNum)
    {
        StudyRoomDO studyRoomDO=studyRoomBus.getStudyRoom(studyroomNum).get();
        System.out.println(studyroomNum);
        System.out.println(studyRoomDO.getIsOpen());
        studyRoomDO.setIsOpen(true);
        System.out.println(studyRoomBus.updateStudyRoom(studyRoomDO));
        return "redirect:/manager";
    }

    @GetMapping(value="/manager/closeStudyroom/{studyroomNum}")
    public String closeStudyroom(@PathVariable("studyroomNum") String studyroomNum)
    {
        StudyRoomDO studyRoomDO=studyRoomBus.getStudyRoom(studyroomNum).get();
        studyRoomDO.setIsOpen(false);
        studyRoomBus.updateStudyRoom(studyRoomDO);
        return "redirect:/manager";
    }

    @RequestMapping(value="/manager/editStudyroomTime/{studyroomNum}")
    public String editStudyroomTime(@PathVariable("studyroomNum") String studyroomNum,Model model)
    {
        StudyRoomDO studyRoomDO=studyRoomBus.getStudyRoom(studyroomNum).get();
        model.addAttribute("studyroomToEdit",studyRoomDO);
        return "manager/editStudyroomTime";
    }

    @PostMapping(value="/manager/editStudyroomTimeSubmit")
    public String editStudyroomTimeSubmit(@RequestParam("studyroomNum") String studyroomNum,
                                          @RequestParam("openTime") int openTime,
                                          @RequestParam("closeTime") int closeTime,
                                          RedirectAttributesModelMap model)
    {
        if(closeTime<=openTime){
            model.addFlashAttribute("msg","wrong time!");
            return "redirect:/manager/editStudyroomTime/"+studyroomNum;
        }
        StudyRoomDO studyRoomDO=studyRoomBus.getStudyRoom(studyroomNum).get();
        studyRoomDO.setOpenTime(openTime);
        studyRoomDO.setCloseTime(closeTime);
        studyRoomBus.saveStudyRoom(studyRoomDO);
        return "redirect:/manager";
    }

//    @GetMapping(value = "/studentManagement")
//    public String student(Model model) {
//        model.addAttribute("students",studentBus.getStudents());
//        return "studentManagement";
//    }

}
