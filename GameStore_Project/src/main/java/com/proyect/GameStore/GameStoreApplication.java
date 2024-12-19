package com.proyect.GameStore;


import com.proyect.GameStore.Entity.ConsolaEntity;
import com.proyect.GameStore.Implements.ConsolaImplt;
import com.proyect.GameStore.Repository.ConsolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Stream;

@SpringBootApplication
public class GameStoreApplication  implements CommandLineRunner {

	@Autowired
	private ConsolaImplt consolaImplt;

	public static void main(String[] args)  {
		SpringApplication.run(GameStoreApplication.class, args);
	}


	public void run(String... args)throws Exception {
		consolaImplt.inicioConsola("nintendo");
	}

}
