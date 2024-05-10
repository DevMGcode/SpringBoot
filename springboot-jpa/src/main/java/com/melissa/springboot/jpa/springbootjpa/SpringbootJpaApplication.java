package com.melissa.springboot.jpa.springbootjpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.melissa.springboot.jpa.springbootjpa.dto.PersonDto;
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
		
		personalizedQueries2();
	}

	@Transactional(readOnly = true)
	public void personalizedQueries2(){

		
		System.out.println("========================= Consulta por objeto persona y lenguaje de programación =========================");
		List<Object[]> personsRegs = repository.findAllMixPerson();

		personsRegs.forEach(reg->{
			System.out.println("programmingLanguage="+ reg[1] + ", persona=" + reg[0]);
		});

		System.out.println("Consulta que llena y devuelve objeto entity de una instancia personalizada");
		List<Person> persons = repository.findAllObjecPersonPersonalized();
		persons.forEach(System.out::println);

		System.out.println("Consulta que llena y devuelve objeto Dto de una clase personalizada");
		List<PersonDto> personDto= repository.findAllPersonDto();
		personDto.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void personalizedQueries(){

		Scanner scanner = new Scanner(System.in);
		System.out.println("=========================Consultas solo el nombre por el id=========================");
		System.out.println("ingrese el id para el nombre:");
		Long id= scanner.nextLong();
		scanner.close();
		System.out.println("=======mostrando solo el nombre:=======");
		String name= repository.getNameById(id);
		System.out.println(name);
		System.out.println("======mostrando solo el id:=======");
		Long idDb= repository.getIdById(id);
		System.out.println(idDb);
		System.out.println("======mostrando  nombre completo con concat:======");
		String fullname= repository.getFullNameById(id);
		System.out.println(fullname);

		System.out.println("======Consultas por campos personalizados por el  id =======");
		Object[] personReg = (Object[]) repository.obtenerPersonDataById(id);
		System.out.println("id="+personReg[0]+", Nombre="+ personReg[1]+", Apellido=" +  personReg[2] +", Lenguaje=" + personReg[3]);

		System.out.println("=====Consultas por campos personalizados lista=====");
		List<Object[]>regs= repository.obtenerPersonDataList();
		regs.forEach(reg->System.out.println("id="+reg[0]+", Nombre="+ reg[1]+", Apellido=" +  reg[2] +", Lenguaje=" + reg[3]));
	}

	@Transactional
	public void delete2(){
		repository.findAll().forEach(System.out::println);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id a eliminar:");
		Long id =scanner.nextLong();

		Optional <Person> optionalPerson= repository.findById(id);

		optionalPerson.ifPresentOrElse(repository::delete,
		()->System.out.println("Lo sentimos no existe la persona con ese id"));
		
		repository.findAll().forEach(System.out::println);
		
		scanner.close();
	}

	@Transactional
	public void update(){
		Scanner scanner= new Scanner(System.in);
		System.out.println("Ingrese el id de la persona:");
		Long id = scanner.nextLong();

		Optional <Person> optionalPerson = repository.findById(id);
		//optionalPerson.ifPresent(person->{
		if (optionalPerson.isPresent()){
			Person personDB = optionalPerson.orElseThrow();
			System.out.println(personDB);
			System.out.println("ingrese el lenguaje de programación:");
			String programmingLanguage = scanner.next();
			personDB.setProgrammingLanguage(programmingLanguage);
			Person personUpdated= repository.save(personDB);
			System.out.println(personUpdated);
		}else{
			System.out.println("El usuario no esta presente! no existe!");
		}

			
		//});
		scanner.close();
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
