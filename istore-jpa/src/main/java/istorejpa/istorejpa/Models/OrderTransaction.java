package istorejpa.istorejpa.Models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table ( name = "trans_r")
@TableGenerator(name="trans_tab", initialValue=3000, allocationSize=100000000)
public class OrderTransaction implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3512413182318917098L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="trans_tab")
	@Column(columnDefinition = "SERIAL",insertable = false)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "item_id", referencedColumnName = "item_id",unique = true)
	private Item itemId;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "user_email",referencedColumnName = "user_email")
	private User buyerId;
	
	@Column(name = "trans_timestamp")
	@CreationTimestamp
	private LocalDateTime timeStamp;
	
	public OrderTransaction() {
		
	}
	

	public OrderTransaction(Item itemId, User user) {
		super();
		this.itemId = itemId;
		this.buyerId = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Item getItemId() {
		return itemId;
	}

	public void setItemId(Item itemId) {
		this.itemId = itemId;
	}

	

	public User getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(User buyerId) {
		this.buyerId = buyerId;
	}


	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	
}
