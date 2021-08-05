package model.dto;

public class BookClassification {
	private String KDC;
	private String category_name;
	
	public BookClassification(String KDC, String category_name) {
		this.KDC = KDC;
		this.category_name = category_name;
	}

	public String getKDC() {
		return KDC;
	}

	public void setKDC(String kDC) {
		KDC = kDC;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	@Override
	public String toString() {
		return "BookClassification [KDC=" + KDC + ", category_name=" + category_name + "]";
	}
	
	
}
