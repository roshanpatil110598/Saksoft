package com.sakoft.demo.Repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sakoft.demo.Model.Customer;

@Repository
public interface Repo extends CrudRepository<Customer, Serializable>
{

	Customer save(Customer custs);

	

}
