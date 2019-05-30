package entityClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
/**
 * this class is used to operate all of the cureMessages
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class CureMessageDB implements Iterable<CureMessage>{
	//the singleton design pattern
	private static CureMessageDB cureMessageDB = new CureMessageDB();
	private static ArrayList<CureMessage> cureMessages = CureMessageDB.loadCureMessages();
	
	
	private CureMessageDB() {
		
	}
	
	/**
	 * this method is to update the cureMessage ArrayList by read the file
	 * @return
	 */
	public static ArrayList<CureMessage> loadCureMessages(){
		ArrayList<CureMessage> temp = new ArrayList<CureMessage>();
		File file = new File("src/data/CureMessage.txt");
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String string;
			while((string = bufferedReader.readLine()) != null ) {
				if (string.startsWith("#")) {
					continue;
				}
				StringTokenizer stringTokenizer = new StringTokenizer(string, "_");
				stringTokenizer.nextToken();
			    String id = stringTokenizer.nextToken();
			    CureMessage cureMessage = new CureMessage(id);
			    temp.add(cureMessage);
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HospitalNoneFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CureMessageNoneFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return temp;
	}
	
	public static CureMessageDB getCureMessageDB() {
		return cureMessageDB;
	}
	public static ArrayList<CureMessage> getCureMessages() {
		return cureMessages;
	}
	
	public Iterator<CureMessage> iterator() {
		return this.cureMessages.iterator();
	}
	/**
	 * this method will add the cureMessage
	 * @param cureMessage
	 */
	public void addCureMessage(CureMessage cureMessage){
		cureMessages.add(cureMessage);
	}
	/**
	 * this method will delete the cureMessage
	 * @param addmissionNumber
	 * @throws CureMessageNoneFoundException
	 */
	public void deleteCureMessage(String addmissionNumber)  throws CureMessageNoneFoundException{
		//用来判断是否找到该人
		Boolean found = false;
		for (CureMessage cureMessage : cureMessages) {
			if (cureMessage.getAddmissionNumber().equals(addmissionNumber)) {
				cureMessages.remove(cureMessage);
				found = true;
			}
		}
		if (found == false) {
			//抛出人员未找到异常
			throw new CureMessageNoneFoundException();
		}
		
	}
	/**
	 * this method will search the cureMessage by addmissionNumber
	 * @param addmissionNumber
	 * @return
	 * @throws CureMessageNoneFoundException
	 */
	public CureMessage getCureMessageById(String addmissionNumber) throws CureMessageNoneFoundException{
		for (CureMessage cureMessage : cureMessages) {
			if (cureMessage.getAddmissionNumber().equals(addmissionNumber)) {
				return cureMessage;
			}else {
				continue;
			}
		}
		//全部遍历结束之后如果没找到则抛出Exception
			throw new CureMessageNoneFoundException();
	}
}
