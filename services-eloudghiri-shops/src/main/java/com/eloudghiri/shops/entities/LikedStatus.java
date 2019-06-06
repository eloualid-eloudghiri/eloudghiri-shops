package com.eloudghiri.shops.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LikedStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "id_user")
	private Long idUser;

	@Column(name = "id_shop")
	private Long idShop;

	@Column(name = "statut")
	private boolean liked;

	@Column(name = "time_of_status")
	private LocalDateTime timeOfStatus;

	public LikedStatus(){}

	public LikedStatus(Long idUser, Long idShop, boolean liked, LocalDateTime timeOfStatus) {
		this.idUser = idUser;
		this.idShop = idShop;
		this.liked = liked;
		this.timeOfStatus = timeOfStatus;
	}

	public Long getId() {
		return id;
	}

	public LikedStatus setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getIdUser() {
		return idUser;
	}

	public LikedStatus setIdUser(Long idUser) {
		this.idUser = idUser;
		return this;
	}

	public Long getIdShop() {
		return idShop;
	}

	public LikedStatus setIdShop(Long idShop) {
		this.idShop = idShop;
		return this;
	}

	public boolean getLiked() {
		return liked;
	}

	public LikedStatus setLiked(boolean liked) {
		this.liked = liked;
		return this;
	}

	public LocalDateTime getTimeOfStatus() {
		return timeOfStatus;
	}

	public LikedStatus setTimeOfStatus(LocalDateTime timeOfStatus) {
		this.timeOfStatus = timeOfStatus;
		return this;
	}
}
