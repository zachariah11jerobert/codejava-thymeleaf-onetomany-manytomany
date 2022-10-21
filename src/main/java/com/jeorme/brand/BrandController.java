package com.jeorme.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BrandController {
	
	@Autowired
	private BrandRepository brandRepo;
	
	@GetMapping("/brands/new")
	public String showCreateNewBrandForm(Model model) {
		model.addAttribute("brand",new Brand());
		
		return "brand_form";
	}
	
	@PostMapping("/brands/save")
	public String saveBrand(Brand brand) {
		brandRepo.save(brand);
		
		return "redirect:/";
	}
	
	@GetMapping("/brands")
	public String listBrands(Model model) {
		List<Brand> listBrands=brandRepo.findAll();
		model.addAttribute("listBrands", listBrands);
		
		return "brands";
	}
	
	@GetMapping("/brands/edit/{id}")
	public String showEditBrandForm(@PathVariable("id") Integer id,Model model) {
		Brand brand=brandRepo.findById(id).get();
		
		return "brand_form";
	}

}
