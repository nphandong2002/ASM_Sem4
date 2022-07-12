package com.example.asm_sem4.Repostitory;

import com.example.asm_sem4.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<RoleEntity,Integer> {
    RoleEntity findRoleEntitiesByName(String name);
}
