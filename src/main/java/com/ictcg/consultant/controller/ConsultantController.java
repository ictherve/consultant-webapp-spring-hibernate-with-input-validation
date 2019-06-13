package com.ictcg.consultant.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ictcg.consultant.model.Consultant;
import com.ictcg.consultant.service.ConsultantService;

@Controller
@RequestMapping("/consultant")
public class ConsultantController {

	@Autowired
	private ConsultantService consultantService;
	
	@GetMapping("/list")
	public String findAll(Model model) {
		
		model.addAttribute("consultants", consultantService.findAll());
		
		return "consultant-list";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("consultant") Consultant consultant, BindingResult result, Model model) {
		
		if(result.hasErrors())
			return "consultant-form";
		consultantService.save(consultant);
		return "redirect:/consultant/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Integer consultantId, Model model) {
		
		consultantService.delete(consultantId);
		
		return "redirect:/consultant/list";
	}
	
	@GetMapping("/registerForm")
	public String showRegisterForm(Model model) {
		model.addAttribute("consultant", new Consultant());
		return "consultant-form";
	}
	
	@GetMapping("/updateForm")
	public String showUpdateForm(@RequestParam Integer consultantId, Model model) {
		model.addAttribute("consultant", consultantService.findById(consultantId));
		return "consultant-form";
	}
}
