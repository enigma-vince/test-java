package example.tokodia.service.impl;

import example.tokodia.model.Product;
import example.tokodia.repository.ProductRepository;
import example.tokodia.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
  private final ProductRepository productRepository;

  @Override
  public Product create(Product request) {
	return productRepository.saveAndFlush(request);
  }

  @Override
  public List<Product> getAll() {
	return productRepository.findAll();
  }

  @Override
  public Product getById(Integer id) {
	Optional<Product> product = productRepository.findById(id);
	return product.orElse(null);
  }

  @Override
  public Product update(Product request) {
	this.getById(request.getId());
	return productRepository.save(request);
  }

  @Override
  public void delete(Integer id) {
	this.getById(id);
	productRepository.deleteById(id);
  }
}
