package example.tokodia.controller;

import example.tokodia.model.Product;
import example.tokodia.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
  private final ProductService productService;

  @PostMapping
  public Product createProduct(@RequestBody Product request){
	return productService.create(request);
  }

  @GetMapping("/")
  public List<Product> getAll(){
	return productService.getAll();
  }

  @GetMapping("/{id}")
  public Product getById(@PathVariable Integer id){
	return productService.getById(id);
  }

  @PutMapping("/{id}")
  public Product update(@RequestBody Product request){
	return productService.update(request);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id){
	productService.delete(id);
  }
}
