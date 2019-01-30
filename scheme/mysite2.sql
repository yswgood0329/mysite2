desc board;

select * from board;

select * from user;

delete from board where no=10;



select * from board;


update board set o_no = 2 where no = 6;
update board set o_no = 2 where no = 11;
update board set title='Test Title6', context='Test Context6', o_no=3 where no = 6;

select no, title, write_date, hit, g_no, o_no, depth, user_no from board;

select * from board order by o_no;

select * from (select * from board order by o_no) as a order by g_no;
select no, title, write_date, hit, g_no, o_no, depth, user_no from (select no, title, write_date, hit, g_no, o_no, depth, user_no from board order by o_no) as a order by g_no;



select	no, 
		title, 
        write_date, 
        hit, g_no, 
        o_no, 
        depth, 
        user_no,
        k.name
from	(	select 	a.no, 
					title, 
                    context, 
                    write_date, 
                    hit, 
                    g_no, 
                    o_no, 
                    depth, 
                    user_no, 
                    b.name 
			from 	board a 
            join 	user b 		on b.no = a.user_no 
            where 	b.name like '%f%' 
            order 	by o_no) as k 
order	by g_no;

select a.no, title, context, write_date, hit, g_no, o_no, depth, user_no, b.name from board a join user b on b.no = a.user_no where b.name like '%f%' order by o_no;

desc board;

select no, g_no from board where g_no=0;
select no from board where g_no=0;

update board set g_no = no where no = (select no from (select no from board where g_no=-1) as x) ;

select no from (select no from board where g_no=0) as x;

select no, title, context, write_date from board where no = 1;

select count(*) from board where g_no = 1;
select count(*) from (select no from board where g_no = 1) as x;

insert into board value(null, 'Test Title1', 'Test Content2', current_date(), 0, 1, 0, 0, 4);

insert into board value(null, ?, ?, current_date(), hit, groupNo, orderNo, depth, userNo);

insert 
into 	board 
value	(null, 
		'Test Title4', 
        'Test Context4', 
        current_date(), 
        0, 
        0, 
        (	select 	count(*) 
			from 	(	select 	no 
						from 	board 
                        where 	g_no = 0) 
			as x), 
		0, 
        2);
        
        
        
-- 여기서부터 입니다.
insert into board value(4, 'Test Title4', 'Test Context', current_date(), 0, 4,1,0, 2);
insert into board value(3, 'Test Title3', 'Test Context', current_date(), 0, 3,1,0, 2);
insert into board value(5, 'Test Title5', 'Test Context', current_date(), 0, 3,2,1, 2);
insert into board value(7, 'Test Title7', 'Test Context', current_date(), 0, 3,3,2, 2);
insert into board value(9, 'Test Title9', 'Test Context', current_date(), 0, 3,4,3, 2);
insert into board value(6, 'Test Title6', 'Test Context', current_date(), 0, 3,5,1, 2);
insert into board value(8, 'Test Title8', 'Test Context', current_date(), 0, 3,6,2, 2);
insert into board value(2, 'Test Title2', 'Test Context', current_date(), 0, 2,1,0, 2);
insert into board value(1, 'Test Title1', 'Test Context', current_date(), 0, 1,1,0, 2);

insert into board value(20, 'Test Title', 'Test Context', current_date(), 0, -1,2,1, 2);

select	a.no, title,
        g_no, 
        o_no, 
        depth, 
        b.name 
from	(	select	* 
			from 	board 
            order 	by o_no) as a 
join 	user b
on 		a.user_no = b.no
order	by g_no;

select * from board where no = 12;

select	* 
			from 	board 
            order 	by o_no;


update board set o_no = o_no + 1 where g_no = 3 and o_no >= 2 and no != 10;

update board set g_no = g_no + 1 where g_no >= 1;

select * from board where title like '%t%' order by o_no; -- all
select * from board where title like '%t%' order by o_no; -- title
select * from board where context like '%t%' order by o_no; -- context
select * from board a join user b on b.no = a.user_no where b.name like '%f%' order by o_no; -- user

select 	a.*, b.name from board a join user b on b.no = a.user_no where b.name like '%f%' order by o_no;
select 	a.no, 
					title, 
                    context, 
                    write_date, 
                    hit, 
                    g_no, 
                    o_no, 
                    depth, 
                    user_no, 
                    b.name 
			from 	board a 
            join 	user b 		on b.no = a.user_no 
            where 	b.name like '%f%' 
            order 	by o_no;

select * from board;


select	a.no, title, write_date, hit, g_no, o_no, depth, user_no from		( select * from board where title like '%m%' order by o_no ) as a order 	by g_no;

-- ------------- 다시 시작 입니다.

select	*
from 	( 	select 	a.*, b.name 
			from 	board a 
            join 	user b 	
            on 		b.no = a.user_no 
            where 	b.name like '%d%' 
            or		context like '%d%'
            or 		title like '%d%'
            order 	by o_no  ) as k
order	by g_no;

select * from board;

select * from ( select * from board order by o_no ) as k order by g_no limit 1, 10;
