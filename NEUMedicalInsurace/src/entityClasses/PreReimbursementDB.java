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
 * this class is used to operate all the preReimbursement objects
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class PreReimbursementDB implements Iterable<PreReimbursement>{
		//单例设计模式
		private static PreReimbursementDB preReimbursementDB = new PreReimbursementDB();
		private static ArrayList<PreReimbursement> preReimbursements = PreReimbursementDB.loadPreReimbursementDB();
		
		//不含参构造器
		private PreReimbursementDB() {
		
		}
		
		/**
		 * update the arrayList
		 * @return
		 */
		public static ArrayList<PreReimbursement> loadPreReimbursementDB() {
			ArrayList<PreReimbursement> temp = new ArrayList<PreReimbursement>();
			File file = new File("src/data/PreReimbursementMessage.txt");
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
				String string;
				while((string = bufferedReader.readLine()) != null) {
					if (string.startsWith("#")) {
						continue;
					}
					StringTokenizer stringTokenizer = new StringTokenizer(string, "_");
				    String addmissionNumber = stringTokenizer.nextToken();
				    PreReimbursement pReimbursement = new PreReimbursement(addmissionNumber);
				    temp.add(pReimbursement);
				}
				bufferedReader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PrescriptionNoneFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CureMessageNoneFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return temp;
		}
		
		/**
		 * return the object
		 * @return
		 */
		public static PreReimbursementDB getPreReimbursementDB() {
			return preReimbursementDB;
		}
		/**
		 * return the arrayList
		 * @return
		 */
		public static ArrayList<PreReimbursement> getPreReimbursements() {
			return preReimbursements;
		}
		/**
		 * return the iterator
		 */
		public Iterator<PreReimbursement> iterator() {
			return this.preReimbursements.iterator();
		}
		/**
		 * add preReimbursement 
		 * @param preReimbursement
		 */
		public void addPreRiembursement(PreReimbursement preReimbursement){
			preReimbursements.add(preReimbursement);
		}
		/**
		 * delete the object
		 * @param addmissionNumber
		 * @throws PreReimbursementNoneFoundException
		 */
		public void deletePreRiembursement(String addmissionNumber)  throws PreReimbursementNoneFoundException{
			//用来判断是否找到该人
			Boolean found = false;
			for (PreReimbursement preReimbursement : preReimbursements) {
				if (preReimbursement.getPrescriptionList().getCureMessage().getAddmissionNumber().equals(addmissionNumber)) {
					preReimbursements.remove(preReimbursement);
					found = true;
				}
			}
			if (found == false) {
				//抛出人员未找到异常
				throw new PreReimbursementNoneFoundException();
			}
			
		}
		
		/**
		 * find preReimbursement by addmissionNumber
		 * @param addmissionNumber
		 * @return
		 * @throws PreReimbursementNoneFoundException
		 */
		public PreReimbursement getPreReimbursement(String addmissionNumber) throws PreReimbursementNoneFoundException{
			for (PreReimbursement preReimbursement : preReimbursements) {
				if (preReimbursement.getPrescriptionList().getCureMessage().getAddmissionNumber().equals(addmissionNumber)) {
					return preReimbursement;
				}else {
					continue;
				}
			}
			throw new PreReimbursementNoneFoundException();
		}
}
