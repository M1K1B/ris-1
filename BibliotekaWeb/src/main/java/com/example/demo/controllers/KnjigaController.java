package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/knjiga/")
public class KnjigaController {
	@GetMapping(value="getIzdavaci")
	public String getIzdavaci (HttpServletRequest request) {
		List<String> izdavaci = new ArrayList<String>();
		
		izdavaci.add("Vulkan");
		izdavaci.add("Laguna");
		izdavaci.add("Finesa");
		request.getSession().setAttribute("izdavaci", izdavaci);
		
		return "knjige-izdavaca";
	}
	
	@GetMapping(value="checkKnjige")
	public ModelAndView checkKnjige (@RequestParam("izdavac") String izdavac) {
		Map<String, Integer> mapa = new HashMap<String, Integer>();
		
		int brPrimeraka = 0;
		
		if (izdavac.equals("Vulkan"))
			brPrimeraka = 1;
		else if (izdavac.equals("Laguna"))
			brPrimeraka = 2;
		else
			brPrimeraka = 4;
		
		mapa.put("brPrimeraka", brPrimeraka);
		
		ModelAndView mav = new ModelAndView("knjige-izdavaca");
		mav.addObject("model", mapa);
		
		return mav;
	}
}