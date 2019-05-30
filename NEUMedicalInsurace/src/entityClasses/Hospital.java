package entityClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
/**
 * 该类为医院的实体类
 * @author 	Whisky
 * @Time 2017-07-30
 */
public class Hospital {
	private String id;
	private String name;//默认医院名字无法重复
	private String hospitalLevel;
	private String hospitalSort;
	/**
	 * create Hospital by id
	 * @param id
	 */
	public Hospital(String id) {
		File file = new File("src/data/HospitalMessage.txt");
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String string;
			while((string = bufferedReader.readLine()) != null) {
				if (string.startsWith("#")) {
					continue;
				}
				StringTokenizer stringTokenizer = new StringTokenizer(string, "_");
				if(id.equals(stringTokenizer.nextToken())) {
					this.id = id;
					this.name = stringTokenizer.nextToken();
					this.hospitalLevel = stringTokenizer.nextToken();
					this.hospitalSort = stringTokenizer.nextToken();
				}
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	/**
	 * create Hospital if all of the property are known
	 * @param id
	 * @param name
	 * @param hospitalLevel
	 * @param hospitalSort
	 */
	public Hospital(String id, String name, String hospitalLevel, String hospitalSort) {
		super();
		this.id = id;
		this.name = name;
		this.hospitalLevel = hospitalLevel;
		this.hospitalSort = hospitalSort;
	}
	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return this.id + "_" + this.name + "_" + this.hospitalLevel + "_" + this.hospitalSort;
	}
	/**
	 * compare tow hospitals
	 * @param hospital
	 * @return
	 */
	public boolean equals(Hospital hospital) {
		if (this.getId().equals(hospital.getId())||this.getName().equals(hospital.getName())) {
			return true;
		}else {
			return false;
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHospitalLevel() {
		return hospitalLevel;
	}

	public void setHospitalLevel(String hospitalLevel) {
		this.hospitalLevel = hospitalLevel;
	}
}
