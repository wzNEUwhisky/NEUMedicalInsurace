package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
/**
 * 主界面入口
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class Main extends Application {
	public static Stage primaryStage = null;
	/**
	 * 开始方法
	 */
	@Override
	public void start(Stage primaryStage) {
		Main.primaryStage = primaryStage;
		startSystem();
	}
	/**
	 * 进入登录界面
	 */
	public void startSystem() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/login.fxml")));//装载布局文件
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//装载场景
			primaryStage.setTitle("医保报销系统_1701_20175159_魏子淇");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//Css控制样式
			primaryStage.show();
			//primaryStage.getIcons().add(
					//new Image ("file:resources/images/thomas.png"));
			LoginController controller = loader.getController();//绑定控制器
			controller.setMainApp(this);		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入主界面
	 */
	public void showMainWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/Main.fxml")));//装载布局文件
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//装载场景
			primaryStage.setTitle("医保报销系统_1701_20175159_魏子淇");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//绑定控制器
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 人员登入界面入口
	 */
	public void showPersonInWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/MainPersonIn.fxml")));//装载布局文件
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//装载场景
			primaryStage.setTitle("医保报销系统_1701_20175159_魏子淇");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//绑定控制器
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 人员查找界面入口
	 */
	public void showPersonFindWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/MainPersonFind.fxml")));//装载布局文件
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//装载场景
			primaryStage.setTitle("医保报销系统_1701_20175159_魏子淇");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//绑定控制器
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 人员id查找界面入口
	 */
	public void showPersonFindIdWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/MainPersonFindId.fxml")));//装载布局文件
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//装载场景
			primaryStage.setTitle("医保报销系统_1701_20175159_魏子淇");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//绑定控制器
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 人员删除界面入口
	 */
	public void showPersonDeleteWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/MainPersonDelete.fxml")));//装载布局文件
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//装载场景
			primaryStage.setTitle("医保报销系统_1701_20175159_魏子淇");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//绑定控制器
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 人员更改界面入口
	 */
	public void showPersonChangeWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/MainPersonChange.fxml")));//装载布局文件
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//装载场景
			primaryStage.setTitle("医保报销系统_1701_20175159_魏子淇");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//绑定控制器
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 药品录入界面入口
	 */
	public void showDrugInWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/MainDrugIn.fxml")));//装载布局文件
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//装载场景
			primaryStage.setTitle("医保报销系统_1701_20175159_魏子淇");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//绑定控制器
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 药品更改界面入口
	 */
	public void showDrugChangeWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/MainDrugChange1.fxml")));//装载布局文件
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//装载场景
			primaryStage.setTitle("医保报销系统_1701_20175159_魏子淇");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//绑定控制器
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 药品查找界面入口
	 */
	public void showDrugFindWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/MainDrugFind.fxml")));//装载布局文件
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//装载场景
			primaryStage.setTitle("医保报销系统_1701_20175159_魏子淇");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//绑定控制器
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 药品删除界面入口
	 */
	public void showDrugDeleteWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/MainDrugDelete.fxml")));//装载布局文件
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//装载场景
			primaryStage.setTitle("医保报销系统_1701_20175159_魏子淇");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//绑定控制器
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 报销界面入口
	 */
	public void showBaoxiaoWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((Main.class.getClassLoader().getResource("application/Baoxiao.fxml")));//装载布局文件
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);//装载场景
			primaryStage.setTitle("医保报销系统_1701_20175159_魏子淇");
			primaryStage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			MainController controller = loader.getController();//绑定控制器
			controller.setMainApp(this);
			controller.setStage(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 主程序开始
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
