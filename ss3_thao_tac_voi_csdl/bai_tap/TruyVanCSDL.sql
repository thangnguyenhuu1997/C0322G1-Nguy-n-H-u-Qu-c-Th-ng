USE quanlysinhvien;
-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select * from student where student_name like 'h%';
-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select * from class where start_date like '%12%';
-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select * from subject where Credit between 3 and 5;
-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
set sql_safe_updates = 0;
update student set class_id = 2 where student_name = 'Hung';
set sql_safe_updates = 1;
-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
select student.student_name, subject.subject_id, mark.mark
from student join mark on student.student_id = mark.student_id 
join subject on mark.subject_id = subject.subject_id
order by mark.mark desc, student.student_name;
