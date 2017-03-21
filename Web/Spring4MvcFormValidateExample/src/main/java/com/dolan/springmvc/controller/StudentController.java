package com.dolan.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dolan.springmvc.model.Student;

@Controller
@RequestMapping("/")
public class StudentController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String newStudent(ModelMap model){
		Student stu = new Student();
		model.addAttribute("student",stu);
		return "Student/new";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String saveStudent(@Valid Student stu,BindingResult result,ModelMap model){
		if(result == null || result.hasErrors()){
			return "Student/new";
		}
		model.addAttribute("success", "Dear "+stu.getFirstName()+", your registration completed successfully");
		return "Student/success";
	}
	
	/*
     * Method used to populate the Section list in view.
     * Note that here you can call external systems to provide real data.
     */
    @ModelAttribute("sections")
    public List<String> initializeSections() {
 
        List<String> sections = new ArrayList<String>();
        sections.add("Graduate");
        sections.add("Post Graduate");
        sections.add("Research");
        return sections;
    }
	
	   /*
     * Method used to populate the country list in view.
     * Note that here you can call external systems to provide real data.
     */
    @ModelAttribute("countries")
    public List<String> initializeCountries() {
 
        List<String> countries = new ArrayList<String>();
        countries.add("USA");
        countries.add("CANADA");
        countries.add("FRANCE");
        countries.add("GERMANY");
        countries.add("ITALY");
        countries.add("OTHER");
        return countries;
    }
 
    /*
     * Method used to populate the subjects list in view.
     * Note that here you can call external systems to provide real data.
     */
    @ModelAttribute("subjects")
    public List<String> initializeSubjects() {
 
        List<String> subjects = new ArrayList<String>();
        subjects.add("Physics");
        subjects.add("Chemistry");
        subjects.add("Life Science");
        subjects.add("Political Science");
        subjects.add("Computer Science");
        subjects.add("Mathmatics");
        return subjects;
    }
	
	

}
