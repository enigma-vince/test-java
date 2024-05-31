package example.tokodia.controller;

import example.tokodia.model.Wallet;
import example.tokodia.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallets")
@AllArgsConstructor
public class WalletController {
  private WalletService walletService;

  @PostMapping("/{customer_id}")
  public Wallet createWallet(@RequestBody Wallet request,
							 @PathVariable String customer_id
  ){
	return walletService.create(request, customer_id);
  }

  @GetMapping("/")
  public List<Wallet> getAll(){
	return walletService.getAll();
  }

  @GetMapping("/{id}")
  public Wallet getById(@PathVariable String id){
	return walletService.getById(id);
  }

  @PutMapping("/{id}")
  public Wallet update(@RequestBody Wallet request){
	return walletService.update(request);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id){
	walletService.delete(id);
  }
}
