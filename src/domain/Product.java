package domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import util.DBUtil;


@NoArgsConstructor
@Getter
@Setter
@Entity


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

	@OneToMany(mappedBy = "productId")
	private List<Basket> baskets;
	
	
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


	public Product(int productId, String productType, String productName, String description, int price,
			int inventory) {
		super();
		this.productId = productId;
		this.productType = productType;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.inventory = inventory;
	}
	
}