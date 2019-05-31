package istorejpa.istorejpa.ModelUI;

import java.time.LocalDateTime;

public class OrderTransactionUI {
	private String itemId;
	private String buyerId;
	private String transId;
	private LocalDateTime timestamp;
	
	public OrderTransactionUI() {
		
	}
	
	public OrderTransactionUI(String transId,String itemId,String buyerId) {
		this.transId = transId;
		this.itemId = itemId;
		this.buyerId = buyerId;
	}

	public OrderTransactionUI(String transId,String itemId,String buyerId,LocalDateTime timestamp) {
		this.transId = transId;
		this.itemId = itemId;
		this.buyerId = buyerId;
		this.timestamp = timestamp;
	}

	
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}


	
}
