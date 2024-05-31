package example.tokodia.service;

import example.tokodia.model.Product;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface ProductService {
  Product create(Product request);
  List<Product> getAll();
  Product getById(Integer id);
  Product update(Product request);
  void delete(Integer id);
}
