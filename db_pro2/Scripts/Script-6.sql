 DROP TABLE SAMPLE_T;
 
CREATE TABLE SAMPLE_T (
	   ID NUMBER PRIMARY KEY
	 , NAME VARCHAR(30) NOT NULL
	 , GENDER CHAR(1) CHECK(GENDER IN ('F', 'M'))
	 , AGE NUMBER DEFAULT(0) NOT NULL
);

INSERT INTO SAMPLE_T VALUES(SEQ_TEST.NEXTVAL, '홍길동', 'M', 32);
INSERT INTO SAMPLE_T VALUES(SEQ_TEST.NEXTVAL, '김수정', 'F', 28);
INSERT INTO SAMPLE_T VALUES(SEQ_TEST.NEXTVAL, '박정길', 'M', 32);
INSERT INTO SAMPLE_T VALUES(SEQ_TEST.NEXTVAL, '박수진', 'F', 23);

CREATE OR REPLACE VIEW V_SAMPLE_T
	AS SELECT ID
		    , NAME
		    , GENDER
		    , AGE 
		 FROM SAMPLE_T
		WHERE AGE BETWEEN 30 AND 35
WITH READ ONLY;
--WITH CHECK OPTION; WHERE 절과 함께 써야함

SELECT * FROM V_SAMPLE_T;
SELECT * FROM USER_VIEWS;
SELECT * FROM SAMPLE_T;

UPDATE V_SAMPLE_T 
   SET AGE = AGE + 1;

INSERT INTO V_SAMPLE_T VALUES(5, '이기석', 'M');
   
DELETE FROM V_SAMPLE_T;