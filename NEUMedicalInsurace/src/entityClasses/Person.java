package entityClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.TimeZone;
/**
 * ��������Ա��ʵ����
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class Person {
	
	//��������
	private String id;
	private String certificateType;//֤������
	private String certificateCode;//֤�����
	private String name;//����
	private String gender;//�Ա�
	private String nation;//����
	private Date birthDate;//��������
	private String doctorSort;//ҽ����Ա���
	
	//�Ǳ�������
	private Date workAttendTime = null;//�μӹ�������
	private Date leaveTime = null;//��������
	private Boolean leaveStatus = null;//������״̬
	private String residenceNature = null;//��������
	private String residenceAddress = null;//�������ڵ�
	private String cultureLevel = null;//�Ļ��̶�
	private String politicsStatus = null;//������ò
	private String personIdentity = null;//�������
	private String employmentForm = null;//�ù���ʽ
	private String professionalPosts = null;//רҵ�˼���ְ��
	private String quanlifiationGrade = null;//����ְҵ�ʸ�ȼ�
	private String marriedStatus = null;//����״��
	private String governmentDuty = null;//����ְ��
	private String workUnitCode = null;//��λ����
	private String healthyStatus = null;//����״��
	private String modelWorkerMark = null;//��ģ��־
	private String leaderMark = null;//�ɲ���־
	private String civilServantMark = null;//����Ա��־
	private String inMark = null;//�ڱ��־
	private String residentMark = null;//�����־
	private String flexibleWorkMark = null;//����ҵ��־
	private String peasantWorkerMark = null;//ũ�񹤱�־
	private String employerMark = null;//������־
	private String soilderTurningMark = null;//��ת��Ա��־
	private String socialSecurityCardNumber = null;//�籣����
	private String medicalInstitution = null;//����ҽ�ƻ�������
	/**
	 * create person object by using id
	 * @param id
	 */
	public Person(String id) throws ParseException{
		File file = new File("src/data/personMessage.txt");
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
					this.certificateType = stringTokenizer.nextToken();
					this.certificateCode = stringTokenizer.nextToken();
					this.name = stringTokenizer.nextToken();
					this.nation = stringTokenizer.nextToken();
					DateFormat df = DateFormat.getDateInstance();
					this.birthDate = df.parse(stringTokenizer.nextToken());
					this.gender = stringTokenizer.nextToken();
					this.doctorSort = stringTokenizer.nextToken();
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
	 * create person object by using all the properties
	 * @param id
	 * @param certificateType
	 * @param certificateCode
	 * @param name
	 * @param gender
	 * @param nation
	 * @param birthDate
	 * @param doctorSort
	 */
	public Person(String id,String certificateType,String certificateCode,String name,String gender,String nation, Date birthDate, String doctorSort) {
		this.id = id;
		this.certificateType = certificateType;
		this.certificateCode = certificateCode;
		this.name = name;
		this.gender = gender;
		this.nation = nation;
		this.birthDate = birthDate;
		this.doctorSort = doctorSort;
	}
	/**
	 * toString method
	 */
	@Override
	public String toString() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.birthDate);
		return this.id + "_" + this.certificateType + "_" + this.certificateCode + "_" + this.name + "_" + this.nation + "_" + calendar.get(Calendar.YEAR)+ "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + "_" + this.gender + "_" + this.doctorSort;
	}
	
	/**
	 * write person object into File
	 */
//	public void writeInFile() {
//		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
//		calendar.setTime(this.birthDate);
//		String string = this.id + "_" + this.certificateType + "_" + this.certificateCode + "_" + this.name + "_" + this.nation + "_" + calendar.get(Calendar.YEAR)+ "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + "_" + this.gender + "_" + this.doctorSort;
//		//Ĭ��ϵͳwindows10
//		FileTool.writeInFile("src/data/personMessage.txt", string + "\r\n" );
//	}
	
	
	//��дequals����
	public boolean equals(Person person) {
		if (this.getId().equals(person.getId())) {
			return true;
		}else {
			return false;
		}
	}
	//����
//	public static void main(String[] args) {
//		Person person = new Person("CNSY00001");
//		System.out.println(person);
//	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCertificateType() {
		return certificateType;
	}
	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}
	public String getCertificateCode() {
		return certificateCode;
	}
	public void setCertificateCode(String certificateCode) {
		this.certificateCode = certificateCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getWorkAttendTime() {
		return workAttendTime;
	}
	public void setWorkAttendTime(Date workAttendTime) {
		this.workAttendTime = workAttendTime;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	public Boolean getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(Boolean leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public String getResidenceNature() {
		return residenceNature;
	}
	public void setResidenceNature(String residenceNature) {
		this.residenceNature = residenceNature;
	}
	public String getResidenceAddress() {
		return residenceAddress;
	}
	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}
	public String getCultureLevel() {
		return cultureLevel;
	}
	public void setCultureLevel(String cultureLevel) {
		this.cultureLevel = cultureLevel;
	}
	public String getPoliticsStatus() {
		return politicsStatus;
	}
	public void setPoliticsStatus(String politicsStatus) {
		this.politicsStatus = politicsStatus;
	}
	public String getPersonIdentity() {
		return personIdentity;
	}
	public void setPersonIdentity(String personIdentity) {
		this.personIdentity = personIdentity;
	}
	public String getEmploymentForm() {
		return employmentForm;
	}
	public void setEmploymentForm(String employmentForm) {
		this.employmentForm = employmentForm;
	}
	public String getProfessionalPosts() {
		return professionalPosts;
	}
	public void setProfessionalPosts(String professionalPosts) {
		this.professionalPosts = professionalPosts;
	}
	public String getQuanlifiationGrade() {
		return quanlifiationGrade;
	}
	public void setQuanlifiationGrade(String quanlifiationGrade) {
		this.quanlifiationGrade = quanlifiationGrade;
	}
	public String getMarriedStatus() {
		return marriedStatus;
	}
	public void setMarriedStatus(String marriedStatus) {
		this.marriedStatus = marriedStatus;
	}
	public String getGovernmentDuty() {
		return governmentDuty;
	}
	public void setGovernmentDuty(String governmentDuty) {
		this.governmentDuty = governmentDuty;
	}
	public String getWorkUnitCode() {
		return workUnitCode;
	}
	public void setWorkUnitCode(String workUnitCode) {
		this.workUnitCode = workUnitCode;
	}
	public String getDoctorSort() {
		return doctorSort;
	}
	public void setDoctorSort(String doctorSort) {
		this.doctorSort = doctorSort;
	}
	public String getHealthyStatus() {
		return healthyStatus;
	}
	public void setHealthyStatus(String healthyStatus) {
		this.healthyStatus = healthyStatus;
	}
	public String getModelWorkerMark() {
		return modelWorkerMark;
	}
	public void setModelWorkerMark(String modelWorkerMark) {
		this.modelWorkerMark = modelWorkerMark;
	}
	public String getLeaderMark() {
		return leaderMark;
	}
	public void setLeaderMark(String leaderMark) {
		this.leaderMark = leaderMark;
	}
	public String getCivilServantMark() {
		return civilServantMark;
	}
	public void setCivilServantMark(String civilServantMark) {
		this.civilServantMark = civilServantMark;
	}
	public String getInMark() {
		return inMark;
	}
	public void setInMark(String inMark) {
		this.inMark = inMark;
	}
	public String getResidentMark() {
		return residentMark;
	}
	public void setResidentMark(String residentMark) {
		this.residentMark = residentMark;
	}
	public String getFlexibleWorkMark() {
		return flexibleWorkMark;
	}
	public void setFlexibleWorkMark(String flexibleWorkMark) {
		this.flexibleWorkMark = flexibleWorkMark;
	}
	public String getPeasantWorkerMark() {
		return peasantWorkerMark;
	}
	public void setPeasantWorkerMark(String peasantWorkerMark) {
		this.peasantWorkerMark = peasantWorkerMark;
	}
	public String getEmployerMark() {
		return employerMark;
	}
	public void setEmployerMark(String employerMark) {
		this.employerMark = employerMark;
	}
	public String getSoilderTurningMark() {
		return soilderTurningMark;
	}
	public void setSoilderTurningMark(String soilderTurningMark) {
		this.soilderTurningMark = soilderTurningMark;
	}
	public String getSocialSecurityCardNumber() {
		return socialSecurityCardNumber;
	}
	public void setSocialSecurityCardNumber(String socialSecurityCardNumber) {
		this.socialSecurityCardNumber = socialSecurityCardNumber;
	}
	public String getMedicalInstitution() {
		return medicalInstitution;
	}
	public void setMedicalInstitution(String medicalInstitution) {
		this.medicalInstitution = medicalInstitution;
	}
}
