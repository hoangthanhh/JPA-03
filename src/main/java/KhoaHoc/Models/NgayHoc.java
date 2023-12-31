package KhoaHoc.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "ngayhoc")
public class NgayHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ngayHocId;
    @Column(name = "khoahocid")
    private int khoaHocId;
    @Column(name = "noidung")
    private String noiDung;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "khoahocid",insertable = false,updatable = false)
    @JsonIgnoreProperties(value = "ngayHocs")
    private KhoaHoc khoaHoc;

    public int getNgayHocId() {
        return ngayHocId;
    }

    public void setNgayHocId(int ngayHocId) {
        this.ngayHocId = ngayHocId;
    }

    public int getKhoaHocId() {
        return khoaHocId;
    }

    public void setKhoaHocId(int khoaHocId) {
        this.khoaHocId = khoaHocId;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }
}
