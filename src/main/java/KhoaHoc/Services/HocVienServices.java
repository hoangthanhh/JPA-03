package KhoaHoc.Services;

import KhoaHoc.Models.HocVien;
import KhoaHoc.Models.KhoaHoc;
import KhoaHoc.repository.HocVienRepo;
import KhoaHoc.repository.KhoaHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HocVienServices implements IHocVienServices {
    @Autowired
    HocVienRepo hocVienRepo;

    @Autowired
    KhoaHocRepo khoaHocRepo;

    @Override
    public HocVien suaHocVien(HocVien hocVienSua) {
        Optional<HocVien> hocVien = hocVienRepo.findById(hocVienSua.getHocVienId());
        if (hocVien.isEmpty()) {
            return null;
        }
        HocVien hv = hocVien.get();
        hv.setKhoaHoc(hocVienSua.getKhoaHoc());
        hv.setHoTen(hocVienSua.getHoTen());
        hv.setNgaySinh(hocVienSua.getNgaySinh());
        hv.setDiaChi(hocVienSua.getDiaChi());
        hv.setQueQuan(hocVienSua.getQueQuan());
        hv.setSdt(hocVienSua.getSdt());
        return hv;
    }

    @Override
    public List<HocVien> timKiemHocVien(String hoTen, int khoaHocId) {
        List<HocVien> list = new ArrayList<HocVien>();
        for (HocVien x : hocVienRepo.findAll()) {
            if (x.getHoTen().toLowerCase().contains(hoTen.toLowerCase()) && x.getKhoaHoc().getKhoaHocId() == khoaHocId) {
                list.add(x);
            }
        }
        return list;
    }

    @Override
    public int tinhDoanhThuTrongThang(int thang) {
        List<KhoaHoc> list = khoaHocRepo.findAll();
        int tongDoanhThu = 0;

        for (KhoaHoc khoaHoc : list) {
            LocalDate ngayBatDau = khoaHoc.getNgayBatDau().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (ngayBatDau != null && ngayBatDau.getMonthValue() == thang) {
                int soHocVien = hocVienRepo.soHocVien(khoaHoc.getKhoaHocId());
                int hocPhi = hocVienRepo.hocPhi(khoaHoc.getKhoaHocId());

                // Tính doanh thu cho khóa học
                int doanhThu = soHocVien * hocPhi;
                tongDoanhThu += doanhThu;
            }
        }
        return tongDoanhThu;
    }
}
