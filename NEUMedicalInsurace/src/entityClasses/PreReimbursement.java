package entityClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * 预结算的实体类
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class PreReimbursement {
	
	private PrescriptionList prescriptionList;//
	private double sumPrice;//费用总额//
	private double baoxiaoPrice;//报销金额//
	private double selfPrice;//自费金额//
	private double yearSumPrice;//年度累计报销金额
	private double startPrice;//起付金额//
	private double topPrice;//报销封顶线//
	private double yiItemSelfPrice;//乙类项目自费金额//
	private double specialSelfPrice;//特检特治金额//
	private String name;//患者姓名//
	private String certificateCode;//证件编号//
	private Hospital Hospital;//就诊医院//
	private String stayHospital;//医院名字
	private String stayTime;//就诊时段//
	private double selfPriceA;//A段自费金额
	private double selfPriceB;//B段自费金额
	private double selfPriceC;//C段自费金额
	/**
	 * create a preReimbursement object by addmissionNumber
	 * @param addmissionNumber
	 * @throws PrescriptionNoneFoundException
	 * @throws CureMessageNoneFoundException 
	 */
	public PreReimbursement(String addmissionNumber) throws PrescriptionNoneFoundException, CureMessageNoneFoundException {
		//遍历prescriptionList,将所有金钱相加，即为总金额
		this.prescriptionList = new PrescriptionList(addmissionNumber);
		double price = 0d;
		for (Prescription prescription : prescriptionList) {
			price += prescription.getSumprice();
		}
		this.sumPrice = price;
		Person person = prescriptionList.getCureMessage().getPerson();
		//接下来的属性就是简单的读取操作，不做过多解释
		this.name = person.getName();
		this.certificateCode = person.getCertificateCode();
		this.Hospital = prescriptionList.getCureMessage().getHospital();
		this.stayHospital = this.Hospital.getName();
		this.stayTime = prescriptionList.getCureMessage().getInDate().toString() + "——" + prescriptionList.getCureMessage().getOutDate().toString();
		//该部分计算可以被报销的金额，注意，并不是最后的金额
		double sum = 0d;
		double yi = 0d;
		for(Prescription prescription : prescriptionList) {
			int drugLevel = 0;
			int hospitalLevel = 0;
			
			//将药物等级转化为int
			if (prescription.getDrug().getHospitalLevel().equals("一级")) {
				drugLevel = 1;
			}else if (prescription.getDrug().getHospitalLevel().equals("二级")) {
				drugLevel = 2;
			}else if (prescription.getDrug().getHospitalLevel().equals("三级")) {
				drugLevel = 3;
			}
			
			//将医院等级转化为int
			if (this.Hospital.getHospitalLevel().equals("一级")) {
				hospitalLevel = 1;
			}else if (this.Hospital.getHospitalLevel().equals("二级")) {
				hospitalLevel = 2;
			}else if (this.Hospital.getHospitalLevel().equals("三级")) {
				hospitalLevel = 3;
			}
			//分段计算
			if (drugLevel >= hospitalLevel && prescription.getDrug().getPriceLevel().equals("甲类")) {
				sum += prescription.getSumprice();
			}if (drugLevel >= hospitalLevel && prescription.getDrug().getPriceLevel().equals("乙类")) {
				sum += 0.5 * prescription.getSumprice();
				yi += 0.5 * prescription.getSumprice();
			}
		}
		this.baoxiaoPrice = sum;
		this.yiItemSelfPrice = yi;
		this.selfPrice = this.sumPrice - this.baoxiaoPrice;
		//特检特治目前不在考虑范围之内
		this.specialSelfPrice = 0d;
		this.topPrice = FileTool.getStartFile(person.getDoctorSort());
		this.startPrice = FileTool.getStartPrice();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        //计算ABC段自费金额
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
		//算出后得到真正的自费和报销金额
		this.selfPrice += this.selfPriceA + this.selfPriceB + this.selfPriceC + FileTool.getStartPrice();
		this.baoxiaoPrice = this.sumPrice - this.selfPrice;
		//判断是否超出封顶线
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
