package kr.co.infracube.dto;

public class DeliveryDto {
	private String Sequence;
	private String Customer_Code;
	private String Customer_Name;
	private String Business_Name;
	private String Manufacturer;
	private String Model_Name;
	private String Serial_Num;
	private String OS;
	private String CPU;
	private String Memory;
	private String HDD;
	private String Service_Type;
	private String Term;
	private String Delivery_Date;
	private String End_Date;
	private String Note;
	private String Use_YN;
	private String Insert_Delivery;
	private String Insert_Date;
	private String Update_Delivery;
	private String Update_Date;
	
	
	public String getSequence() {
		return Sequence;
	}
	public void setSequence(String sequence) {
		Sequence = sequence;
	}
	public String getCustomer_Name() {
		return Customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}
	public String getBusiness_Name() {
		return Business_Name;
	}
	public void setBusiness_Name(String business_Name) {
		Business_Name = business_Name;
	}
	public String getManufacturer() {
		return Manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}
	public String getModel_Name() {
		return Model_Name;
	}
	public void setModel_Name(String model_Name) {
		Model_Name = model_Name;
	}
	public String getSerial_Num() {
		return Serial_Num;
	}
	public void setSerial_Num(String serial_Num) {
		Serial_Num = serial_Num;
	}
	public String getOS() {
		return OS;
	}
	public void setOS(String oS) {
		OS = oS;
	}
	public String getCPU() {
		return CPU;
	}
	public void setCPU(String cPU) {
		CPU = cPU;
	}
	public String getMemory() {
		return Memory;
	}
	public void setMemory(String memory) {
		Memory = memory;
	}
	public String getHDD() {
		return HDD;
	}
	public void setHDD(String hDD) {
		HDD = hDD;
	}
	public String getService_Type() {
		return Service_Type;
	}
	public void setService_Type(String service_Type) {
		Service_Type = service_Type;
	}
	public String getTerm() {
		return Term;
	}
	public void setTerm(String term) {
		Term = term;
	}
	public String getDelivery_Date() {
		return Delivery_Date;
	}
	public void setDelivery_Date(String delivery_Date) {
		Delivery_Date = delivery_Date;
	}
	public String getEnd_Date() {
		return End_Date;
	}
	public void setEnd_Date(String end_Date) {
		End_Date = end_Date;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	public String getUse_YN() {
		return Use_YN;
	}
	public void setUse_YN(String use_YN) {
		Use_YN = use_YN;
	}
	public String getCustomer_Code() {
		return Customer_Code;
	}
	public void setCustomer_Code(String customer_Code) {
		Customer_Code = customer_Code;
	}
	public String getInsert_Delivery() {
		return Insert_Delivery;
	}
	public void setInsert_Delivery(String insert_Delivery) {
		Insert_Delivery = insert_Delivery;
	}
	public String getInsert_Date() {
		return Insert_Date;
	}
	public void setInsert_Date(String insert_Date) {
		Insert_Date = insert_Date;
	}
	public String getUpdate_Delivery() {
		return Update_Delivery;
	}
	public void setUpdate_Delivery(String update_Delivery) {
		Update_Delivery = update_Delivery;
	}
	public String getUpdate_Date() {
		return Update_Date;
	}
	public void setUpdate_Date(String update_Date) {
		Update_Date = update_Date;
	}
	@Override
	public String toString() {
		return "DeliveryDto [Sequence=" + Sequence + ", Customer_Code=" + Customer_Code + ", Customer_Name="
				+ Customer_Name + ", Business_Name=" + Business_Name + ", Manufacturer=" + Manufacturer
				+ ", Model_Name=" + Model_Name + ", Serial_Num=" + Serial_Num + ", OS=" + OS + ", CPU=" + CPU
				+ ", Memory=" + Memory + ", HDD=" + HDD + ", Service_Type=" + Service_Type + ", Term=" + Term
				+ ", Delivery_Date=" + Delivery_Date + ", End_Date=" + End_Date + ", Note=" + Note + ", Use_YN="
				+ Use_YN + ", Insert_Delivery=" + Insert_Delivery + ", Insert_Date=" + Insert_Date
				+ ", Update_Delivery=" + Update_Delivery + ", Update_Date=" + Update_Date + "]";
	}
	
}
