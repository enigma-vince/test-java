package example.tokodia.service.impl;

import example.tokodia.model.Customer;
import example.tokodia.model.Wallet;
import example.tokodia.repository.WalletRepository;
import example.tokodia.service.CustomerService;
import example.tokodia.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WalletServiceImpl implements WalletService {
  private final CustomerService customerService;
  private final WalletRepository walletRepository;

  @Override
  public Wallet create(Wallet request, String customer_id) {
	Customer customer = customerService.getById(customer_id);
	request.setCustomer(customer);
	return walletRepository.saveAndFlush(request);
  }

  @Override
  public List<Wallet> getAll() {
	return walletRepository.findAll();
  }

  @Override
  public Wallet getById(String id) {
	Optional<Wallet> wallet = walletRepository.findById(id);
	return wallet.orElse(null);
  }

  @Override
  public Wallet update(Wallet request) {
	this.getById(request.getId());
	return walletRepository.save(request);
  }

  @Override
  public void delete(String id) {
	this.getById(id);
	walletRepository.deleteById(id);
  }
}
