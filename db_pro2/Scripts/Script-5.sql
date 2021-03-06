SELECT * FROM EMPLOYEES;

SELECT * FROM DEPARTMENTS;

SELECT * FROM JOBS;

SELECT * FROM LOCATIONS;

SELECT * FROM COUNTRIES;

SELECT * FROM REGIONS;

/*
 * EMPLOYEES 테이블을 조회 할 때 JOB_ID, DEPARTMENT_ID 가 ID가 아닌
 * NAME으로 조회될 수 있도록 JOIN을 활용한다.
 * (서브 쿼리로도 사용 가능하기 때문에 서브쿼리로도 만들어본다.)
 */
SELECT E.EMPLOYEE_ID
	 , E.FIRST_NAME || ' ' || E.LAST_NAME AS NAME
	 , E.EMAIL 
	 , E.PHONE_NUMBER 
	 , E.HIRE_DATE 
	 , J.JOB_TITLE 
	 , E.SALARY 
	 , E.COMMISSION_PCT 
	 , E.MANAGER_ID 
	 , D.DEPARTMENT_NAME
  FROM EMPLOYEES E
  JOIN JOBS J
    ON E.JOB_ID = J.JOB_ID
  JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID ;

SELECT E.EMPLOYEE_ID
	 , E.FIRST_NAME || ' ' || E.LAST_NAME AS NAME
	 , E.EMAIL 
	 , E.PHONE_NUMBER 
	 , E.HIRE_DATE 
	 , (SELECT JOB_TITLE 
	 	  FROM JOBS J
	 	 WHERE E.JOB_ID = J.JOB_ID) AS JOB_TITLE
	 , E.SALARY 
	 , E.COMMISSION_PCT 
	 , E.MANAGER_ID 
	 , (SELECT DEPARTMENT_NAME
	 	  FROM DEPARTMENTS D
	 	 WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID) AS DEPARTMENT_NAME
  FROM EMPLOYEES E
  JOIN JOBS J
    ON E.JOB_ID = J.JOB_ID
  JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID ;   

/*
 * DEPARTMENTS 테이블과 LOCATIONS 테이블을 사용하여 각 부서가 어느 지역에 위차하고
 * 있는지 JOIN 을 활용하여 조회한다.
 * (서브 쿼리로도 사용 가능하기 때문에 서브쿼리로도 만들어본다.)
 */
 SELECT LOCATION_ID
 	  , D.DEPARTMENT_NAME
      , L.CITY
   FROM DEPARTMENTS D
   JOIN LOCATIONS L
  USING (LOCATION_ID);
 
SELECT D.DEPARTMENT_ID
	 , D.DEPARTMENT_NAME
	 , D.MANAGER_ID
	 , D.LOCATION_ID
	 , (SELECT STREET_ADDRESS FROM LOCATIONS L WHERE D.LOCATION_ID = L.LOCATION_ID) AS STREET_ADDRESS
	 , (SELECT COUNTRY_ID  FROM LOCATIONS L WHERE D.LOCATION_ID = L.LOCATION_ID) AS COUNTRY_ID
	 , (SELECT CITY FROM LOCATIONS L WHERE D.LOCATION_ID = L.LOCATION_ID) AS CITY
	 , (SELECT STATE_PROVINCE FROM LOCATIONS L WHERE D.LOCATION_ID = L.LOCATION_ID) AS STATE_PROVINCE
	 , (SELECT COUNTRY_ID FROM LOCATIONS L WHERE D.LOCATION_ID = L.LOCATION_ID) AS COUNTRY_ID
  FROM DEPARTMENTS D;


/*
 * LOCATIONS 테이블과 COUNTRIES, REGION 테이블을 사용하여 각 지역이
 * 어느 나라 그리고 어떤 대륙에 위치하고 있는지 JOIN 을 활용하여 조회한다.
 */ 
SELECT R.REGION_NAME 
	 , C.COUNTRY_NAME 
	 , L.STREET_ADDRESS
     , L.POSTAL_CODE
     , L.CITY 
     , L.STATE_PROVINCE
FROM LOCATIONS L
  JOIN COUNTRIES C
    ON L.COUNTRY_ID  = C.COUNTRY_ID
  JOIN REGIONS R 
    ON C.REGION_ID = R.REGION_ID;
   
/*
 * 대륙별 직원 수를 파악하기 위한 조회쿼리를 만든다.
 */
SELECT COUNT(*)
     , R.REGION_NAME
  FROM EMPLOYEES E
  JOIN DEPARTMENTS D 
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
  JOIN LOCATIONS L 
  	ON D.LOCATION_ID = L.LOCATION_ID 
  JOIN COUNTRIES C 
    ON L.COUNTRY_ID = C.COUNTRY_ID 
  JOIN REGIONS R 
    ON C.REGION_ID = R.REGION_ID
 GROUP BY R.REGION_NAME;

/*
 * 나라별별 직원 수를 파악하기 위한 조회쿼리를 만든다.
 */
SELECT COUNT(*)
     , R.REGION_NAME
     , C.COUNTRY_NAME
  FROM EMPLOYEES E
  JOIN DEPARTMENTS D 
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID 
  JOIN LOCATIONS L 
  	ON D.LOCATION_ID = L.LOCATION_ID 
  JOIN COUNTRIES C 
    ON L.COUNTRY_ID = C.COUNTRY_ID 
  JOIN REGIONS R 
    ON C.REGION_ID = R.REGION_ID
 GROUP BY ROLLUP(R.REGION_NAME, C.COUNTRY_NAME);
 


--SELECT * FROM 
--SELECT D.DEPARTMENT_NAME
--	 , MIN(HIRE_DATE)
--	 , MAX(HIRE_DATE)
--  FROM EMPLOYEES E
--  JOIN DEPARTMENTS D
--    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
-- GROUP BY D.DEPARTMENT_NAME;
  