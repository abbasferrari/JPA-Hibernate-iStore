package istorejpa.istorejpa.Models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "item_r")
@TableGenerator(name="tab", initialValue=1000, allocationSize=100000000)
public class Item implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -5644591101687249466L;
	
	@Column(columnDefinition = "SERIAL",insertable = false)
	private Long serialNo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="tab")
	@Column(name = "item_id")
	private Integer id;
	
	@Column(name = "item_name")
	private String name;
	
	@Column(name = "item_description")
	private String description;
	
	@Column(name = "item_category")
	private String category;
	
	@Column(name = "item_price")
	private Double price;
	
	@Column
	@CreationTimestamp
	private LocalDateTime timeStamp;

	@Column(name = "item_status")
	private int status = 0;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "seller_id")
	private User sellerId;
	

	public Item( String name, String description, String category, double price,
			 User seller) {
		super();

		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.sellerId = seller;
	}
	//Test
	public Item( Integer id, String name, String description, String category, double price,
			 User seller) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.sellerId = seller;
	}

	public Item() {
		super();
		
	}

	public User getSellerId() {
		return sellerId;
	}

	public void setSellerId(User sellerId) {
		this.sellerId = sellerId;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public long getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(long serialNo) {
		this.serialNo = serialNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}



	public int getStatus() {
		return status;
	}

	
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Item [serialNo=" + serialNo + ", id=" + id + ", name=" + name + ", description=" + description
				+ ", category=" + category + ", price=" + price + ", timeStamp=" + timeStamp + ", status=" + status
				+ ", sellerId=" + sellerId + "]";
	}


	
	
}
