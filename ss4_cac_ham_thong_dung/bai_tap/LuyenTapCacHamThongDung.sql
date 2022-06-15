USE QuanLySinhVien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * 
from subject
where credit >= all(select credit from subject);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select mark.MarkId, mark.mark, subject.SubName, subject.credit
from mark join subject on mark.SubId = subject.SubId
having mark.mark >= all(select max(mark) from mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select *, avg(mark.mark) as 'diem_trung_binh'
from student join mark on student.StudentId = mark.StudentId
group by student.StudentId
order by avg(mark.mark) desc;
