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
 * this class is for all the prescriptions in one cureMessage
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class PrescriptionList implements Iterable<Prescription>{
	
	private ArrayList<Prescription> prescriptions = new ArrayList<Prescription>();
	private CureMessage cureMessage;
	/**
	 * create a object
	 * @param prescriptions
	 * @param cureMessage
	 */
	public PrescriptionList(ArrayList<Prescription> prescriptions, CureMessage cureMessage) {
		this.prescriptions = prescriptions;
		this.cureMessage = cureMessage;
	}
	/**
	 * create a prescriptionList by using addmissionNumber
	 * @param addmissionNumber
	 * @throws PrescriptionNoneFoundException
	 * @throws CureMessageNoneFoundException 
	 */
	public PrescriptionList(String addmissionNumber) throws PrescriptionNoneFoundException, CureMessageNoneFoundException{
		File file = new File("src/data/PrescriptionMessage.txt");
		try {
			this.cureMessage = new CureMessage(addmissionNumber);
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String string;
			int i = 0;
			while((string = bufferedReader.readLine()) != null) {
				if (string.startsWith("#")) {
					continue;
				}
				StringTokenizer stringTokenizer = new StringTokenizer(string, "_");
				String temp;
				temp = stringTokenizer.nextToken();
				if(addmissionNumber.equals(temp)) {
					Prescription prescription = new Prescription(stringTokenizer.nextToken(), Integer.parseInt(stringTokenizer.nextToken()),Double.parseDouble(stringTokenizer.nextToken()));
					prescription.setAddmissionNumber(addmissionNumber);
					prescriptions.add(prescription);
					i++;
				}else {
					continue;
				}
				
			}
			if (i == 0) {
				throw new PrescriptionNoneFoundException();
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (HospitalNoneFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * toString method
	 */
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		for (Prescription prescription : prescriptions) {
			sBuilder.append(prescription.toString());
		}
		return sBuilder.toString();
	}
	/**
	 * return iterator
	 */
	@Override
	public Iterator<Prescription> iterator() {
		return this.prescriptions.iterator();
	}

	public ArrayList<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(ArrayList<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public CureMessage getCureMessage() {
		return cureMessage;
	}

	public void setCureMessage(CureMessage cureMessage) {
		this.cureMessage = cureMessage;
	}
	
	
	
	//≤‚ ‘¥˙¬Î
//	public static void main(String[] args) {
//		PrescriptionList prescriptionList = new PrescriptionList("1234567890");
//		System.out.println(prescriptionList);
//	}
}
