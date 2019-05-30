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
 * ����ΪҩƷ��Ϣ���Ľ��������
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
		        "����",
		        "����",
		        "����"
		    );
	ObservableList<String> options2 = 
		    FXCollections.observableArrayList(
		        "һ��",
		        "����",
		        "����"
		    );
	ObservableList<String> options3 = 
		    FXCollections.observableArrayList(
		        "��",
		        "��"
		    );
	//��ʼ������
	@FXML
	private void initialize() {
		priceLevelField.setItems(options1);
		hospitalLevelField.setItems(options2);
		examineMarkField.setItems(options3);
	}
	/**
	 * ��ť����
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
					examineMarkField.setValue(drug.getExamineMark() == true? "��" : "��");
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
			tishiField.setText("�����ڸ�ҩƷ������������");
		}
	}
	/**
	 * ��ť����
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
			if (temp.equals("��")) {
				examineMark = true;
			}else {
				examineMark = false;
			}
			Drug drugTemp = new Drug(id, name, highestPrice, unit, priceLevel, hospitalLevel,examineMark);
			ArrayList<Drug> drugs = DrugDB.loadDrugs();
			FileTool.cleanFile("src/data/DrugMessage.txt", "#ҩƷ����_ҩƷ����_����޼�_��λ_�շ���Ŀ�ȼ�_ҽԺ�ȼ�_�Ƿ���Ҫ������־"+"\r\n");
			for (Drug drug : drugs) {
				if (!(drug.getId().equals(idField.getText()))) {
					FileTool.writeInFile("src/data/DrugMessage.txt", drug.toString()+"\r\n");
				}else {
					FileTool.writeInFile("src/data/DrugMessage.txt", drugTemp.toString()+"\r\n");
					tishiField.setText("�޸ĳɹ���");
				}
			}	
		}else {
			tishiField.setText("������Ŀ��Ϊ��ѡ���ȫ������");
		}
	}
}
