package com.example.demo.controllers;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repositories.ClanRepository;
import com.example.demo.repositories.KategorijaRepository;

import jakarta.servlet.http.HttpServletRequest;
import model.Clan;
import model.Kategorija;

@Controller
@RequestMapping("/clan/")
public class ClanController {
	
	@Autowired
	KategorijaRepository kr;
	
	@Autowired
	ClanRepository cr;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@GetMapping(value="sviClanovi")
	public String getClanovi(HttpServletRequest req) {
		req.setAttribute("clanovi", cr.findAll());
		
		return "svi-clanovi";
	}
	
	@ModelAttribute("clan")
	public Clan getClan() {
		return new Clan();
	}
	
	@ModelAttribute("kategorije")
	public List<Kategorija> getKategorije() {
		return kr.findAll();
	}
	
	@GetMapping(value="unosClana")
	public String unosClana() {
		return "novi-clan";
	}
	
	@PostMapping(value="saveClan")
	public String saveClan(@ModelAttribute("clan") Clan clan, Model m) {
		Clan cl = cr.save(clan);
		
		m.addAttribute("poruka", "Clan je uspesno sacuvan. Id clana je ");
		m.addAttribute("clanSaved", cl);
		
		return "novi-clan";
	}
}