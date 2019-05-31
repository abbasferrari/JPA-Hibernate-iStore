package istorejpa.istorejpa.ModelUI;

public class AdItemUI {
	private Integer sno;
	private String id;
	private String name;
	private String status;
	private String description;
	private String category;
	private Double price;
	private String sellerId;
	private String timestamp;
	
	public AdItemUI() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public AdItemUI(Integer sno,String status,String id, String name, String description,
			String category, Double price, String sellerId,String timestamp) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.sellerId = sellerId;
		this.sno = sno;
		this.status = status;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "AdItemUI [sno=" + sno + ", id=" + id + ", name=" + name + ", status=" + status + ", description="
				+ description + ", category=" + category + ", price=" + price + ", sellerId=" + sellerId
				+ ", timestamp=" + timestamp + "]";
	}

	
}
