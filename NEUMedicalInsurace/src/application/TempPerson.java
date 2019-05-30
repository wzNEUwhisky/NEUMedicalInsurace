package application;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;

import javafx.beans.property.SimpleStringProperty;
/**
 * 该类为tableColumn反射关系类
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class TempPerson {
	private SimpleStringProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty certificateType;
	private SimpleStringProperty certificateCode;
	private SimpleStringProperty gender;
	private SimpleStringProperty nation;					
	private SimpleStringProperty birthday;					
	private SimpleStringProperty doctorSort;

	public TempPerson(String id, String name, String certificateType,
			String certificateCode, String gender, String nation,
			String birthday, String doctorSort) {
		super();
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.certificateType = new SimpleStringProperty(certificateType);
		this.certificateCode = new SimpleStringProperty(certificateCode);
		this.gender = new SimpleStringProperty(gender);
		this.nation = new SimpleStringProperty(nation);
		this.birthday = new SimpleStringProperty(birthday);
		this.doctorSort = new SimpleStringProperty(doctorSort);
	}

	public String getId() {
		return id.get();
	}

	public String getName() {
		return name.get();
	}

	public String getCertificateType() {
		return certificateType.get();
	}

	public String getCertificateCode() {
		return certificateCode.get();
	}

	public String getGender() {
		return gender.get();
	}

	public String getNation() {
		return nation.get();
	}

	public String getBirthday() {
		return birthday.get();
	}

	public String getDoctorSort() {
		return doctorSort.get();
	}
}
