package KhoaHoc.Controller;

import KhoaHoc.Models.HocVien;
import KhoaHoc.Services.HocVienServices;
import KhoaHoc.repository.HocVienRepo;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
public class HocVienController {
    @Autowired
    private HocVienServices hocVienServices;

    @RequestMapping(value = "suahocvien", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public HocVien suaHocVien(@RequestBody String hocVienSua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer() {
                    @Override
                    public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
                        return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
                    }
                }
        ).create();
        HocVien hv = gson.fromJson(hocVienSua, HocVien.class);
        return hocVienServices.suaHocVien(hv);
    }

    @RequestMapping(value = "timkiemhocvien", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HocVien> timKiemHocVien(@RequestBody String hoTen, int khoaHocId) {
        return hocVienServices.timKiemHocVien(hoTen,khoaHocId);
    }

    @RequestMapping(value = "tinhdoanhthu", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public int tinhDoanhThu(@RequestParam int thang) {
        return hocVienServices.tinhDoanhThuTrongThang(thang);
    }
}
