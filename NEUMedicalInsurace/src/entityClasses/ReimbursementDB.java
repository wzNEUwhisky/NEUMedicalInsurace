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
 * this class is to operate all the Reimbursement object
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class ReimbursementDB {
			//singleton design pattern
			private static ReimbursementDB reimbursementDB = ReimbursementDB.getReimbursementDB();
			private static ArrayList<Reimbursement> reimbursements = ReimbursementDB.loadReimbursementDB();
			
			//不含参构造器
			private ReimbursementDB() {
			
			}
			
			/**
			 * update the arrayList
			 * @return
			 */
			public static ArrayList<Reimbursement> loadReimbursementDB() {
				ArrayList<Reimbursement> temp = new ArrayList<Reimbursement>();
				File file = new File("src/data/ReimbursementMessage.txt");
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
					String string;
					while((string = bufferedReader.readLine()) != null ) {
						if (string.startsWith("#")) {
							continue;
						}
						StringTokenizer stringTokenizer = new StringTokenizer(string, "_");
					    String addmissionNumber = stringTokenizer.nextToken();
					    Reimbursement reimbursement = new Reimbursement(addmissionNumber);
					    temp.add(reimbursement);
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
			 * get object
			 * @return
			 */
			public static ReimbursementDB getReimbursementDB() {
				return reimbursementDB;
			}
			/**
			 * get arrayList
			 * @return
			 */
			public static ArrayList<Reimbursement> getReimbursements() {
				return reimbursements;
			}
			/**
			 * get iterator
			 * @return
			 */
			public Iterator<Reimbursement> iterator() {
				return this.reimbursements.iterator();
			}
			/**
			 * add object
			 * @param reimbursement
			 */
			public void addRiembursement(Reimbursement reimbursement){
				reimbursements.add(reimbursement);
			}
			/**
			 * delete object
			 * @param addmissionNumber
			 * @throws ReimbursementNoneFoundException
			 */
			public void deleteRiembursement(String addmissionNumber)  throws ReimbursementNoneFoundException{
				//用来判断是否找到该人
				Boolean found = false;
				for (Reimbursement reimbursement : reimbursements) {
					if (reimbursement.getPreReimbursement().getPrescriptionList().getCureMessage().getAddmissionNumber().equals(addmissionNumber)) {
						reimbursements.remove(reimbursement);
						found = true;
					}
				}
				if (found == false) {
					//抛出人员未找到异常
					throw new ReimbursementNoneFoundException();
				}
				
			}
			
			/**
			 * get Reimbursement
			 * @param addmissionNumber
			 * @return
			 * @throws ReimbursementNoneFoundException
			 */
			public Reimbursement getReimbursement(String addmissionNumber) throws ReimbursementNoneFoundException{
				for (Reimbursement reimbursement : reimbursements) {
					if (reimbursement.getPreReimbursement().getPrescriptionList().getCureMessage().getAddmissionNumber().equals(addmissionNumber)) {
						return reimbursement;
					}else {
						continue;
					}
				}
				throw new ReimbursementNoneFoundException();
			}
}
