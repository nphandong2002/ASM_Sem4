package com.example.asm_sem4.Service;

import com.example.asm_sem4.Entity.UserEntity;
import com.example.asm_sem4.Repostitory.UserRepo;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public  class UserService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;


    public UserEntity save(UserEntity user){
        return userRepo.save(user);
    }
    public List<UserEntity> getall(Pageable pageable){
        return  userRepo.findAll(pageable).getContent();
    }
    @PreAuthorize("hasAuthority('admin')")
    public String deleteUser(int id) {
        userRepo.deleteById(id);
        return "success";
    }
    public UserEntity findbyid(int id){
        return userRepo.findUserEntityById(id);
    }
    public UserEntity findUserEntitiesByUsername(String name){
        return  userRepo.findUserEntitiesByUsername(name);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = findUserEntitiesByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("username not found");
        }
        SimpleGrantedAuthority grand = new SimpleGrantedAuthority(userEntity.roleEntity.getName());
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();


        authorities.add(grand);
        User user = new User(userEntity.getUsername(), userEntity.getPassword(), authorities);
        return user;
    }

}
