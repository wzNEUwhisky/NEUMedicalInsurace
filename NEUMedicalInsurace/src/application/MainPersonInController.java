package application;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import entityClasses.*;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
/**
 * 该类为人员信息录入界面控制器
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class MainPersonInController extends MainController{
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
		idField.setText("CNSY");
		certificateTypeField.setItems(options1);
		genderField.setItems(options2);
		doctorTypeField.setItems(options3);
	}
	/**
	 * 按钮方法
	 */
	@FXML
	public void fileInPerson() {
		boolean found = false;
		//判断是否所有内容均存在
		if (idField.getText().length() != 0 && nameField.getText().length() != 0 && certificateCodeField.getText().length() != 0 && nationField.getText().length() != 0
				&& birthdayField.getText().length() != 0 && certificateTypeField.getValue() != null && genderField.getValue() != null && doctorTypeField.getValue() != null) {
			for (Person person : PersonDB.loadPersons()) {
				if (person.getId().equals(idField.getText())) {
					found = true;
				}
			}
			if (found == false) {
				try {
					String id = idField.getText();
					String name = nameField.getText();
					String certificateType = certificateTypeField.getValue();
					String certificateCode = certificateCodeField.getText();
					String gender = genderField.getValue();
					String nation = nationField.getText();
					DateFormat aFormat = DateFormat.getDateInstance();
					Date birthday = aFormat.parse(birthdayField.getText());
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
					Person person = new Person(id, certificateType, certificateCode, name, gender, nation, birthday, doctorType);
					FileTool.writeInFile("src/data/personMessage.txt", person.toString() + "\r\n");
					PersonDB.loadPersons();
					tishiField.setText("增加成功");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					tishiField.setText("请输入指定日期格式");
				}
			}else {
				tishiField.setText("该id已经存在，请重新输入");
			}
		}else {
			tishiField.setText("抱歉，所有项目均为必填项目，请重新输入");
		}
	}
	
}
