package KhoaHoc.repository;

import KhoaHoc.Models.HocVien;
import KhoaHoc.Models.KhoaHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HocVienRepo extends JpaRepository<HocVien,Integer> {
    @Query(value = "select count(hoc_vien_id) from hocvien where khoahocid = :khoaHocId", nativeQuery = true)
    int soHocVien(@Param("khoaHocId") int khoaHocId);

    @Query(value = "select hoc_phi from khoahoc where khoa_hoc_id = :khoaHocId", nativeQuery = true)
    int hocPhi(@Param("khoaHocId") int khoaHocId);

}
