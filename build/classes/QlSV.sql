create database QuanLySinhVien
go
use QuanLySinhVien;
drop database QuanLySinhVien
go
create table Lop(
	TenLop Nvarchar(25), 
	Khoa Nvarchar(25),
	primary key(TenLop)
)
go
create table SinhVien(
	Msv Nvarchar(25) not null,
	HoTen Nvarchar(30) not null,
	NgaySinh Varchar(15),
	GioiTinh bit default 1,
	SDT Varchar(15) not null,
	DiaChi Nvarchar(15) not null,
	Email Nvarchar(50) not null,
	Lop Nvarchar(25) not null,--Kiểu như AT18B--
	primary key(Msv),
	FOREIGN KEY (Lop)
    REFERENCES Lop(TenLop),
	passwd Nvarchar(15)
)
go
Create table MonHoc(
	MaMon Nvarchar(25) not null,
	TenMon Nvarchar(25) not null,
	SoTin int not null,
	primary key (MaMon),

)

go
create table GiaoVien(
	MaGv Nvarchar(25) not null,
	HoTen Nvarchar(30) not null,
	NgaySinh Nvarchar(25) not null,
	GioiTinh bit default 1,
	SDT Varchar(15) not null,
	DiaChi Nvarchar(50) not null,
	Email Nvarchar(50) not null,
	TrinhDo nvarchar(30),
	Luong int,
	MaMon Nvarchar(25),
	primary key(MaGv),
	foreign key (MaMon) references MonHoc(MaMon),
	passwd Nvarchar(15)

)



go
create table Diem(
	Msv Nvarchar(25) not null,
	MaMon Nvarchar(25) not null,
	DiemChuyenCan float not null ,check (DiemChuyenCan <=10 and DiemChuyenCan >= 0),--chuyeen can
	DiemGk float not null,check (DiemGk <=10 and DiemGk >= 0),--giua ki
	--DiemTong1 float ,check (DiemTong1 <=10 and DiemTong1 >= 0),--Nó là điểm tổng kết trên lớp
	DiemThi float ,check (DiemThi <=10 and DiemThi >= 0),
	-- DiemTong2 float ,check (DiemTong2 <=10 and DiemTong2 >= 0),--Nó là điểm tổng kết trên lớp và khi thi
	Primary key (Msv, MaMon),
	FOREIGN KEY (Msv) REFERENCES Sinhvien(Msv),
    FOREIGN KEY (MaMon) REFERENCES Monhoc(MaMon)

)

go
create table LopTheoMon(
	MaMon Nvarchar(25) not null,
	Msv Nvarchar(25) not null,
	FOREIGN KEY (Msv) REFERENCES Sinhvien(Msv),
    FOREIGN KEY (MaMon) REFERENCES MonHoc(MaMon)
)



go
-- Insert data into Lop (5 rows)
INSERT INTO Lop  VALUES
('AT18A','ATTT'),
('AT18B','ATTT'),
('AT18C','ATTT'),
('AT18D','ATTT'),
('AT18E','ATTT');

go
-- Insert data into SinhVien (5 rows)
INSERT INTO SinhVien (Msv, HoTen, NgaySinh, SDT, DiaChi, Email, Lop,passwd) VALUES
('AT180101', N'Nguyễn Văn A', '16/04/2003', '0123456789', 'Address1', 'john.doe@example.com', 'AT18A','123456'),
('AT180201', N'Nguyễn Văn A', '16/04/2003', '0123456789', 'Address2', 'jane.doe@example.com', 'AT18B','123456'),
('AT180301', N'Nguyễn Văn A', '16/04/2003', '0123456789', 'Address3', 'alice.smith@example.com', 'AT18C','123456'),
('AT180401', N'Nguyễn Văn A', '16/04/2003', '0123456789', 'Address4', 'bob.johnson@example.com', 'AT18D','123456'),
('AT180501', N'Nguyễn Văn A', '16/04/2003', '0123456789', 'Address5', 'eva.davis@example.com', 'AT18E','123456');
go

-- Insert data into MonHoc (5 rows)
INSERT INTO MonHoc (MaMon, TenMon, SoTin) VALUES
('Mon1', 'Math',  3),
('Mon2', 'Physics', 4),
('Mon3', 'Chemistry',  3),
('Mon4', 'Biology',  4), 
('Mon5', 'History',  3);
go

-- Insert data into GiaoVien (5 rows)
INSERT INTO GiaoVien (MaGv, HoTen, NgaySinh, SDT, DiaChi, Email, TrinhDo, Luong, MaMon,passwd) VALUES
('GV0001', N'Nguyễn văn A', '16/04/2003', '0123456789', 'TeacherAddress1', 'teacherA@example.com', N'Tiến sĩ', 5000,'Mon1','123456'),
('GV0002', N'Nguyễn văn AB', '16/04/2003', '0123456789', 'TeacherAddress2', 'teacherB@example.com', N'Kỹ sư', 4500,'Mon1','123456'),
('GV0003', 'Nguyễn văn AC', '16/04/2003', '0123456789', 'TeacherAddress3', 'teacherC@example.com', N'Tiến sĩ', 4000,'Mon1','123456'),
('GV0004', N'Nguyễn văn AD', '16/04/2003', '0123456789', 'TeacherAddress4', 'teacherD@example.com', N'Tiến sĩ', 5000,'Mon1','123456'),
('GV0005', N'Nguyễn văn AE', '16/04/2003', '0123456789', 'TeacherAddress5', 'teacherE@example.com', N'Tiến sĩ', 4500,'Mon1','123456');
go

-- Insert data into Diem (5 rows)
INSERT INTO Diem (Msv, MaMon, DiemChuyenCan, DiemGk, DiemThi) VALUES
('AT180101', 'Mon1', 7.5, 8.0, 9.0),
('AT180201', 'Mon2', 8.5, 7.0, 8.0),
('AT180301', 'Mon3', 9.0, 8.5, 7.5),
('AT180401', 'Mon4', 7.0, 9.0, 8.5),
('AT180501', 'Mon5', 8.0, 7.5, 9.0);
go
-- Insert data into LopTheoMon (5 rows)
INSERT INTO LopTheoMon (MaMon, Msv) VALUES
('Mon1', 'AT180101'),
('Mon2', 'AT180201'),
('Mon3', 'AT180301'),
('Mon4', 'AT180401'),
('Mon5', 'AT180501');







select * from SinhVien

drop table khaoThi
create table khaoThi(
	username Nvarchar(15),
	passwd Nvarchar(15),
	primary key(username)
)


insert into khaoThi values('NTT2003','19052003'),('TMT2003','19052003');

select * from SinhVien
select * from GiaoVien


