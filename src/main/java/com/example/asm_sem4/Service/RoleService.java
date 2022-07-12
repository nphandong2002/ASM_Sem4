package com.example.asm_sem4.Service;

import com.example.asm_sem4.Entity.RoleEntity;
import com.example.asm_sem4.Repostitory.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepo roleRepo;
    public RoleEntity findByName(String name){
        return  roleRepo.findRoleEntitiesByName(name);
    }
    public RoleEntity save(RoleEntity role){
        return roleRepo.save(role);
    }
}
