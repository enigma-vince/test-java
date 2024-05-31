package example.tokodia.service.impl;

import example.tokodia.model.Customer;
import example.tokodia.model.Product;
import example.tokodia.model.Transaction;
import example.tokodia.model.Wallet;
import example.tokodia.repository.TransactionRepository;
import example.tokodia.service.CustomerService;
import example.tokodia.service.ProductService;
import example.tokodia.service.TransactionService;
import example.tokodia.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
  private final TransactionRepository transactionRepository;
  private final WalletService walletService;
  private final ProductService productService;
  private final CustomerService customerService;

  @Override
  public Transaction create(Transaction request,
							String wallet_id,
							Integer product_id,
							String customer_id)
  {
	try {
	  Product product = productService.getById(product_id);
	  Wallet wallet = walletService.getById(wallet_id);
	  Customer customer = customerService.getById(customer_id);

	  Integer productPrice = product.getPrice();
	  Integer balance = wallet.getBalance();
	  Integer totalPrice = request.getQuantity() * productPrice;

	  if (balance >= totalPrice){
		wallet.setBalance(balance - totalPrice);
		walletService.update(wallet);
		request.setTotal_price(totalPrice);
		request.setCustomer(customer);

		return transactionRepository.saveAndFlush(request);
	  }
	  return null;
	} catch (Exception e) {
	  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
	}

  }

  @Override
  public List<Transaction> getAll() {
	return transactionRepository.findAll();
  }

  @Override
  public Transaction getById(Integer id) {
	Optional<Transaction> product = transactionRepository.findById(id);
	return product.orElse(null);
  }

  @Override
  public Transaction update(Transaction request) {
	this.getById(request.getId());
	return transactionRepository.save(request);
  }

  @Override
  public void delete(Integer id) {
	this.getById(id);
	transactionRepository.deleteById(id);
  }
}
