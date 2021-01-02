package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter

@Entity(name="shoppingbasket")
public class Basket {
	@Id 
	@Column (name = "basket_id")
    int basketId;
	
	@Column (name ="basketuser_id" )
	int userId;
	
	@Column (name = "product_id")
	int productId;
	

	@Column (name = "product_count")
    int productCount;
	
	@Column (name = "validity")
    int validity;
	
	
//	@ManyToOne
//	@JoinColumn (name = "basketuser_id", referencedColumnName = "shoppinguser_id", nullable=false)	
//	User usersId;
//	
//	@ManyToOne
//	@JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable=false)
//	Product productsId;
	
	public Basket(int basketId, int userId, int productId, int productCount, int validity) {
		super();
		this.basketId = basketId;
		this.userId = userId;
		this.productId = productId;
		this.productCount = productCount;
		this.validity = validity;
	}

	

	public int getBasketId() {
		return basketId;
	}

	public int getUserId() {
		return userId;
	}

	public int getProductId() {
		return productId;
	}

	public int getProductCount() {
		return productCount;
	}




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Basket [basketId=");
		builder.append(basketId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", productCount=");
		builder.append(productCount);
		builder.append(", validity=");
		builder.append(validity);
		builder.append("]");
		return builder.toString();
	}
	
}