
<!-- 	int[] pageinfo = dao.getPage(list); -->

conn board/board
select * from board; 
select * from member;
select * from restaurant;

select boardseq ��ȣ, boardtitle ����,  boardwriter �ۼ���,
to_char(boardtime, 'YYYY/MM/DD hh24:mi:ss') �ۼ��ð�, boardviewcount ��ȸ��
from board 
where boardcontents like '%�ѹ�%'

alter table board drop column step
delete 

where boardseq=4 order by ��ȣ desc
update board set boardviewcount = (select max(boardviewcount)+1 from board) where boardseq=3
update board set boardtitle = '���� ����' , boardcontents = '���� ����' where boardseq =16
delete board where boardseq = 10
select to_char(sysdate, 'YYYY/MM/DD hh24:mi:ss') from board;

insert into board values (1, '����', '����', 'admin', sysdate, 0)

insert into board values ((select max(boardseq)+1 from board), '����', '����', '�ۼ���',
sysdate, 0)

create table member (
		id varchar2(20) primary key,
		password varchar2(10) not null,
		name varchar2(30) not null,
		phone varchar2(15), 
		indate date,
		email varchar2(30)
);
insert into member values ('hr', '123', '���', '010-1234-5678', sysdate, 'pchmarine@naver.com')

����¡ ó�� sql
select r, boardseq, boardtime 
from (select rownum r, boardseq, boardtime
		from ( select rownum, boardseq, boardtime from board order by boardtime desc)
		order by boardtime desc)

sql�� from-select-order by ������ ����Ǳ� ������
rownum�� order�� ������ �Ϸ��� from���� �Ȱ��� ����� �ٿ��־��ָ� �ȴ�
�׷��� rownum�� ������ �����Ҷ� ������ ������ �ƿ� ����� �����ֱ� ������ ����������
select���� �ѹ� �� ���ξ� �Ѵ�
rownum : select�Ҷ� ���ڵ� ��ȣ�� �������ִ� �����Լ� // �Խù� ����¡ ó��


select X.r, X.boardseq ��ȣ, X.boardtitle ����, X.boardwriter �ۼ���, 
 to_char(X.boardtime, 'YYYY/MM/DD hh24:mi:ss') �ۼ��ð�, X.boardviewcount ��ȸ��
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

insert into restaurant values ('������', '���ǵ� 51-8', '24', '����� ��', '�ѽ�', '��ġ������')
insert into restaurant values ('������', ' ������� 212', '22', '��Ƽķ�۽�', '����', '�������')
select province ��, address �ּ�, closetime �����ð�, name ���Ը�, tag ����, keyword Ű����
	from restaurant order by ���Ը�
 

 
 
