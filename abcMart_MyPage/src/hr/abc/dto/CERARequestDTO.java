package hr.abc.dto;

public class CERARequestDTO {
	
	private String id;
	private String productName;
	private String contents;
	private String reasons;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getReasons() {
		return reasons;
	}
	public void setReasons(String reasons) {
		this.reasons = reasons;
	}
	
	@Override
	public String toString() {
		return "CERARequestDTO [id=" + id + ", productName=" + productName + ", contents=" + contents + ", reasons="
				+ reasons + "]";
	}

}
