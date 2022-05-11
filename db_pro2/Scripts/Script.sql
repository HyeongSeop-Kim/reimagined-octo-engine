/*
 * DDL
 * 		- Data Definition Language : 데이터 정의어
 * 		- 객체를 정의하기 위한 CREATE(생성), ALTER(수정), DROP(제거) 구문이 있다.
 * 		- 오라클에서 사용하는 객체
 */

/*
CREATE TABLE 테이블명 (
	컬럼명 데이터타입(크기) [제약조건]
	, ...
);
*/

CREATE TABLE sample_t (
	   u_id NUMBER 		 CONSTRAINT PK_SAMPLE_T_U_ID PRIMARY KEY	
	 , jumin CHAR(13)	 -- UNIQUE
	 , name VARCHAR2(50) NOT NULL
	 , age NUMBER(3)	 DEFAULT(0)
	 , gender CHAR(1)	 CHECK(GENDER IN ('M', 'F'))
	 , birth_day DATE    DEFAULT(SYSDATE)
	 , ref_col NUMBER	 -- REFERENCES ref_t(r_id)
--	 , CONSTRAINT PK_SAMPLE_T_U_ID PRIMARY KEY(u_id)
	 , CONSTRAINT UK_SAMPLE_T_JUMIN UNIQUE(jumin)
	 , CONSTRAINT FK_SAMPLE_T_REF_COL FOREIGN KEY(ref_col) REFERENCES ref_t(r_id)
);

CREATE TABLE ref_t (
	   r_id NUMBER PRIMARY KEY
     , note VARCHAR2(100)
);

ALTER TABLE sample_t ADD (nickname VARCHAR2(100));
ALTER TABLE sample_t MODIFY (nickname VARCHAR2(200));
ALTER TABLE sample_t RENAME COLUMN nickname TO n_name;		-- 가급적 사용X
ALTER TABLE sample_t DROP COLUMN n_name;

ALTER TABLE sample_t RENAME TO sam_t;		-- 가급적 사용X

ALTER TABLE ref_t ADD CONSTRAINT UK_REF_T_NOTE UNIQUE(note);

ALTER TABLE ref_t ADD UNIQUE(note);
ALTER TABLE ref_t RENAME CONSTRAINT SYS_C007446 TO UK_REF_T_NOTE;

-- 컬럼 레벨로만 제약 조건을 추가하는 NOT NULL, CHECK 는 MODIFY로 추가/삭제
-- 테이블 레벨로 제약 조건을 추가할 수 있는 PRIMARY KEY, UNIQUE, FOREIGN KEY 는 ADD, DROP 사용
ALTER TABLE ref_t MODIFY note NOT NULL;	
ALTER TABLE ref_t MODIFY note NULL; -- 또는 DROP CONSTRAINT 제약조건 이름
ALTER TABLE ref_t MODIFY note CHECK(note IN ('t', 'k'));
ALTER TABLE ref_t DROP CONSTRAINT SYS_C007459;

ALTER TABLE ref_t DROP CONSTRAINT UK_REF_T_NOTE
				  DROP CONSTRAINT SYS_C007460;
ALTER TABLE ref_t ADD PRIMARY KEY(r_id, note);

DROP TABLE ref_t; -- CASCADE COSTRAINT; 가급적 사용하지 말 것

ALTER TABLE sample_t DROP CONSTRAINT FK_SAMPLE_T_REF_COL;
ALTER TABLE ref_t DROP COLUMN r_id; -- CASCADE CONSTRAINT; <- 자식까지 지우기


COMMENT ON COLUMN sample_t.u_id IS '사용자 구분 아이디';
COMMENT ON COLUMN sample_t.u_id IS '사용자 이름';
COMMENT ON COLUMN sample_t.u_id IS '사용자 나이';
COMMENT ON COLUMN sample_t.u_id IS '사용자 성별(M:남자, F:여자)';
COMMENT ON COLUMN sample_t.u_id IS '사용자 생년월일';

DROP TABLE SAMPLE_T;
DROP TABLE REF_T;

SELECT * FROM SAMPLE_T;
SELECT * FROM USER_ALL_TABLES WHERE TABLE_NAME = 'SAMPLE_T';
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'SAMPLE_T';
SELECT * FROM USER_COL_COMMENTS WHERE TABLE_NAME = 'SAMPLE_T';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'SAMPLE_T';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'REF_T';
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'REF_T';
/*
 * CONSTRAINT(제약조건)
 * 		테이블에 데이터를 저장할 때 저장되는 데이터를 제한하기 위해 사용하는 조건
 * 		데이터의 무결성을 보장하기위해 사용한다.
 * 
 * 		컬럼 레벨
 * 			- 컬럼 옆에 직접 명시하여 작성
 * 		테이블 레벨
 * 			- 컬럼 외의 영역에 명시하여 작성
 * 
 * 		NOT NUL
 * 			- NULL 데이터를 허용하지 않음
 * 			- 컬럼 레벨로만 적용할 수 있음
 * 		UNIQUE
 * 			- 중복 데이터를 허용하지 않음
 *		    - UK 라고 한다.
 * 		PRIMARY KEY
 *			- NOT NUㅣL + UNIQUE 결합된 조건
 *      	- 기본키, PK라고하며 데이터 식별값으로 사용
 * 		FOREIGN KEY
 *      	- 외래키, FK라고하며 다른 테이블의 데이터를
 * 			  참조하기 위한 참조값이 저장된 컬럼을 명시
 * 			- 테이블간의 관계를 형성하기 위해 사용
 * 			- 참조 대상이 되는 테이블의 데이터는 임의로 삭제할 수 없게 된다.
 * 			  FK로 지정된 컬럼에 저장될 데이터는 반드시 참조 대상 테이블에
 * 			  동일한 데이터가 있어야 한다.(참조 대상이 있어야 함) 
 * 		
 * 		CHECK
 * 			- 미리 설정한 값만 저장할 수 있도록 검사			  
 */