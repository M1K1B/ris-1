package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Clan;

public interface ClanRepository extends JpaRepository<Clan, Integer> {
	
	@Query("select c from Clan c inner join c.zaduzenjes z where z.primerak.invBroj=:id")
	
	public List<Clan> getClanoviZaPrimerak (@Param("id") Integer id);
}