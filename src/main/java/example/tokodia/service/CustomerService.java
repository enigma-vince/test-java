package example.tokodia.service;

import example.tokodia.model.Customer;

import java.util.List;

public interface CustomerService {
  Customer create(Customer request);
  List<Customer> getAll();
  Customer getById(String id);
  Customer update(Customer request);
  void delete(String id);
}
