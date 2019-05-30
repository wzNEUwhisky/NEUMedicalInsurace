package entityClasses;
/**
 * 该类为处方类的实体类
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class Prescription {
	
	private String addmissionNumber = null;
	private Drug drug;
	private int amount;
	private double price;
	private double sumprice;
	/**
	 * build the object by using drug
	 * @param drug
	 * @param amount
	 * @param price
	 */
	public Prescription(Drug drug, int amount, double price) {
		this.drug = drug;
		this.amount = amount;
		this.price = price;
		this.sumprice = this.price * this.amount;
	}
	/**
	 * build the object by using id
	 * @param id
	 * @param amount
	 * @param price
	 */
	public Prescription(String id, int amount, double price) {
		this.drug = new Drug(id);
		this.amount = amount;
		this.price = price;
		this.sumprice = this.price * this.amount;
	}
	/**
	 * build the object include addmissionNumber
	 * @param addmissionNumber
	 * @param id
	 * @param amount
	 * @param price
	 */
	public Prescription(String addmissionNumber, String id, int amount, double price) {
		this.addmissionNumber = addmissionNumber;
		this.drug = new Drug(id);
		this.amount = amount;
		this.price = price;
		this.sumprice = this.price * this.amount;
	}
	
	/**
	 * compare tow objects
	 * @param prescription
	 * @return
	 */
	public boolean equals(Prescription prescription) {
		if(this.addmissionNumber.equals(prescription.addmissionNumber) && this.drug.equals(prescription.getDrug()) && this.price == prescription.price && this.sumprice == this.sumprice) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * toString method
	 */
	public String toString() {
		return this.addmissionNumber + "_" + this.drug.getId() + "_" + this.getAmount() + "_" + this.getPrice() + "_" + this.getSumprice();
	}
	
	public String getAddmissionNumber() {
		return addmissionNumber;
	}

	public void setAddmissionNumber(String addmissionNumber) {
		this.addmissionNumber = addmissionNumber;
	}
	
	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSumprice() {
		return sumprice;
	}

	public void setSumprice(double sumprice) {
		this.sumprice = sumprice;
	}
	
	
}
