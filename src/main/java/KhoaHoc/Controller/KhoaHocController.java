package KhoaHoc.Controller;

import KhoaHoc.Models.KhoaHoc;
import KhoaHoc.Services.KhoaHocServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class KhoaHocController {
    @Autowired
    private KhoaHocServices khoaHocServices;

    @RequestMapping(value = "them1ngaychokhoahoc", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void them1NgayChoKhoaHoc(@RequestParam int khoaHocId) {
        khoaHocServices.them1NgayChoKhoaHoc(khoaHocId);
    }

    @RequestMapping(value = "xoakhoahoc", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public KhoaHoc xoaKhoaHoc(@RequestParam int khoaHocId) {
        return khoaHocServices.xoaKhoaHoc(khoaHocId);
    }
}
