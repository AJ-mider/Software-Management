drop table if exists tbl_student;
create table tbl_student
(
    id       int         not null auto_increment,
    stuNum   varchar(16) not null,
    name     varchar(16) not null,
    password varchar(16) not null,
    primary key (id),
    unique (stuNum)
);
drop table if exists tbl_manager;
create table tbl_manager
(
    id       int         not null auto_increment,
    managerNum   varchar(16) not null,
    name     varchar(16) not null,
    password varchar(16) not null,
    primary key (id),
    unique (managerNum)
);
drop table if exists tbl_studyroom;
create table tbl_studyroom
(
    id           int         not null auto_increment,
    studyroomNum varchar(16) not null,
    openTime int not null,
    closeTime int not null,
    isOpen boolean not null,
    primary key (id)
);

drop table if exists tbl_seat;
create table tbl_seat
(
    id          int not null auto_increment,
    studyroomNum varchar(16) not null,
    seatNum int not null,
    isBooking boolean not null,
    primary key (id)
);

drop table if exists tbl_booking;
create table tbl_booking
(
    id            int not null auto_increment,
    seatId        int not null,
    stuNum        varchar(16) not null,

--     0
    studyroomNum varchar(16) not null,

--     yyyy-mm-dd-hh
    bookingPeriodStartTime VARCHAR(16) not null,
    bookingPeriodEndTime VARCHAR(16) not null,
    primary key (id)
);
