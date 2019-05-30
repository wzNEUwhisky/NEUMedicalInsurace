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
 * this class is used to operate all the prescriptions
 * @author 	Whisky
 *
 */
public class PrescriptionDB implements Iterable<Prescription>{
		//singleton design pattern
		private static PrescriptionDB prescriptionDB = new PrescriptionDB();
		private static ArrayList<Prescription> prescriptions = PrescriptionDB.loadPrescriptions();
		
		private PrescriptionDB() {
			
		}
		
		/**
		 * update the arrayList
		 * @return
		 */
		public static ArrayList<Prescription> loadPrescriptions(){
			ArrayList<Prescription> temp = new ArrayList<Prescription>();
			File file = new File("src/data/PrescriptionMessage.txt");
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
				String string;
				while((string = bufferedReader.readLine()) != null ) {
					if (string.startsWith("#")) {
						continue;
					}
					StringTokenizer stringTokenizer = new StringTokenizer(string, "_");
					Prescription prescription = new Prescription(stringTokenizer.nextToken(),stringTokenizer.nextToken(),Integer.parseInt(stringTokenizer.nextToken()),Double.parseDouble(stringTokenizer.nextToken()));
				   temp.add(prescription);
				}
				bufferedReader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return temp;
		}
		/**
		 * return iterator
		 */
		public Iterator<Prescription> iterator(){
			return this.prescriptions.iterator();
		}
		
		/**
		 * return arrayList
		 * @return
		 */
		public static PrescriptionDB getPrescriptionDB() {
			return prescriptionDB;
		}
		/**
		 * add prescription
		 * @param prescription
		 */
		public static void addPrescription(Prescription prescription){
			prescriptions.add(prescription);
		}
		/**
		 * delete prescription
		 * @param prescription
		 * @throws PrescriptionNoneFoundException
		 */
		public void deletePerson(Prescription prescription)  throws PrescriptionNoneFoundException{
			//用来判断是否找到该人
			Boolean found = false;
			for (Prescription prescription2 : prescriptions) {
				if (prescription.equals(prescription2)) {
					prescriptions.remove(prescription2);
					found = true;
				}
			}
			if (found == false) {
				//抛出人员未找到异常
				throw new PrescriptionNoneFoundException();
			}
			
		}
		
		/**
		 * return arrayList
		 * @return
		 */
		public ArrayList<Prescription> getPrescriptions() {
			return prescriptions;
		}
		
		/**
		 * get PrescriptionList
		 * @param addmissionNumber
		 * @return
		 * @throws PrescriptionNoneFoundException
		 * @throws CureMessageNoneFoundException 
		 */
		public PrescriptionList getPrescriptionByAddmissionNumber(String addmissionNumber) throws PrescriptionNoneFoundException, CureMessageNoneFoundException{
			PrescriptionList prescriptionList = new PrescriptionList(addmissionNumber);
			return prescriptionList;
		}
}
