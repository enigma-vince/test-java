package example.tokodia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wallet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private Integer balance;

  @ManyToOne
  @JoinColumn(name = "customer_id",nullable = false)
  @JsonIgnore
  private Customer customer;

}
