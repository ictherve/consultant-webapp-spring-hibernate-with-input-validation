package com.ictcg.consultant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@GetMapping("/all")
	public String findAll(Model model) {
		
		model.addAttribute("consultants", consultantService.findAll());
		
		return "consultant-list";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("Consultant") Consultant consultant, Model model) {
		consultantService.save(consultant);
		return "redirect:/consultant/list";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@RequestParam Integer id, Model model) {
		
		consultantService.delete(id);
		
		return "redirect:/consultant/list";
	}
	
	@GetMapping("/registerForm")
	public String showRegisterForm(Model model) {
		model.addAttribute("consultant", new Consultant());
		return "consultant-form";
	}
	
	@GetMapping("/updateForm/{id}")
	public String showUpdateForm(@RequestParam Integer id, Model model) {
		model.addAttribute("consultant", consultantService.findById(id));
		return "consultant-form";
	}
}
