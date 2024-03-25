package com.vagas.junior;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vagas.junior.firebase.FirebaseConfig;

@SpringBootApplication
public class JuniorApplication {

	public static void main(String[] args) {
		
		//FirebaseConfig conect = new FirebaseConfig();
		//try {
		//	conect.firebaseApp();
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
		SpringApplication.run(JuniorApplication.class, args);
	}

}
