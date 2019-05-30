package application;

import entityClasses.Drug;
import entityClasses.DrugDB;
import entityClasses.FileTool;
import entityClasses.Person;
import entityClasses.PersonDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
/**
 * 该类为药品信息录入界面控制器
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class MainDrugInController extends MainController {
	DrugDB drugDB = DrugDB.getDrugDB();
	@FXML
	private TextField idField;
	@FXML
	private TextField nameField;
	@FXML
	private TextField highestPriceField;
	@FXML
	private TextField unitField;
	@FXML
	private ComboBox<String> priceLevelField;
	@FXML
	private ComboBox<String> hospitalLevelField;
	@FXML
	private ComboBox<String> examineMarkField;
	@FXML
	private TextField tishiField;
	
	ObservableList<String> options1 = 
		    FXCollections.observableArrayList(
		        "甲类",
		        "乙类",
		        "丙类"
		    );
	ObservableList<String> options2 = 
		    FXCollections.observableArrayList(
		        "一级",
		        "二级",
		        "三级"
		    );
	ObservableList<String> options3 = 
		    FXCollections.observableArrayList(
		        "是",
		        "否"
		    );
	//初始化界面
	@FXML
	private void initialize() {
		priceLevelField.setItems(options1);
		hospitalLevelField.setItems(options2);
		examineMarkField.setItems(options3);
	}
	/**
	 * 按钮方法
	 */
	@FXML
	public void fileInDrug() {
		boolean found = false;
		if (idField.getText().length() != 0 && nameField.getText().length() != 0 && highestPriceField.getText().length() != 0 && unitField.getText().length() != 0 && priceLevelField.getValue() != null && hospitalLevelField.getValue() != null &&examineMarkField.getValue() != null) {
			for (Drug drug : DrugDB.loadDrugs()) {
				if (drug.getId().equals(idField.getText())) {
					found = true;
				}
			}
			if (found == false) {
				String id = idField.getText();
				String name = nameField.getText();
				double highestPrice = Double.parseDouble(highestPriceField.getText());
				String unit = unitField.getText();
				
				String priceLevel = priceLevelField.getValue();
				String hospitalLevel = hospitalLevelField.getValue();
				String temp = examineMarkField.getValue();
				boolean examineMark;
				if (temp.equals("是")) {
					examineMark = true;
				}else {
					examineMark = false;
				}
				Drug drug = new Drug(id, name, highestPrice, unit, priceLevel, hospitalLevel,examineMark);
				FileTool.writeInFile("src/data/DrugMessage.txt", drug.toString() + "\r\n");
				DrugDB.loadDrugs();
				tishiField.setText("录入成功");
			}else {
				tishiField.setText("该id已经存在，请重新输入");
			}
		}else {
			tishiField.setText("所有条目均为必选项，请全部输入");
		}
		
	}
	
}
