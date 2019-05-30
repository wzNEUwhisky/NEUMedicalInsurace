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
 * ����Ϊ��Ա��Ϣ¼����������
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
		idField.setText("CNSY");
		certificateTypeField.setItems(options1);
		genderField.setItems(options2);
		doctorTypeField.setItems(options3);
	}
	/**
	 * ��ť����
	 */
	@FXML
	public void fileInPerson() {
		boolean found = false;
		//�ж��Ƿ��������ݾ�����
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
					if (temp.equals("��ְ��Ա")) {
						doctorType = "11";
					}else if (temp.equals("������Ա")) {
						doctorType = "21";
					}else if (temp.equals("���ܵͱ���ְ��Ա")) {
						doctorType = "40";
					}else if (temp.equals("���ܵͱ�������Ա")) {
						doctorType = "41";
					}
					Person person = new Person(id, certificateType, certificateCode, name, gender, nation, birthday, doctorType);
					FileTool.writeInFile("src/data/personMessage.txt", person.toString() + "\r\n");
					PersonDB.loadPersons();
					tishiField.setText("���ӳɹ�");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					tishiField.setText("������ָ�����ڸ�ʽ");
				}
			}else {
				tishiField.setText("��id�Ѿ����ڣ�����������");
			}
		}else {
			tishiField.setText("��Ǹ��������Ŀ��Ϊ������Ŀ������������");
		}
	}
	
}
