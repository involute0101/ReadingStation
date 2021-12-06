package com.dbtest.controller;

import com.dbtest.entity.BulletScreen;
import com.dbtest.service.BulletScreenSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/BulletScreen")
public class BulletScreenController {
    @Autowired
    BulletScreenSerivce bulletScreenSerivce;
    @PostMapping("/getBulletScreenRandomly")
    public List<BulletScreen>getBulletScreenRandomly(int num){
        return bulletScreenSerivce.getBulletScreenRandomly(num);
    }

}
