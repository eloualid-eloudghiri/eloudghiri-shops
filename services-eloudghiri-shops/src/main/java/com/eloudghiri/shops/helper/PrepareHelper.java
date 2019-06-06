package com.eloudghiri.shops.helper;


import com.eloudghiri.shops.entities.Shop;
import com.eloudghiri.shops.entities.User;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrepareHelper {

    private PrepareHelper() {
    }

    public static List<Shop> sortShopList(List<Shop> shops , User user){
        return shops.stream().sorted(new Comparator<Shop>() {
            @Override
            public int compare(Shop shopOne, Shop shopTwo) {
                return PrepareHelper.evaluateDistanceShopAndUser(shopOne,shopTwo,user);
            }
        }).collect(Collectors.toList());
    }

    private static int  evaluateDistanceShopAndUser(Shop shopOne, Shop shopTwo , User user){
        return (Math.sqrt(Math.pow((shopOne.getCoordinate().getPositionX() - user.getCoordinate().getPositionX()),2) + Math.pow((shopOne.getCoordinate().getPositionY() - user.getCoordinate().getPositionY()),2)))
                -
                Math.sqrt(Math.pow((shopTwo.getCoordinate().getPositionX() - user.getCoordinate().getPositionX()),2) + Math.pow((shopTwo.getCoordinate().getPositionY() - user.getCoordinate().getPositionY()),2)) >= 0 ? 1 : -1;
    }
    
	public static boolean validateToken(User user, String token) {
		return token.equals(user.getToken());
	}
}
