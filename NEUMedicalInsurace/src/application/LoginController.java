package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * this class is the loginController 
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class LoginController {
	Main mainApp;
	@FXML
	private TextField managerIDField;
	@FXML
	private TextField passwordField; 
	/**
	 * 初始化方法，在文件被加载后会被自动调用
	 */
	@FXML
	private void initialize() {
		
	}
	/**
	 * 按钮操作
	 * @param event
	 */
	@FXML
	public void eventButton(ActionEvent event) {
		String managerID = managerIDField.getText();
		String password = passwordField.getText();
		File file = new File("src/data/ManagerMessage.txt");
		int i = 0;
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(file));
			String string;
			while((string = bReader.readLine()) != null){
				StringTokenizer stringTokenizer = new StringTokenizer(string,",");
				String s1 = stringTokenizer.nextToken();
				String s2 = stringTokenizer.nextToken();
				if(s1.equals(managerID)&&s2.equals(password)) {
					i = 1;
				}
			}
			if (i == 1) {
				mainApp.showMainWindow();
			}else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("登录失败提示");
				alert.setHeaderText(null);
				alert.setContentText("账号或者密码错误，请重新输入");

				alert.showAndWait();
				mainApp.startSystem();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
}
