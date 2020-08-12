package com.itcr.datos.railspot;

import com.itcr.datos.railspot.dataStructures.SinglyList;
import com.itcr.datos.railspot.management.UserTree;
import com.itcr.datos.railspot.objects.Ticket;
import com.itcr.datos.railspot.objects.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RailspotApplication {

	public static void main(String[] args) {

		UserTree.initUserTree();
		SpringApplication.run(RailspotApplication.class, args);
	}

}
