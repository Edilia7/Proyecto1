package com.proyecto.proyecto.controller;

import com.proyecto.proyecto.Repository.PersonRepository;
import com.proyecto.proyecto.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person")
    public String formPersonal(){
        return "person";
    }


    @PostMapping("/person")
    public String formPersonal(Person person){
        personRepository.save(person);
        return "redirect:/person";
    }

}
