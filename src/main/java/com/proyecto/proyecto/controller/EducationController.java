package com.proyecto.proyecto.controller;

import com.proyecto.proyecto.Repository.EducationRepositiry;
import com.proyecto.proyecto.model.Education;
import com.proyecto.proyecto.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EducationController {

    @Autowired
    private EducationRepositiry educationRepository;



    @GetMapping("/education")
    public String formEducation(Model model) {
        model.addAttribute("education", new Education());
        return "education";
    }

    @PostMapping("/education")
    public String saveEducation(@Valid Education education, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            System.out.println("Has errors");
            return "education";
        }
        educationRepository.save(education);
        return "redirect:/education";
    }

    @ModelAttribute("level")
    public List<String> initializeEducation(){
        List<String> level = new ArrayList<>();
        level.add("--Select an option--");
        level.add("No studies");
        level.add("High school");
        level.add("One year post-secondary credential");
        level.add("Two years post-secondary credential");
        level.add("Bachelor Degree");
        level.add("Master");
        level.add("Doctoral");
        return level;
    }

}
