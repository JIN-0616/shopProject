drop sequence hobby_seq;
drop table hobby;

create sequence hobby_seq;

create table hobby(
	hobby_idx  number(4)  primary key,
	name  varchar2(30),
	title  varchar2(30),
	content  varchar2(30),
	gender  varchar2(10),
	hobby  varchar2(20),
	img_file_name  varchar2(30)
);

rop sequence rhobby_seq;
create sequence rhobby_seq;

drop table hobby_reply;

 create  table hobby_reply (  --´ñ±Û
   rhobby_idx   NUMBER(4) primary key ,
   rwriter        VARCHAR2(20) ,
   rmemo       VARCHAR2(30) ,
   hobby_idx   NUMBER(4),
   constraint  hobby_reply_fk  foreign key(hobby_idx)
              references  hobby(hobby_idx) on delete cascade
 ) ;