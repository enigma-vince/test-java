package example.tokodia.service.impl;

import example.tokodia.model.Customer;
import example.tokodia.repository.CustomerRepository;
import example.tokodia.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
  private final CustomerRepository customerRepository;

  @Override
  public Customer create(Customer request) {
	return customerRepository.saveAndFlush(request);
  }

  @Override
  public List<Customer> getAll() {
	return customerRepository.findAll();
  }

  @Override
  public Customer getById(String id) {
	Optional<Customer> customer = customerRepository.findById(id);
	return customer.orElse(null);
  }

  @Override
  public Customer update(Customer request) {
	this.getById(request.getId());
	return customerRepository.save(request);
  }

  @Override
  public void delete(String id) {
	this.getById(id);
	customerRepository.deleteById(id);
  }
}
