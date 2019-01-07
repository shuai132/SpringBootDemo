package com.example.controller.hardware;

import com.example.controller.base.BaseController;
import com.example.hardware.WiringPi;
import com.example.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hardware")
@Api(value = "硬件控制")
public class HardwareController extends BaseController {
    @PostMapping
    @ApiOperation("led")
    public Response<Boolean> led(@RequestParam(value = "state") boolean state) {
        return helper.handle(() -> {
            WiringPi.CLibrary c = WiringPi.getInstance();
            c.pullUpDnControl(9, 0);
            c.pinMode(9, 1);
            c.digitalWrite(9, state);
            return c.digitalRead(9);
        });
    }
}
