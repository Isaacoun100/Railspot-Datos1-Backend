package com.itcr.datos.railspot;

import com.itcr.datos.railspot.management.UserTree;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RailspotApplication {

	public static void main(String[] args) {

		UserTree.initUserTree();
		SpringApplication.run(RailspotApplication.class, args);
	}

}
