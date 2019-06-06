package com.eloudghiri.shops.dtos.mapper;


import com.eloudghiri.shops.dtos.UserDTO;
import com.eloudghiri.shops.entities.User;
import com.eloudghiri.shops.helper.MD5Haching;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends EntityMapper<User, UserDTO> {
	
    @Override
    default UserDTO toDto(User entity){
        if(entity == null)
            return null;
        else{
            return new UserDTO().setId(entity.getId())
                    .setEmail(entity.getEmail())
                    .setFirstName(entity.getFirstName())
                    .setLastName(entity.getLastName())
                    .setTelephone(entity.getTelephone())
                    .setCoordinate(entity.getCoordinate())
                    .setToken(entity.getToken());
        }
    }

    @Override
    default User toEntity(UserDTO dto) {
        if (dto == null)
            return null;
        else
            return new User().setEmail(dto.getEmail())
                    .setFirstName(dto.getFirstName())
                    .setLastName(dto.getLastName())
                    .setPassword(MD5Haching.hachingString(dto.getPassword()))
                    .setTelephone(dto.getTelephone())
                    .setCoordinate(dto.getCoordinate());
    }
}
