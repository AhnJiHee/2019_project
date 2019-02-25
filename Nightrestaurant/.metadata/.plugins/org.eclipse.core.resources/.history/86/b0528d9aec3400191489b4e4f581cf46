
<!-- 	int[] pageinfo = dao.getPage(list); -->

conn board/board
select * from board; 
select * from member;

select boardseq 번호, boardtitle 제목,  boardwriter 작성자,
to_char(boardtime, 'YYYY/MM/DD hh24:mi:ss') 작성시간, boardviewcount 조회수
from board 
where boardcontents like '%한번%'

alter table board drop column step
delete 

where boardseq=4 order by 번호 desc
update board set boardviewcount = (select max(boardviewcount)+1 from board) where boardseq=3
update board set boardtitle = '수정 시험' , boardcontents = '수정 시험' where boardseq =16
delete board where boardseq = 10
select to_char(sysdate, 'YYYY/MM/DD hh24:mi:ss') from board;

insert into board values (1, '제목', '내용', 'admin', sysdate, 0)

insert into board values ((select max(boardseq)+1 from board), '제목', '내용', '작성자',
sysdate, 0)

create table member (
		id varchar2(20) primary key,
		password varchar2(10) not null,
		name varchar2(30) not null,
		phone varchar2(15), 
		indate date,
		email varchar2(30)
);
insert into member values ('hr', '123', '운영자', '010-1234-5678', sysdate, 'pchmarine@naver.com')

페이징 처리 sql
select r, boardseq, boardtime 
from (select rownum r, boardseq, boardtime
		from ( select rownum, boardseq, boardtime from board order by boardtime desc)
		order by boardtime desc)

sql은 from-select-order by 순으로 실행되기 때문에
rownum을 order된 순서로 하려면 from절을 똑같이 만들어 붙여넣어주면 된다
그런데 rownum은 범위를 지정할때 끝값이 없으면 아예 출력을 안해주기 때문에 마지막으로
select문을 한번 더 감싸야 한다
rownum : select할때 레코드 번호를 생성해주는 내장함수 // 게시물 페이징 처리


select X.r, X.boardseq 번호, X.boardtitle 제목, X.boardwriter 작성자, 
 to_char(X.boardtime, 'YYYY/MM/DD hh24:mi:ss') 작성시간, X.boardviewcount 조회수
 from (
 	select rownum r, A.boardseq, A.boardtitle, A.boardwriter, A.boardtime, A.boardviewcount
 	from (
 			select * from board order by boardtime desc) A
 	where rownum <= 20) X
 where X.r >=11
 
 
 select count(*) from board

 
 select X.rnum, X.boardseq, X.boardtitle, X.boardwriter, X.boardtime, X.boardviewcount
from ( 
    select rownum as rnum, A.boardseq, A.boardtitle, A.boardwriter, A.boardtime, A.boardviewcount
    from (
        select boardseq, boardtitle, boardwriter, boardtime, boardviewcount
        from board
        order by boardtime desc) A
    where rownum <= 20) X
where X.rnum >= 11
 
 
 /////////////////////////////////////////////////////////////////////////////////
 select * from member
 
 
 
 create table restaurant (
	province varchar2(20),
	address varchar2(100),
	closetime varchar2(100),
	name varchar2(100),
	tag varchar2(20),
	keyword varchar2(100)
)

insert into restaurant values ('광진구', '구의동 51-8', '24', '찬희네 집', '한식', '김치볶음밥')
insert into restaurant values ('강남구', ' 테헤란로 212', '22', '멀티캠퍼스', '뷔페', '자율배식')
select province 구, address 주소, closetime 마감시간, name 가게명, tag 종목, keyword 키워드
	from restaurant order by 가게명
 

 
 
