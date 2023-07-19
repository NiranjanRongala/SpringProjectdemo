package i3com.example.SpringProjectdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import i3com.example.SpringProjectdemo.entities.Customer;

//Performing CRUD Operations
public interface CustomerRepo extends JpaRepository <Customer,Integer>{
	

	 
	 
}