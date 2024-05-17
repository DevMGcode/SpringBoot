package com.melissa.springboot.jpa.springbootjparelationship;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.melissa.springboot.jpa.springbootjparelationship.entities.Address;
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
		oneToMany();
	}

	@Transactional
	public void oneToMany(){
		Client client = new Client("Jenny","Caicedo");
		Address address1 = new Address("La Luna",1234);
		Address address2 = new Address("Vasco de lima",9874);

		client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		clientRepository.save(client);
		System.out.println(client);
	}

	@Transactional
	public void manyToOne(){
		Client client = new Client ("Daniel","Restrepo");
		clientRepository.save(client);

		Invoice invoice = new Invoice("Compras de oficina",2000L);
		invoice.setClient(client);
		Invoice invoiceDB = invoiceRepository.save(invoice);
		System.out.println(invoiceDB);
	}

	@Transactional
	public void manyToOneFindByIdClient(){
		Optional <Client>  optionalClient = clientRepository.findById(1L);
			if(optionalClient.isPresent()){
			Client client = optionalClient.orElseThrow();
			Invoice invoice = new Invoice("Compras de oficina",2000L);
			invoice.setClient(client);
			Invoice invoiceDB = invoiceRepository.save(invoice);
			System.out.println(invoiceDB);
		}
	}



}
