package application;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import entityClasses.FileTool;
import entityClasses.Person;
import entityClasses.PersonDB;
import entityClasses.PersonNoneFoundException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 * 该类为人员信息更改界面控制器
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class MainPersonChangeController extends MainController {
	PersonDB personDB = PersonDB.getPersonDB();
	@FXML
	private TextField idField;
	@FXML
	private TextField nameField;
	@FXML
	private ComboBox<String> certificateTypeField;
	@FXML
	private TextField certificateCodeField;
	@FXML
	private ComboBox<String> genderField;
	@FXML
	private TextField nationField;
	@FXML
	private TextField birthdayField;
	@FXML
	private ComboBox<String> doctorTypeField;
	@FXML
	private TextField tishiField;
	@FXML
	private Button changeButton;
	@FXML
	private Label geshiLabel;
	ObservableList<String> options1 = 
		    FXCollections.observableArrayList(
		        "身份证",
		        "医保卡"
		    );
	ObservableList<String> options2 = 
		    FXCollections.observableArrayList(
		        "男",
		        "女"
		    );
	ObservableList<String> options3 = 
		    FXCollections.observableArrayList(
		        "在职人员",
		        "退休人员",
		        "享受低保在职人员",
		        "享受低保退休人员"
		    );
	@FXML//加载界面
	private void initialize() {
		certificateTypeField.setItems(options1);
		genderField.setItems(options2);
		doctorTypeField.setItems(options3);
	}
	/**
	 * 按钮方法
	 */
	@FXML
	public void idFind() {
		if (idField.getText().length() != 0) {
			boolean found = false;
			for(Person person : PersonDB.loadPersons()) {
				if (person.getId().equals(idField.getText())) {
					found = true;
					idField.setVisible(false);
					nameField.setVisible(true);
					nameField.setText(person.getName());
					certificateTypeField.setVisible(true);
					certificateTypeField.setValue(person.getCertificateType());
					certificateCodeField.setVisible(true);
					certificateCodeField.setText(person.getCertificateCode());
					genderField.setVisible(true);
					genderField.setValue(person.getGender());
					nationField.setVisible(true);
					nationField.setText(person.getNation());
					birthdayField.setVisible(true);
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(person.getBirthDate());
					String birthday = calendar.get(Calendar.YEAR)+ "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DAY_OF_MONTH);	
					birthdayField.setText(birthday);
					doctorTypeField.setVisible(true);
					String iString = null;
					if (person.getDoctorSort().equals("11")) {
						iString = "在职人员";
					}else if (person.getDoctorSort().equals("21")) {
						iString = "退休人员";
					}else if (person.getDoctorSort().equals("40")) {
						iString = "享受低保在职人员";
					}else if (person.getDoctorSort().equals("41")) {
						iString = "享受低保退休人员";
					}
					doctorTypeField.setValue(iString);
					changeButton.setVisible(true);
					geshiLabel.setVisible(true);
				}else {
					continue;
				}
			}
			if (found == false) {
				tishiField.setText("不存在该人，请重新输入");
				idField.setText("");
			}
		}else {
			tishiField.setText("请输入人员id");
		}
	}
	/**
	 * 按钮方法
	 */
	@FXML
	public void changePerson() {
		if (nameField.getText().length() != 0 && certificateCodeField.getText().length() != 0 && nationField.getText().length() != 0
				&& birthdayField.getText().length() != 0 && certificateTypeField.getValue() != null && genderField.getValue() != null && doctorTypeField.getValue() != null) {
			String name = nameField.getText();
			String certificateType = certificateTypeField.getValue();
			String certificateCode = certificateCodeField.getText();
			String gender = genderField.getValue();
			String nation = nationField.getText();
			String birthday = birthdayField.getText();
			String temp = doctorTypeField.getValue();
			String doctorType = null;
			if (temp.equals("在职人员")) {
				doctorType = "11";
			}else if (temp.equals("退休人员")) {
				doctorType = "21";
			}else if (temp.equals("享受低保在职人员")) {
				doctorType = "40";
			}else if (temp.equals("享受低保退休人员")) {
				doctorType = "41";
			}
			ArrayList<Person> persons = PersonDB.loadPersons();
			FileTool.cleanFile("src/data/personMessage.txt", "#个人ID_证件类型_证件编号_姓名_民族_出生日期_性别_医疗类型"+"\r\n");
			for (Person person : persons) 
				if (!(person.getId().equals(idField.getText()))) {
					FileTool.writeInFile("src/data/personMessage.txt", person.toString()+"\r\n");
				}else {
					DateFormat dFormat = DateFormat.getDateInstance();
					try {
						Person personTemp = new Person(idField.getText(),certificateType,certificateCode,name,gender,nation, dFormat.parse(birthday), doctorType);
						FileTool.writeInFile("src/data/personMessage.txt", personTemp.toString()+"\r\n");
						tishiField.setText("修改成功！");
					} catch (ParseException e) {
						FileTool.writeInFile("src/data/personMessage.txt", person.toString()+"\r\n");
						// TODO Auto-generated catch block
						tishiField.setText("请输入指定日期格式");
					}
				}
			}else {
				tishiField.setText("所有项目均为必填项，请重新输入后操作");
			}
				
	}
	
}
