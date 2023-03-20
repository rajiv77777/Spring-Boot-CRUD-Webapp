package com.webapp.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.webapp.demo.Application;
import com.webapp.demo.dao.AlienRepo;
import com.webapp.demo.model.Alien;

@RestController //For restAPIs
//@Controller	//For Controller UI
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@PostMapping("/alien")
	public Alien addAlien(Alien alien) {
		ModelAndView mv = new ModelAndView("home.jsp");
		repo.save(alien);
		String addAlienStatusMessage = "Data Added";
		mv.addObject("addAlienStatus", addAlienStatusMessage);
		
		//sample to pull date from DB with pre-defined functions of JPA
		//System.out.println(repo.findByName("rajiv"));
		//System.out.println(repo.findByAidGreaterThan(100));
		//System.out.println(repo.findByNameSorted("name"));
		
		return alien;
	}
	
/* Normal method
 * 	@RequestMapping("addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}
*/	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView("data.jsp");
		Alien alien = repo.findById(aid).orElse(null);
		mv.addObject(alien);
		return mv;
	}
	
	@RequestMapping("/api/v1/getAllAliens")
	@ResponseBody
	public List<Alien> getAllAliens() {
		return repo.findAll();
	}
	
	@GetMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAlienbyAID(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}
	
	@DeleteMapping("/alien/{aid}")
	public void deleteAlien(@PathVariable int aid) {
		repo.deleteById(aid);
	
	}
	
	//if consumes is not mentioned in mapping method, we cant use Json request for REST APIs, we can use only HTML form data requests with key and values.
	@PutMapping(path="/alien", consumes = {"application/json"})
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
}
