package com.example.asm_sem4.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userDto {
    private Integer id;
    @NotEmpty(message = "name not null")
    public String name;
    @NotEmpty(message = "phone not null")
    public String phone;
    @NotEmpty(message = "email not null")
    public String email;
    @NotEmpty(message = "address not null")
    public String address;
    @NotEmpty(message = "username not null")
    private String username;
    @NotEmpty(message = "password not null")
    private String password;

    private String roleId;


}
