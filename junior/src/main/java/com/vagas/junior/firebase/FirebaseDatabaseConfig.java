package com.vagas.junior.firebase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

@Configuration
public class FirebaseDatabaseConfig {
	public final Logger LOGGER = LoggerFactory.getLogger(FirebaseDatabaseConfig.class);
	private static FirebaseDatabase database;
	private static Firestore databaseFb;
	private FileInputStream serviceAccount;
	private FirebaseOptions options;
	
	
	@Bean
	public FirebaseDatabase firebaseDatabase() {
		
		// Verifica se o FirebaseApp já existe; se não, inicializa-o
		if (FirebaseApp.getApps().isEmpty()) {
			System.out.println("Passou aqui 1");
			try {
				serviceAccount = new FileInputStream("src/main/resources/serviceAccountKey.json");
				options = new FirebaseOptions.Builder().setServiceAccount(serviceAccount)
			    	    .setDatabaseUrl("https://vagasjunior-5bdf7-default-rtdb.firebaseio.com/")
			    	    .build();
				FirebaseApp.initializeApp(options);
				//databaseFb = FirestoreClient.getFirestore();
				LOGGER.info("FirebaseApp inicializado com sucesso");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		LOGGER.info("FirebaseApp inicializado com sucesso");
		System.out.println("Passou aqui 2 " + database.getInstance().getReference().toString());
		return database.getInstance();
	}
	
	public static FirebaseDatabase getDatabase() {
		
		return database.getInstance();
	}
	
	public static Firestore getFirestore() {
		System.out.println("Passou aqui 2 " + databaseFb.collection("candidato").document("Qyh6N6LUSR3eMoaU5XDt").get());
		return databaseFb;
	}
}
