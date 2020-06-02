package com.lostandfound.lostandfound.controller;

import java.util.List;

import com.lostandfound.lostandfound.entities.Finding;
import com.lostandfound.lostandfound.models.FindingViewModel;
import com.lostandfound.lostandfound.models.Response;
import com.lostandfound.lostandfound.repository.FindingsRepository;
import com.lostandfound.lostandfound.repository.IFindingsRepository;
import com.lostandfound.lostandfound.storage.InMemoryFindingsStorage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindingsController {
	private IFindingsRepository findingsRepository;

	public FindingsController() {
		findingsRepository = new FindingsRepository(new InMemoryFindingsStorage());
	}

	@GetMapping("/findings/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/findings/{id}")
	public ResponseEntity<Response<Finding>> get(@PathVariable int id) {
		Finding finding = null;
		try {
			finding = findingsRepository.get(id);
			System.out.println(String.format("We found finding with id: %s for searched %s", finding.getId(), id));

			return new ResponseEntity<Response<Finding>>(new Response<Finding>(finding), HttpStatus.OK);
			// return ResponseEntity.ok(new Response<Finding>(finding));
		} catch (Exception e) {
			// return ResponseEntity.notFound().build();
			return new ResponseEntity<Response<Finding>>(
					new Response<Finding>(String.format("No finding with id: %s", id), null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/findings/search")
	public ResponseEntity<Response<List<Finding>>> search(@RequestParam(value = "q", defaultValue = "") String q) {
		String[] keywords = q.split(",");
		List<Finding> findings = findingsRepository.search(keywords);

		System.out.println(String.format("Searching for %s!", q));

		return new ResponseEntity<Response<List<Finding>>>(new Response<List<Finding>>(findings), HttpStatus.OK);
	}

	@PostMapping(path = "/findings", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Response<Finding>> create(@RequestBody FindingViewModel finding) {
		Finding createdFinding;
		System.out.println(finding.getDescription());
		try {
			createdFinding = findingsRepository.create(finding);
			System.out.println(String.format("Finding was created with: id - %s, description - %s",
					createdFinding.getId(), finding.getDescription()));

			return new ResponseEntity<Response<Finding>>(new Response<Finding>(createdFinding), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Response<Finding>>(new Response<Finding>(e.getMessage(), null),
					HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/findings/{id}")
	public ResponseEntity<Response<Integer>> remove(@PathVariable int id) {
		try {
			int removedId = findingsRepository.remove(id);
			System.out.println(String.format("Finding was deleted, id: %s for passed %s", removedId, id));
			return new ResponseEntity<Response<Integer>>(new Response<Integer>(removedId), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Response<Integer>>(new Response<Integer>(e.getMessage(), null),
					HttpStatus.NOT_FOUND);
		}
	}
}