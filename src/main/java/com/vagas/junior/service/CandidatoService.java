package com.vagas.junior.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.vagas.junior.dao.CandidatoRepository;
import com.vagas.junior.dto.CandidatoDTO;
import com.vagas.junior.entity.CandidatoEntity;
import com.vagas.junior.firebase.FirebaseDatabaseConfig;
import com.vagas.junior.utils.QueryParams;
import com.vagas.junior.utils.QueryResults;

@Service
public class CandidatoService {
	

	private CandidatoRepository repository;
	
	
	@Transactional(readOnly = true)
	public QueryResults getAll(QueryParams queryParams) {
		
		PageRequest pageRequest = PageRequest.of(queryParams.getPageNumber(), queryParams.getPageSize(),
				Sort.Direction.valueOf(queryParams.getSortOrder().toUpperCase()),
				(queryParams.getSortField()));

		Page<CandidatoEntity> candidatoPage = repository.find(queryParams.getFilter(), pageRequest);

		List<CandidatoDTO> candidatoList = candidatoPage.getContent().stream().map(c -> c.toDto(c))
				.collect(Collectors.toList());

		return new QueryResults(candidatoList, candidatoPage.getTotalElements());
		
		
		
	}
	
	
	@Transactional(readOnly=true)
	public List<CandidatoDTO> getget() {
		FirebaseDatabase db = FirebaseDatabaseConfig.getDatabase();
		Firestore dbz = FirebaseDatabaseConfig.getFirestore();
		DatabaseReference raiz = db.getReference();
		List<CandidatoDTO> dtoList = new ArrayList<>();
		Query query ;
		
		raiz.child("candidato").orderByKey();
		 
		DocumentReference docRef;// = dbz.collection("candidato").document("Qyh6N6LUSR3eMoaU5XDt");
		System.out.println("Document data: " + dbz);
		// asynchronously retrieve the document
//		ApiFuture<DocumentSnapshot> future = docRef.get();
//		// ...
//		// future.get() blocks on response
//		DocumentSnapshot document;
//		try {
//			document = future.get();
//			if (document.exists()) {
//				  System.out.println("Document data: " + document.getData());
//				} else {
//				  System.out.println("No such document!");
//				}
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("FIMMM");
		return dtoList;
	}
	

}
