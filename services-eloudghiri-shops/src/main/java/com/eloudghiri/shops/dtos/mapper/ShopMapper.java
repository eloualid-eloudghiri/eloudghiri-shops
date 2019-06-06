package com.eloudghiri.shops.dtos.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.eloudghiri.shops.dtos.ShopDTO;
import com.eloudghiri.shops.entities.Shop;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {})
public interface ShopMapper extends EntityMapper<Shop, ShopDTO> {

	@Override
	default ShopDTO toDto(Shop entity) {
		if (entity == null)
			return null;
		else
			return new ShopDTO().setId(entity.getId())
					.setName(entity.getName())
					.setUri(entity.getUri())
					.setAdresse(entity.getAdresse())
					.setCoordinate(entity.getCoordinate());
	}
	
	@Override
	default Shop toEntity(ShopDTO dto) {
		if (dto == null)
			return null;
		else
			return new Shop().setAdresse(dto.getAdresse())
					.setCoordinate(dto.getCoordinate())
					.setName(dto.getName())
					.setUri(dto.getUri());
	}
	
	@Override
	default List<ShopDTO> toListDto(List<Shop> entities) {
		if (entities == null || entities.isEmpty())
			return Collections.emptyList();
		else {
			List<ShopDTO> dtos = new ArrayList<>();
			for (Shop entity : entities) {
				dtos.add(toDto(entity));
			}
			return dtos;
		}
	}

	@Override
	default List<Shop> toListEntity(List<ShopDTO> dtos) {
		if (dtos == null || dtos.isEmpty())
			return Collections.emptyList();
		else {
			List<Shop> entities = new ArrayList<>();
			for (ShopDTO dto : dtos) {
				entities.add(toEntity(dto));
			}
			return entities;
		}
	}
}
