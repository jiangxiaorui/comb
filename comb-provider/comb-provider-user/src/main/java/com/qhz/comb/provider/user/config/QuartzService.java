package com.qhz.comb.provider.user.config;

import com.qhz.comb.provider.bus.api.feign.BorrowFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jiangting
 * @since 1.0, 2018/6/1
 */
@Component
public class QuartzService {

    @Autowired
    BorrowFeignClient testFeginService;

    @Scheduled(cron = "0/5 * * * * ? ")
    public void timerToNow() {
        String result = testFeginService.test();
        System.out.println(result);
        System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
