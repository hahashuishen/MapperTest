drop database if exists mybatis;

create database mybatisqs;

use mybatisqs;
create table news_inf
(
    news_id int primary key auto_increment,
    news_title varchar(255),
    news_content varchar (255)
)