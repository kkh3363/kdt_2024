-- 테이터 베이스 선택
use movie;

-- 테이블 생성 : 극장 (theater)
CREATE TABLE theater (
    theaterNum INTEGER PRIMARY KEY,
    theaterName VARCHAR(20),
    theaterLocation VARCHAR(20)
);

-- 테이블 생성 : 고객 (Users)
CREATE TABLE users (
    userNum INTEGER PRIMARY KEY,
    userName VARCHAR(20),
    userAddress VARCHAR(20)
);

-- 테이블 생성 : 상영관 (Cinema)
CREATE TABLE cinema (
    theaterNum INTEGER NOT NULL,
    cinemaNum INTEGER PRIMARY KEY,
    movieName VARCHAR(20),
    price INTEGER,
    seat INTEGER,
    FOREIGN KEY (theaterNum)
        REFERENCES theater (theaterNum)
);

-- 테이블 생성 : 예약 (reservation)
CREATE TABLE reservation (
    theaterNum INTEGER NOT NULL,
    cinemaNum INTEGER NOT NULL,
    userNum INTEGER NOT NULL,
    seatNum INTEGER,
    date DATE,
    FOREIGN KEY (theaterNum)
        REFERENCES theater (theaterNum),
    FOREIGN KEY (cinemaNum)
        REFERENCES cinema (cinemaNum),
    FOREIGN KEY (userNum)
        REFERENCES users (userNum)
);

-- 테이블 데이터 생성 : 극장 (theater)
insert into theater(theaterNum, theaterName, theaterLocation) 
	values(1,"롯데", "잠실");
insert into theater(theaterNum, theaterName, theaterLocation) 
	values(2,"메가", "강남");
insert into theater(theaterNum, theaterName, theaterLocation) 
	values(3,"대한", "잠실");
	
-- 테이블 데이터 생성 : 상영관 (cinema)
insert into cinema(theaterNum, cinemaNum, movieName, price, seat)
	values(1, 1, "어려운 영화", 15000, 48);
insert into cinema(theaterNum, cinemaNum, movieName, price, seat)
	values(3, 3, "멋진 영화", 7500, 120);
insert into cinema(theaterNum, cinemaNum, movieName, price, seat)
	values(3, 2, "재밌는 영화", 8000, 110);
    
-- 테이블 데이터 생성 : 고객 (users)
insert into users(userNum, userName, userAddress)
	values(3,"홍길동","강남");
insert into users(userNum, userName, userAddress)
	values(4,"김철수","잠실");
insert into users(userNum, userName, userAddress)
	values(9,"박영희","강남");
    
-- 테이블 데이터 생성 : 예약 (reservation)
insert into reservation(theaterNum, cinemaNum, userNum, seatNum, date)
	values(3,2,3,15,"2014-09-01");
insert into reservation(theaterNum, cinemaNum, userNum, seatNum, date)
	values(3,3,4,16,"2014-09-01");
insert into reservation(theaterNum, cinemaNum, userNum, seatNum, date)
	values(1,1,9,48,"2014-09-01");
