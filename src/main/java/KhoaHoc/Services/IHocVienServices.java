package KhoaHoc.Services;

import KhoaHoc.Models.HocVien;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IHocVienServices {
    public HocVien suaHocVien(HocVien hocVienSua);
    public List<HocVien> timKiemHocVien(String hoTen, int khoaHocId);
    public int tinhDoanhThuTrongThang(int thang);
}
