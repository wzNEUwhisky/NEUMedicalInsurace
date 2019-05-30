package application;

import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
/**
 * �������������ͬʱҲ�����п������Ļ���
 * �������з�����Ϊ���滽�Ѳ���
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
	 * ������Ա¼�����
	 * @param event
	 */
	@FXML
	public void messageInPerson(ActionEvent event) {
		mainApp.showPersonInWindow();
	}
	/**
	 * ������Աɾ������
	 * @param event
	 */
	@FXML
	public void messageDeletePerson(ActionEvent event) {
		mainApp.showPersonDeleteWindow();
	}
	/**
	 * ������Ա���Ľ���
	 * @param event
	 */
	@FXML
	public void messageChangePerson(ActionEvent event) {
		mainApp.showPersonChangeWindow();
	}
	/**
	 * ������Ա���ҽ���
	 * @param event
	 */
	@FXML
	public void messageFindPerson(ActionEvent event) {
		mainApp.showPersonFindWindow();
	}
	/**
	 * ����ҩƷ¼�����
	 * @param event
	 */
	@FXML
	public void messageInDrug(ActionEvent event) {
		mainApp.showDrugInWindow();
	}
	/**
	 * ����ҩƷɾ������
	 * @param event
	 */
	@FXML
	public void messageDeleteDrug(ActionEvent event) {
		mainApp.showDrugDeleteWindow();
	}
	/**
	 * ����ҩƷ���ý���
	 * @param event
	 */
	@FXML
	public void messageChangeDrug(ActionEvent event) {
		mainApp.showDrugChangeWindow();
	}
	/**
	 * ����ҩƷ���ҽ���
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
	 * ���뱨������
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
	 * ���ص�¼����
	 */
	@FXML
	public void exitSystem() {
		mainApp.startSystem();
	}
}
