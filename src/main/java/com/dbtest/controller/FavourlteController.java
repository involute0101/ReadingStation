package com.dbtest.controller;

import com.dbtest.entity.Favourite;
import com.dbtest.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Favourite")
public class FavourlteController {

    @Autowired
    private FavouriteService favouriteService;

    @GetMapping("/add")
    public void insertFavourite(@RequestParam String account,@RequestParam int bookId,@RequestParam String bookName){
        Favourite favourite = new Favourite();
        favourite.setAccount(account);
        favourite.setBookId(bookId);
        favourite.setBookName(bookName);
        favouriteService.insertFavourite(favourite);
    }

    @GetMapping("/myFavourite")
    public List<Favourite> myFavourite(@RequestParam String account){
        return favouriteService.myFavourite(account);
    }
}
