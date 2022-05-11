SELECT EMPLOYEE_ID AS 사번
	 , FIRST_NAME AS 이름
	 , LAST_NAME AS 성
	 , DEPARTMENT_ID AS 부서
  FROM EMPLOYEES
 ORDER BY DEPARTMENT_ID DESC NULLS LAST, FIRST_NAME DESC ;
 
SELECT EMPLOYEE_ID AS 사번
	 , FIRST_NAME AS 이름
	 , LAST_NAME AS 성
	 , DEPARTMENT_ID AS 부서
  FROM EMPLOYEES
 ORDER BY 4 DESC NULLS LAST, 이름 DESC ;
 
SELECT DEPARTMENT_ID
	 , COUNT(*)
	 , SUM(SALARY)
	 , AVG(SALARY)
	 , MIN(SALARY)
	 , MAX(SALARY)
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY DEPARTMENT_ID
 ORDER BY DEPARTMENT_ID;
 
SELECT COUNT(*)
     , DECODE(COMMISSION_PCT, NULL, 'NO', 'YES')
  FROM EMPLOYEES e 
 GROUP BY DECODE(COMMISSION_PCT, NULL, 'NO', 'YES');
 
-- 1980 년대, 1990 년대, 2000년대 별로 그룹을 묶어서 평균 급여와 총인원 수를 구한다.
SELECT TRUNC(EXTRACT(YEAR FROM HIRE_DATE), -1) AS 년도
     , AVG(SALARY) AS 평균급여
	 , COUNT(*) AS 인원
  FROM EMPLOYEES
 GROUP BY TRUNC(EXTRACT(YEAR FROM HIRE_DATE), -1);
 
-- 커미션 받는 직원 중 가장 높은 급여액과 가장 낮은 급여액을 구한다.
SELECT MAX(SALARY)
     , MIN(SALARY)
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL;

-- DEPARTMENTS 테이블에서 MANAGER_ID가 NULL 인 부서의 수와 아닌 부서의 수를 구한다.

SELECT DECODE(MANAGER_ID, NULL, 'NO', 'YES')
     , COUNT(*)
  FROM DEPARTMENTS
 GROUP BY DECODE(MANAGER_ID, NULL, 'NO', 'YES');
 
/*
 * EMPLOYEES 테이블에서 급여 통계를 위해 급여 구역별 인원수를 구한다.
 * 급여 구역은 2000 부터 1000단위로 분류하도록 한다.
 */
SELECT TRUNC(SALARY, -3)
     , COUNT(*)
  FROM EMPLOYEES
 GROUP BY TRUNC(SALARY, -3);
 
-- HAVING : 그룹 조건절
SELECT TRUNC(SALARY, -3)
     , COUNT(*)
  FROM EMPLOYEES
 GROUP BY TRUNC(SALARY, -3)
HAVING COUNT(*) >= 10
 ORDER BY 1;
 
SELECT TRUNC(SALARY, -3)
     , COUNT(*)
  FROM EMPLOYEES 
 GROUP BY TRUNC(SALARY, -3)
HAVING COUNT(*) >= 10
 ORDER BY 1;
 
/*
 * 부서별 전화번호 사용 실태를 확인하기 위한 조회 쿼리를 작성한다.
 * 	전화번호 앞 3자리에 따라 다음의 요금이 측정되어있다.
 * 	515 : 월 500원
 *  590 : 월 450원
 *  650 : 월 400원
 *  011 : 월 300원
 *  603 : 월 600원
 * 위의 요금을 참고하여 부서별 월별 통신비를 산출하도록 한다.
*/

SELECT DEPARTMENT_ID AS 부서
     , SUBSTR(PHONE_NUMBER, 1, 3) AS 회선번호
     , COUNT(*) AS 회선수
     , DECODE(SUBSTR(PHONE_NUMBER, 1, 3), '515', 500 * COUNT(*)
     									, '590', 450 * COUNT(*)
     									, '650', 400 * COUNT(*)
     									, '011', 300 * COUNT(*)
     									, '603', 600 * COUNT(*)) AS 총사용요금
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID, SUBSTR(PHONE_NUMBER, 1, 3)
 ORDER BY DEPARTMENT_ID;

SELECT DEPARTMENT_ID
     , COUNT(*)
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID
 ORDER BY 1;

SELECT DEPARTMENT_ID
     , COUNT(*)
  FROM EMPLOYEES
 GROUP BY ROLLUP(DEPARTMENT_ID)
 ORDER BY 1;

SELECT DEPARTMENT_ID
     , JOB_ID
     , COUNT(*)
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID, JOB_ID
 ORDER BY 1;

SELECT DEPARTMENT_ID
     , JOB_ID
     , COUNT(*)
  FROM EMPLOYEES
 GROUP BY CUBE(DEPARTMENT_ID, JOB_ID)
 ORDER BY 1;




SELECT DEPARTMENT_ID
     , JOB_ID
     , COUNT(*)
     , CASE WHEN GROUPING(DEPARTMENT_ID) = 0 AND GROUPING(JOB_ID) = 0 THEN '부서/직급별집계'
            WHEN GROUPING(DEPARTMENT_ID) = 0 AND GROUPING(JOB_ID) = 1 THEN '부서별집계'
            WHEN GROUPING(DEPARTMENT_ID) = 1 AND GROUPING(JOB_ID) = 0 THEN '집급별집계'
            WHEN GROUPING(DEPARTMENT_ID) = 1 AND GROUPING(JOB_ID) = 1 THEN '총집계'
       END AS 집계구분
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY CUBE(DEPARTMENT_ID, JOB_ID)
 ORDER BY 1;



SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 100
UNION ALL
SELECT *
  FROM EMPLOYEES
 WHERE MANAGER_ID = 101;

SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 100
UNION
SELECT *
  FROM EMPLOYEES
 WHERE MANAGER_ID = 101;

SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 100
INTERSECT
SELECT *
  FROM EMPLOYEES
 WHERE MANAGER_ID = 101;

SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 100
MINUS
SELECT *
  FROM EMPLOYEES
 WHERE MANAGER_ID = 101;

SELECT DEPARTMENT_ID
     , NULL AS JOB_ID
     , COUNT(*)
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL 
 GROUP BY DEPARTMENT_ID 
UNION ALL 
SELECT NULL AS DEPARTMENT_ID 
	 , JOB_ID 
	 , COUNT(*)
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL 
 GROUP BY JOB_ID;

SELECT DEPARTMENT_ID
     , JOB_ID
     , COUNT(*)
  FROM EMPLOYEES 
 WHERE DEPARTMENT_ID IS NOT NULL 
 GROUP BY GROUPING SETS(DEPARTMENT_ID, JOB_ID)
 ORDER BY 1;
