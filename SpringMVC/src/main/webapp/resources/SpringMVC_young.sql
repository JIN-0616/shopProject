
drop  table  member;
CREATE TABLE MEMBER(
 num NUMBER(4) NOT NULL PRIMARY KEY,
 id VARCHAR2(20),
 pwd VARCHAR2(20),
 name VARCHAR2(40),
 phone VARCHAR2(20),
 email VARCHAR2(40),
 indate date,
 photo VARCHAR2(40),
 admin VARCHAR2(1)
 );

drop  table  member_album;
CREATE TABLE MEMBER_ALBUM(
 num NUMBER(6) NOT NULL PRIMARY KEY,
 mem_num NUMBER(6),
 photo VARCHAR2(40),
 thumbnail VARCHAR2(50)
);

INSERT INTO MEMBER(num,id,pwd,name,phone,email,indate, photo, admin) values
( 1,'admin', '1234','관리자', '111-111', 'admin@gamil',sysdate, 'admin.png', '1');

INSERT INTO MEMBER
(num, id, pwd, name, phone, email, indate,  photo, admin) VALUES
(2,'hong', '1234', '홍길동', '123-456', 'hong@gamil',sysdate, 'hong.png', '1');

INSERT INTO MEMBER
(num, id, pwd, name, phone, email, indate, photo,  admin) VALUES
(3, 'kim', '1234', '김철수', '0000-0000', 'kim@daum.net', CURRENT_DATE, 'kim.png', '1');
select * from MEMBER;

drop  table  board;
CREATE TABLE BOARD(
  num NUMBER(6) NOT NULL PRIMARY KEY,
  mem_id VARCHAR2(20),
  mem_num NUMBER(6),
  title VARCHAR2(70),
  content VARCHAR2(200),
  passwd VARCHAR2(20),
  indate TIMESTAMP,
  filename VARCHAR2(20),
  views NUMBER(6),
  view_cnt NUMBER(6)
);


drop  table  comments;
CREATE TABLE COMMENTS(
  num NUMBER(6) NOT NULL PRIMARY KEY,
  board_num NUMBER(6),
  mem_num NUMBER(6),
  content VARCHAR2(70),
  indate TIMESTAMP
);

INSERT INTO BOARD(num, mem_num, title, content, passwd, indate,filename,  views) VALUES
(1,1,'게시글1','내용1','1234',CURRENT_DATE,'aaa.gif', 0);

INSERT INTO BOARD(num, mem_num, title, content, passwd, indate, filename, views) VALUES
(2,1,'게시글2','내용2','1234',CURRENT_DATE,'bbb.gif',0);
INSERT INTO BOARD(num, mem_num, title, content, passwd, indate,filename, views) VALUES
(3,1,'게시글3','내용3','1234',CURRENT_DATE,'bbb.gif,0);
INSERT INTO BOARD(num, mem_num, title, content, passwd, indate, filename,views) VALUES
(4,1,'게시글4','내용4','1234',CURRENT_DATE,'ccc.gif',0);
INSERT INTO BOARD(num, mem_num, title, content, passwd, indate,filename, views) VALUES
(5,1,'게시글5','내용5','1234',CURRENT_DATE,'aaa.gif',0);
INSERT INTO BOARD(num, mem_num, title, content, passwd, indate, filename,views) VALUES
(6,1,'게시글6','내용6','1234',CURRENT_DATE,'ccc.gif',0);


INSERT INTO BOARD(num, mem_num, title, content, passwd, indate,  filename, views) VALUES
(7,1,'게시글7','내용7','1234',CURRENT_DATE,'bbb.gif', 0);
INSERT INTO BOARD(num, mem_num, title, content, passwd, indate, filename, views) VALUES
(8,1,'게시글8','내용8','1234',CURRENT_DATE, 'aaa.gif',  0);
INSERT INTO BOARD(num, mem_num, title, content, passwd, indate,filename, views) VALUES
(9,1,'게시글9','내용9','1234',CURRENT_DATE, 'ccc.gif', 0);
INSERT INTO BOARD(num, mem_num, title, content, passwd, indate,filename, views) VALUES
(10,1,'게시글10','내용10','1234',CURRENT_DATE, 'aaa.gif', 0);
INSERT INTO BOARD(num, mem_num, title, content, passwd, indate,filename, views) VALUES
(11,1,'게시글11','내용11','1234',CURRENT_DATE, 'bbb.gif', 0);
INSERT INTO BOARD(num, mem_num, title, content, passwd, indate, filename,views) VALUES
(12,1,'게시글12','내용12','1234',CURRENT_DATE,'aaa.gif', 0);
INSERT INTO BOARD(num, mem_num, title, content, passwd, indate, filename, views) VALUES
(13,1,'게시글13','내용13','1234',CURRENT_DATE,'bbb.gif', 0);
INSERT INTO BOARD(num, mem_num, title, content, passwd, indate, filename, views) VALUES
(14,1,'게시글14','내용14','1234',CURRENT_DATE,'aaa.gif', 0);
select * from BOARD;


INSERT INTO COMMENTS(num, board_num,mem_num,content,indate) VALUES
(1,1,1,'내용1',CURRENT_DATE);
INSERT INTO COMMENTS(num, board_num,mem_num,content,indate) VALUES
(2,1,1,'내용2',CURRENT_DATE);
INSERT INTO COMMENTS(num, board_num,mem_num,content,indate) VALUES
(3,1,2,'내용3',CURRENT_DATE);
INSERT INTO COMMENTS(num, board_num,mem_num,content,indate) VALUES
(4,1,2,'내용4',CURRENT_DATE);
INSERT INTO COMMENTS(num, board_num,mem_num,content,indate) VALUES
(5,1,3,'내용5',CURRENT_DATE);
INSERT INTO COMMENTS(num, board_num,mem_num,content,indate) VALUES
(6,1,3,'내용5',CURRENT_DATE);
INSERT INTO COMMENTS(num, board_num,mem_num,content,indate) VALUES
(7,1,4,'내용5',CURRENT_DATE);
INSERT INTO COMMENTS(num, board_num,mem_num,content,indate) VALUES
(8,1,4,'내용5',CURRENT_DATE);
INSERT INTO COMMENTS(num, board_num,mem_num,content,indate) VALUES
(9,1,3,'내용5',CURRENT_DATE);

select * from comments;


drop  table  board_likes;
CREATE TABLE BOARD_LIKES(
  num NUMBER(6) NOT NULL PRIMARY KEY,
  board_num NUMBER(6),
  mem_num NUMBER(6),
  likes NUMBER(6),
  indate TIMESTAMP
);

commit;

======여기까지만 입력력해서 확인하시면 됩니다 ======================================
=============================================================================
=============================================================================
=============================================================================





조인쿼리문 실습 
==============================================================================================================================================================================================================================================================================================================================================================================================================================

    SELECT * FROM  (
	SELECT * FROM         (
	      SELECT ROWNUM row_num, bo.num, bo.filename, bo.mem_id, bo.indate, bo.title FROM  (SELECT b.*, c.view_cnt as view_cnt FROM board b 
            LEFT OUTER JOIN (
                 SELECT BOARD_NUM, NVL(COUNT(MEM_NUM),0) as VIEW_CNT FROM  BOARD_LIKES GROUP BY BOARD_NUM
            ) c  ON b.num = c.board_num ORDER BY b.num DESC
          ) bo 
        ) WHERE row_num >= 1
    )WHERE row_num <= 10;

==========================================================================================================================================================================================================================================================================================================================================================================================