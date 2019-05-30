package application;
import java.util.ArrayList;

import entityClasses.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
/**
 * 该类为人员信息删除界面控制器
 * @author 	Whisky
 *
 */
public class MainPersonDeleteController extends MainController{
	private PersonDB personDB = PersonDB.getPersonDB();
	@FXML
	private TextField idField;
	@FXML
	private TextField tishiField;
	//加载界面
	@FXML
	private void initialize() {
		idField.setText("CNSY");
	}
	/**
	 * 按钮方法
	 */
	public void fileDeletePerson() {
		String id = idField.getText();
		PersonDB.loadPersons();
		boolean found = false;
		try {
			ArrayList<Person> temp = PersonDB.loadPersons();
			FileTool.cleanFile("src/data/personMessage.txt", "#个人ID_证件类型_证件编号_姓名_民族_出生日期_性别_医疗类型"+"\r\n");
			for (Person person : temp) {
				if (!(person.getId().equals(id))) {
					FileTool.writeInFile("src/data/personMessage.txt", person.toString()+"\r\n");
				}else {
					tishiField.setText("删除成功！");
					found = true;
					continue;
				}
			}
			if (found == false) {
				throw new PersonNoneFoundException();
			}
		} catch (PersonNoneFoundException e) {
			// TODO Auto-generated catch block
			tishiField.setText("不存在该人，请重新输入");
		}
	}
}
