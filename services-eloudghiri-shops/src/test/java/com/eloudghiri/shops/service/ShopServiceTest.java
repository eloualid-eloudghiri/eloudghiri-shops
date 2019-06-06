package com.eloudghiri.shops.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.eloudghiri.shops.entities.LikedStatus;
import com.eloudghiri.shops.entities.Shop;
import com.eloudghiri.shops.services.ShopService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eloudghiri.shops.repositories.LikedStatusRepository;
import com.eloudghiri.shops.repositories.ShopRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class ShopServiceTest {

	@Mock
	private ShopRepository shopRepository;

	@Mock
	private LikedStatusRepository likedStatusRepository;
	
	@Mock
	private com.eloudghiri.shops.dtos.mapper.ShopMapper ShopMapper;
	
	@InjectMocks
	private ShopService shopService;
	
	private Long userId = Long.valueOf(1);
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllShopsForUser() {
		when(shopRepository.findAll()).thenReturn(new ArrayList<>());
		when(ShopMapper.toListDto(Mockito.any())).thenCallRealMethod();
		shopService.getAllShopsForUser(userId);
	}

	@Test
	public void getLikedShopByUser() {
		List<LikedStatus> likedStatus = new ArrayList<>();
		LikedStatus status = new LikedStatus(userId, Long.valueOf(1), true, LocalDateTime.now());
		likedStatus.add(status);
		when(likedStatusRepository.findLikedStatusByUser(userId, true)).thenReturn(likedStatus);
		when(shopRepository.getOne(Long.valueOf(1))).thenReturn(new Shop());
		when(ShopMapper.toListDto(Mockito.any())).thenCallRealMethod();
		shopService.getLikedShopByUser(userId);
	}

	@Test
	public void setLikeStatusForUserOK() {
		LikedStatus likedStatus = new LikedStatus(userId, Long.valueOf(1), true, LocalDateTime.now());
		when(likedStatusRepository.save(likedStatus)).thenReturn(likedStatus);
		boolean value = shopService.setLikeStatusForUser(userId, Long.valueOf(1),true);
		assertTrue(value);
	}
	
	@Test
	public void setLikeStatusForUserKO() {
		when(likedStatusRepository.save(Mockito.any())).thenThrow(new DataAccessResourceFailureException(""));
		boolean value = shopService.setLikeStatusForUser(userId, Long.valueOf(1),false);
		assertFalse(value);
	}
}
