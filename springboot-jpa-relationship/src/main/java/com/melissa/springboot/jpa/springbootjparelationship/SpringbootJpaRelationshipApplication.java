package com.melissa.springboot.jpa.springbootjparelationship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.melissa.springboot.jpa.springbootjparelationship.entities.Client;
import com.melissa.springboot.jpa.springbootjparelationship.entities.Invoice;
import com.melissa.springboot.jpa.springbootjparelationship.repositories.ClientRepository;
import com.melissa.springboot.jpa.springbootjparelationship.repositories.InvoiceRepository;

@SpringBootApplication
public class SpringbootJpaRelationshipApplication implements CommandLineRunner {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private InvoiceRepository invoiceRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRelationshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		manyToOne();
	}

	public void manyToOne(){
		Client client = new Client ("Daniel","Restrepo");
		clientRepository.save(client);

		Invoice invoice = new Invoice("Compras de oficina",2000L);
		invoice.setClient(client);
		Invoice invoiceDB = invoiceRepository.save(invoice);
		System.out.println(invoiceDB);

	}



}
