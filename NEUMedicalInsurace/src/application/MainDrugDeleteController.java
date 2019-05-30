package application;

import javafx.scene.control.TextField;

import java.util.ArrayList;

import entityClasses.Drug;
import entityClasses.DrugDB;
import entityClasses.DrugNoneFoundException;
import entityClasses.FileTool;
import javafx.fxml.FXML;
/**
 * 该类为药品删除界面控制器
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class MainDrugDeleteController extends MainController {
	DrugDB drugs = DrugDB.getDrugDB();
	@FXML
	private TextField idField;
	@FXML
	private TextField tishiField;
	//初始化方法
	@FXML
	public void initialize() {
		
	}
	/**
	 * 按钮方法
	 */
	@FXML
	public void fileDeleteDrug() {
		String id = idField.getText();
		boolean found = false;
		try {
			ArrayList<Drug> temp = DrugDB.loadDrugs();
			FileTool.cleanFile("src/data/DrugMessage.txt", "#药品编码_药品名称_最高限价_单位_收费项目等级_医院等级_是否需要审批标志"+"\r\n");
			for (Drug drug : temp) {
				if (!(drug.getId().equals(id))) {
					FileTool.writeInFile("src/data/DrugMessage.txt", drug.toString()+"\r\n");
				}else {
					tishiField.setText("删除成功！");
					found = true;
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
}
