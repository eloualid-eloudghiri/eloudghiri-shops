package com.eloudghiri.shops.services;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.eloudghiri.shops.dtos.ShopDTO;
import com.eloudghiri.shops.dtos.mapper.ShopMapper;
import com.eloudghiri.shops.entities.LikedStatus;
import com.eloudghiri.shops.entities.Shop;
import com.eloudghiri.shops.repositories.LikedStatusRepository;
import com.eloudghiri.shops.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

@Service
public class ShopService implements IShopService {

	@Autowired
	private ShopRepository shopRepository;

	@Autowired
	private LikedStatusRepository likedStatusRepository;

	@Autowired
	private ShopMapper shopMapper;

	@Override
	public List<ShopDTO> getAllShopsForUser(Long idUser) {
		List<Shop> shops = getListShop(idUser, null);
		shops.removeAll(getListShop(idUser, true));
		shops.removeAll(getListShop(idUser, false));
		return shopMapper.toListDto(shops);
	}

	@Override
	public List<ShopDTO> getLikedShopByUser(Long idUser) {
		return shopMapper.toListDto(getListShop(idUser, true));
	}

	private List<Shop> getListShop(Long idUser, Boolean status) {
		List<Shop> shops = new ArrayList<>();
		if (status != null) {
			List<LikedStatus> likedStatut = likedStatusRepository.findLikedStatusByUser(idUser, status);
			likedStatut.stream().forEach(element -> {
				if (status == false) {
					Long intervalHours = element.getTimeOfStatus().until(LocalDateTime.now(), ChronoUnit.HOURS);
					if (Math.abs(intervalHours) < 2) {
						shops.add(shopRepository.getOne(element.getIdShop()));
					} else {
						likedStatusRepository.delete(element);
					}
				} else {
					shops.add(shopRepository.getOne(element.getIdShop()));
				}
			});
		} else {
			shops.addAll(shopRepository.findAll());
		}
		return shops;
	}

	@Override
	public boolean setLikeStatusForUser(Long idUser, Long idShop, boolean status) {
		LikedStatus likedStatus = new LikedStatus(idUser, idShop, status, LocalDateTime.now());
		try {
			likedStatusRepository.save(likedStatus);
		} catch (DataAccessResourceFailureException e) {
			return false;
		}
		return true;
	}
}
