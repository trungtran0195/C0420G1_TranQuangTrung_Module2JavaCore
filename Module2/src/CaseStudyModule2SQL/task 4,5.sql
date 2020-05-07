-- yeucau4
SELECT khachhang.HoTen , count(hopdong.IDKhachHang) as so_lan_dat_phong from khachhang inner join hopdong on khachhang.IDKhachHang = hopdong.IDKhachHang
inner join loaikhach on khachhang.IDLoaiKhach=loaikhach.IDLoaiKhach where loaikhach.TenLoaiKhach='Diamond'
group by khachhang.IDKhachHang order by so_lan_dat_phong
-- yeucau5
SELECT khachhang.IDKhachHang, khachhang.HoTen, loaikhach.TenLoaiKhach, hopdong.IDHopDong, hopdong.NgayLamHopDong, hopdong.NgayKetThuc,dichvu.TenDichVu,
sum(dichvu.ChiPhiThue + hopdongchitiet.SoLuong*dichvudikem.Gia) as TongTien from khachhang
left join loaikhach on khachhang.IDLoaiKhach = loaikhach.IDLoaiKhach
left join hopdong on khachhang.IDKhachHang = hopdong.IDKhachHang
left join dichvu on hopdong.IDDichVu =  dichvu.IDDichVu
left join hopdongchitiet on hopdong.IDHopDong = hopdongchitiet.IDHopDong
left join dichvudikem on hopdongchitiet.IDDichVuDiKem =  dichvudikem.IDDichVuDiKem
group by hopdong.IDHopDong;
