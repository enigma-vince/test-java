package example.tokodia.controller;

import example.tokodia.model.Transaction;
import example.tokodia.service.TransactionService;
import example.tokodia.util.response.WebResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionController {
  private final TransactionService transactionService;

  @PostMapping
  public ResponseEntity<WebResponse<Transaction>> create(
		  @RequestBody Transaction request,
		  @RequestParam String wallet_id,
		  @RequestParam Integer product_id,
		  @RequestParam String customer_id
  ){
	Transaction transaction = transactionService.create(request,wallet_id, product_id, customer_id);
	WebResponse<Transaction> response = WebResponse.<Transaction>builder()
			.message("Transaction Successfully")
			.data(transaction)
			.build();
	return ResponseEntity.ok(response);
  }

  @GetMapping("/")
  public List<Transaction> getAll(){
	return transactionService.getAll();
  }

  @GetMapping("/{id}")
  public Transaction getById(@PathVariable Integer id){
	return transactionService.getById(id);
  }

  @PutMapping("/{id}")
  public Transaction update(@RequestBody Transaction request){
	return transactionService.update(request);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id){
	transactionService.delete(id);
  }
}
