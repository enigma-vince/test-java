package example.tokodia.service;

import example.tokodia.model.Wallet;

import java.util.List;

public interface WalletService {
  Wallet create(Wallet request,String customer_id);
  List<Wallet> getAll();
  Wallet getById(String id);
  Wallet update(Wallet request);
  void delete(String id);
}
