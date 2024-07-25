drop view if exists view2;
select theatername, userName
     from theater  t , reservation  r , users u
	where  t.theaterNum = r.theaterNum and r.userNum = u.userNum;

drop view if exists view_3;
create view view_3
as     
select count(u.userNum)
	from theater t, reservation r, users u
	where t.theaterNum = r.theaterNum and r.userNum = u.userNum  and t.theaterName = '대한' 
    group by r.date
    order by date;
