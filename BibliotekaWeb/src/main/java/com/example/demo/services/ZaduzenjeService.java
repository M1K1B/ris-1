package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.ClanRepository;
import com.example.demo.repositories.KategorijaRepository;
import com.example.demo.repositories.ZaduzenjeRepository;

import model.Clan;
import model.Kategorija;
import model.Zaduzenje;

@Service
public class ZaduzenjeService {
	@Autowired
	ZaduzenjeRepository zr;
	
	@Autowired
	KategorijaRepository kr;
	
	@Autowired
	ClanRepository cr;
	
	public List<Kategorija> getKateogrije () {
		return kr.findAll();
	}
	
	public List<Zaduzenje> getZaduzenjaZaKategoriju (int idKategorije) {
		return zr.getZaduzenjaZaKategoriju(idKategorije);
	}
	
	public Clan getClan(int idClana) {
		return cr.findById(idClana).get();
	}
	
	public List<Clan> getClanoviZaPrimerak (int invBroj) {
		return cr.getClanoviZaPrimerak(invBroj);
	}
}