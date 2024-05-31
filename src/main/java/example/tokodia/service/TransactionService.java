package example.tokodia.service;

import example.tokodia.model.Transaction;

import java.util.List;

public interface TransactionService {
  Transaction create(Transaction request, String wallet_id, Integer product_id, String customer_id);
  List<Transaction> getAll();
  Transaction getById(Integer id);
  Transaction update(Transaction request);
  void delete(Integer id);
}
