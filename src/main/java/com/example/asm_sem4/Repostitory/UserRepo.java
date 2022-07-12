package com.example.asm_sem4.Repostitory;

import com.example.asm_sem4.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<UserEntity,Integer> {
    UserEntity findUserEntitiesByUsername(String name);

    UserEntity findUserEntityById(int id);

}
