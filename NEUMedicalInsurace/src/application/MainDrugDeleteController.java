package application;

import javafx.scene.control.TextField;

import java.util.ArrayList;

import entityClasses.Drug;
import entityClasses.DrugDB;
import entityClasses.DrugNoneFoundException;
import entityClasses.FileTool;
import javafx.fxml.FXML;
/**
 * ����ΪҩƷɾ�����������
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class MainDrugDeleteController extends MainController {
	DrugDB drugs = DrugDB.getDrugDB();
	@FXML
	private TextField idField;
	@FXML
	private TextField tishiField;
	//��ʼ������
	@FXML
	public void initialize() {
		
	}
	/**
	 * ��ť����
	 */
	@FXML
	public void fileDeleteDrug() {
		String id = idField.getText();
		boolean found = false;
		try {
			ArrayList<Drug> temp = DrugDB.loadDrugs();
			FileTool.cleanFile("src/data/DrugMessage.txt", "#ҩƷ����_ҩƷ����_����޼�_��λ_�շ���Ŀ�ȼ�_ҽԺ�ȼ�_�Ƿ���Ҫ������־"+"\r\n");
			for (Drug drug : temp) {
				if (!(drug.getId().equals(id))) {
					FileTool.writeInFile("src/data/DrugMessage.txt", drug.toString()+"\r\n");
				}else {
					tishiField.setText("ɾ���ɹ���");
					found = true;
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
}
