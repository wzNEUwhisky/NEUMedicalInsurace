package entityClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

import javax.print.attribute.standard.RequestingUserName;

import org.omg.CORBA.StringHolder;
/**
 * this class is the tool class for whole this project
 * @author 	Whisky
 * @Time 2017-07-30
 */
public class FileTool {
	private static BufferedReader bufferedReader;
	/**
	 * this method is used to clean the file to prepare for the writing in
	 * @param fileName
	 * @param firstLine
	 */
	public static void cleanFile(String fileName , String firstLine) {
		File file = new File(fileName);
		try {
			FileWriter fWriter = new FileWriter(file);
			fWriter.write(firstLine);
			fWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to write a String into a file
	 * @param fileName
	 * @param message
	 */
	public static void writeInFile(String fileName, String message) {
		File file = new File(fileName);
		try {
			FileWriter fWriter = new FileWriter(file, true);
			fWriter.write(message);
			fWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to get the most baoXiaoPrice
	 * @param doctorSort
	 * @return
	 */
	public static double getStartFile(String doctorSort) {
		File file = new File("src/data/医疗待遇计算参数.txt");
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			String string;
			while((string = bufferedReader.readLine()) != null) {
				if (string.startsWith("#")) {
					continue;
				}
				StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
				if (stringTokenizer.nextToken().startsWith("封顶线")) {
					String sort = stringTokenizer.nextToken();
					if (doctorSort.equals(sort)) {
						return Double.parseDouble(stringTokenizer.nextToken());
					}else {
						continue;
					}
				}else {
					continue;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return 0d;
	}
	/**
	 * this method is to get the startPrice
	 * @return
	 */
	public static double getStartPrice() {
		File file = new File("src/data/医疗待遇计算参数.txt");
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			String string;
			while((string = bufferedReader.readLine()) != null) {
				if (string.startsWith("#起付标准")) {
					StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
					String sort = bufferedReader.readLine();
					stringTokenizer = new StringTokenizer(sort, ",");
					return Double.parseDouble(stringTokenizer.nextToken());
				}else {
					continue;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return 0d;
	}
	/**
	 * this method is used to get downLevel by using the stage
	 * @param stage
	 * @return
	 */
	public static double getUpLevel(int stage) {
		File file = new File("src/data/医疗待遇计算参数.txt");
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			String string;
			while((string = bufferedReader.readLine()) != null) {
				if (string.startsWith("#起付标准")) {
					for (int i = 0; i < stage; i++) {
						string = bufferedReader.readLine();
					}
					StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
					stringTokenizer.nextToken();
					return Double.parseDouble(stringTokenizer.nextToken());
				}else {
					continue;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return 0d;
	}
	/**
	 * this method is used to get upLevel by using the stage
	 * @param stage
	 * @return
	 */
	public static double getDownLevel(int stage) {
		File file = new File("src/data/医疗待遇计算参数.txt");
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			String string;
			while((string = bufferedReader.readLine()) != null) {
				if (string.startsWith("#起付标准")) {
					for (int i = 0; i < stage; i++) {
						string = bufferedReader.readLine();
					}
					StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
					stringTokenizer.nextToken();
					stringTokenizer.nextToken();
					return Double.parseDouble(stringTokenizer.nextToken());
				}else {
					continue;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return 0d;
	}
	/**
	 * this method is used to get the selfPricerate by using the stage
	 * @param stage
	 * @return
	 */
	public static double getZifeiRate(int stage) {
		File file = new File("src/data/医疗待遇计算参数.txt");
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			String string;
			while((string = bufferedReader.readLine()) != null) {
				if (string.startsWith("#起付标准")) {
					for (int i = 0; i < stage; i++) {
						string = bufferedReader.readLine();
					}
					StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
					stringTokenizer.nextToken();
					stringTokenizer.nextToken();
					stringTokenizer.nextToken();
					return Double.parseDouble(stringTokenizer.nextToken());
				}else {
					continue;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return 0d;
	}
	/**
	 * this method is used to get the sumBaoXiaoPrice
	 * @param certificateNumber
	 * @return
	 */
	public static double getSumBaoxiaoPrice(String certificateNumber, String year) {
		double sum = 0d;
		String string = null;
		File file = new File("src/data/ReimbursementMessage.txt");
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			while((string = bufferedReader.readLine()) != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		        Date date = new Date();
		        String temp = sdf.format(date);
//		        StringTokenizer stringTokenizer = new StringTokenizer(string, "_");
//		        stringTokenizer.nextToken();
//		        stringTokenizer.nextToken();
//		        stringTokenizer.nextToken();
//		        stringTokenizer.nextToken();
//		        StringTokenizer stringTokenizer2 = new StringTokenizer(stringTokenizer.nextToken(), "——");
//		        stringTokenizer2.nextToken();
//		        String dateString = stringTokenizer2.nextToken();
//		        DateFormat dateFormat = DateFormat.getDateInstance();
//		        Date date2 = dateFormat.parse(dateString);
		        StringTokenizer stringTokenizer = new StringTokenizer(string, "_");
		        stringTokenizer.nextToken();
		        String getC = stringTokenizer.nextToken();
		        stringTokenizer.nextToken();
		        stringTokenizer.nextToken();
		        stringTokenizer.nextToken();
		        stringTokenizer.nextToken();
		        stringTokenizer.nextToken();
		        stringTokenizer.nextToken();
		        stringTokenizer.nextToken();
		        if (getC.equals(certificateNumber) && temp.equals(year)) {
					sum += Double.parseDouble(stringTokenizer.nextToken());
				}
		        
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return sum;
	}
}
