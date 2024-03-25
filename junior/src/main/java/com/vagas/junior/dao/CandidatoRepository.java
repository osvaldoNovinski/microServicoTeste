package com.vagas.junior.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.google.cloud.firestore.CollectionReference;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.vagas.junior.entity.CandidatoEntity;
import com.vagas.junior.firebase.FirebaseDatabaseConfig;

@Repository
public interface CandidatoRepository {
	
	
	Page<CandidatoEntity> find(String filtro, Pageable pageable);

}
