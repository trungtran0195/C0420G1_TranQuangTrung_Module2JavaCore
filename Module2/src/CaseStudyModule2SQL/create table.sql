CREATE TABLE furama_resort.ViTri(
IDViTri INT,
TenViTri varchar(45),
primary key(IDViTri)
);
CREATE TABLE furama_resort.BoPhan(
IDBoPhan INT,
TenBoPhan varchar(45),
primary key(IDBoPhan)
);
CREATE TABLE furama_resort.TrinhDo(
IDTrinhDo INT,
TrinhDo varchar(45),
primary key(IDTrinhDo)
);
CREATE TABLE furama_resort.NhanVien(
   IDNhanVien INT AUTO_INCREMENT,
   HoTen VARCHAR(50),
   IDViTri INT, FOREIGN KEY(IDViTri) REFERENCES ViTri(IDViTri),
   IDTrinhDo INT, FOREIGN KEY(IDTrinhDo) REFERENCES TrinhDo(IDTrinhDo),
   IDBoPhan INT, FOREIGN KEY(IDBoPhan) REFERENCES BoPhan(IDBoPhan),
   NgaySinh DATE,
   SoCMTND varchar(45),
   Luong varchar(45),
   SDT varchar(45),
   Email varchar(45),
   DiaChi varchar(45),
   PRIMARY KEY(IDNhanVien)
);
CREATE TABLE furama_resort.LoaiKhach(
IDLoaiKhach INT,
TenLoaiKhach varchar(45),
PRIMARY KEY(IDLoaiKhach)
);
CREATE TABLE furama_resort.KhachHang(
IDKhachHang INT AUTO_INCREMENT,
IDLoaiKhach INT, FOREIGN KEY(IDLoaiKhach) REFERENCES LoaiKhach(IDLoaiKhach),
HoTen varchar(45),
NgaySinh DATE,
SoCMTND varchar(45),
SDT varchar(45),
Email varchar(45),
DiaChi varchar(45),
primary key(IDKhachHang)
);
CREATE TABLE furama_resort.KieuThue(
IDKieuThue INT,
TenKieuThue varchar(45),
Gia INT,
primary key(IDKieuThue)
);
CREATE TABLE furama_resort.LoaiDichVu(
IDLoaiDichVu INT,
TenLoaiDichVu varchar(50),
primary key(IDLoaiDichVu)
);
CREATE TABLE furama_resort.DichVu(
IDDichVu INT,
TenDichVu varchar(45),
DienTich INT,
SoTang INT,
SoNguoiToiDa varchar(45),
ChiPhiThue varchar(45),
IdKieuThue INT(45), FOREIGN KEY(IdKieuThue) REFERENCES KieuThue(IdKieuThue),
IdLoaiDichVu INT, FOREIGN KEY(IdLoaiDichVu) REFERENCES LoaiDichVu(IdLoaiDichVu),
TrangThai varchar(45),
primary key(IDDichVu)
);
CREATE TABLE furama_resort.DichVuDiKem(
IdDichVuDiKem INT,
TenDichVuDiKem varchar(45),
Gia INT,
DonVi INT,
TrangThaiKhaDung varchar(45),
primary key(IdDichVuDiKem)
);
CREATE TABLE furama_resort.HopDong(
IDHopDong INT,
IDNhanVien INT, FOREIGN KEY(IDNhanVien) REFERENCES NhanVien(IDNhanVien),
IDKhachHang INT, FOREIGN KEY(IDKhachHang) REFERENCES KhachHang(IDKhachHang),
IDDichVu INT, FOREIGN KEY(IDDichVu) REFERENCES DichVu(IDDichVu),
NgayLamHopDong DATE,
NgayKetThuc DATE,
TienDatCoc INT,
TongTien INT,
primary key(IDHopDong)
);
CREATE TABLE furama_resort.HopDongChiTiet(
IDHopDongChiTiet INT,
IDHopDong INT, FOREIGN KEY(IDHopDong) REFERENCES HopDong(IDHopDong),
IDDichVuDiKem INT, FOREIGN KEY(IDDichVuDiKem) REFERENCES DichVuDiKem(IDDichVuDiKem),
SoLuong INT,
primary key(IDHopDongChiTiet)
);
