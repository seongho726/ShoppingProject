

package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Basket {
	@Id 
	@Column (name = "basket_id")
    int basketId;
	
	@Column (name = "basketuser_id")
    int userId;
	
	@JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable=false)
    Product productId;
	
	@Column (name = "product_count")
    int productCount;
	
	@Column (name = "validity")
    int validity;
}