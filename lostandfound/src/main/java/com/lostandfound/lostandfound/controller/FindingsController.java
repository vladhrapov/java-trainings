package com.lostandfound.lostandfound.controller;

import com.lostandfound.lostandfound.model.Finding;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindingsController
{

	@GetMapping("/findings/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name)
	{
		return String.format("Hello %s! My car: %s", name);
	}

	@GetMapping("/findings/{id}")
	public String get(@PathVariable int id)
	{
		return String.format("We found finding with id: %s", id);
	}

	@GetMapping("/findings/search")
	public String search(@RequestParam(value = "q", defaultValue = "") String q)
	{
		return String.format("Searching for %s!", q);
	}

	@PostMapping(path = "/findings", consumes = "application/json", produces = "application/json")
	public String create(@RequestBody Finding finding)
	{
		return String.format("Finding was created with: id - %s, description - %s", finding.getId(), finding.getDescription());
	}

	@DeleteMapping("/findings/{id}")
	public String remove(@PathVariable int id)
	{
		return String.format("Finding was deleted, id: %s", id);
	}
}