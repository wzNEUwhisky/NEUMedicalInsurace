package application;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;

import entityClasses.Person;
import entityClasses.PersonDB;
import entityClasses.PersonNoneFoundException;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * 该类为人员信息查找界面
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class MainPersonFindController extends MainController {
	PersonDB personDB = PersonDB.getPersonDB();
	@FXML
	private TextField idField;
	@FXML
	private TextField nameField;
	@FXML
	private TableView messageTable;
	@FXML
	private TableColumn idColumn;
	@FXML
	private TableColumn nameColumn; 
	@FXML
	private TableColumn certificateTypeColumn;
	@FXML
	private TableColumn certificateCodeColumn;
	@FXML
	private TableColumn genderColumn;
	@FXML
	private TableColumn nationColumn;
	@FXML
	private TableColumn birthdayColumn;
	@FXML
	private TableColumn doctorSortColumn;
	//加载界面
	private void initialize() {
		
	}
	/**
	 * 按钮方法
	 */
	@FXML
	private void FindPerson() {
		if (idField.getText().length() != 0) {
			String id;
			String name;
			String certificateType;
			String certificateCode;
			String gender;
			String nation;					
			String birthday;					
			String doctorSort;
			try {
				ArrayList<Person> temp = PersonDB.getPersonById(idField.getText());
				ObservableList<TempPerson> data = FXCollections.observableArrayList();
				for(Person person : temp) {
					id = person.getId();
					name = person.getName();
					certificateType = person.getCertificateType();
					certificateCode = person.getCertificateCode();
					gender = person.getGender();
					nation = person.getNation();					
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(person.getBirthDate());
					birthday = calendar.get(Calendar.YEAR)+ "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DAY_OF_MONTH);					
					doctorSort = person.getDoctorSort();
					TempPerson tempPerson = new TempPerson(id, name, certificateType, certificateCode, gender, nation, birthday, doctorSort);
					data.add(tempPerson);
				}
				messageTable.setItems(data);
				idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
				nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
				certificateTypeColumn.setCellValueFactory(new PropertyValueFactory<>("certificateType"));
				certificateCodeColumn.setCellValueFactory(new PropertyValueFactory<>("certificateCode"));
				genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
				nationColumn.setCellValueFactory(new PropertyValueFactory<>("nation"));
				birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
				doctorSortColumn.setCellValueFactory(new PropertyValueFactory<>("doctorSort"));
				
			} catch (PersonNoneFoundException e) {
				System.out.println("没找到人");
			}
		}else if (nameField.getText().length() != 0) {
			String id;
			String name;
			String certificateType;
			String certificateCode;
			String gender;
			String nation;					
			String birthday;					
			String doctorSort;
			try {
				ArrayList<Person> temp = PersonDB.getPersonByName(nameField.getText());
				ObservableList<TempPerson> data = FXCollections.observableArrayList();
				for(Person person : temp) {
					id = person.getId();
					name = person.getName();
					certificateType = person.getCertificateType();
					certificateCode = person.getCertificateCode();
					gender = person.getGender();
					nation = person.getNation();	
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(person.getBirthDate());
					birthday = calendar.get(Calendar.YEAR)+ "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DAY_OF_MONTH);					
					doctorSort = person.getDoctorSort();
					TempPerson tempPerson = new TempPerson(id, name, certificateType, certificateCode, gender, nation, birthday, doctorSort);
					data.add(tempPerson);
				}
				messageTable.setItems(data);
				idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
				nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
				certificateTypeColumn.setCellValueFactory(new PropertyValueFactory<>("certificateType"));
				certificateCodeColumn.setCellValueFactory(new PropertyValueFactory<>("certificateCode"));
				genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
				nationColumn.setCellValueFactory(new PropertyValueFactory<>("nation"));
				birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
				doctorSortColumn.setCellValueFactory(new PropertyValueFactory<>("doctorSort"));
				
			} catch (PersonNoneFoundException e) {
				System.out.println("没找到人");
			}
		}
	}
}

