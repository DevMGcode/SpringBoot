package com.melissa.springboot.jpa.springbootjpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.melissa.springboot.jpa.springbootjpa.entities.Person;
import com.melissa.springboot.jpa.springbootjpa.repositories.PersonRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner{
	
	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		create();
	}

	@Transactional
	public void create(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el nombre:");
		String name= scanner.next();
		System.out.println("Ingrese el Apellido:");
		String lastname= scanner.next();
		System.out.println("Ingrese el lenguaje de programación:");
		String programmingLanguage= scanner.next();
		scanner.close();

		Person person = new Person(null,name,lastname,programmingLanguage);
		Person personNew=repository.save(person);
		System.out.println(personNew);

		repository.findById(personNew.getId()).ifPresent(System.out::println);
	}

	@Transactional(readOnly = true)
	public void findOne(){
	/* 	Person person=null;
		Optional<Person> optionalPerson= repository.findById(2L);
		if(optionalPerson.isPresent()){
			person=optionalPerson.get();
		}
		System.out.println(person); */
		repository.findByNameContaining("ria").ifPresent(System.out::println);
	}

	@Transactional(readOnly = true)
	public void list(){
		//List<Person> persons = (List<Person>) repository.findAll();
		//List<Person> persons = (List<Person>) repository.buscarByProgrammingLanguage("Java","Lina");
		List<Person> persons = (List<Person>) repository.findByProgrammingLanguageAndName("Java","Lina");
		persons.stream().forEach(person->{System.out.println(person); });
		
		List<Object[]>personsValues = repository.obtenerPersonData("Maria");
		personsValues.stream().forEach(person->{System.out.println(person[0] + " Especialista en " + person[1]); });
	}

}
