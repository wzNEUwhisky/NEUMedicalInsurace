package entityClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.StringTokenizer;
/**
 * ����ΪҩƷ��ʵ����
 * @author 	Whisky
 * @Time 2018-07-30
 */
public class Drug {
	//��������
	private String id;//ҩƷ����
	private String name;//ҩƷ����
	private double highestPrice;//����޼�
	private String unit;//ҩƷ������λ
	private String priceLevel;//ҩƷ��Ŀ�շѵȼ�
	private String hospitalLevel;//ҽԺ�ȼ�
	
	//��ѡ����
	private String englishName = null;//Ӣ������
	private String prescriptionMark = null;//����ҩ��־
	private String priceSort = null;//�շ����
	private String hospitalMadeMark = null;//Ժ���Ƽ���־
	private Boolean examineMark = false;//�Ƿ���Ҫ������־ ,Ĭ��Ϊ��
	private String drugSort = null;//ҩ������
	private String useTime = null;//ʹ��Ƶ��
	private String useMethod = null;//ʹ�÷���
	private String useDays = null;//�޶�����
	private String drugProducter = null;//ҩƷ����
	private String comment = null;//��ע
	private String countryCatalogCode = null;//����Ŀ¼����
	private String useRange = null;//�������÷�Χ
	private String productLocation = null;//����
	/**
	 * this method will build a object if all the property has been known
	 * @param id
	 * @param name
	 * @param highestPrice
	 * @param unit
	 * @param priceLevel
	 * @param hospitalLevel
	 * @param examineMark
	 */
	public Drug(String id,String name,double highestPrice,String unit,String priceLevel,String hospitalLevel,boolean examineMark) {
		this.id = id;
		this.name = name;
		this.highestPrice = highestPrice;
		this.unit = unit;
		this.priceLevel = priceLevel;
		this.hospitalLevel = hospitalLevel;
		this.examineMark = examineMark;
	}
	/**
	 * this method will build a object by id
	 * @param id
	 */
	public Drug(String id) {
		File file = new File("src/data/DrugMessage.txt");
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
					this.highestPrice = Double.parseDouble(stringTokenizer.nextToken());
					this.unit = stringTokenizer.nextToken();
					this.priceLevel = stringTokenizer.nextToken();
					this.hospitalLevel = stringTokenizer.nextToken();
					if (stringTokenizer.nextToken() == "��") {
						this.examineMark = true;
					}else {
						this.examineMark = false;
					}
					
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
	 * this method will be used if the drug object need print out
	 */
	@Override
	public String toString() {
		String temp = null;
		if (this.examineMark == true) {
			temp = "��";
		}else {
			temp = "��";
		}
		return this.id + "_" + this.name + "_" + this.highestPrice + "_" + this.unit + "_" + this.priceLevel + "_" + this.hospitalLevel + "_" + temp;
	}
	/**
	 * two drugs will equal if their id is the same
	 * @param drug
	 * @return
	 */
	public boolean equals(Drug drug) {
		if (this.getId().equals(drug.getId())) {
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
	public double getHighestPrice() {
		return highestPrice;
	}
	public void setHighestPrice(double highestPrice) {
		this.highestPrice = highestPrice;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPriceLevel() {
		return priceLevel;
	}
	public void setPriceLevel(String priceLevel) {
		this.priceLevel = priceLevel;
	}
	public String getHospitalLevel() {
		return hospitalLevel;
	}
	public void setHospitalLevel(String hospitalLevel) {
		this.hospitalLevel = hospitalLevel;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public String getPrescriptionMark() {
		return prescriptionMark;
	}
	public void setPrescriptionMark(String prescriptionMark) {
		this.prescriptionMark = prescriptionMark;
	}
	public String getPriceSort() {
		return priceSort;
	}
	public void setPriceSort(String priceSort) {
		this.priceSort = priceSort;
	}
	public String getHospitalMadeMark() {
		return hospitalMadeMark;
	}
	public void setHospitalMadeMark(String hospitalMadeMark) {
		this.hospitalMadeMark = hospitalMadeMark;
	}
	public Boolean getExamineMark() {
		return examineMark;
	}
	public void setExamineMark(Boolean examineMark) {
		this.examineMark = examineMark;
	}
	public String getDrugSort() {
		return drugSort;
	}
	public void setDrugSort(String drugSort) {
		this.drugSort = drugSort;
	}
	public String getUseTime() {
		return useTime;
	}
	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}
	public String getUseMethod() {
		return useMethod;
	}
	public void setUseMethod(String useMethod) {
		this.useMethod = useMethod;
	}
	public String getUseDays() {
		return useDays;
	}
	public void setUseDays(String useDays) {
		this.useDays = useDays;
	}
	public String getDrugProducter() {
		return drugProducter;
	}
	public void setDrugProducter(String drugProducter) {
		this.drugProducter = drugProducter;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCountryCatalogCode() {
		return countryCatalogCode;
	}
	public void setCountryCatalogCode(String countryCatalogCode) {
		this.countryCatalogCode = countryCatalogCode;
	}
	public String getUseRange() {
		return useRange;
	}
	public void setUseRange(String useRange) {
		this.useRange = useRange;
	}
	public String getProductLocation() {
		return productLocation;
	}
	public void setProductLocation(String productLocation) {
		this.productLocation = productLocation;
	}
}
