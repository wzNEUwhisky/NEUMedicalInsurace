package application;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import entityClasses.*;
import javafx.fxml.FXML;
/**
 * 该类为报销界面控制器
 * @author 	Whisky
 * @Time 2018-07-31
 */
public class BaoXiaoController extends MainController {
//	PersonDB personDB = PersonDB.getPersonDB();
//	CureMessageDB cureMessages = CureMessageDB.getCureMessageDB();
//	PreReimbursementDB preReimbursements = PreReimbursementDB.getPreReimbursementDB();
//	ReimbursementDB reimbursementDB = ReimbursementDB.getReimbursementDB();
	PreReimbursement pReimbursement;
	@FXML
	private TextField addmissionNumberField;
	@FXML
	private TextField sumPriceField;
	@FXML
	private TextField baoxiaoPriceField;
	@FXML
	private TextField selfPriceField;
	@FXML
	private TextField yearBaoxiaoPriceField;
	@FXML
	private TextField startStandardField;
	@FXML
	private TextField topStandardField;
	@FXML
	private TextField secondItemSelfPriceField;
	@FXML
	private TextField specialPriceField;
	@FXML
	private Button calculateButton;
	@FXML
	private TextArea finalField;
	@FXML
	private TextField tishiField;
	@FXML
	private Button dayinButton;
	/**
	 * 与报销按钮功能
	 */
	@FXML
	public void yubaoxiao() {
		boolean found = false;
		boolean foundCur = false;
		String addmissionNumber = addmissionNumberField.getText();
		if (addmissionNumberField.getText().length() != 0) {
			for(CureMessage cureMessage : CureMessageDB.loadCureMessages()) {
				if (cureMessage.getAddmissionNumber().equals(addmissionNumber)) {
					foundCur = true;
					if (!(PreReimbursementDB.loadPreReimbursementDB().isEmpty())) {
						for (PreReimbursement preReimbursement :PreReimbursementDB.loadPreReimbursementDB()) {
							if (preReimbursement.getPrescriptionList().getCureMessage().getAddmissionNumber().equals(addmissionNumber)) {
								sumPriceField.setVisible(true);
								baoxiaoPriceField.setVisible(true);
								selfPriceField.setVisible(true);
								yearBaoxiaoPriceField.setVisible(true);
								startStandardField.setVisible(true);
								topStandardField.setVisible(true);
								secondItemSelfPriceField.setVisible(true);
								specialPriceField.setVisible(true);
								calculateButton.setVisible(true);
								finalField.setVisible(true);
								sumPriceField.setText(new Double(preReimbursement.getSumPrice()).toString());
								baoxiaoPriceField.setText(new Double(preReimbursement.getBaoxiaoPrice()).toString());
								selfPriceField.setText(new Double(preReimbursement.getSelfPrice()).toString());
								yearBaoxiaoPriceField.setText(new Double(preReimbursement.getYearSumPrice()).toString());
								startStandardField.setText(new Double(preReimbursement.getStartPrice()).toString());
								topStandardField.setText(new Double(preReimbursement.getTopPrice()).toString());
								secondItemSelfPriceField.setText(new Double(preReimbursement.getYiItemSelfPrice()).toString());
								specialPriceField.setText(new Double(preReimbursement.getSpecialSelfPrice()).toString());
								pReimbursement = preReimbursement;
								tishiField.setText("预结算成功");
							}else {
								try {
									pReimbursement = new PreReimbursement(addmissionNumber);
									sumPriceField.setVisible(true);
									baoxiaoPriceField.setVisible(true);
									selfPriceField.setVisible(true);
									yearBaoxiaoPriceField.setVisible(true);
									startStandardField.setVisible(true);
									topStandardField.setVisible(true);
									secondItemSelfPriceField.setVisible(true);
									specialPriceField.setVisible(true);
									calculateButton.setVisible(true);
									finalField.setVisible(true);
									sumPriceField.setText(new Double(pReimbursement.getSumPrice()).toString());
									baoxiaoPriceField.setText(new Double(pReimbursement.getBaoxiaoPrice()).toString());
									selfPriceField.setText(new Double(pReimbursement.getSelfPrice()).toString());
									yearBaoxiaoPriceField.setText(new Double(pReimbursement.getYearSumPrice()).toString());
									startStandardField.setText(new Double(pReimbursement.getStartPrice()).toString());
									topStandardField.setText(new Double(pReimbursement.getTopPrice()).toString());
									secondItemSelfPriceField.setText(new Double(pReimbursement.getYiItemSelfPrice()).toString());
									specialPriceField.setText(new Double(pReimbursement.getSpecialSelfPrice()).toString());
									tishiField.setText("预结算成功");
									FileTool.writeInFile("src/data/PreReimbursementMessage.txt", pReimbursement.toString()+"\r\n");
								} catch (PrescriptionNoneFoundException e) {
									// TODO Auto-generated catch block
									tishiField.setText("您没有处方信息，无法报销");
								} catch (CureMessageNoneFoundException e) {
									// TODO Auto-generated catch block
									tishiField.setText("您没有就诊信息，无法报销");
								}
							}
						}
					}else {
							try {
								pReimbursement = new PreReimbursement(addmissionNumber);
								sumPriceField.setVisible(true);
								baoxiaoPriceField.setVisible(true);
								selfPriceField.setVisible(true);
								yearBaoxiaoPriceField.setVisible(true);
								startStandardField.setVisible(true);
								topStandardField.setVisible(true);
								secondItemSelfPriceField.setVisible(true);
								specialPriceField.setVisible(true);
								calculateButton.setVisible(true);
								finalField.setVisible(true);
								sumPriceField.setText(new Double(pReimbursement.getSumPrice()).toString());
								baoxiaoPriceField.setText(new Double(pReimbursement.getBaoxiaoPrice()).toString());
								selfPriceField.setText(new Double(pReimbursement.getSelfPrice()).toString());
								yearBaoxiaoPriceField.setText(new Double(pReimbursement.getYearSumPrice()).toString());
								startStandardField.setText(new Double(pReimbursement.getStartPrice()).toString());
								topStandardField.setText(new Double(pReimbursement.getTopPrice()).toString());
								secondItemSelfPriceField.setText(new Double(pReimbursement.getYiItemSelfPrice()).toString());
								specialPriceField.setText(new Double(pReimbursement.getSpecialSelfPrice()).toString());
								tishiField.setText("预结算成功");
								FileTool.writeInFile("src/data/PreReimbursementMessage.txt", pReimbursement.toString()+"\r\n");
							} catch (PrescriptionNoneFoundException e) {
								// TODO Auto-generated catch block
								tishiField.setText("您没有处方信息，无法报销");
							} catch (CureMessageNoneFoundException e) {
								// TODO Auto-generated catch block
								tishiField.setText("您没有就诊信息，无法报销");
							}
						}
				}else {
					continue;
				}
			}if (foundCur == false) {
				tishiField.setText("无效的住院号，请重新输入");
			}
		}else {
			tishiField.setText("请输入住院号");
		}
	}
	/**
	 * 报销按钮功能
	 */
	@FXML
	public void calculate() {
		boolean find = false;
		try {
			for (Reimbursement reimbursement : ReimbursementDB.loadReimbursementDB()) {
				if (reimbursement.getPrescriptionList().getCureMessage().getAddmissionNumber().equals(addmissionNumberField.getText())) {
					find = true;
				}
			}
			if (find == false) {
				Reimbursement reimbursement = new Reimbursement(addmissionNumberField.getText());
				StringBuilder sBuilder = new StringBuilder();
				sBuilder.append("姓名:");
				sBuilder.append(reimbursement.getName());
				sBuilder.append("\n");
				sBuilder.append("证件编号:");
				sBuilder.append(reimbursement.getCertificateCode());
				sBuilder.append("\n");
				sBuilder.append("就诊医院:");
				sBuilder.append(reimbursement.getStayHospital());
				sBuilder.append("\n");
				sBuilder.append("就诊时段:");
				Date out = reimbursement.getPrescriptionList().getCureMessage().getOutDate();
				Date in = reimbursement.getPrescriptionList().getCureMessage().getInDate();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(in);
				String outString = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
				sBuilder.append(outString + "——");
				calendar.setTime(out);
				String inString = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
				sBuilder.append(inString);
				sBuilder.append("\n");
				sBuilder.append("起付标准:");
				sBuilder.append(reimbursement.getStartPrice());
				sBuilder.append("\n");
				sBuilder.append("人员类别:");
				sBuilder.append(reimbursement.getDoctorSort());
				sBuilder.append("\n");
				sBuilder.append("住院次数:");
				sBuilder.append(reimbursement.getHospitalTime());
				sBuilder.append("\n");
				sBuilder.append("个人自费费用:");
				sBuilder.append(reimbursement.getSelfPrice());
				sBuilder.append("\n");
				sBuilder.append("中心报销金额:");
				sBuilder.append(reimbursement.getBaoxiaoPrice());
				sBuilder.append("\n");
				finalField.setText(sBuilder.toString());
				tishiField.setText("结算成功!");
				FileTool.writeInFile("src/data/ReimbursementMessage.txt", reimbursement.toString()+"\r\n");
			}else {
				finalField.setText("该次住院已经结算，无法重新结算！");
			}
		} catch (PrescriptionNoneFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CureMessageNoneFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	public void dayin() {
		try {
			WritableWorkbook book = Workbook.createWorkbook(new File("src/data/dayin.xls"));
			WritableSheet sheetOne = book.createSheet("沈阳市医疗保险费用结算清单", 0);
			WritableFont font = new WritableFont(WritableFont.ARIAL,11,WritableFont.NO_BOLD,false,
					UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK);
			WritableCellFormat bord = new WritableCellFormat(font);
			bord.setBackground(jxl.format.Colour.WHITE);
			bord.setAlignment(jxl.format.Alignment.CENTRE);
			bord.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
			WritableCellFormat mainTitle = new WritableCellFormat(font);
			mainTitle.setBackground(jxl.format.Colour.WHITE);
			mainTitle.setAlignment(jxl.format.Alignment.CENTRE);
			mainTitle.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
			WritableCellFormat dateMessage = new WritableCellFormat(font);
			dateMessage.setBackground(jxl.format.Colour.WHITE);
			dateMessage.setAlignment(jxl.format.Alignment.RIGHT);
			dateMessage.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
			WritableCellFormat lotsMessage = new WritableCellFormat(font);
			lotsMessage.setBackground(jxl.format.Colour.WHITE);
			lotsMessage.setAlignment(jxl.format.Alignment.LEFT);
			lotsMessage.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
			sheetOne.setColumnView(0, 15);
			sheetOne.setColumnView(1, 15);
			sheetOne.setColumnView(2, 15);
			sheetOne.setColumnView(3, 15);
			sheetOne.setColumnView(4, 15);
			sheetOne.setColumnView(5, 15);
			sheetOne.setColumnView(6, 15);
			String addmissionNumber = addmissionNumberField.getText();
			Reimbursement reimbursement = new Reimbursement(addmissionNumber);
			Label labelTitle = new Label(0,0,"沈阳市医疗保险费用结算清单",mainTitle);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date date = new Date();
			Label labelDate = new Label(0,1,"结算日期" + sdf.format(date),dateMessage);
			Label labelName = new Label(0,2,"患者姓名",bord);
			Label labelNameField = new Label(1,2,reimbursement.getName(),bord);
			Label labelAddmissionNumber = new Label(3,2,"住院号码",bord);
			Label labelAddmissionNumberField = new Label(4,2,reimbursement.getPrescriptionList().getCureMessage().getAddmissionNumber(),bord);
			Label labelDorctorSort = new Label(5,2,"人员类别",bord);
			String temp = null;
			if (reimbursement.getPrescriptionList().getCureMessage().getPerson().getDoctorSort().equals("11")) {
				temp = "在职人员";
			}else if(reimbursement.getPrescriptionList().getCureMessage().getPerson().getDoctorSort().equals("21")){
				temp = "退休人员";
			}else if(reimbursement.getPrescriptionList().getCureMessage().getPerson().getDoctorSort().equals("40")){
				temp = "在职低保人员";
			}else if(reimbursement.getPrescriptionList().getCureMessage().getPerson().getDoctorSort().equals("41")){
				temp = "退休低保人员";
			}
			Label labelDorctorSortField = new Label(6,2,temp,bord);
			Label labelReason = new Label(0,3,"申报原因",bord);
			Label labelReasonField = new Label(1,3,"",bord);
			Label labelSort = new Label(3,3,"报销类别",bord);
			Label labelSortField = new Label(4,3,"",bord);
			Label labelHospitalTime = new Label(5,3,"住院次数",bord);
			Label labelHospitalTimeField = new Label(6,3,(new Integer(reimbursement.getHospitalTime()-1)).toString(),bord);
			Label labelHospital = new Label(0,4,"就诊医院",bord);
			Label labelHospitalField = new Label(1,4,reimbursement.getPreReimbursement().getPrescriptionList().getCureMessage().getHospital().getName(),bord);
			Label labelStayTime = new Label(4,4,"就诊时段",bord);
			Date out = reimbursement.getPrescriptionList().getCureMessage().getOutDate();
			Date in = reimbursement.getPrescriptionList().getCureMessage().getInDate();
			StringBuilder sBuilder = new StringBuilder();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(in);
			String outString = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
			sBuilder.append(outString + "——");
			calendar.setTime(out);
			String inString = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
			sBuilder.append(inString);
			Label labelStayTimeField = new Label(5,4,sBuilder.toString(),bord);
			StringBuilder text = new StringBuilder();
			text.append("结算明细:" + "\n");
			text.append("起付标准:" + "\n");
			text.append((new Double(reimbursement.getStartPrice())).toString() + "\n");
			text.append("丙类自费项目：" + "\n");
			for (Prescription prescription: reimbursement.getPrescriptionList()) {
				if (prescription.getDrug().getPriceLevel().equals("丙类")) {
					text.append("药品名称：" + prescription.getDrug().getName() + "    数量：" + prescription.getAmount() + "\n");
				}
			}
			text.append("乙类项目：" + "\n");
			for (Prescription prescription: reimbursement.getPrescriptionList()) {
				if (prescription.getDrug().getPriceLevel().equals("乙类")) {
					text.append("药品名称：" + prescription.getDrug().getName() + "    数量：" + prescription.getAmount() + "\n");
				}
			}
			text.append("特检特治:" + "\n");
			for (Prescription prescription: reimbursement.getPrescriptionList()) {
				if (prescription.getDrug().getExamineMark().equals("是")) {
					text.append("药品名称：" + prescription.getDrug().getName() + "    数量：" + prescription.getAmount() + "\n");
				}
			}
			text.append("****************************************************************************************************************\n");
			text.append("个人自费费用:  " + reimbursement.getSelfPrice() + "\n");
			text.append("中心报销金额：  " + reimbursement.getBaoxiaoPrice() + "\n");
			Label lotMessage = new Label(0,5,text.toString(),lotsMessage);
			Label finalField = new Label(0,20,"本表一式三联，财务科、结算科、参保人各一联。",dateMessage);
			sheetOne.addCell(labelTitle);
			sheetOne.addCell(labelDate);
			sheetOne.addCell(labelName);
			sheetOne.addCell(labelNameField);
			sheetOne.addCell(labelAddmissionNumber);
			sheetOne.addCell(labelAddmissionNumberField);
			sheetOne.addCell(labelDorctorSort);
			sheetOne.addCell(labelDorctorSortField);
			sheetOne.addCell(labelReason);
			sheetOne.addCell(labelReasonField);
			sheetOne.addCell(labelSort);
			sheetOne.addCell(labelSortField);
			sheetOne.addCell(labelHospitalTime);
			sheetOne.addCell(labelHospitalTimeField);
			sheetOne.addCell(labelHospital);
			sheetOne.addCell(labelHospitalField);
			sheetOne.addCell(labelStayTime);
			sheetOne.addCell(labelStayTimeField);
			sheetOne.addCell(lotMessage);			
			sheetOne.addCell(finalField);
			sheetOne.mergeCells(0, 0, 6, 0);
			sheetOne.mergeCells(0, 1, 6, 1);
			sheetOne.mergeCells(1, 2, 2, 2);
			sheetOne.mergeCells(1, 3, 2, 3);
			sheetOne.mergeCells(1, 4, 3, 4);
			sheetOne.mergeCells(5, 4, 6, 4);
			sheetOne.mergeCells(0, 5, 6, 19);
			sheetOne.mergeCells(0, 20, 6, 20);
			book.write();
			book.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PrescriptionNoneFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CureMessageNoneFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
