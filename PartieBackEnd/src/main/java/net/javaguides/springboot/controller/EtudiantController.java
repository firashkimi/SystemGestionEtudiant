package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.javaguides.springboot.model.Etudiant;
import net.javaguides.springboot.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EtudiantController {

	@Autowired
	private EtudiantRepository etudiantRepository;
	
	// get all employees
	@GetMapping("/etudiants")
	public List<Etudiant> getAllEmployees(){
		return etudiantRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/etudiants")
	public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}
	
	// get employee by id rest api
	@GetMapping("/etudiants/{id}")
	public ResponseEntity<Etudiant> getEmployeeById(@PathVariable Long id) {
		Etudiant etudiant = etudiantRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Etudiant not exist with id :" + id));
		return ResponseEntity.ok(etudiant);
	}
	
	// update employee rest api
	
	@PutMapping("/etudiants/{id}")
	public ResponseEntity<Etudiant> updateEmployee(@PathVariable Long id, @RequestBody Etudiant etudiantDetails){
		Etudiant etudiant = etudiantRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Etudiant not exist with id :" + id));
		
		etudiant.setFirstName(etudiantDetails.getFirstName());
		etudiant.setLastName(etudiantDetails.getLastName());
		etudiant.setEmailId(etudiantDetails.getEmailId());
		
		Etudiant updatedEtudiant = etudiantRepository.save(etudiant);
		return ResponseEntity.ok(updatedEtudiant);
	}
	
	// delete employee rest api
	@DeleteMapping("/etudiants/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEtudiant(@PathVariable Long id){
		Etudiant etudiant = etudiantRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Etudiant not exist with id :" + id));
		
		etudiantRepository.delete(etudiant);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
