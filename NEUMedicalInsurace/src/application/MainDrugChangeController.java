package application;

import java.util.ArrayList;

import entityClasses.Drug;
import entityClasses.DrugDB;
import entityClasses.DrugNoneFoundException;
import entityClasses.FileTool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
/**
 * 该类为药品信息更改界面控制器
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class MainDrugChangeController extends MainController {
	DrugDB drugDB = DrugDB.getDrugDB();
	@FXML
	private TextField tishiField;
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
	private Button sure1;
	@FXML
	private Button sure2;
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
	//初始化方法
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
	public void findDrug() {
		String id = idField.getText();
		boolean found = false;
		try {
			ArrayList<Drug> temp = DrugDB.loadDrugs();
			for (Drug drug : temp) {
				if (drug.getId().equals(id)) {
					idField.setVisible(false);
					nameField.setVisible(true);
					nameField.setText(drug.getName());
					highestPriceField.setVisible(true);
					highestPriceField.setText(new Double(drug.getHighestPrice()).toString());
					unitField.setVisible(true);
					unitField.setText(drug.getUnit());
					priceLevelField.setVisible(true);
					priceLevelField.setValue(drug.getPriceLevel());
					hospitalLevelField.setVisible(true);
					hospitalLevelField.setValue(drug.getHospitalLevel());
					examineMarkField.setVisible(true);
					examineMarkField.setValue(drug.getExamineMark() == true? "是" : "否");
					sure1.setVisible(false);
					sure2.setVisible(true);
					found = true;
				}else {
					continue;
				}
			}
			if (found == false) {
				throw new DrugNoneFoundException();
			}
		} catch (DrugNoneFoundException e) {
			// TODO Auto-generated catch block
			tishiField.setText("不存在该药品，请重新输入");
		}
	}
	/**
	 * 按钮方法
	 */
	@FXML
	public void changeDrug() {
		if (idField.getText().length() != 0 && nameField.getText().length() != 0 && highestPriceField.getText().length() != 0 && unitField.getText().length() != 0 && priceLevelField.getValue() != null && hospitalLevelField.getValue() != null &&examineMarkField.getValue() != null) {
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
			Drug drugTemp = new Drug(id, name, highestPrice, unit, priceLevel, hospitalLevel,examineMark);
			ArrayList<Drug> drugs = DrugDB.loadDrugs();
			FileTool.cleanFile("src/data/DrugMessage.txt", "#药品编码_药品名称_最高限价_单位_收费项目等级_医院等级_是否需要审批标志"+"\r\n");
			for (Drug drug : drugs) {
				if (!(drug.getId().equals(idField.getText()))) {
					FileTool.writeInFile("src/data/DrugMessage.txt", drug.toString()+"\r\n");
				}else {
					FileTool.writeInFile("src/data/DrugMessage.txt", drugTemp.toString()+"\r\n");
					tishiField.setText("修改成功！");
				}
			}	
		}else {
			tishiField.setText("所有条目均为必选项，请全部输入");
		}
	}
}
