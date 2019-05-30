package application;
import entityClasses.Drug;
import entityClasses.DrugDB;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 * 该类为药品信息查找界面控制器
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class MainDrugFindController extends MainController{
	DrugDB drugDB = DrugDB.getDrugDB();
	@FXML
	private TextField idField;
	@FXML
	private Label nameField;
	@FXML
	private Label highestPriceField;
	@FXML
	private Label unitField;
	@FXML
	private Label priceLevelField;
	@FXML
	private Label hospitalLevelField;
	@FXML
	private Label examineMarkField;
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
	public void filefindDrug() {
		boolean find = false;
		if (idField.getText().length() != 0) {
			String id = idField.getText();
			for (Drug drug : DrugDB.loadDrugs()) {
				if (drug.getId().equals(id)) {
				    find = true;
				    nameField.setText(drug.getName());
				    highestPriceField.setText((new Double(drug.getHighestPrice())).toString());
				    unitField.setText(drug.getUnit());
				    priceLevelField.setText(drug.getPriceLevel());
				    hospitalLevelField.setText(drug.getHospitalLevel());
				    String examine = null;
				    if (drug.getExamineMark() == true) {
						examine = "是";
					}else {
						examine = "否";
					}
				    examineMarkField.setText(examine);
				}
			}
			if (find == false) {
				tishiField.setText("无效的id，请重新输入");
			}
		}else {
			tishiField.setText("请输入id");
		}
		
	}
}
