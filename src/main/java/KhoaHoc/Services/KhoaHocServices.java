package KhoaHoc.Services;

import KhoaHoc.Models.KhoaHoc;
import KhoaHoc.repository.KhoaHocRepo;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Service
public class KhoaHocServices implements IKhoaHocServices{
    @Autowired
    private KhoaHocRepo khoaHocRepo;

    @Override
    public void them1NgayChoKhoaHoc(int khoaHocId) {
        Optional<KhoaHoc> optionalKhoaHoc = khoaHocRepo.findById(khoaHocId);
        if (optionalKhoaHoc.isPresent()) {
            KhoaHoc khoaHoc = optionalKhoaHoc.get();

            if (khoaHoc.getSoNgayHoc() < 15) {

                // Chuyển đổi từ java.util.Date sang java.time.LocalDate
                LocalDate ngayKetThuc = khoaHoc.getNgayKetThuc().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                // Thêm một ngày
                ngayKetThuc = ngayKetThuc.plusDays(1);

                // Chuyển lại sang java.util.Date
                Date ngayKetThucDate = Date.from(ngayKetThuc.atStartOfDay(ZoneId.systemDefault()).toInstant());

                khoaHoc.setNgayKetThuc(ngayKetThucDate);

                khoaHocRepo.save(khoaHoc);
            }
        }
    }

    @Override
    public KhoaHoc xoaKhoaHoc(int khoaHocId) {
        Optional<KhoaHoc> khoaHoc =khoaHocRepo.findById(khoaHocId);
        if (khoaHoc.isEmpty()) {
            return null;
        }
        khoaHocRepo.delete(khoaHoc.get());
        return khoaHoc.get();
    }
}
