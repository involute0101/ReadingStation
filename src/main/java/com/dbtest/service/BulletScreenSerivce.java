package com.dbtest.service;

import com.dbtest.dao.BulletScreenMappers;
import com.dbtest.pojo.BulletScreen;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@NoArgsConstructor
@Service
public class BulletScreenSerivce {
    @Autowired
    private SqlSessionFactory mybatisSqlSessionFactory;
    public List<BulletScreen> getBulletScreenRandomly(int nums){
        try(SqlSession sqlSession=mybatisSqlSessionFactory.openSession()) {
            BulletScreenMappers bulletScreenMapper=sqlSession.getMapper(BulletScreenMappers.class);
            List<BulletScreen>bulletScreens=new ArrayList<>();
            Random random=new Random();
            int id=0;
            while(bulletScreens.size()<=nums){
                id=random.nextInt(100)+1;
                bulletScreens.add(bulletScreenMapper.selectBulletScreen(id));
            }
            return bulletScreens;
        }
    }
}
