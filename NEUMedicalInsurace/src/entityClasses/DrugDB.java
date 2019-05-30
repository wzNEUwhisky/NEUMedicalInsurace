package entityClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
/**
 * this class is used to operate all the drugs
 * @author 	Whisky
 * @Time 2017-07-30
 */
public class DrugDB implements Iterable<Drug>{
	//singleton design pattern
	private static DrugDB drugDB = new DrugDB();
	private static ArrayList<Drug> drugs = DrugDB.loadDrugs();
	
	//�����ι�����
	private DrugDB() {
		
	}
	
	/**
	 * this method is to update the drug arrayList
	 * @return
	 */
	public static ArrayList<Drug> loadDrugs(){
		ArrayList<Drug> temp = new ArrayList<Drug>();
		File file = new File("src/data/DrugMessage.txt");
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String string;
			while((string = bufferedReader.readLine()) != null ) {
				if (string.startsWith("#")) {
					continue;
				}
				StringTokenizer stringTokenizer = new StringTokenizer(string, "_");
			    String id = stringTokenizer.nextToken();
			    Drug drug = new Drug(id);
			    temp.add(drug);
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
	 * get objet
	 * @return
	 */
	public static DrugDB getDrugDB() {
		return drugDB;
	}
	/**
	 * get the arrayList
	 * @return
	 */
	public static ArrayList<Drug> getdrugs() {
		return drugs;
	}
	/**
	 * get the iterator
	 */
	public Iterator<Drug> iterator() {
		return this.drugs.iterator();
	}
	/**
	 * add the drug
	 * @param drug
	 */
	public void addDrug(Drug drug){
		drugs.add(drug);
	}
	/**
	 * this method is to delete the drug
	 * @param id
	 * @throws DrugNoneFoundException
	 */
	public static void deleteDrug(String id)  throws DrugNoneFoundException{
		//�����ж��Ƿ��ҵ���ҩ��
		Boolean found = false;
		File file = new File("src/data/DrugMessage.txt");
		try {
			PrintWriter printWriter = new PrintWriter(new FileWriter(file));
			printWriter.println("#ҩƷ����_ҩƷ����_����޼�_��λ_�շ���Ŀ�ȼ�_ҽԺ�ȼ�_�Ƿ���Ҫ������־");
			for (Drug drug :drugs) {
				if (!(drug.getId().equals(id))) {
					printWriter.println(drug.toString());
					continue;
				}else {
					found = true;
					drugs.remove(drug);
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
			//�׳�ҩƷδ�ҵ��쳣
			throw new DrugNoneFoundException();
		}
		
	}
	
	/**
	 * get drug by search id
	 * @param id
	 * @return
	 * @throws DrugNoneFoundException
	 */
	public Drug getDrugById(String id) throws DrugNoneFoundException{
		for (Drug drug : drugs) {
			if (drug.getId().equals(id)) {
				return drug;
			}else {
				continue;
			}
		}
		//ȫ����������֮�����û�ҵ��������׳�Exception
			throw new DrugNoneFoundException();
	}
}
