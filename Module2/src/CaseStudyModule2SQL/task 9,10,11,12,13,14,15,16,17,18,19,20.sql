-- yeucau9
select temp.month , count(month(hopdong.NgayLamHopDong)) as so_khach_hang_dang_ky , sum(hopdong.TongTien) as Tong_tien from
(select 1 as month
union select 2 as month
union select 3 as month
union select 4 as month
union select 5 as month
union select 6 as month
union select 7 as month
union select 8 as month
union select 9 as month
union select 10 as month
union select 11 as month
union select 12 as month) as temp
left join hopdong on month(hopdong.NgayLamHopDong) = temp.month
left join khachhang on khachhang.IDKhachHang=hopdong.IDKhachHang
where year(hopdong.NgayLamHopDong)= "2019" or year(hopdong.NgayLamHopDong) is null or month(hopdong.NgayLamHopDong) is null
group by temp.month
order by temp.month

-- yeucau10
select hopdong.IDHopDong, hopdong.NgayLamHopDong, hopdong.NgayKetThuc, hopdong.TienDatCoc, count(hopdongchitiet.IDHopDongChiTiet) as So_luong_dich_vu_di_kem
from hopdong inner join hopdongchitiet on hopdong.IDHopDong=hopdongchitiet.IDHopDong group by hopdong.IDHopDong

-- yeucau11
select dichvudikem.TenDichVuDiKem, dichvudikem.Gia, dichvudikem.DonVi from hopdong
inner join hopdongchitiet on hopdong.IDHopDong = hopdongchitiet.IDHopDong
inner join dichvudikem on hopdongchitiet.IdDichVuDiKem = dichvudikem.IdDichVuDiKem
inner join khachhang on khachhang.IDKhachHang=hopdong.IDKhachHang
inner join loaikhach on khachhang.IDLoaiKhach=loaikhach.IDLoaiKhach
where loaikhach.TenLoaiKhach='Diamond' and khachhang.DiaChi in ("Vinh","QuangNgai");

-- yeucau12
select hopdong.IDHopDong, hopdong.TongTien, nhanvien.HoTen, khachhang.HoTen, khachhang.SDT, dichvu.TenDichVu, 
count(hopdongchitiet.IDDichVuDiKem) as so_lan_su_dung from hopdong
inner join nhanvien on hopdong.IDNhanVien = nhanvien.IDNhanVien
inner join khachhang on hopdong.IDKhachHang = khachhang.IDKhachHang
inner join dichvu on dichvu.IDDichVu = hopdong.IDDichVu
inner join hopdongchitiet on hopdong.IDHopDong = hopdongchitiet.IDHopDong
where not exists(select hopdong.IDHopDong where hopdong.NgayLamHopDong between "2019-01-01" and "2019-06-31")
and exists(select hopdong.IDHopDong where hopdong.NgayLamHopDong between "2019-09-01" and "2019-12-31");

-- yeucau13
select dichvudikem.IdDichVuDiKem, dichvudikem.TenDichVuDiKem, dichvudikem.Gia,
count(hopdongchitiet.IDDichVuDiKem) as so_lan_su_dung from dichvudikem
inner join hopdongchitiet on dichvudikem.IdDichVuDiKem = hopdongchitiet.IdDichVuDiKem
ORDER BY so_lan_su_dung desc
LIMIT 1

-- yeucau14
select hopdong.IDHopDong, loaidichvu.TenLoaiDichVu, dichvudikem.TenDichVuDiKem, count(hopdongchitiet.IDDichVuDiKem) as so_lan_su_dung
from hopdong inner join dichvu on dichvu.IDDichVu = hopdong.IDDichVu
inner join loaidichvu on loaidichvu.IDLoaiDichVu = dichvu.IdLoaiDichVu
inner join hopdongchitiet on hopdongchitiet.IDHopDong = hopdong.IDHopDong
inner join dichvudikem on dichvudikem.IdDichVuDiKem = hopdongchitiet.IdDichVuDiKem
group by(dichvudikem.TenDichVuDiKem) having so_lan_su_dung=1;


-- yeucau15
select nhanvien.IDNhanVien , nhanvien.HoTen, trinhdo.TrinhDo, bophan.TenBoPhan, nhanvien.SDT, nhanvien.DiaChi,
count(hopdong.IDNhanVien) as so_lan_lap_hop_dong from nhanvien
left join trinhdo on nhanvien.IDTrinhDo = trinhdo.IDTrinhDo
left join bophan on nhanvien.IDBoPhan = bophan.IDBoPhan
left join hopdong on nhanvien.IDNhanVien = hopdong.IDNhanVien 
where exists(select hopdong.IDNhanVien where hopdong.NgayLamHopDong between "2018-01-01" and "2019-12-31")
group by nhanvien.HoTen
having so_lan_lap_hop_dong < 4

-- yeucau16
select nhanvien.*
from nhanvien
where nhanvien.IDNhanVien in
	(select hd.IDNhanVien
	from  hopdong as hd
	where year(hd.NgayLamHopDong) < 2017 or year(hd.NgayLamHopDong)> 2019
	group by hd.IDNhanVien)
    
-- yeucau17
update khachhang,(select hopdong.IDKhachHang as id,sum(hopdong.TongTien) as tong_tien from hopdong
where year(hopdong.NgayLamHopDong) = 2019
group by hopdong.IDKhachHang
having tong_tien>10000000) as temp set khachhang.IDLoaiKhach= (select loaikhach.IDLoaiKhach from loaikhach where loaikhach.TenLoaiKhach="Diamond")
where khachhang.IDLoaiKhach=(select loaikhach.IDLoaiKhach from loaikhach where loaikhach.TenLoaiKhach="Platinium")
and temp.id= khachhang.IDKhachHang;

-- yeucau18
delete khachhang,hopdong,hopdongchitiet from khachhang inner join hopdong on khachhang.IDKhachHang=hopdong.IDKhachHang
inner join hopdongchitiet on hopdong.IDHopDong=hopdongchitiet.IDHopDong
where not exists(select hopdong.IDHopDong where year(hopdong.NgayLamHopDong)>'2016' and khachhang.IDKhachHang=hopdong.IDKhachHang);

-- yeucau19
update dichvudikem inner join (select dichvudikem.TenDichVuDiKem as ten_dich_vu_di_kem
from hopdongchitiet inner join dichvudikem on dichvudikem.IdDichVuDiKem=hopdongchitiet.IdDichVuDiKem
group by dichvudikem.IdDichVuDiKem
having count (hopdongchitiet.IdDichVuDiKem) >3) as temp set dichvudikem.Gia = dichvudikem.Gia*2 where dichvudikem.TenDichVuDiKem=temp.ten_dich_vu_di_kem;

-- yeucau20
select nhanvien.IDNhanVien as ID , nhanvien.HoTen,nhanvien.Email,nhanvien.SDT,nhanvien.NgaySinh,nhanvien.DiaChi,"nhanvien" as FromTable
from nhanvien
union all 
select khachhang.IDKhachHang as ID, khachhang.HoTen,khachhang.Email,khachhang.SDT,khachhang.NgaySinh,khachhang.DiaChi,"khachhang" as FromTable
from khachhang;




