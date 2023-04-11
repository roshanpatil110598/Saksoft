package com.sakoft.demo.HomeController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sakoft.demo.Model.Customer;
import com.sakoft.demo.ServiceInterface.ServiceI;

@RestController
public class HomeController
{

	@Autowired
	ServiceI ser;
	
	@PostMapping("/savedata")
	public ResponseEntity<Customer> saveData(@RequestBody Customer custs)
	{
		Customer custom=ser.saveDataCustomer(custs);
		return new ResponseEntity<>(custom,HttpStatus.OK);
	}
	
	
	@GetMapping("/getdata")
	public ResponseEntity<List<Customer>> getData()
	{
		List<Customer> customerlist=ser.getCustomerData();
		return new ResponseEntity<List<Customer>>(customerlist,HttpStatus.ACCEPTED);
	}
	
	//update
	@PutMapping("/updatedata")
	public ResponseEntity<Customer> updateData(@RequestBody Customer cus)
	{
		Customer custom=ser.updateData(cus);
		return new ResponseEntity<Customer>(custom,HttpStatus.OK);
	}
	
	//delete by id
	@DeleteMapping("/deletedata/{id}")
	public ResponseEntity<String> deletedata(@PathVariable("id") int id)
	{
		ser.deleteData(id);
		return new ResponseEntity<String>("Delete Sucssfully",HttpStatus.OK);
	}
	
}
