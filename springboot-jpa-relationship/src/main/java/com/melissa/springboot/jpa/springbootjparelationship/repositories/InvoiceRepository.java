package com.melissa.springboot.jpa.springbootjparelationship.repositories;

import org.springframework.data.repository.CrudRepository;

import com.melissa.springboot.jpa.springbootjparelationship.entities.Invoice;

public interface InvoiceRepository extends CrudRepository <Invoice,Long> {

}
