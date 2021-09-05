CREATE DATABASE `ssm_crud_book_manage`;

USE `ssm_crud_book_manage`;

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
`bookID` INT(10) NOT NULL AUTO_INCREMENT COMMENT '��id',
`bookName` VARCHAR(100) NOT NULL COMMENT '����',
`bookCounts` INT(11) NOT NULL COMMENT '����',
`detail` VARCHAR(200) NOT NULL COMMENT '����',
KEY `bookID` (`bookID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8

INSERT INTO `books`(`bookID`,`bookName`,`bookCounts`,`detail`)VALUES
(1,'Java',1,'�����ŵ�����'),
(2,'MySQL',10,'��ɾ�⵽��·'),
(3,'Linux',5,'�ӽ��ŵ�����');