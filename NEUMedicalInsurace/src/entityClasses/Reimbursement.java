package entityClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
/**
 * 结算信息实体类
 * @author 	Whisky
 * @Time 2017-07-30
 *
 */
public class Reimbursement extends PreReimbursement {
	
	private String doctorSort;
	private int hospitalTime;
	private PreReimbursement preReimbursement;
	/**
	 * create a object by using addmissionNumber
	 * @param addmissionNumber
	 * @throws PrescriptionNoneFoundException
	 * @throws CureMessageNoneFoundException 
	 */
	public Reimbursement(String addmissionNumber) throws PrescriptionNoneFoundException, CureMessageNoneFoundException {
		super(addmissionNumber);
		this.preReimbursement = new PreReimbursement(addmissionNumber);
		this.doctorSort = this.preReimbursement.getPrescriptionList().getCureMessage().getPerson().getDoctorSort();
		int i = 1;
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/data/ReimbursementMessage.txt")));
			String string;
			StringTokenizer stringTokenizer;
			while((string = bufferedReader.readLine()) != null) {
				stringTokenizer = new StringTokenizer(string, "_");
				stringTokenizer.nextToken();
				stringTokenizer.nextToken();
				if (this.preReimbursement.getCertificateCode().equals(stringTokenizer.nextToken())) {
					i++;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.hospitalTime = i;
	}
	/**
	 * create a object by using all the properties
	 * @param addmissionNumber
	 * @param doctorSort
	 * @param hospitalTime
	 * @param preReimbursement
	 * @throws PrescriptionNoneFoundException
	 * @throws CureMessageNoneFoundException 
	 */
	public Reimbursement(String addmissionNumber, String doctorSort, int hospitalTime,
			PreReimbursement preReimbursement) throws PrescriptionNoneFoundException, CureMessageNoneFoundException {
		super(addmissionNumber);
		this.doctorSort = doctorSort;
		this.hospitalTime = hospitalTime;
		this.preReimbursement = preReimbursement;
	}
	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return this.preReimbursement.getPrescriptionList().getCureMessage().getAddmissionNumber() + "_" + this.getName() + "_" + this.getCertificateCode() + "_" + this.getStayHospital() + "_" + this.getStayTime() + "_" + this.getStartPrice() + "_" + this.getDoctorSort() + "_" + this.hospitalTime + "_" + this.getSelfPrice() + "_" + this.getBaoxiaoPrice();

	}
	
//	//将person对象写入文件
//	public void writeInFile() {
//		String string = this.doctorSort + "_" + this.hospitalTime + "_" + this.preReimbursement;
//		FileTool.writeInFile("src/data/PreRiembursementMessage.txt", string);
//	}
	
	
	/**
	 * compare two objects
	 * @param reimbursement
	 * @return
	 */
	public boolean equals(Reimbursement reimbursement) {
		if (this.preReimbursement.getPrescriptionList().getCureMessage().getAddmissionNumber().equals(reimbursement.getPreReimbursement().getPrescriptionList().getCureMessage().getAddmissionNumber())) {
			return true;
		}else {
			return false;
		}
	}

	public String getDoctorSort() {
		return doctorSort;
	}

	public void setDoctorSort(String doctorSort) {
		this.doctorSort = doctorSort;
	}

	public int getHospitalTime() {
		return hospitalTime;
	}

	public void setHospitalTime(int hospitalTime) {
		this.hospitalTime = hospitalTime;
	}

	public PreReimbursement getPreReimbursement() {
		return preReimbursement;
	}

	public void setPreReimbursement(PreReimbursement preReimbursement) {
		this.preReimbursement = preReimbursement;
	}
}
