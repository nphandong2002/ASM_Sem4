package com.example.asm_sem4.Mapper;

import com.example.asm_sem4.Dto.userDto;
import com.example.asm_sem4.Entity.UserEntity;

public class UserMappercustom {
    public  UserEntity convertToDto2(userDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        if ( userDto.getId() != null ) {
            userEntity.setId( userDto.getId() );
        }
        if ( userDto.getUsername() != null ) {
            userEntity.setUsername( userDto.getUsername() );
        }
        if ( userDto.getPassword() != null ) {
            userEntity.setPassword( userDto.getPassword() );
        }
        if ( userDto.getName() != null ) {
            userEntity.setName( userDto.getName() );
        }
        if ( userDto.getEmail() != null ) {
            userEntity.setEmail( userDto.getEmail() );
        }
        if ( userDto.getAddress() != null ) {
            userEntity.setAddress( userDto.getAddress() );
        }
        if ( userDto.getPhone() != null ) {
            userEntity.setPhone( Integer.parseInt( userDto.getPhone() ) );
        }

        return userEntity;
    }


    public  userDto convertToEntity2(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        userDto userDto = new userDto();

        userDto.setId( userEntity.getId() );
        if ( userEntity.getName() != null ) {
            userDto.setName( userEntity.getName() );
        }
        userDto.setPhone( String.valueOf( userEntity.getPhone() ) );
        if ( userEntity.getEmail() != null ) {
            userDto.setEmail( userEntity.getEmail() );
        }
        if ( userEntity.getAddress() != null ) {
            userDto.setAddress( userEntity.getAddress() );
        }
        if ( userEntity.getUsername() != null ) {
            userDto.setUsername( userEntity.getUsername() );
        }
        if ( userEntity.getPassword() != null ) {
            userDto.setPassword( userEntity.getPassword() );
        }

        return userDto;
    }
}