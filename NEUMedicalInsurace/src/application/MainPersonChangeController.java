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
 * ����Ϊ��Ա��Ϣ���Ľ��������
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
		        "���֤",
		        "ҽ����"
		    );
	ObservableList<String> options2 = 
		    FXCollections.observableArrayList(
		        "��",
		        "Ů"
		    );
	ObservableList<String> options3 = 
		    FXCollections.observableArrayList(
		        "��ְ��Ա",
		        "������Ա",
		        "���ܵͱ���ְ��Ա",
		        "���ܵͱ�������Ա"
		    );
	@FXML//���ؽ���
	private void initialize() {
		certificateTypeField.setItems(options1);
		genderField.setItems(options2);
		doctorTypeField.setItems(options3);
	}
	/**
	 * ��ť����
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
						iString = "��ְ��Ա";
					}else if (person.getDoctorSort().equals("21")) {
						iString = "������Ա";
					}else if (person.getDoctorSort().equals("40")) {
						iString = "���ܵͱ���ְ��Ա";
					}else if (person.getDoctorSort().equals("41")) {
						iString = "���ܵͱ�������Ա";
					}
					doctorTypeField.setValue(iString);
					changeButton.setVisible(true);
					geshiLabel.setVisible(true);
				}else {
					continue;
				}
			}
			if (found == false) {
				tishiField.setText("�����ڸ��ˣ�����������");
				idField.setText("");
			}
		}else {
			tishiField.setText("��������Աid");
		}
	}
	/**
	 * ��ť����
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
			if (temp.equals("��ְ��Ա")) {
				doctorType = "11";
			}else if (temp.equals("������Ա")) {
				doctorType = "21";
			}else if (temp.equals("���ܵͱ���ְ��Ա")) {
				doctorType = "40";
			}else if (temp.equals("���ܵͱ�������Ա")) {
				doctorType = "41";
			}
			ArrayList<Person> persons = PersonDB.loadPersons();
			FileTool.cleanFile("src/data/personMessage.txt", "#����ID_֤������_֤�����_����_����_��������_�Ա�_ҽ������"+"\r\n");
			for (Person person : persons) 
				if (!(person.getId().equals(idField.getText()))) {
					FileTool.writeInFile("src/data/personMessage.txt", person.toString()+"\r\n");
				}else {
					DateFormat dFormat = DateFormat.getDateInstance();
					try {
						Person personTemp = new Person(idField.getText(),certificateType,certificateCode,name,gender,nation, dFormat.parse(birthday), doctorType);
						FileTool.writeInFile("src/data/personMessage.txt", personTemp.toString()+"\r\n");
						tishiField.setText("�޸ĳɹ���");
					} catch (ParseException e) {
						FileTool.writeInFile("src/data/personMessage.txt", person.toString()+"\r\n");
						// TODO Auto-generated catch block
						tishiField.setText("������ָ�����ڸ�ʽ");
					}
				}
			}else {
				tishiField.setText("������Ŀ��Ϊ�������������������");
			}
				
	}
	
}
