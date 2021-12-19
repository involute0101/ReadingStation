package com.dbtest.dao;

import com.dbtest.entity.Favourite;

import java.util.List;

public interface FavouriteMappers {

    public void insertFavourite(Favourite favourite);

    public List<Favourite> myFavourite(String account);
}
