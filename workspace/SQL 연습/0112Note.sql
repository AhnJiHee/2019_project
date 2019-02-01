<Create Table>
-- 회원가입 정보 저장 테이블
create table member (id varchar2(10), password number(5),
		name varchar2(30), phone varchar2(20), indate date);
		
<Alter Table>
alter table member add(email varchar2 (30))
alter table member modify(email varchar2 (40))
alter table member drop column email

<Drop Table>
drop table member
-- 만약 alter table 사용하지 않고 컬럼 수정하고 싶다면
create table member_copy as select * from member
-- 백업한 이후에 필요한 정보를 추가해서 table을 재정의하는 방법도 있다

create table member (id varchar2(10), password number(5),
		name varchar2(30), phone varchar2(20), indate date,
		email varchar2(30));

<조건 부여하기>
-- constraint 제약조건명 제약조건타입
create table member (
	id varchar2(10) constraint member_id_pk primary key,
	password number(5) constraint member_pw_nn not null,
	name varchar2(30), 
	phone varchar2(20) constraint member_phone_ck check (phone like '010%'),
	indate date,
	email varchar2(30) constraint member_email_uq unique);

PRIMARY KEY : 중복 방지 + 공백 방지
NOT NULL : 공백 방지
CHECK (확인 조건) : 조건 확인
UNIQUE : 중복 방지

-- member 테이블의 id 컬럼값들을 employees 테이블
-- employee_id 값들만 저장할 수 있다면?
-- 외부테이블의 컬럼 값들을 참조해야 한다
create table member(column1, column2, ... , 
id varchar2(10) constraint member_id_ref references employees(employee_id))

<Insert>
insert into member (id, password, name, email, phone, indate)
values ('oracle', 1111, '홍길동', 'ora@multi.com', '010-2222-3333', sysdate)
select * from member;

-- 입력하지 않은 컬럼에는 자동으로 null 입력
insert into member (id, password)
values ('oracle2', 1111)

-- 물론 null을 직접 입력해줘도 된다
insert into member (id, password, name, email, phone, indate)
values ('oracle3', 1111, null, null, nULl, NULL)
		
-- employees 테이블의 값을 복사해서 member로 옮기고 싶다
insert into member(id, email, password)
select employee_id, email, manager_id from employees
where first_name != 'Steven'

insert into member 
values ('oracle4', 1111, '홍길동', '070-2222-3333', sysdate, 'ora4@multi.com' )

1. 테이블 생성 + 데이터 복사
create table ... as select
2. 데이터만 복사
insert into ... select
3. 제약조건의 효력은 insert 시 발생

<Delete>
delete member
where ID like '1%'
or ID like '2%'
or ID like '3%'

select indate, phone from member;
commit
insert into member 
values ('oracle4', 1111, '홍길동', '010-2222-3333', sysdate, 'ora4@multi.com' )
	
delete member where id='oracle4' or id='oracle5'
rollback
		
<Update>
<예제>
update member set phone = '010-9999-0987', name = '이길동' where id = 'oracle4'
--전화번호 4자리가 0987인 회원이 있다면 회원과 같은 날짜에
-- 가입한 회원의 가입 날짜를 내일로 바꾸자
update member set indate = sysdate +1
where to_char(indate,'yyyy-mm-dd') 
= (select to_char(indate,'yyyy-mm-dd')
from member where phone like '%0987' )

-- 데이터 삭제하기
drop table 테이블명 => 테이블까지 완전히 삭제, 
							=> commit/rollback 안됨
delete 테이블명 => 테이블은 삭제하지 않음
					  => commit/rollback 가능
					  
select * from member
select * from board

		