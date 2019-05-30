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
 * this class is used to operate all of the hospitals
 * @author 	Whisky
 *
 */
public class HospitalDB implements Iterable<Hospital>{
	//singleton design pattern
	private static HospitalDB hospitalDB = new HospitalDB();
	private static ArrayList<Hospital> hospitals = HospitalDB.loadHospitals();
	
	//不含参构造器
	private HospitalDB() {
		
	}
	
	/**
	 * update the hospital arrayList
	 * @return
	 */
	public static ArrayList<Hospital> loadHospitals(){
		ArrayList<Hospital> temp = new ArrayList<Hospital>();
		File file = new File("src/data/HospitalMessage.txt");
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String string;
			while((string = bufferedReader.readLine()) != null ) {
				if (string.startsWith("#")) {
					continue;
				}
				StringTokenizer stringTokenizer = new StringTokenizer(string, "_");
			    String id = stringTokenizer.nextToken();
			    Hospital hospital = new Hospital(id);
			    temp.add(hospital);
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
	 * return object
	 * @return
	 */
	public static HospitalDB getHospitalDB() {
		return hospitalDB;
	}
	
	/**
	 * return arrayList
	 * @return
	 */
	public static ArrayList<Hospital> getHospitals() {
		return hospitals;
	}
	
	/**
	 * return iterator
	 */
	public Iterator<Hospital> iterator() {
		return this.hospitals.iterator();
	}
	/**
	 * add Hospital
	 * @param hospital
	 */
	public void addHospital(Hospital hospital){
		hospitals.add(hospital);
	}
	/**
	 * delete Hospitals
	 * @param id
	 * @throws HospitalNoneFoundException
	 */
	public void deleteHospital(String id)  throws HospitalNoneFoundException{
		//用来判断是否找到该人
		Boolean found = false;
		for (Hospital hospital : hospitals) {
			if (hospital.getId().equals(id)) {
				hospitals.remove(hospital);
				found = true;
			}
		}
		if (found == false) {
			//抛出人员未找到异常
			throw new HospitalNoneFoundException();
		}
		
	}
	
	/**
	 * search Hospital by using id
	 * @param id
	 * @return
	 * @throws HospitalNoneFoundException
	 */
	public Hospital getHospitalById(String id) throws HospitalNoneFoundException{
		for (Hospital hospital : hospitals) {
			if (hospital.getId().equals(id)) {
				return hospital;
			}else {
				continue;
			}
		}
		//全部遍历结束之后如果没找到该人则抛出PersonNoneFoundException
		throw new HospitalNoneFoundException();
	}
	
	/**
	 * search Hospital by using name
	 * @param name
	 * @return
	 * @throws HospitalNoneFoundException
	 */
	public Hospital getHospitalByName(String name) throws HospitalNoneFoundException{
		for (Hospital hospital : hospitals) {
			if (hospital.getName().equals(name)) {
				return hospital;
			}else {
				continue;
			}
		}
		//全部遍历结束之后如果没找到该人则抛出PersonNoneFoundException
			throw new HospitalNoneFoundException();
	}
}
