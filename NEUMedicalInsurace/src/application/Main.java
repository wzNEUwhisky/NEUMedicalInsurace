package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
/**
 * ���������
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class Main extends Application {
	public static Stage primaryStage = null;
	/**
	 * ��ʼ����
	 */
	@Override
	public void start(Stage primaryStage) {
		Main.primaryStage = primaryStage;
		startSystem();
	}
	/**
	 * �����¼����
	 */
	public void startSystem() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/login.fxml")));//װ�ز����ļ�
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//װ�س���
			primaryStage.setTitle("ҽ������ϵͳ_1701_20175159_κ���");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//Css������ʽ
			primaryStage.show();
			//primaryStage.getIcons().add(
					//new Image ("file:resources/images/thomas.png"));
			LoginController controller = loader.getController();//�󶨿�����
			controller.setMainApp(this);		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ����������
	 */
	public void showMainWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/Main.fxml")));//װ�ز����ļ�
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//װ�س���
			primaryStage.setTitle("ҽ������ϵͳ_1701_20175159_κ���");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//�󶨿�����
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ��Ա����������
	 */
	public void showPersonInWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/MainPersonIn.fxml")));//װ�ز����ļ�
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//װ�س���
			primaryStage.setTitle("ҽ������ϵͳ_1701_20175159_κ���");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//�󶨿�����
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ��Ա���ҽ������
	 */
	public void showPersonFindWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/MainPersonFind.fxml")));//װ�ز����ļ�
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//װ�س���
			primaryStage.setTitle("ҽ������ϵͳ_1701_20175159_κ���");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//�󶨿�����
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ��Աid���ҽ������
	 */
	public void showPersonFindIdWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/MainPersonFindId.fxml")));//װ�ز����ļ�
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//װ�س���
			primaryStage.setTitle("ҽ������ϵͳ_1701_20175159_κ���");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//�󶨿�����
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ��Աɾ���������
	 */
	public void showPersonDeleteWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/MainPersonDelete.fxml")));//װ�ز����ļ�
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//װ�س���
			primaryStage.setTitle("ҽ������ϵͳ_1701_20175159_κ���");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//�󶨿�����
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ��Ա���Ľ������
	 */
	public void showPersonChangeWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/MainPersonChange.fxml")));//װ�ز����ļ�
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//װ�س���
			primaryStage.setTitle("ҽ������ϵͳ_1701_20175159_κ���");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//�󶨿�����
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ҩƷ¼��������
	 */
	public void showDrugInWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/MainDrugIn.fxml")));//װ�ز����ļ�
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//װ�س���
			primaryStage.setTitle("ҽ������ϵͳ_1701_20175159_κ���");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//�󶨿�����
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ҩƷ���Ľ������
	 */
	public void showDrugChangeWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/MainDrugChange1.fxml")));//װ�ز����ļ�
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//װ�س���
			primaryStage.setTitle("ҽ������ϵͳ_1701_20175159_κ���");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//�󶨿�����
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ҩƷ���ҽ������
	 */
	public void showDrugFindWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/MainDrugFind.fxml")));//װ�ز����ļ�
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//װ�س���
			primaryStage.setTitle("ҽ������ϵͳ_1701_20175159_κ���");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//�󶨿�����
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ҩƷɾ���������
	 */
	public void showDrugDeleteWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/MainDrugDelete.fxml")));//װ�ز����ļ�
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//װ�س���
			primaryStage.setTitle("ҽ������ϵͳ_1701_20175159_κ���");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//�󶨿�����
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * �����������
	 */
	public void showBaoxiaoWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/Baoxiao.fxml")));//װ�ز����ļ�
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//װ�س���
			primaryStage.setTitle("ҽ������ϵͳ_1701_20175159_κ���");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//�󶨿�����
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ������ʼ
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
