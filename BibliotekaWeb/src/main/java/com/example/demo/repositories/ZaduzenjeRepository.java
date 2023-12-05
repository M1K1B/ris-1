package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Zaduzenje;

public interface ZaduzenjeRepository extends JpaRepository<Zaduzenje, Integer> {
	
	@Query("select z from Zaduzenje z where z.clan.kategorija.idKategorija = :idKat")
	public List<Zaduzenje> getZaduzenjaZaKategoriju (@Param("idKat") Integer idKat);
}