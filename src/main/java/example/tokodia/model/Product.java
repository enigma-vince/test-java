package example.tokodia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer id;
  private String name;
  private Integer price;

  @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Transaction> transaction_list;
}
