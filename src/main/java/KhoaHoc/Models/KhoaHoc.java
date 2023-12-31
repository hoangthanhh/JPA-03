package KhoaHoc.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "khoahoc")
public class KhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int khoaHocId;
    @Column(name = "tenkhoahoc")
    @Size(max = 10, message = "ten khoa hoc khong duoc qua 10 ky tu")
    private String tenKhoaHoc;
    @Column(name = "mota")
    private String moTa;
    @Column(name = "hocPhi")
    @Max(value = 10000000, message = "hoc phi khong duoc qua 10 trieu")
    private int hocPhi;
    @Column(name = "ngaybatdau")
    private Date ngayBatDau;
    @Column(name = "ngayketthuc")
    private Date ngayKetThuc;

    @OneToMany(mappedBy = "khoaHoc")
    @JsonIgnoreProperties(value = "khoaHoc")
    private Set<HocVien> hocViens;

    @OneToMany(mappedBy = "khoaHoc")
    @JsonIgnoreProperties(value = "khoaHoc")
    private Set<NgayHoc> ngayHocs;

    public int getSoNgayHoc() {
        return (int) ChronoUnit.DAYS.between(ngayBatDau.toInstant(), ngayKetThuc.toInstant());
    }

    public int getKhoaHocId() {
        return khoaHocId;
    }

    public void setKhoaHocId(int khoaHocId) {
        this.khoaHocId = khoaHocId;
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(int hocPhi) {
        this.hocPhi = hocPhi;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Set<HocVien> getHocViens() {
        return hocViens;
    }

    public void setHocViens(Set<HocVien> hocViens) {
        this.hocViens = hocViens;
    }

    public Set<NgayHoc> getNgayHocs() {
        return ngayHocs;
    }

    public void setNgayHocs(Set<NgayHoc> ngayHocs) {
        this.ngayHocs = ngayHocs;
    }

}
