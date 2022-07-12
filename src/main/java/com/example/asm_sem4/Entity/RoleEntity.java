package com.example.asm_sem4.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@Getter
@Setter

public class RoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public RoleEntity(){}

    public RoleEntity(String name){
        this.name = name;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "roleEntity")
    private List<UserEntity> user;

}
