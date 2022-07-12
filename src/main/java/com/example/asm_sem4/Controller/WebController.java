package com.example.asm_sem4.Controller;

import com.example.asm_sem4.Dto.userDto;
import com.example.asm_sem4.Entity.UserEntity;
import com.example.asm_sem4.Mapper.UserMappercustom;
import com.example.asm_sem4.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller

public class WebController {
    @Autowired
    UserService userSevice;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserMappercustom userMappercustom;

    @GetMapping(value = {"/","/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/user")

    public String user(Model model,
                        @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                        @RequestParam(value = "limit", required = false, defaultValue = "5") String limit

    ){
        List<UserEntity> list = userSevice.getall(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit), Sort.by("id").descending()));

        Object  principal  = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        UserEntity user = userSevice.findUserEntitiesByUsername(username);

        userDto u = new userDto();

        model.addAttribute("role",user.getRoleId());
        model.addAttribute("list",list);
        model.addAttribute("user",u);
        return "admin";

    }
    @PostMapping(path  = "/create")
    public String create(@ModelAttribute("user") userDto user){
        if (user != null) {
            UserEntity user2 = userSevice.findUserEntitiesByUsername(user.getUsername());
            if(user2 != null && user == null){
                throw new UsernameNotFoundException("username exesit");
            }
            System.out.println("log 1: "+ user);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            UserEntity user1 = userMappercustom.convertToDto2(user);
            System.out.println("log 2: "+ user1.toString());
            userSevice.save(user1);
        }

        return "redirect:/user";
    }
    @GetMapping(value = "/edit")
    public String edit(Model model,@RequestParam("id") int id){
        UserEntity user = userSevice.findbyid(id);
        userDto u = userMappercustom.convertToEntity2(user);
        model.addAttribute("user",u);
        return "edit";
    }
    @GetMapping(value = "/delete")
    public String delete(Model model,@RequestParam("id") int id){
        userSevice.deleteUser(id);
        return "redirect:/user";
    }

}
