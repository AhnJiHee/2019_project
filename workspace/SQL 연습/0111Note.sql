<함수>
-- length 함수의 이용
select first_name, salary
from employees
where length(first_name) >= 8

-- dual table의 역할
select sysdate from employees
select sysdate from dual

-- instr을 이용한 문자열 인덱스 리턴
select instr(first_name, 'Jen') from employees
where first_name like 'Jen%'

-- 둘은 같은 결과물을 출력한다
select hire_date, employee_id
from employees
where hire_date like '___10%'

select hire_date, employee_id
from employees
where instr(hire_date, '10') = 4

-- 둘은 같은 결과물을 출력한다
select last_name || '-' || first_name 이름
from employees

select concat ( concat ( last_name, '-'), first_name) 이름
from employees

-- mod를 이용해 짝수 사번만 return하기
select employee_id, first_name
from employees
where mod(employee_id, 2) = 0
order by employee_id

-- round 함수 (소숫점 아래 n번째 자리'까지' 반올림)
select round(345.14515411) from dual;
select round(345.17515411, 1) from dual;
select round(345.14515411, 2) from dual;
select round(345.14515411, -1) from dual;
select round(345.14515411, -2) from dual;

-- trunc 함수 (버림)
select trunc(345.14515411) from dual;
select trunc(345.17515411, 1) from dual;
select trunc(345.14515411, 2) from dual;
select trunc(345.14515411, -1) from dual;
select trunc(345.14515411, -2) from dual;

-- 날짜 데이터 함수
-- 날짜와 날짜의 연산값은 일 단위로 return
select first_name 이름 , trunc( (sysdate-hire_date)/365 ) || '년 경과' 근속년수
from employees

select first_name 이름, trunc(months_between(sysdate, hire_date)) || '개월 경과' 근속달수
from employees

select first_name 이름 , trunc( (sysdate-hire_date)/7 ) || '주 경과' 근속주수
from employees

select trunc(sysdate - to_date('1996/02/12'))
from dual

-- 타입변환 함수
select '1000' + 1 from dual
-- 얘는 되지만
select '10,000' +1 from dual
-- 얘는 안 된다
select to_number('10,000', '00,000') +1 from dual
-- to_number : 양식 포매팅 가능
select to_char(10000, '00,000') from dual
-- to_char : 유사한 적용 사례
select sysdate - to_date('19/01/01') from dual
select sysdate - to_date('19/01/01', 'YY/MM/DD') from dual
-- to_date : 문자열을 날짜 형식으로 변환
select to_char(hire_date, 'fmMM"월" DD"일" YYYY"년" HH"시" mi"분" ss"초"') from employees
-- to_char : 날짜를 문자 형식으로 변환

-- 타입변환 정리
날짜 -> 문자 to_char (날짜, 'YYMMDD 포맷')
숫자 -> 문자 to_char (숫자, 출력 결과의 '000,000 포맷') => 0, 9로 1자리 정수 표현
문자 -> 숫자 to_number (문자, 입력 문자의 '000,000 포맷')
문자 -> 날짜 to_date (문자, 'YYMMDD 포맷')

-- 예제
-- Employee 사원의 이름, 부서코드 조회
-- 부서코드가 공백이면 '미배정'
-- 부서코드가 0인 애만 보자
select first_name, nvl(to_char(department_id), '미배정')
from EMPLOYEES
where DEPARTMENT_id is null;
-- department_id 컬럼은 '숫자값'을 가지는데, 여기에 '문자열'을 부여하고 싶다면
-- 숫자를 문자로 바꾸어야 한다.

<join query>
-- select 이후 table이 2개 오는 경우
-- employees : first_name, department_id (사원 정보)
-- departments : department_id, department_name (부서 정보)
-- 사원 이름과 부서명을 한 번에 조회하고 싶다
select * from employees, departments
-- select count(*) from employees => 107개
-- select count(*) from departments => 27개
-- 두 개를 조인해서 조회한 결과물은 107x27개

-- 공통된 컬럼을 이용해 조회할 자료의 개수를 한정시켜줘야한다
select first_name, department_name
from Employees, DEPARTMENTS
where employees.department_id = departments.department_id

<연습문제>
-- 사원의 이름이 Jennifer인 경우만 조회하기
select first_name, department_name
from Employees e, DEPARTMENTS d
where e.department_id = d.department_id and initcap(first_name) = initcap('jennifer')
-- 테이블명에도 별명 지정이 가능하다

-- 모든 사원의 이름과 근무 도시명을 출력
select first_name || '-' || city
from employees e, departments d, locations l
where e.department_id = d.department_id and d.location_id = l.location_id

-- London에 근무하는 사원의 수를 출력
select count(first_name)
from employees e, departments d, locations l
where e.department_id = d.department_id and d.location_id = l.location_id and upper(city) = upper('london')

-- 셀프 조인
-- 각 사원의 본인 사번, 본인 이름, 상사 사번, 상사 이름 조회
-- 사원 / 대리
select me.employee_id 사원사번, me.first_name 사원명, 
nvl(mng.employee_id, 0) 매니저사번, nvl(mng.first_name, 'boss') 매니저명
from employees me, employees mng
where me.manager_id = mng.employee_id(+)

-- 사원이름 + 부서이름
-- 부서가 없는 사람도 같이 (아우터 조인)
select first_name, nvl(department_name, '미배정')
from Employees, DEPARTMENTS
where employees.department_id = departments.department_id(+)

<subquery>
-- sarah와 부서 코드가 같은 사원들의 이름과 부서 코드를 출력하고 싶다
-- => sarah의 부서 코드를 조회하는 subquery를 where문 안에 포함시키면 된다
select first_name, department_id
from employees
where department_id =
	(select department_id 
	from employees 
	where upper(first_name) = upper('sarah'))
	
-- 만약 비교대상이 jennifer였다면?
-- jennifer는 2명이므로 출력되는 값도 두개다
select first_name, department_id
from employees
where department_id in 
	(select department_id 
	from employees 
	where upper(first_name) = upper('jennifer'))
	
-- 내 급여가 jennifer의 급여보다 많은 사원만 조회
-- 대소비교 연산자 뒤에 any를 쓰면 조건 중 하나만 만족해도 조회
select first_name, salary
from employees
where salary >= any
	(select salary
	from employees
	where upper(first_name) = upper('jennifer'))

-- 대소비교 연산자 뒤에 all을 쓰면 조건 모두 만족해야 조회
select first_name, salary
from employees
where salary >= all
	(select salary
	from employees
	where upper(first_name) = upper('jennifer'))

-- 단일행 서브쿼리 연산자
where 컬럼명 = (subquery)
where 컬럼명 > (subquery)
where 컬럼명 < (subquery)

-- 다중행 서브쿼리 연산자
where 컬럼명 in (subquery)
where 컬럼명 >any || >all (subquery)
where 컬럼명 <any || <any (subquery)


