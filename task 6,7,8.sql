-- yeucau6
select dichvu.IDDichVu, dichvu.TenDichVu,dichvu.DienTich, dichvu.ChiPhiThue,loaidichvu.TenLoaiDichVu from dichvu
inner join loaidichvu on dichvu.IdLoaiDichVu=loaidichvu.IdLoaiDichVu
where not exists(select hopdong.IDDichVu from hopdong where (hopdong.NgayLamHopDong between "2019-01-01" and "2019-03-31") and hopdong.IDDichVu = dichvu.IDDichVu);

-- yeucau7
select dichvu.IDDichVu, dichvu.TenDichVu,dichvu.DienTich, dichvu.SoNguoiToiDa, dichvu.ChiPhiThue,loaidichvu.TenLoaiDichVu from dichvu
inner join loaidichvu on dichvu.IdLoaiDichVu=loaidichvu.IdLoaiDichVu
where exists(select hopdong.IDDichVu from hopdong where year(hopdong.NgayLamHopDong)= "2018" and hopdong.IDDichVu = dichvu.IDDichVu)
and not exists(select hopdong.IDDichVu from hopdong where year(hopdong.NgayLamHopDong)= "2019" and hopdong.IDDichVu = dichvu.IDDichVu);

-- yeucau8
-- cach1
select distinct khachhang.HoTen from khachhang;
-- cach2
select khachhang.HoTen from khachhang  group by khachhang.HoTen;
-- cach3
select khachhang.HoTen from khachhang  union select khachhang.HoTen from khachhang;