package entityClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * Ԥ�����ʵ����
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class PreReimbursement {
	
	private PrescriptionList prescriptionList;//
	private double sumPrice;//�����ܶ�//
	private double baoxiaoPrice;//�������//
	private double selfPrice;//�Էѽ��//
	private double yearSumPrice;//����ۼƱ������
	private double startPrice;//�𸶽��//
	private double topPrice;//�����ⶥ��//
	private double yiItemSelfPrice;//������Ŀ�Էѽ��//
	private double specialSelfPrice;//�ؼ����ν��//
	private String name;//��������//
	private String certificateCode;//֤�����//
	private Hospital Hospital;//����ҽԺ//
	private String stayHospital;//ҽԺ����
	private String stayTime;//����ʱ��//
	private double selfPriceA;//A���Էѽ��
	private double selfPriceB;//B���Էѽ��
	private double selfPriceC;//C���Էѽ��
	/**
	 * create a preReimbursement object by addmissionNumber
	 * @param addmissionNumber
	 * @throws PrescriptionNoneFoundException
	 * @throws CureMessageNoneFoundException 
	 */
	public PreReimbursement(String addmissionNumber) throws PrescriptionNoneFoundException, CureMessageNoneFoundException {
		//����prescriptionList,�����н�Ǯ��ӣ���Ϊ�ܽ��
		this.prescriptionList = new PrescriptionList(addmissionNumber);
		double price = 0d;
		for (Prescription prescription : prescriptionList) {
			price += prescription.getSumprice();
		}
		this.sumPrice = price;
		Person person = prescriptionList.getCureMessage().getPerson();
		//�����������Ծ��Ǽ򵥵Ķ�ȡ�����������������
		this.name = person.getName();
		this.certificateCode = person.getCertificateCode();
		this.Hospital = prescriptionList.getCureMessage().getHospital();
		this.stayHospital = this.Hospital.getName();
		this.stayTime = prescriptionList.getCureMessage().getInDate().toString() + "����" + prescriptionList.getCureMessage().getOutDate().toString();
		//�ò��ּ�����Ա������Ľ�ע�⣬���������Ľ��
		double sum = 0d;
		double yi = 0d;
		for(Prescription prescription : prescriptionList) {
			int drugLevel = 0;
			int hospitalLevel = 0;
			
			//��ҩ��ȼ�ת��Ϊint
			if (prescription.getDrug().getHospitalLevel().equals("һ��")) {
				drugLevel = 1;
			}else if (prescription.getDrug().getHospitalLevel().equals("����")) {
				drugLevel = 2;
			}else if (prescription.getDrug().getHospitalLevel().equals("����")) {
				drugLevel = 3;
			}
			
			//��ҽԺ�ȼ�ת��Ϊint
			if (this.Hospital.getHospitalLevel().equals("һ��")) {
				hospitalLevel = 1;
			}else if (this.Hospital.getHospitalLevel().equals("����")) {
				hospitalLevel = 2;
			}else if (this.Hospital.getHospitalLevel().equals("����")) {
				hospitalLevel = 3;
			}
			//�ֶμ���
			if (drugLevel >= hospitalLevel && prescription.getDrug().getPriceLevel().equals("����")) {
				sum += prescription.getSumprice();
			}if (drugLevel >= hospitalLevel && prescription.getDrug().getPriceLevel().equals("����")) {
				sum += 0.5 * prescription.getSumprice();
				yi += 0.5 * prescription.getSumprice();
			}
		}
		this.baoxiaoPrice = sum;
		this.yiItemSelfPrice = yi;
		this.selfPrice = this.sumPrice - this.baoxiaoPrice;
		//�ؼ�����Ŀǰ���ڿ��Ƿ�Χ֮��
		this.specialSelfPrice = 0d;
		this.topPrice = FileTool.getStartFile(person.getDoctorSort());
		this.startPrice = FileTool.getStartPrice();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        //����ABC���Էѽ��
		this.yearSumPrice = FileTool.getSumBaoxiaoPrice(person.getCertificateCode(),sdf.format(date));
		if (this.baoxiaoPrice <= FileTool.getUpLevel(1)) {
			this.selfPriceA = (this.baoxiaoPrice - FileTool.getStartPrice()) * FileTool.getZifeiRate(1);
			this.selfPriceB = 0d;
			this.selfPriceC = 0d;
		}else if (this.baoxiaoPrice <= FileTool.getUpLevel(2) && this.baoxiaoPrice > FileTool.getUpLevel(1)) {
		    this.selfPriceA = (FileTool.getUpLevel(1) - FileTool.getStartPrice()) * FileTool.getZifeiRate(1);
			this.selfPriceB = (this.baoxiaoPrice - FileTool.getDownLevel(2)) * FileTool.getZifeiRate(2);
			this.selfPriceC = 0d;
		}else {
			this.selfPriceA = (FileTool.getUpLevel(1) - FileTool.getStartPrice()) * FileTool.getZifeiRate(1);
			this.selfPriceB = (FileTool.getUpLevel(2) - FileTool.getDownLevel(2)) * FileTool.getZifeiRate(2);
			this.selfPriceC = (this.baoxiaoPrice - FileTool.getDownLevel(3)) * FileTool.getZifeiRate(3);
		}
		//�����õ��������ԷѺͱ������
		this.selfPrice += this.selfPriceA + this.selfPriceB + this.selfPriceC + FileTool.getStartPrice();
		this.baoxiaoPrice = this.sumPrice - this.selfPrice;
		//�ж��Ƿ񳬳��ⶥ��
		if(this.baoxiaoPrice + this.yearSumPrice > this.topPrice) {
			this.baoxiaoPrice = this.topPrice - this.yearSumPrice;
			this.selfPrice = this.sumPrice - this.baoxiaoPrice;
		}
	}

	/**
	 * create a preReimbursement object by using all of the property
	 * @param prescriptionList
	 * @param sumPrice
	 * @param baoxiaoPrice
	 * @param selfPrice
	 * @param yearSumPrice
	 * @param startPrice
	 * @param topPrice
	 * @param yiItemSelfPrice
	 * @param specialSelfPrice
	 * @param name
	 * @param certificateCode
	 * @param Hospital
	 * @param stayTime
	 * @param selfPriceA
	 * @param selfPriceB
	 * @param selfPriceC
	 */
	public PreReimbursement(PrescriptionList prescriptionList, double sumPrice, double baoxiaoPrice, double selfPrice,
			double yearSumPrice, double startPrice, double topPrice, double yiItemSelfPrice, double specialSelfPrice,
			String name, String certificateCode, Hospital Hospital, String stayTime, double selfPriceA,
			double selfPriceB, double selfPriceC) {
		this.prescriptionList = prescriptionList;
		this.sumPrice = sumPrice;
		this.baoxiaoPrice = baoxiaoPrice;
		this.selfPrice = selfPrice;
		this.yearSumPrice = yearSumPrice;
		this.startPrice = startPrice;
		this.topPrice = topPrice;
		this.yiItemSelfPrice = yiItemSelfPrice;
		this.specialSelfPrice = specialSelfPrice;
		this.name = name;
		this.certificateCode = certificateCode;
		this.Hospital = Hospital;
		this.stayHospital = this.Hospital.getName();
		this.stayTime = stayTime;
		this.selfPriceA = selfPriceA;
		this.selfPriceB = selfPriceB;
		this.selfPriceC = selfPriceC;
	}
	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return this.prescriptionList.getCureMessage().getAddmissionNumber() + "_" + this.sumPrice + "_" + this.baoxiaoPrice + "_" + this.selfPrice 
				+ "_" + this.yearSumPrice + "_" + this.startPrice + "_" + this.topPrice 
				+ "_" + this.yiItemSelfPrice + "_" + this.specialSelfPrice + "_" + this.name + "_" + this.certificateCode 
				+ "_" + this.stayHospital + "_" + this.stayTime + "_" 
				+ this.selfPriceA + "_" + this.selfPriceB + "_" + this.selfPriceC;
	}
		
	
	/**
	 * compare two objects
	 * @param preReimbursement
	 * @return
	 */
	public boolean equals(PreReimbursement preReimbursement) {
		if (this.getPrescriptionList().getCureMessage().getAddmissionNumber().equals(preReimbursement.getPrescriptionList().getCureMessage().getAddmissionNumber())) {
			return true;
		}else {
			return false;
		}
	}
	public PrescriptionList getPrescriptionList() {
		return prescriptionList;
	}

	public void setPrescriptionList(PrescriptionList prescriptionList) {
		this.prescriptionList = prescriptionList;
	}

	public double getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}

	public double getBaoxiaoPrice() {
		return baoxiaoPrice;
	}

	public void setBaoxiaoPrice(double baoxiaoPrice) {
		this.baoxiaoPrice = baoxiaoPrice;
	}

	public double getSelfPrice() {
		return selfPrice;
	}

	public void setSelfPrice(double selfPrice) {
		this.selfPrice = selfPrice;
	}

	public double getYearSumPrice() {
		return yearSumPrice;
	}

	public void setYearSumPrice(double yearSumPrice) {
		this.yearSumPrice = yearSumPrice;
	}

	public double getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(double startPrice) {
		this.startPrice = startPrice;
	}

	public double getTopPrice() {
		return topPrice;
	}

	public void setTopPrice(double topPrice) {
		this.topPrice = topPrice;
	}

	public double getYiItemSelfPrice() {
		return yiItemSelfPrice;
	}

	public void setYiItemSelfPrice(double yiItemSelfPrice) {
		this.yiItemSelfPrice = yiItemSelfPrice;
	}

	public double getSpecialSelfPrice() {
		return specialSelfPrice;
	}

	public void setSpecialSelfPrice(double specialSelfPrice) {
		this.specialSelfPrice = specialSelfPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCertificateCode() {
		return certificateCode;
	}

	public void setCertificateCode(String certificateCode) {
		this.certificateCode = certificateCode;
	}

	

	public Hospital getHospital() {
		return Hospital;
	}


	public void setHospital(Hospital hospital) {
		Hospital = hospital;
	}


	public String getStayHospital() {
		return stayHospital;
	}


	public void setStayHospital(String stayHospital) {
		this.stayHospital = stayHospital;
	}


	public String getStayTime() {
		return stayTime;
	}

	public void setStayTime(String stayTime) {
		this.stayTime = stayTime;
	}

	public double getSelfPriceA() {
		return selfPriceA;
	}

	public void setSelfPriceA(double selfPriceA) {
		this.selfPriceA = selfPriceA;
	}

	public double getSelfPriceB() {
		return selfPriceB;
	}

	public void setSelfPriceB(double selfPriceB) {
		this.selfPriceB = selfPriceB;
	}

	public double getSelfPriceC() {
		return selfPriceC;
	}

	public void setSelfPriceC(double selfPriceC) {
		this.selfPriceC = selfPriceC;
	}
	
//	public static void main(String[] args) {
//		try {
//			PreReimbursement preReimbursement = new PreReimbursement("1234567890");
//			System.out.println(preReimbursement);
//		} catch (PrescriptionNoneFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
