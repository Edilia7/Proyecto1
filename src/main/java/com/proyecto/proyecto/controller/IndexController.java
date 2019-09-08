package com.proyecto.proyecto.controller;

import com.proyecto.proyecto.Repository.PersonRepository;
import com.proyecto.proyecto.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    PersonRepository personalRepository;

    @GetMapping("/index")
    public String general(Model model){
        model.addAttribute("index", new Person());
        return "index";
    }
}
