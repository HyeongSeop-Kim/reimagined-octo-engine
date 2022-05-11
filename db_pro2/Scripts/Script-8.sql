/* 
 * 다음의 요구 사항에 맞추어 데이터 베이스 작업을 진행한다.
 * 		1. 관리자 계정으로 devAdmin 계정을 새로 만들고 데이터베이스 원격 접속과
 * 		   데이터 테이블 생성, 수정, 삭제 / 데이터 추가, 수정, 삭제 / 뷰 테이블 생성을
 * 		   할 수 있는 권한을 부여한다.
 * 		2. devAdmin 계정으로 접속하고 회원관리를 위한 테이블(USER_ACCOUNT)을 생성한다. 테이블에는
 * 		   ID, 회원계정명, 회원패스워드, 회원이름 정보를 관리 할 수 있도록 컬럼을 생성한다.
 * 		3. 2번에서 생성한 데이터베이스와 외래키로 관계를 맺는 회원정보 테이블(USER_INFO)을 생성한다.
 * 		   테이블에는 ID, 성별, 나이, 이메일, 주소, 전화번호를 관리 할 수 있도록 컬럼을 생성한다.
 * 		   ID 컬럼은 USER ACCOUNT와 외래키 관계를 가지는 컬럼으로 생성한다.
 * 		4. 2번, 3번에서 생성한 테이블에 데이터를 3개 추가한다.
 * 		   데이터를 추가 할 때 ID 컬럼에 대해서는 SEQUENCE 객체를 사용하여 값이 자동으로 생성될 수 있게 한다.
 * 4:37:52
 */
--계정 생성 및 권한 부여
CREATE USER devAdmin IDENTIFIED BY admin;
GRANT CONNECT, RESOURCE, CREATE SESSION, CREATE VIEW, INSERT ANY TABLE, UPDATE ANY TABLE, DELETE ANY TABLE TO devAdmin;

--데이터 용량 부여
ALTER USER devAdmin quota 10M ON USERS;

--관리자로 계정 및 권한 확인
SELECT * FROM ALL_USERS WHERE USERNAME = 'DEVADMIN';
SELECT * FROM DBA_ROLE_PRIVS WHERE GRANTEE = 'DEVADMIN';
SELECT * FROM DBA_SYS_PRIVS WHERE GRANTEE = 'DEVADMIN';

--유저로 권한 확인
SELECT * FROM USER_ROLE_PRIVS;
SELECT * FROM USER_SYS_PRIVS;

CREATE TABLE USER_ACCOUNT(
	   USER_ID NUMBER					CONSTRAINT PK_USER_ACCOUNT_USER_ID PRIMARY KEY
	 , USER_ACCOUNT VARCHAR2(100)
	 , USER_PASSWORD VARCHAR2(100)
	 , USER_NAME VARCHAR2(100)
		     );

ALTER TABLE USER_ACCOUNT MODIFY USER_ACCOUNT NOT NULL;
ALTER TABLE USER_ACCOUNT MODIFY USER_PASSWORD NOT NULL;
ALTER TABLE USER_ACCOUNT MODIFY USER_NAME NOT NULL;
		    
CREATE TABLE USER_INFO(
	   USER_ID NUMBER	 				CONSTRAINT FK_USER_INFO_USER_ID REFERENCES USER_ACCOUNT(USER_ID)
	 , USER_GENDER CHAR(1)
	 , USER_AGE NUMBER
	 , USER_EMAIL VARCHAR2(100)
	 , USER_ADDRESS VARCHAR2(300)
	 , USER_PHONE VARCHAR2(30)
		     );
		    
ALTER TABLE USER_INFO MODIFY USER_GENDER CHECK(USER_GENDER IN ('F','M'));
ALTER TABLE USER_INFO MODIFY USER_AGE CHECK(USER_AGE BETWEEN 0 AND 199);
ALTER TABLE USER_INFO ADD CONSTRAINT PK_USER_INFO_USER_ID PRIMARY KEY(USER_ID);

DROP TABLE USER_INFO;
		    
SELECT * FROM USER_ACCOUNT;
SELECT * FROM USER_INFO;
SELECT * FROM ALL_TABLES WHERE OWNER = 'DEVADMIN' AND TABLE_NAME LIKE 'USER\_%' ESCAPE '\';
SELECT * FROM ALL_TAB_COLUMNS WHERE OWNER = 'DEVADMIN' AND TABLE_NAME LIKE 'USER\_%' ESCAPE '\';
SELECT * FROM USER_CONSTRAINTS;

CREATE SEQUENCE ID_SEQ NOCACHE;
CREATE SEQUENCE ID_SEQ2 NOCACHE;

INSERT INTO USER_ACCOUNT VALUES(
		    ID_SEQ.NEXTVAL
		  , 'HONG1'
		  , '1234'
		  , '홍길동');
INSERT INTO USER_ACCOUNT VALUES(
		    ID_SEQ.NEXTVAL
		  , 'KIM1'
		  , '1234'
		  , '김지현');
INSERT INTO USER_ACCOUNT VALUES(
		    ID_SEQ.NEXTVAL
		  , 'GO1'
		  , '1234'
		  , '고영호');
		  
INSERT INTO USER_INFO VALUES(
		    ID_SEQ2.NEXTVAL
		  , 'M'
		  , '27'
		  , 'HONG1@NAVER.COM'
		  , 'SEOUL'
		  , '010-1111-1111');
INSERT INTO USER_INFO VALUES(
		    ID_SEQ2.NEXTVAL
		  , 'F'
		  , '23'
		  , 'KIM1@NAVER.COM'
		  , 'INCHEON'
		  , '010-1234-1234');
INSERT INTO USER_INFO VALUES(
		    ID_SEQ2.NEXTVAL
		  , 'M'
		  , '29'
		  , 'GO1@NAVER.COM'
		  , 'BUSAN'
		  , '010-2222-2222');