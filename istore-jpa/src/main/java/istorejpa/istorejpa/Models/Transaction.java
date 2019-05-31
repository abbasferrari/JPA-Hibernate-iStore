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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "transr")
public class Transaction implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//@SequenceGenerator(allocationSize=1, initialValue=1000, sequenceName="trans_id_seq", name="trans_id_seq")
	//@GeneratedValue(generator="trans_id_seq", strategy=GenerationType.SEQUENCE)
	//@Column(name = "trans_id", insertable = false)

	/*@SequenceGenerator(allocationSize=1, initialValue=1000, sequenceName="trans_id_seq", name="trans_id_seq")
	//@GeneratedValue(generator="trans_id_seq")
	
	@Column(
		    columnDefinition = "DEFAULT TO_CHAR(nextval('trans_id_seq'::regclass),'\"I\"fm000000')",
		    insertable = false,
		    name = "trans_id"
		)*/
	@Id
	//@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="trans_id_seq", name="trans_id_seq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "SERIAL",insertable = false)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id", referencedColumnName = "item_id")
	private Item itemId;
	
	//@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//@JoinColumn(name = "user_email",referencedColumnName = "user_email")
	//private User buyerId;
	

	@Column(insertable = false)
	@CreationTimestamp
	private LocalDateTime timeStamp;
	
	public Transaction() {
		
	}
	public Transaction(Item item) {
		super();
		this.itemId = item;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}


	public Item getItemId() {
		return itemId;
	}


	public void setItemId(Item itemId) {
		this.itemId = itemId;
	}

	
	


}
