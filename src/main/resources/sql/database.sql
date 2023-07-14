변경사항
테이블명  Algorithm review -> review
데이터 타입 CLOB -> MEDIUMTEXT / NUMBER(n) -> INT

-------------------------------------------------------------------------------
CREATE TABLE member (
  mem_num INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  mem_id VARCHAR(12) NOT NULL,
  mem_auto VARCHAR(36),
  mem_auth INT NOT NULL,
  mem_token VARCHAR(36) NOT NULL
);
-------------------------------------------------------------------------------
CREATE TABLE m_detail(
mem_num INT NOT NULL AUTO_INCREMENT primary key,
mem_name varchar(30) not null,
mem_photo blob,
mem_pname varchar(100),
mem_pw varchar(12) not null,
mem_phone varchar(15) not null,
mem_email varchar(50) not null,
mem_zipcode varchar(5) not null,
mem_address1 varchar(90) not null,
mem_address2 varchar(90) not null,
mem_date date not null,
mem_mdate date,
CONSTRAINT fk1 FOREIGN KEY(mem_num) REFERENCES member(mem_num)
);
-------------------------------------------------------------------------------
create table review(
al_num int not null auto_increment primary key,
mem_num int not null,
al_link varchar(100) not null,
al_level int not null,
al_title varchar(100) not null,
al_cate varchar(18) not null,
al_content mediumtext,
al_date date not null,
al_mdate date,
constraint review_fk1 foreign key(mem_num) references member(mem_num)
);
-------------------------------------------------------------------------------
create table al_tag(
tag_num int not null auto_increment primary key,
al_num int not null,
tag_name varchar(100) not null,
constraint al_tag_fk1 foreign key(al_num) references review(al_num)
);
-------------------------------------------------------------------------------
create table r_like(
al_num int not null primary key,
mem_num int not null,
constraint r_like_fk1 foreign key(al_num) references review(al_num),
constraint r_like_fk2 foreign key(mem_num) references member(mem_num)
);
-------------------------------------------------------------------------------
create table comment(
com_num int not null primary key,
mem_num int not null,
al_num int not null,
com_content varchar(100) not null,
com_date date not null,
com_mdate date,
constraint comment_fk1 foreign key(al_num) references review(al_num),
constraint comment_fk2 foreign key(mem_num) references member(mem_num)
);
-------------------------------------------------------------------------------
create table re_comment(
rcom_num int not null auto_increment primary key,
com_num int not null,
mem_num int not null,
al_num int not null,
rcom_content varchar(100) not null,
rcom_date date not null,
rcom_mdate date,
constraint re_comment_fk1 foreign key(al_num) references review(al_num),
constraint re_comment_fk2 foreign key(mem_num) references member(mem_num),
constraint re_comment_fk3 foreign key(com_num) references comment(com_num)
);
-------------------------------------------------------------------------------
create table pay(
pay_num int not null auto_increment primary key,
mem_num int not null,
pay_status int not null,
pay_quantity int not null,
pay_price int not null,
pay_date date,
constraint pay_fk1 foreign key(mem_num) references member(mem_num)
);
-------------------------------------------------------------------------------
create table point(
point_num int not null auto_increment primary key,
mem_num int not null,
point_status varchar(6),
point int,
point_now int not null,
point_reason varchar(20) not null,
point_date date not null,
constraint point_fk1 foreign key(mem_num) references member(mem_num)
);