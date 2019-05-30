package entityClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.StringTokenizer;
/**
 * 该类为就诊信息的实体类
 * @author 	Whisky
 * @Time  2018-07-30
 * 
 */
public class CureMessage {
	private Person person;//人员
	private String addmissionNumber;//住院号
	private String cureSort;//医疗类别
	private Hospital hospital;//医院
	private Date inDate;//入院日期
	private Date outDate;//出院日期
	private String outReason;//出院原因
	
	/**
	 * this method use addmissionNumber to build the cureMessage object
	 * 
	 * @param addmissionNumber
	 * @throws CureMessageNoneFoundException 
	 * @throws if the hospital can not be found , it will throw HospitalNoneFoundException 
	 */
	public CureMessage(String addmissionNumber) throws HospitalNoneFoundException, CureMessageNoneFoundException {
		boolean found = false;
		File file = new File("src/data/CureMessage.txt");
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String string;
			while((string = bufferedReader.readLine()) != null) {
				if (string.startsWith("#")) {
					continue;
				}
				StringTokenizer stringTokenizer = new StringTokenizer(string, "_");
				stringTokenizer.nextToken();
				if(addmissionNumber.equals(stringTokenizer.nextToken())) {
					found = true;
					stringTokenizer = new StringTokenizer(string, "_");
					String id = stringTokenizer.nextToken();
					this.person = new Person(id);
					this.addmissionNumber = stringTokenizer.nextToken();
					String sort = stringTokenizer.nextToken();
					if (sort.equals("1")) {
						this.cureSort = "医院";
					}else {
						this.cureSort = "社区卫生服务中心";
					}
					String hospitalName = stringTokenizer.nextToken();
					this.hospital = HospitalDB.getHospitalDB().getHospitalByName(hospitalName);
					DateFormat dateFormat = DateFormat.getDateInstance();
					this.inDate = dateFormat.parse(stringTokenizer.nextToken());
					this.outDate = dateFormat.parse(stringTokenizer.nextToken());
					stringTokenizer.nextToken();
					this.outReason = stringTokenizer.nextToken();
				}else {
					continue;
				}
			}
			if (found == false) {
				throw new CureMessageNoneFoundException();
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
		
	}
	/**
	 * this method will be used to build a cureMessage project if all the property has been known
	 * @param person
	 * @param addmissionNumber
	 * @param cureSort
	 * @param hospital
	 * @param inDate
	 * @param outDate
	 * @param outReason
	 */
	public CureMessage(Person person, String addmissionNumber, String cureSort, Hospital hospital, Date inDate, Date outDate, String outReason) {
		this.person = person;
		this.addmissionNumber = addmissionNumber;
		this.cureSort = cureSort;
		this.hospital = hospital;
		this.inDate = inDate;
		this.outDate = outDate;
		this.outReason = outReason;
	}
	/**
	 * this method will return the string if the cureMessage object need to be print out
	 * 
	 */
	@Override
	public String toString() {
		return this.person.getId() + "_" + this.addmissionNumber + "_" + this.cureSort + "_" + this.hospital.getName() + "_" + this.inDate.toString() + "_" + this.outDate.toString() + "_" + this.outReason;
	}
	
	/**
	 * two cureMessages will equal if there addmissionNumber is same
	 * @param cureMessage
	 * @return 
	 */
	public boolean equals(CureMessage cureMessage) {
		if (this.getAddmissionNumber().equals(cureMessage.getAddmissionNumber())) {
			return true;
		}else {
			return false;
		}
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getAddmissionNumber() {
		return addmissionNumber;
	}

	public void setAddmissionNumber(String addmissionNumber) {
		this.addmissionNumber = addmissionNumber;
	}

	public String getCureSort() {
		return cureSort;
	}

	public void setCureSort(String cureSort) {
		this.cureSort = cureSort;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public String getOutReason() {
		return outReason;
	}

	public void setOutReason(String outReason) {
		this.outReason = outReason;
	} 
	
}
