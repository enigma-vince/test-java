package example.tokodia.controller;

import example.tokodia.model.Customer;
import example.tokodia.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {
  private final CustomerService customerService;

  @PostMapping
  public Customer createCustomer(@RequestBody Customer request){
	return customerService.create(request);
  }

  @GetMapping("/")
  public List<Customer> getAll(){
	return customerService.getAll();
  }

  @GetMapping("/{id}")
  public Customer getById(@PathVariable String id){
	return customerService.getById(id);
  }

  @PutMapping("/{id}")
  public Customer update(@RequestBody Customer request){
	return customerService.update(request);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id){
	customerService.delete(id);
  }

}
