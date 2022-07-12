package com.example.asm_sem4;

import com.example.asm_sem4.Entity.RoleEntity;
import com.example.asm_sem4.Entity.UserEntity;
import com.example.asm_sem4.Service.RoleService;
import com.example.asm_sem4.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AsmSem4Application {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            if(roleService.findByName("admin") == null){
                roleService.save(new RoleEntity("admin"));
            }
            if(roleService.findByName("user") == null){
                roleService.save(new RoleEntity("user"));
            }

            UserEntity user = userService.findUserEntitiesByUsername("admin");
            if(user == null){
                UserEntity userAdmin = new UserEntity("admin","$2a$12$rBhM8n2wciynb6e0.Ha0q.qNfDlFXzIjWwjIuRvyvH4D6z6pRlQbO",1);
                userAdmin.setAddress("0");
                userAdmin.setEmail("0");
                userAdmin.setPhone(0);
                userAdmin.setName("admin");

                userService.save(userAdmin);
            }


        };
    }
    public static void main(String[] args) {

        SpringApplication.run(AsmSem4Application.class, args);

    }

}
