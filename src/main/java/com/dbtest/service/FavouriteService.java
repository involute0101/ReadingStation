package com.dbtest.service;

import com.dbtest.dao.FavouriteMappers;
import com.dbtest.entity.Favourite;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteService {

    @Autowired
    private SqlSessionFactory mybatisSqlSessionFactory;

    public void insertFavourite(Favourite favourite){
        try(SqlSession sqlSession = mybatisSqlSessionFactory.openSession()){
            FavouriteMappers mappers = sqlSession.getMapper(FavouriteMappers.class);
            mappers.insertFavourite(favourite);
            sqlSession.commit();
        }
    }

    public List<Favourite> myFavourite(String account){
        try(SqlSession sqlSession = mybatisSqlSessionFactory.openSession()){
            FavouriteMappers mappers = sqlSession.getMapper(FavouriteMappers.class);
            return mappers.myFavourite(account);
        }
    }
}
