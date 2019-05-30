package application;

import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
/**
 * 主界面控制器，同时也是所有控制器的基类
 * 该类所有方法均为界面唤醒操作
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class MainController {
	Main mainApp;
	
	Stage primaryStage;
	
	@FXML
	private Button personMessageIn;
	
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
	public void setStage(Stage primaryStage) {
		this.primaryStage=primaryStage;	
	}
	@FXML
	public void inWorkOrganization(ActionEvent event) {
		
	}
	@FXML
	public void deleteWorkOrganization(ActionEvent event) {
		
	}
	@FXML
	public void changeWorkOrganization(ActionEvent event) {
		
	}
	@FXML
	public void findWorkOrganization(ActionEvent event) {
		
	}
	/**
	 * 进入人员录入界面
	 * @param event
	 */
	@FXML
	public void messageInPerson(ActionEvent event) {
		mainApp.showPersonInWindow();
	}
	/**
	 * 进入人员删除界面
	 * @param event
	 */
	@FXML
	public void messageDeletePerson(ActionEvent event) {
		mainApp.showPersonDeleteWindow();
	}
	/**
	 * 进入人员更改界面
	 * @param event
	 */
	@FXML
	public void messageChangePerson(ActionEvent event) {
		mainApp.showPersonChangeWindow();
	}
	/**
	 * 进入人员查找界面
	 * @param event
	 */
	@FXML
	public void messageFindPerson(ActionEvent event) {
		mainApp.showPersonFindWindow();
	}
	/**
	 * 进入药品录入界面
	 * @param event
	 */
	@FXML
	public void messageInDrug(ActionEvent event) {
		mainApp.showDrugInWindow();
	}
	/**
	 * 进入药品删除界面
	 * @param event
	 */
	@FXML
	public void messageDeleteDrug(ActionEvent event) {
		mainApp.showDrugDeleteWindow();
	}
	/**
	 * 进入药品更该界面
	 * @param event
	 */
	@FXML
	public void messageChangeDrug(ActionEvent event) {
		mainApp.showDrugChangeWindow();
	}
	/**
	 * 今日药品查找界面
	 * @param event
	 */
	@FXML
	public void messageFindDrug(ActionEvent event) {
		mainApp.showDrugFindWindow();
	}
	@FXML
	public void messageInItem(ActionEvent event) {
		
	}
	@FXML
	public void messageDeleteItem(ActionEvent event) {
		
	}
	@FXML
	public void messageChangeItem(ActionEvent event) {
		
	}
	@FXML
	public void messageFindItem(ActionEvent event) {
		
	}
	@FXML
	public void messageInFacility(ActionEvent event) {
		
	}
	@FXML
	public void messageDeleteFacility(ActionEvent event) {
		
	}
	@FXML
	public void messageChangeFacility(ActionEvent event) {
		
	}
	@FXML
	public void messageFindFacility(ActionEvent event) {
		
	}
	@FXML
	public void messageInHospital(ActionEvent event) {
		
	}
	@FXML
	public void messageDeleteHospital(ActionEvent event) {
		
	}
	@FXML
	public void messageChangeHospital(ActionEvent event) {
		
	}
	@FXML
	public void messageFindHospital(ActionEvent event) {
		
	}
	@FXML
	public void changeParameter(ActionEvent event) {
		
	}
	@FXML
	public void findParameter(ActionEvent event) {
		
	}
	@FXML
	public void examineInstitution(ActionEvent event) {
		
	}
	@FXML
	public void examineSpecial(ActionEvent event) {
		
	}
	/**
	 * 进入报销界面
	 * @param event
	 */
	@FXML
	public void centerReimburse(ActionEvent event) {
		mainApp.showBaoxiaoWindow();
	}
	@FXML
	public void findPrice(ActionEvent event) {
		
	}
	/**
	 * 返回登录界面
	 */
	@FXML
	public void exitSystem() {
		mainApp.startSystem();
	}
}
