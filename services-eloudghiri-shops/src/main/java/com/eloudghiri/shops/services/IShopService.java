package com.eloudghiri.shops.services;


import com.eloudghiri.shops.dtos.ShopDTO;

import java.util.List;

public interface IShopService {

	List<ShopDTO> getAllShopsForUser(Long idUser);

	List<ShopDTO> getLikedShopByUser(Long idUser);

	boolean setLikeStatusForUser(Long idUser, Long idShop, boolean status);
}
