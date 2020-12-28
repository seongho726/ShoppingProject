package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.sql.DataSource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import util.DBUtil;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder

public class Product {
   @Id
	@Column(name="product_id")
    int productId;
	
	@Column(name="product_type")
    String productType;
	
	@Column(name="product_name")
    String productName;
	
	@Column
    String description;
	
	@Column
    int price;
	
	@Column
	int inventory;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productid=");
		builder.append(productId);
		builder.append(", producttype=");
		builder.append(productType);
		builder.append(", productname=");
		builder.append(productName);
		builder.append(", explanation=");
		builder.append(description);
		builder.append(", price=");
		builder.append(price);
		builder.append(", inventory=");
		builder.append(inventory);
		builder.append("]");
		return builder.toString();
	}
    
   
}