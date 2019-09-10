package com.proyecto.proyecto.controller;

import com.proyecto.proyecto.Repository.PersonRepository;
import com.proyecto.proyecto.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

//    @GetMapping("/person")
//    public String formPersonal(Model model){
//        model.addAttribute("person", new Person());
//        return "person";
//    }

    @GetMapping("/index")
    public String general(Model model) {
        model.addAttribute("person", new Person());
        return "index";
    }

    @PostMapping("/index")
    public String savePersonal(@ModelAttribute @Valid Person person, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            System.out.println("Has errors");
            return "index";
        }
        personRepository.save(person);
        return "redirect:/index";


//    @PostMapping("/person")
//    public String savePersonal(@ModelAttribute @Valid Person person, BindingResult result, ModelMap model){
//        if(result.hasErrors()){
//            System.out.println("Has errors");
//            return "person";
//        }
//        personRepository.save(person);
//        return "redirect:/person";
    }



    @ModelAttribute("status")
    public List<String> initializeStatus(){
        List<String> status = new ArrayList<>();
        status.add("--Select an option--");
        status.add("Single");
        status.add("Common-Law");
        status.add("Married");
        status.add("Legally Separated");
        status.add("Divorced");
        status.add("Widowed");
        return status;
    }
}