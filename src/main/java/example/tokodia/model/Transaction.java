package example.tokodia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer quantity;
  private Integer price;
  private Integer total_price;

  @ManyToOne
  @JoinColumn(name = "customer_id",nullable = false)
  @JsonIgnore
  private Customer customer;

  @ManyToOne
  @JoinColumn(name = "product_id",nullable = false)
  @JsonIgnore
  private Product product;
}
