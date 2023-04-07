package com.huawei.ibooking.controller;

import com.huawei.ibooking.business.BookingBusiness;
import com.huawei.ibooking.business.SeatBusiness;
import com.huawei.ibooking.business.StudentBusiness;
import com.huawei.ibooking.business.StudyRoomBusiness;
import com.huawei.ibooking.model.BookingDO;
import com.huawei.ibooking.model.StudyRoomDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BookingController {
    @Autowired
    private StudyRoomBusiness studyRoomBus;
    @Autowired
    private BookingBusiness bookingBus;
    @Autowired
    private StudentBusiness studentBus;
    @Autowired
    private SeatBusiness seatBus;
    @GetMapping(value = "/student/bookings/{stuNum}")
    public String list(@PathVariable("stuNum") String stuNum, Model model){
        System.out.println(stuNum);
        final List<BookingDO> bookings=bookingBus.getBookings(stuNum);
        model.addAttribute("bookings",bookings);
        return "student/booking";
    }


    @GetMapping(value = "/student/historybookings/{stuNum}")
    public String list1(@PathVariable("stuNum") String stuNum, Model model){
        System.out.println(stuNum);
        final List<BookingDO> historybookings=bookingBus.getBookings(stuNum);
        model.addAttribute("historybookings",historybookings);
        return "student/historybookings";
    }

    @GetMapping(value="/student/addBooking/{studyRoomNum}/{seatNum}")
    public String addBooking(@PathVariable("studyRoomNum") String studyRoomNum,
                             @PathVariable("seatNum") int seatNum,
                             Model model){
        model.addAttribute("studyRoomNum",studyRoomNum);
        model.addAttribute("seatNumToEdit",seatNum);
        return "student/addBooking";
    }


    @RequestMapping(value="/student/rapidlyBooking")
    public String rapidlyBooking(Model model){
        model.addAttribute("studyRoomNum",seatBus.getEmptyRoom());
        model.addAttribute("seatNumToEdit",seatBus.getEmptySeat(seatBus.getEmptyRoom()));
        return "student/addBooking";
    }


    @PostMapping(value="/student/addBookingSubmit")
    public String addBookingSubmit(@RequestParam("stuNum") String stuNum,
                                   @RequestParam("studyroomId") String studyroomNum,
                                   @RequestParam("seatId") int seatId,
                                   @RequestParam("bookingPeriodStartTime") String bookingPeriodStartTime,
                                   @RequestParam("bookingPeriodEndTime") String bookingPeriodEndTime,
                                   Model model, HttpSession session){

        BookingDO bookingDO=new BookingDO(stuNum,studyroomNum,seatId,bookingPeriodStartTime,bookingPeriodEndTime);
        bookingBus.saveBooking(bookingDO);
        seatBus.updateSeat(seatId);
        List<StudyRoomDO> studyRoomDOList=studyRoomBus.getStudyRooms();
        model.addAttribute("studyrooms",studyRoomDOList);
        return "student/studentPage";
    }






}
