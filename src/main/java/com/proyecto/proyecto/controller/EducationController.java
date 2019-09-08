package com.proyecto.proyecto.controller;

import com.proyecto.proyecto.Repository.EducationRepositiry;
import com.proyecto.proyecto.model.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EducationController {

    @Autowired
    private EducationRepositiry educationRepository;

//    @GetMapping("/education")
//    public String formEducation(){
//        return "education";
//    }

    @GetMapping("/education")
    public String formEducation(Model model) {
        model.addAttribute("education", new Education());
        return "education";
    }


    @PostMapping("/education")
    public String formEducation(Education education){
        educationRepository.save(education);
        return "redirect:/education";
    }
}
