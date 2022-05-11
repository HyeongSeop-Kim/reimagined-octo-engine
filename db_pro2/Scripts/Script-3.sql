CREATE TABLE 지출내역서 (
	날짜 DATE
  , 입금액 NUMBER
  , 출금액 NUMBER
  , 비고 VARCHAR2(450)
);
CREATE TABLE 지출내역구분 (
	   식별 NUMBER 			CONSTRAINT PK_지출내역구분_식별 PRIMARY KEY
	 , 구분 VARCHAR2(900)	UNIQUE
);
SELECT *
  FROM 지출내역서;
DROP TABLE 지출내역서;
DROP TABLE 지출내역구분;

/*
 * 지출내역서 테이블과 지출내역서구분 테이블에 데이터를 추가/수정/삭제 하는 작업을 진행한다.
 * 		- "지출내역구분" 에는 본인의 한달치 분량의 생활비 내역을 참고하여
 * 		 교통비, 식대, 수도세, 전기세 등의 구분명을 추가한다.
 *      - "지출내역서" 에는 본인의 한 달치 분량의 실제 입출고 내역을 참고하여
 * 		 가계부를 작성하듯 데이터를 추가한다.
 * 		- 테이블에 추가하는 데이터는 최소 5~10개 정도는 추가하도록 한다.
 */

INSERT INTO 지출내역구분 VALUES(1, '교통비');
INSERT INTO 지출내역구분 VALUES(2, '식대');
INSERT INTO 지출내역구분 VALUES(3, '수도세');
INSERT INTO 지출내역구분 VALUES(4, '전기세');
INSERT INTO 지출내역구분 VALUES(5, '유흥비');
INSERT INTO 지출내역구분 VALUES(6, '저금');
INSERT INTO 지출내역구분 VALUES(7, '보험비');
INSERT INTO 지출내역구분 VALUES(8, '이월금');
INSERT INTO 지출내역구분 VALUES(9, '월급');

INSERT INTO 지출내역서 VALUES(TO_DATE('20220429'), 10000, 0, '저금', 1, 6);
INSERT INTO 지출내역서 VALUES(TO_DATE('20220429'), 0, 8000, '아침식사', 2, 2);
INSERT INTO 지출내역서 VALUES(TO_DATE('20220429'), 0, 12000, '점심식사', 3, 2);
INSERT INTO 지출내역서 VALUES(TO_DATE('20220501'), 50000, 0, '이월금', 4, 8);
INSERT INTO 지출내역서 VALUES(TO_DATE('20220510'), 100000, 0, '월급', 5, 9);
INSERT INTO 지출내역서 VALUES(TO_DATE('20220429'), 0, 10000, '보험금 납입', 6, 7);
INSERT INTO 지출내역서 VALUES(TO_DATE('20220501'), 0, 10000, '교통비', 7, 1);
INSERT INTO 지출내역서 VALUES(TO_DATE('20220429'), 0, 10000, '수도세', 8, 3);
INSERT INTO 지출내역서 VALUES(TO_DATE('20220429'), 0, 10000, '전기세', 9, 4);

INSERT INTO 지출내역서 VALUES(TO_DATE('20220329'), 10000, 0, '저금', 10, 6);
INSERT INTO 지출내역서 VALUES(TO_DATE('20220329'), 0, 8000, '아침식사', 11, 2);
INSERT INTO 지출내역서 VALUES(TO_DATE('20220227'), 0, 12000, '점심식사', 12, 2);
INSERT INTO 지출내역서 VALUES(TO_DATE('20220301'), 50000, 0, '이월금', 13, 8);
INSERT INTO 지출내역서 VALUES(TO_DATE('20220210'), 100000, 0, '월급', 14, 9);
INSERT INTO 지출내역서 VALUES(TO_DATE('20220529'), 0, 10000, '보험금 납입', 15, 7);
INSERT INTO 지출내역서 VALUES(TO_DATE('20220501'), 0, 10000, '교통비', 16, 1);
INSERT INTO 지출내역서 VALUES(TO_DATE('20220224'), 0, 10000, '수도세', 17, 3);
INSERT INTO 지출내역서 VALUES(TO_DATE('20220329'), 0, 10000, '전기세', 18, 4);

INSERT INTO 지출내역서 VALUES(TO_DATE('20200429'), 10000, 0, '저금', 19, 6);
INSERT INTO 지출내역서 VALUES(TO_DATE('20200429'), 0, 8000, '아침식사', 20, 2);
INSERT INTO 지출내역서 VALUES(TO_DATE('20200429'), 0, 12000, '점심식사', 21, 2);
INSERT INTO 지출내역서 VALUES(TO_DATE('20200501'), 50000, 0, '이월금', 22, 8);
INSERT INTO 지출내역서 VALUES(TO_DATE('20200510'), 100000, 0, '월급', 23, 9);
INSERT INTO 지출내역서 VALUES(TO_DATE('20200429'), 0, 10000, '보험금 납입', 24, 7);
INSERT INTO 지출내역서 VALUES(TO_DATE('20200501'), 0, 10000, '교통비', 25, 1);
INSERT INTO 지출내역서 VALUES(TO_DATE('20200429'), 0, 10000, '수도세', 26, 3);
INSERT INTO 지출내역서 VALUES(TO_DATE('20200429'), 0, 10000, '전기세', 27, 4);

INSERT INTO 지출내역서 VALUES(TO_DATE('20210329'), 10000, 0, '저금', 28, 6);
INSERT INTO 지출내역서 VALUES(TO_DATE('20210329'), 0, 8000, '아침식사', 29, 2);
INSERT INTO 지출내역서 VALUES(TO_DATE('20210227'), 0, 12000, '점심식사', 30, 2);
INSERT INTO 지출내역서 VALUES(TO_DATE('20210301'), 50000, 0, '이월금', 31, 8);
INSERT INTO 지출내역서 VALUES(TO_DATE('20210210'), 100000, 0, '월급', 32, 9);
INSERT INTO 지출내역서 VALUES(TO_DATE('20210529'), 0, 10000, '보험금 납입', 33, 7);
INSERT INTO 지출내역서 VALUES(TO_DATE('20210501'), 0, 10000, '교통비', 34, 1);
INSERT INTO 지출내역서 VALUES(TO_DATE('20210224'), 0, 10000, '수도세', 35, 3);
INSERT INTO 지출내역서 VALUES(TO_DATE('20210329'), 0, 10000, '전기세', 36, 4);

/*
 *  위 작업을 모두 마친 후에는 다음의 작업을 추가로 진행한다.
 * 		- 입금액만을 따로 조회하여 얼마나 입금되었는지 통계 조회를 한다.
 * 	    - 출금액만을 따로 조회하여 얼마나 출금이 되었는지 통계 조회를 한다.
 * 		- 위에서 조회한 데이터를 "월별출금내역" 테이블을 새로 만들어 월별로 저장될 수 있게 한다.
 * 		- "월별지출내역" 테이블에는 년, 월, 지출구분, 금액 컬럼을 가지게 만들고 지출구분운 '입', '출'만 저장되도록 한다.
 */

SELECT EXTRACT(YEAR FROM 날짜) AS 년
	 , EXTRACT(MONTH FROM 날짜) AS 월
	 , SUM(입금액) AS 입금액
  FROM 지출내역서
 WHERE 입금액 > 0
 GROUP BY EXTRACT(YEAR FROM 날짜), EXTRACT(MONTH FROM 날짜);

SELECT EXTRACT(YEAR FROM 날짜) AS 년
	 , EXTRACT(MONTH FROM 날짜) AS 월
	 , SUM(출금액) AS 출금액
  FROM 지출내역서
 WHERE 출금액 > 0
 GROUP BY EXTRACT(YEAR FROM 날짜), EXTRACT(MONTH FROM 날짜);

SELECT EXTRACT(YEAR FROM 날짜) AS 년
	 , EXTRACT(MONTH FROM 날짜) AS 월
	 , SUM(입금액) AS 입금액
	 , SUM(출금액) AS 출금액
  FROM 지출내역서
 GROUP BY EXTRACT(YEAR FROM 날짜), EXTRACT(MONTH FROM 날짜);

SELECT EXTRACT(YEAR FROM 날짜) AS 년
	 , EXTRACT(MONTH FROM 날짜) AS 월
	 , SUM(입금액) AS 입금액
  FROM 지출내역서
 WHERE 입금액 > 0
 GROUP BY ROLLUP(EXTRACT(YEAR FROM 날짜), EXTRACT(MONTH FROM 날짜));

SELECT EXTRACT(YEAR FROM 날짜) AS 년
	 , EXTRACT(MONTH FROM 날짜) AS 월
	 , SUM(출금액) AS 출금액
  FROM 지출내역서
 WHERE 출금액 > 0
 GROUP BY ROLLUP(EXTRACT(YEAR FROM 날짜), EXTRACT(MONTH FROM 날짜));

SELECT EXTRACT(YEAR FROM 날짜) AS 년
	 , EXTRACT(MONTH FROM 날짜) AS 월
	 , SUM(입금액) AS 입금액
	 , SUM(출금액) AS 출금액
  FROM 지출내역서
 GROUP BY ROLLUP(EXTRACT(YEAR FROM 날짜), EXTRACT(MONTH FROM 날짜));

CREATE TABLE 월별지출내역
    AS SELECT EXTRACT(YEAR FROM 날짜) AS 년
    	    , EXTRACT(MONTH FROM 날짜) AS 월
    	    , '입' AS 지출구분
    	    , 입금액 AS 금액
    	 FROM 지출내역서
    	WHERE 1=0;

SELECT *
  FROM USER_TAB_COLUMNS
 WHERE TABLE_NAME = '월별지출내역';
    
DROP TABLE 월별지출내역;
	   
INSERT ALL INTO 월별지출내역 VALUES (년, 월, 지출구분, 금액)
SELECT EXTRACT(YEAR FROM 날짜) AS 년
     , EXTRACT(MONTH FROM 날짜) AS 월
     , CASE WHEN 입금액 > 0 THEN '입'
            WHEN 출금액 > 0 THEN '출'
       END 지출구분
     , SUM(입금액 + 출금액) AS 금액
  FROM 지출내역서
 GROUP BY EXTRACT(YEAR FROM 날짜), EXTRACT(MONTH FROM 날짜)
		, CASE WHEN 입금액 > 0 THEN '입'
		 	   WHEN 출금액 > 0 THEN '출'
		  END;

/*
 * 지출내역서에 작성된 모든 지출을 기존 금액보다 10% 인상 시키고 이를
 * 월별지출내역에도 반영하도록 한다.
 */
		 
UPDATE 지출내역서
   SET 출금액 = 출금액 * 1.1 
 WHERE 출금액 > 0;

UPDATE 월별지출내역
   SET 금액 = 금액 * 1.1
 WHERE 지출구분 = '출'
		 

SELECT *
  FROM 월별지출내역; 
SELECT *
  FROM 지출내역서;

