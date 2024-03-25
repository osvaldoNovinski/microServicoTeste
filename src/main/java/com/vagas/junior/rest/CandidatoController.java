package com.vagas.junior.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.database.FirebaseDatabase;
import com.vagas.junior.service.CandidatoService;
import com.vagas.junior.utils.QueryParams;

@RestController
@RequestMapping(value = "/api")
public class CandidatoController {

	private FirebaseDatabase firebaseDatabase;
	@Autowired
	private CandidatoService service;

	public CandidatoController(FirebaseDatabase firebaseDatabase) {
		this.firebaseDatabase = firebaseDatabase;
	}

//	    
//	private final FirebaseAuth firebaseAuth;
//    private final DatabaseReference databaseReference;
//    
//    public CandidatoController(FirebaseAuth firebaseAuth, FirebaseDatabase firebaseDatabase) {
//        this.firebaseAuth = firebaseAuth;
//        this.databaseReference = firebaseDatabase.getReference("https://vagasjunior-5bdf7-default-rtdb.firebaseio.com");
//    }
//
//	@GetMapping("/candidato")
//	public List<CandidatoEntity> getAll() {
		
		// Use Firebase services here
//		return "Firebase integration example";
//	}
	
	@PostMapping(value = "/candidato")
	public ResponseEntity<?> getAll(@RequestBody QueryParams queryParams) {
		System.out.println("VÉIOOOOOOO");
		return new ResponseEntity<>(service.getAll(queryParams), HttpStatus.OK);
	}
	
	@GetMapping(value = "/get")
	public ResponseEntity get(){
		System.out.println("VÉIOOOOOOO");
		service.getget();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
