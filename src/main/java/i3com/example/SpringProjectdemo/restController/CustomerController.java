package i3com.example.SpringProjectdemo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import i3com.example.SpringProjectdemo.entities.Customer;
import i3com.example.SpringProjectdemo.repo.CustomerRepo;
import io.swagger.v3.oas.annotations.Operation;

@RestController // create Restful web services using Spring MVC
public class CustomerController {
	@Autowired // inject dependencies automatically
	private CustomerRepo customerRepo;

	// 2 List Of Customers
	@GetMapping("/listOfCustomers")
	@Operation(summary = "Get Customers List")
	public List<Customer> getAll() {

		return customerRepo.findAll();

	}

}