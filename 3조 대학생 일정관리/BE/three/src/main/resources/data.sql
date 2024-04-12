INSERT INTO user (NAME, nickname, phone_num, email, studies, PASSWORD, enrollment_status, grade, withdraw_status,address)
VALUES('Kim-Gill-Dong','aaa','01000000000','aaa@naver.com','Department of Pharmacy','12341234','N',null,'N','Daegu, Suseong-gu');

INSERT INTO user (NAME, nickname, phone_num, email, studies, PASSWORD, enrollment_status, grade, withdraw_status,address)
VALUES('Gam-Gill-Dong','aab','01011111111','aab@naver.com','Business Administration','111111','Y','third','N','Daegu, Dalseo-gu');

INSERT INTO user (NAME, nickname, phone_num, email, studies, PASSWORD, enrollment_status, grade, withdraw_status,address)
VALUES('Steve','steve','01011112222','steve1234@google.com','Department of English Language and Literature','111122','Y','second','N','Seongseo Industrial Complex');

INSERT INTO user (NAME, nickname, phone_num, email, studies, PASSWORD, enrollment_status, grade, withdraw_status, address)
VALUES('Karen','karen','01035642522','karen0000@google.com','Korean language and literature','356425','Y','fourth','N','Daegu, Seo-gu');

INSERT INTO user (NAME, nickname, phone_num, email, studies, PASSWORD, enrollment_status, grade, withdraw_status, address)
VALUES('Kim-Chul-Soo','chulsoo','01025662122','chulsoo0001@google.com','Department of Education','212266','Y','first','N','Dalseong-gun');

INSERT INTO user (NAME, nickname, phone_num, email, studies, PASSWORD, enrollment_status, grade, withdraw_status, address)
VALUES('Son-Gill-Dong','Sgd','01015312564','Son1234@naver.com','Department of Orchestral Instruments','15312564','Y','third','Y','Gumi');

INSERT INTO user (NAME, nickname, phone_num, email, studies, PASSWORD, enrollment_status, grade, withdraw_status, address)
VALUES('Hwang-Yu-Ra','Yulha','01013412422','Yulha1341@google.com','Department of Psychology','134124','Y','first','N', 'Gyeongju');

INSERT INTO user (NAME, nickname, phone_num, email, studies, PASSWORD, enrollment_status, grade, withdraw_status, address)
VALUES('Kwon-Gill_Dong','KGD','01059182562','KGD1234@google.com','Department of Police Administration','591825','Y','fourth','Y', 'Chilgok');

INSERT INTO user (NAME, nickname, phone_num, email, studies, PASSWORD, enrollment_status, grade, withdraw_status, address)
VALUES('David','machine','01018592652','machine2256@google.com','Department of Mechanical Engineering','185926','N','second','N', 'Seoul');

INSERT INTO user (NAME, nickname, phone_num, email, studies, PASSWORD, enrollment_status, grade, withdraw_status, address)
VALUES('Cindy','cd','01018592655','m2256@google.com','Department of Early Childhood Education','185956','N',null,'Y','Ulsan');

Insert into todo (profile_id, todo) values (6,'Freshman OT');
Insert into todo (profile_id, todo) values (3,'University MT');
Insert into todo (profile_id, todo) values (2,'Preparing for the midterm exam');
Insert into todo (profile_id, todo) values (8,'Preparing for final exams');
Insert into todo (profile_id, todo) values (9,'Preparing for final exams');
Insert into todo (profile_id, todo) values (5,'Club OT');
Insert into todo (profile_id, todo) values (7,'Preparing for the festival');
Insert into todo (profile_id, todo) values (10,'Preparing for employment');
Insert into todo (profile_id, todo) values (5,'Club MT');
Insert into todo (profile_id, todo) values (1,'Graduate');


Insert into memo (memo, profile_id)
values ('University Entrance Ceremony',6);
Insert into memo (memo, profile_id)
values ('The day I go to college MT',3);
Insert into memo (memo, profile_id)
values ('4/19~4/23 1st semester midterm exam',2);
Insert into memo (memo, profile_id)
values ('6/14~ 6/18 1st semester final exam',9);
Insert into memo (memo, profile_id)
values ('10/18~ 10/22 2nd semester midterm exam',2);
Insert into memo (memo, profile_id)
values ('12/13~ 12/17 2nd semester final exam',8);
Insert into memo (memo, profile_id)
values ('University Festival',7);
Insert into memo (memo, profile_id)
values ('Club OT after class',5);
Insert into memo (memo, profile_id)
values ('Club MT',5);
Insert into memo (memo, profile_id)
values ('Graduate',10);

Insert into time_table (subject, profile_id)
values ('Biopharmaceutical Experiment',1);
Insert into time_table (subject, profile_id)
values ('Understanding Business Administration',2);
Insert into time_table (subject, profile_id)
values ('English and American Literature',3);
Insert into time_table (subject, profile_id)
values ('Korean grammar',4);
Insert into time_table (subject, profile_id)
values ('Group counseling and guidance',5);
Insert into time_table (subject, profile_id)
values ('Violin',6);
Insert into time_table (subject, profile_id)
values ('Introduction to Psychology',7);
Insert into time_table (subject, profile_id)
values ('Police investigation theory',8);
Insert into time_table (subject, profile_id)
values ('Required major - basic mechanical practice',9);
Insert into time_table (subject, profile_id)
values ('Early childhood education theory',10);


Insert into term_memo (todo,time_table_id)
values ('Tomorrow is the day I go to university, I want to eat barbecue quickly.',3);
Insert into term_memo (todo,time_table_id)
values ('A month before the midterm exam, hard work mode on',2);
Insert into term_memo (todo,time_table_id)
values ('A month before final exams, hard work mode on',9);
Insert into term_memo (todo,time_table_id)
values ('My grade is A+!!!!',2);
Insert into term_memo (todo,time_table_id)
values ('I’m devastated that I got a C+ grade',5);
Insert into term_memo (todo,time_table_id)
values ('Today is the university festival',7);
Insert into term_memo (todo,time_table_id)
values ('What kind of people will I meet tomorrow at the first club activity OT?',5);
Insert into term_memo (todo,time_table_id)
values ('Tomorrow is club MT',9);
Insert into term_memo (todo,time_table_id)
values ('Start job search',8);
Insert into term_memo (todo,time_table_id)
values ('Graduation, end of studies, start of employment hell',10);


Insert into board (profile_id, content, title, categories, deleteyn)
values (1, 'Please recommend a pharmaceutical company', 'Can you recommend a pharmaceutical company?','Community','N');
Insert into board (profile_id, content, title, categories, deleteyn)
values (2, 'Looking for a book "Understanding Economics".', 'I buy it for 10,000 won.(Purchase completed)','Fleemarket','Y');
Insert into board (profile_id, content, title, categories, deleteyn)
values (3, 'I looking forward to finding a past issue.', 'Can you inform me about the past issues?','InformationExchange','N');
Insert into board (profile_id, content, title, categories, deleteyn)
values (4, 'Today we have Korean language and literature freshman OT', 'Please join us after class.','Community','N');
Insert into board (profile_id, content, title, categories, deleteyn)
values (5, 'A teacher recruitment notice has been posted.', 'If you are interested, please check it out.','InformationExchange','N');
Insert into board (profile_id, content, title, categories, deleteyn)
values (6, 'We are looking for people who want to learn violin with us.', 'Recruitment closes in two weeks.','Community','N');
Insert into board (profile_id, content, title, categories, deleteyn)
values (7, 'I Sell book "Understanding Psychology".', 'I sell for 8,000 won.(Sale completed)','Fleemarket','Y');
Insert into board (profile_id, content, title, categories, deleteyn)
values (8, 'Yesterday, the student, Kwon Gil-dong received the Brave Citizen Award for catching a pickpocket. ', 'Congratulations to Gildong Kwon.','Community','N');
Insert into board (profile_id, content, title, categories, deleteyn)
 values (9, 'Tommorow is practice day.', 'We look forward to your involvement.','Community','N');
Insert into board (profile_id, content, title, categories, deleteyn)
values (10, 'OO Kindergarten is recruiting teachers.', 'If you are interested, please contact the department chair.','InformationExchange','N');









