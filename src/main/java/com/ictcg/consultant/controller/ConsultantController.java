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
	
	@GetMapping("/list")
	public String findAll(Model model) {
		
		model.addAttribute("consultants", consultantService.findAll());
		
		return "consultant-list";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("Consultant") Consultant consultant, Model model) {
		consultantService.save(consultant);
		return "redirect:/consultant/list";
	}
	
	@DeleteMapping("/delete/{customerId}")
	public String delete(@RequestParam Integer customerId, Model model) {
		
		consultantService.delete(customerId);
		
		return "redirect:/consultant/list";
	}
	
	@GetMapping("/registerForm")
	public String showRegisterForm(Model model) {
		model.addAttribute("consultant", new Consultant());
		return "consultant-form";
	}
	
	@GetMapping("/updateForm/{customerId}")
	public String showUpdateForm(@RequestParam Integer customerId, Model model) {
		model.addAttribute("consultant", consultantService.findById(customerId));
		return "consultant-form";
	}
}
