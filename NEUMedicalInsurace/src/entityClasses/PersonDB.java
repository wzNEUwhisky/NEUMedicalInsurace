package entityClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
/**
 * this class is used to operate all persons
 * @author 	Whisky
 * @Time 2017-07-30
 */
public class PersonDB implements Iterable<Person>{
	//�������ģʽ
	private static PersonDB personDB = new PersonDB();
	private static ArrayList<Person> persons = PersonDB.loadPersons();
	
	//�����ι�����
	private PersonDB() {
		
	}
	
	/**
	 * this method is used to update the person arrayList
	 * @return
	 */
	public static ArrayList<Person> loadPersons(){
		ArrayList<Person> temp = new ArrayList<Person>();
		File file = new File("src/data/personMessage.txt");
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String string;
			while((string = bufferedReader.readLine()) != null) {
				if (string.startsWith("#")) {
					continue;
				}
				StringTokenizer stringTokenizer = new StringTokenizer(string, "_");
			    String id = stringTokenizer.nextToken();
			    Person person = new Person(id);
			    temp.add(person);
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return temp;
	}
	
	/**
	 * get object
	 * @return
	 */
	public static PersonDB getPersonDB() {
		return personDB;
	}
	/**
	 * get person arrayList
	 * @return
	 */
	public static ArrayList<Person> getPersons() {
		return persons;
	}
	/**
	 * get iterator
	 */
	public Iterator<Person> iterator() {
		return this.persons.iterator();
	}
	/**
	 * add person
	 * @param person
	 */
	public void addPerson(Person person){
		persons.add(person);
	}
	/**
	 * delete person
	 * @param id
	 * @throws PersonNoneFoundException
	 */
	public static void deletePerson(String id)  throws PersonNoneFoundException{
		//�����ж��Ƿ��ҵ�����
		Boolean found = false;
		File file = new File("src/data/personMessage.txt");
		try {
			PrintWriter printWriter = new PrintWriter(new FileWriter(file));
			printWriter.println("#����ID_֤������_֤�����_����_����_��������_�Ա�_ҽ������");
			for (Person person : personDB) {
				if (!(person.getId().equals(id))) {
					printWriter.println(person.toString());
					continue;
				}else {
					found = true;
					persons.remove(person);
				}
			}
			printWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (found == false) {
			//�׳���Աδ�ҵ��쳣
			throw new PersonNoneFoundException();
		}
		
	}
	
	/**
	 * search person by id
	 * @param id
	 * @return
	 * @throws PersonNoneFoundException
	 */
	public static ArrayList<Person> getPersonById(String id) throws PersonNoneFoundException{
		ArrayList<Person> personsById = new ArrayList<Person>();
		//�����ж��Ƿ��ҵ�����
		int i = 0;
		for (Person person : PersonDB.loadPersons()) {
			if (person.getId().startsWith(id)) {
				personsById.add(person);
				i++;
			}else {
				continue;
			}
		}
		//ȫ����������֮�����û�ҵ��������׳�PersonNoneFoundException
		if (i == 0) {
			throw new PersonNoneFoundException();
		}
		return personsById;
	}
	
	/**
	 * search person by name
	 * @param name
	 * @return
	 * @throws PersonNoneFoundException
	 */
	public static ArrayList<Person> getPersonByName(String name) throws PersonNoneFoundException{
		ArrayList<Person> personsByName = new ArrayList<Person>();
		//�����ж��Ƿ��ҵ�����
		int i = 0;
		for (Person person : PersonDB.loadPersons()) {
			if (person.getName().startsWith(name)) {
				personsByName.add(person);
				i++;
			}else {
				continue;
			}
		}
		//ȫ����������֮�����û�ҵ��������׳�PersonNoneFoundException
		if (i == 0) {
			throw new PersonNoneFoundException();
		}
		return personsByName;
	}
}
