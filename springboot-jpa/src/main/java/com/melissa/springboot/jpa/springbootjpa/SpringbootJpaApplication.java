package com.melissa.springboot.jpa.springbootjpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		
		findOne();
	}

	public void findOne(){
	/* 	Person person=null;
		Optional<Person> optionalPerson= repository.findById(2L);
		if(optionalPerson.isPresent()){
			person=optionalPerson.get();
		}
		System.out.println(person); */
		repository.findById(3L).ifPresent(System.out::println);
	}
	public void list(){
		//List<Person> persons = (List<Person>) repository.findAll();
		//List<Person> persons = (List<Person>) repository.buscarByProgrammingLanguage("Java","Lina");
		List<Person> persons = (List<Person>) repository.findByProgrammingLanguageAndName("Java","Lina");
		persons.stream().forEach(person->{System.out.println(person); });
		
		List<Object[]>personsValues = repository.obtenerPersonData("Maria");
		personsValues.stream().forEach(person->{System.out.println(person[0] + " Especialista en " + person[1]); });
	}

}
