package com.eloudghiri.shops.controllers;

import java.util.List;

import com.eloudghiri.shops.dtos.ShopDTO;
import com.eloudghiri.shops.dtos.ShopLikedDTO;
import com.eloudghiri.shops.services.IShopService;
import com.eloudghiri.shops.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/Shop")
public class ShopController {

    @Autowired
    private IShopService shopService;

    @Autowired
    private IUserService userService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<ShopDTO>> getAllShops(@RequestParam("token") String token,
                                                     @RequestParam("userId") Long userId) {
        if (userService.validateLoggedUser(userId, token)) {
            return new ResponseEntity<>(shopService.getAllShopsForUser(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(path = "/liked")
    public ResponseEntity<List<ShopDTO>> getLikedShops(@RequestParam("token") String token,
                                                       @RequestParam("userId") Long userId) {
        if (userService.validateLoggedUser(userId, token)) {
            return new ResponseEntity<>(shopService.getLikedShopByUser(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping
    public ResponseEntity<Void> setLikeStatus(@RequestBody ShopLikedDTO body) {
        System.out.println("+++++++++++++++++++++++");
        System.out.println(body.getUserId());
        System.out.println("+++++++++++++++++++++++");
        if (userService.validateLoggedUser(body.getUserId(), body.getToken())) {
            shopService.setLikeStatusForUser(body.getUserId(), body.getShopId(), body.getStatus());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
