package com.melissa.springboot.jpa.springbootjpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.melissa.springboot.jpa.springbootjpa.dto.PersonDto;
import com.melissa.springboot.jpa.springbootjpa.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{

  @Query("select min(length(p.name)) from Person p")
  public Integer getMinLengthName();

  @Query("select max(length(p.name)) from Person p")
  public Integer getMaxLengthName();

  @Query("select p.name, length(p.name) from Person p")
  public List<Object[]> getPersonNameLength();

  @Query("select count(p) from Person p")
  Long totalPerson();

  @Query("select min(p.id) from Person p")
  Long minId();

  @Query("select max(p.id) from Person p")
  Long maxId();

  @Query("select p from Person p order by p.name, p.lastname desc")
  List<Person>getAll();
  List<Person> findByIdBetweenOrderByIdDesc(Long id1, Long id2);
  List<Person> findByNameBetweenOrderByNameAsc(String name1, String name2);

  @Query("select p from Person p where p.id between ?1 and ?2 order by p.name , p.lastname asc")
  List<Person> findAllBetweenId(Long id1, Long id2);

  @Query("select p from Person p where p.name between ?1 and ?2 order by p.name desc")
  List<Person> findAllBetweenName(String c1, String c2);

  @Query("select p.id, upper(p.name), lower(p.lastname), upper(p.programmingLanguage) from Person p")
  List<Object[]> findAllPersonDataListCase();

  //@Query("select CONCAT (p.name,' ',p.lastname) from Person p ")
  @Query("select  upper( concat(p.name ,' ', p.lastname)) from Person p ")
  List<String> findAllFullNameConcatUpper();
  
  @Query("select  lower( concat (p.name,' ',p.lastname)) from Person p ")
  List<String> findAllFullNameConcatLower();

  @Query("select  concat( p.name,' ',p.lastname) from Person p ")
  List<String> findAllFullNameConcat();

  @Query("select count(distinct(p.programmingLanguage)) from Person p")
  Long findAllProgrammingLanguageDistinctCount();

  @Query("select distinct(p.programmingLanguage) from Person p")
  List<String> findAllProgrammingLanguageDistinct();

  @Query("select  p.name from Person p")
  List<String> findAllNames();

  @Query("select  distinct (p.name) from Person p")
  List<String> findAllNamesDistinct();

  @Query("select new com.melissa.springboot.jpa.springbootjpa.dto.PersonDto(p.name , p.lastname) from Person p ")
  List<PersonDto> findAllPersonDto();

  @Query("select new Person(p.name , p.lastname) from Person p ")
  List<Person> findAllObjecPersonPersonalized();

  @Query("select p.name p from Person p where p.id=?1")
  String getNameById(Long id);

  @Query("select p.id p from Person p where p.id=?1")
  Long getIdById(Long id);

  @Query("select concat (p.name,' ',p.lastname)as fullname from Person p where p.id=?1")
  String getFullNameById(Long id);

  @Query("select p from Person p where p.id=?1")
  Optional<Person>findOne(Long id);

  @Query("select p from Person p where p.name=?1")
  Optional<Person>findOneName(String name);

  @Query("select p from Person p where p.name like %?1%")
  Optional<Person>findOneLikeName(String name);

  Optional<Person>findByNameContaining(String name);

  List<Person> findByProgrammingLanguage(String programmingLanguage);

  @Query("select p from Person p where p.programmingLanguage=?1 and p.name=?2")
  List<Person> buscarByProgrammingLanguage(String programmingLanguage, String name);

  List<Person> findByProgrammingLanguageAndName(String programmingLanguage, String name);

  @Query("select p, p.programmingLanguage from Person p")
  List<Object[]> findAllMixPerson();

  @Query("select p.id, p.name, p.lastname, p.programmingLanguage from Person p")
  List<Object[]> obtenerPersonDataList();

  @Query("select p.id, p.name, p.lastname, p.programmingLanguage from Person p where p.id=?1")
  Object obtenerPersonDataById(Long id);

  @Query("select p.name, p.programmingLanguage from Person p")
  List<Object[]> obtenerPersonData();

  @Query("select p.name, p.programmingLanguage from Person p where p.name=?1")
  List<Object[]> obtenerPersonData(String name);

  @Query("select p.name, p.programmingLanguage from Person p where p.programmingLanguage=?1 and p.name=?2")
  List<Object[]> obtenerPersonData(String programmingLanguage, String name);

  @Query("select p.name, p.programmingLanguage from Person p where p.programmingLanguage=?1")
  List<Object[]> obtenerPersonDataByProgrammingLanguage(String programmingLanguage);
  
} 
