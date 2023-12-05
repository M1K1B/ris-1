package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.services.ZaduzenjeService;

import model.Kategorija;
import model.Zaduzenje;

@Controller
@RequestMapping("/zaduzenje/")
public class ZaduzenjeController {
	
	@Autowired
	ZaduzenjeService zs;
	
	@GetMapping(value="svaZaduzenja")
	public String svaZaduzenja () {
		return "zaduzenja";
	}
	
	@ModelAttribute("kategorije")
	public List<Kategorija> getKategorije () {
		return zs.getKateogrije();
	}
	
	@GetMapping(value="getZaduzenja")
	public String getZaduzenja (@RequestParam("kategorija") Integer id, Model m) {
		m.addAttribute("zaduzenja", zs.getZaduzenjaZaKategoriju(id));
		return "zaduzenja";
	}
	
	@GetMapping(value="infoClan")
	public String infoClan(@RequestParam("id") Integer id, Model m) {
		m.addAttribute("info", zs.getClan(id));
		return "info-clan";
	}

	@GetMapping(value="infoPrimerak")
	public String infoPrimerak(@RequestParam("id") Integer invBroj, Model m) {
		m.addAttribute("clanovi", zs.getClanoviZaPrimerak(invBroj));
		return "info-primerak";
	}
}