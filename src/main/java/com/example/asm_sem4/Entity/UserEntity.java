package com.example.asm_sem4.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "user")
@ToString
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public  int id;
    @Column(name = "username")
    public  String username;
    @NotNull(message = "password not null")
    @Column(name = "passworld")
    public  String password;

    @Column(name = "role_id")
    public  int roleId;
    @NotNull(message = "name not null")
    @Column(name = "name")
    public  String name;
    @NotNull(message = "email not null")

    @Column(name = "email")
    public  String email;
    @NotNull(message = "address not null")

    @Column(name = "address")
    public  String address;
    @NotNull(message = "phone not null")

    @Column(name = "phone")
    public  int phone;
    public UserEntity(){}

    public UserEntity(String username, String password,int roleId){
        this.username = username;
        this.password = password;
        this.roleId = roleId;
    }




    @ManyToOne
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    public RoleEntity roleEntity;
}
