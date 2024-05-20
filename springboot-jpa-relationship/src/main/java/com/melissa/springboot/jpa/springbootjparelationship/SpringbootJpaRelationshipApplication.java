package com.melissa.springboot.jpa.springbootjparelationship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
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
		removeInvoiceBidireccional();
	}

	@Transactional
	public void removeInvoiceBidireccional(){

		Client client = new Client ("Jenny","Caicedo");

		Invoice invoice1= new Invoice("compras de casa",5000L);
		Invoice invoice2= new Invoice("compras de oficina",9000L);

		client.addInvoice(invoice1).addInvoice(invoice2);
		System.out.println(client);

		Optional<Client> optionalClient = clientRepository.findOneALL(3L);

		optionalClient.ifPresent(clientDb ->{

			Invoice invoice3= new Invoice("compras de casa",5000L);
			invoice3.setId(1L);
			
			Optional<Invoice> invoiceOptional = invoiceRepository.findById(2L);  //Optional.of(invoice3);
			invoiceOptional.ifPresent(invoice->{
				clientDb.removeInvoice(invoice);
				clientRepository.save(clientDb);
				System.out.println(clientDb);
			});

		});
	}


	@Transactional
	public void removeInvoiceBidireccionalFindById(){

		Optional<Client> optionalClient = clientRepository.findOneALL(1L);

		optionalClient.ifPresent(client ->{

			Invoice invoice1= new Invoice("compras de casa",5000L);
			Invoice invoice2= new Invoice("compras de oficina",9000L);
	
			client.addInvoice(invoice1).addInvoice(invoice2);
	
			clientRepository.save(client);
			System.out.println(client);
		});

		Optional<Client> optionalClientDb = clientRepository.findOneALL(1L);

		optionalClientDb.ifPresent(client->{
			Invoice invoice3 = new Invoice("compras de casa",5000L);
			invoice3.setId(1L);
			Optional<Invoice> invoiceOptional = Optional.of(invoice3); // invoiceRepository.findById(2L);
			invoiceOptional.ifPresent(invoice->{
				client.removeInvoice(invoice);
				clientRepository.save(client);
				System.out.println(client);
			});
		});
	}

	@Transactional
	public void oneToManyInvoiceBidireccionalFindById(){

		Optional<Client> optionalClient = clientRepository.findOneALL(1L);

		optionalClient.ifPresent(client ->{

			Invoice invoice1= new Invoice("compras de casa",5000L);
			Invoice invoice2= new Invoice("compras de oficina",9000L);
	
			client.addInvoice(invoice1).addInvoice(invoice2);
	
			clientRepository.save(client);
			System.out.println(client);
		});

	}


	@Transactional
	public void oneToManyInvoiceBidireccional(){
		Client client = new Client("Jenny","Caicedo");

		Invoice invoice1= new Invoice("compras de casa",5000L);
		Invoice invoice2= new Invoice("compras de oficina",9000L);

		client.addInvoice(invoice1).addInvoice(invoice2);

		clientRepository.save(client);
		System.out.println(client);

	}

	@Transactional
	public void removeAddressFindById(){
		Optional<Client> optionalClient= clientRepository.findById(2L);
		optionalClient.ifPresent(client->{
			
			Address address1 = new Address("La Luna",1234);
			Address address2 = new Address("Vasco de lima",9874);
			
			Set <Address> addresses= new HashSet<>();
			addresses.add(address2);
			addresses.add(address1);
			client.setAddresses(addresses);

			clientRepository.save(client);
			System.out.println(client);

			Optional<Client> optionalClient2 = clientRepository.findOne(2L);
			optionalClient2.ifPresent(c->{
				c.getAddresses().remove(address2);
				clientRepository.save(c);
				System.out.println(c);
			});




		});
	}

	@Transactional
	public void removeAddress(){
		Client client = new Client("Jenny","Caicedo");
		Address address1 = new Address("La Luna",1234);
		Address address2 = new Address("Vasco de lima",9874);

		client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		clientRepository.save(client);
		System.out.println(client);

		Optional<Client> optionalClient = clientRepository.findById(3L);
		optionalClient.ifPresent(c->{
			c.getAddresses().remove(address1);
			clientRepository.save(c);
			System.out.println(c);
		});
	}

	@Transactional
	public void oneToManyFindById(){
		Optional<Client> optionalClient= clientRepository.findById(2L);
		optionalClient.ifPresent(client->{
			
			Address address1 = new Address("La Luna",1234);
			Address address2 = new Address("Vasco de lima",9874);
			
			Set <Address> addresses= new HashSet<>();
			addresses.add(address2);
			addresses.add(address1);
			client.setAddresses(addresses);

			
			clientRepository.save(client);
			System.out.println(client);
		});
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
