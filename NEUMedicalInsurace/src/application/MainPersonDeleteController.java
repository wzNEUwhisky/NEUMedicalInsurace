package application;
import java.util.ArrayList;

import entityClasses.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
/**
 * ����Ϊ��Ա��Ϣɾ�����������
 * @author 	Whisky
 *
 */
public class MainPersonDeleteController extends MainController{
	private PersonDB personDB = PersonDB.getPersonDB();
	@FXML
	private TextField idField;
	@FXML
	private TextField tishiField;
	//���ؽ���
	@FXML
	private void initialize() {
		idField.setText("CNSY");
	}
	/**
	 * ��ť����
	 */
	public void fileDeletePerson() {
		String id = idField.getText();
		PersonDB.loadPersons();
		boolean found = false;
		try {
			ArrayList<Person> temp = PersonDB.loadPersons();
			FileTool.cleanFile("src/data/personMessage.txt", "#����ID_֤������_֤�����_����_����_��������_�Ա�_ҽ������"+"\r\n");
			for (Person person : temp) {
				if (!(person.getId().equals(id))) {
					FileTool.writeInFile("src/data/personMessage.txt", person.toString()+"\r\n");
				}else {
					tishiField.setText("ɾ���ɹ���");
					found = true;
					continue;
				}
			}
			if (found == false) {
				throw new PersonNoneFoundException();
			}
		} catch (PersonNoneFoundException e) {
			// TODO Auto-generated catch block
			tishiField.setText("�����ڸ��ˣ�����������");
		}
	}
}
