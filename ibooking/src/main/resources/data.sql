insert into tbl_student (stuNum, name, password)
values ('01010101', '01010101', 'test123'),
       ('01010102', '01010102', 'test123'),
       ('01010103', '01010103', 'test123'),
       ('01010104', '01010104', 'test123'),
       ('01010105', '01010105', 'test123'),
       ('111111', 'test_stu', '111111');
insert into tbl_manager (managerNum, name, password)
values ('11010101', '11010101', 'test123'),
       ('11010102', '11010102', 'test123'),
       ('11010103', '11010103', 'test123'),
       ('11010104', '11010104', 'test123'),
       ('11010105', '11010105', 'test123'),
       ('222222', 'test_manager', '222222');
insert into tbl_studyroom (studyroomNum,openTime,closeTime,isOpen)
values ('A-101',10,22,true),
       ('A-201',10,22,true),
       ('A-301',10,22,false),
       ('B-201',10,22,false),
       ('B-202',10,22,true);
insert into tbl_seat (studyRoomNum,seatNum,isBooking)
values ('A-101',1,false),
       ('A-101',2,false),
       ('A-101',3,false),
       ('A-201',1,false),
       ('A-201',2,false),
       ('A-201',3,false),
       ('A-301',1,false),
       ('A-301',2,false),
       ('A-301',3,false),
       ('B-201',1,false),
       ('B-201',2,false),
       ('B-201',3,false),
       ('B-202',1,false),
       ('B-202',2,false),
       ('B-202',3,false);

insert into tbl_booking (seatId,stuNum,bookingPeriodStartTime,bookingPeriodEndTime,studyroomNum)
values (1,111111,'2022-05-08-10','2022-05-10-10','A-101'),
       (2,111111,'2022-05-08-10','2022-05-10-10','A-101'),
       (3,111111,'2022-05-08-10','2022-05-10-10','A-101'),
       (4,111111,'2022-05-08-10','2022-05-10-10','A-101'),
       (5,111111,'2022-05-08-10','2022-05-10-10','A-101');

