package com.jsite.szy.dispatch.emergency.mconfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.jsite.core.config.Global;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class congfigModel {
	// 文件名
	static String path = Global.getConfig("uploadFile")+"WEB-INF/classes/com/jsite/szy/dispatch/emergency/mconfig/modelConfig.xls";
	// sheet名
	static String polutionP = "polutionRCD";
	static String modelBoundry = "modelBoundry";
	static String modelResvior = "modelResvior";
	static String modelSection = "modelSection";

	public static void main(String[] args) {
		Object[][] object;
		object = readExcel(path, polutionP, 3);

		/*System.out.println(object.length);
		for (int i = 0; i < object.length; i++) {

			for (int j = 0; j < 3; j++) {
				System.out.println(object[i][j]);
			}

		}*/
		
		
		/*List<modelResvior> list = getmodelResvior("4");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getRCD());
			System.out.println(list.get(i).getRESNM());
			System.out.println(list.get(i).getSTNM());

		}*/
		//System.out.println(getRNMfromRCD("1"));
		List<modelSection> list=getmodelSection("4") ;
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getRCD());
			System.out.println(list.get(i).getType());

		}
	}

	/**
	 * 新建方案时的发生污染河道 信息
	 */
	public static List<polutionP> getLocationList(String river) {
		List<polutionP> list = new ArrayList<polutionP>();
		Object[][] object = readExcel(path, polutionP, 3);

		for (int i = 0; i < object.length; i++) {
			if(river.equals(object[i][0].toString()));
			polutionP model = new polutionP();
			model.setRiver(object[i][0].toString());// 流域编号
			model.setRCD(object[i][1].toString());// 设置ID
			model.setRNM(object[i][2].toString());// 设置名称
			
			list.add(model);
		}

		return list;

	}
     
	// 应急事件溯源信息表中 根据RCD查找RVN
	public static String getRNMfromRCD(String rCD) {
		String rnm = null;

		List<polutionP> list = getLocationList("");

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getRCD().equals(rCD))
				rnm = list.get(i).getRNM();
		}

		return rnm;

	}

	/**
	 * 生成边界条件表头 生成list用
	 */
	public static List<modelBoundry> getModelBoundry(String rCD) {
		List<modelBoundry> list = new ArrayList<modelBoundry>();
		Object[][] object = readExcel(path, modelBoundry, 8);

		for (int i = 0; i < object.length; i++) {
			if (object[i][0].equals(rCD)){
			    modelBoundry model = new modelBoundry();
			
				model.setRCD(object[i][0].toString());// 设置ID
				model.setBtype(object[i][1].toString());
				model.setBname(object[i][2].toString());
				model.setVtype(object[i][3].toString());
				model.setSTCD(object[i][4].toString());
				model.setSTNM(object[i][5].toString());
			    list.add(model);
			}
		}

		return list;

	}
	
	/**
	 * 生成水库运行条件  参与水库
	 */
	public static List<modelResvior> getmodelResvior(String rCD) {
		List<modelResvior> list = new ArrayList<modelResvior>();
		Object[][] object = readExcel(path, modelResvior, 3);

		for (int i = 0; i < object.length; i++) {
			if (object[i][0].equals(rCD)){
				modelResvior model = new modelResvior();
			
				model.setRCD(object[i][0].toString());// 设置ID
				model.setRESNM(object[i][1].toString());
				model.setSTNM(object[i][2].toString());
				
			    list.add(model);
			}
		}

		return list;

	}
	
	/**
	 * 生成水库运行条件  河道section
	 */
	public static List<modelSection> getmodelSection(String rCD) {
		List<modelSection> list = new ArrayList<modelSection>();
		Object[][] object = readExcel(path, modelSection, 6);

		for (int i = 0; i < object.length; i++) {
			if (object[i][0].equals(rCD)){
				modelSection model = new modelSection();
			
				model.setRCD(object[i][0].toString());// 设置ID
				model.setNid(Integer.parseInt(object[i][1].toString()));
				model.setSecID(object[i][2].toString());
				model.setType(object[i][3].toString());
				model.setName(object[i][4].toString());
				model.setFid(Integer.parseInt(object[i][5].toString()));
			    list.add(model);
			}
		}

		return list;

	}
	
	
	public static Object[][] readExcel(String filename, String sheetname,
			int column) {
		Object[][] object = null;

		Workbook wb;
		try {

			InputStream is1 = new FileInputStream(filename);
			wb = Workbook.getWorkbook(is1);
			Sheet sheet1 = wb.getSheet(sheetname);
			int rowth = sheet1.getRows();// 总行数
			int rowlen = 0;// 非空的总行数
			for (int i = 0; i < rowth; i++) {
				if (sheet1.getCell(column - 1, i).getContents().equals("")) {
					break;
				}
				rowlen++;
			}
			object = new Object[rowlen - 1][column];
			/*
			 * System.out.println("" + rowth); System.out.println("" + rowlen);
			 */

			for (int i = 1; i < rowlen; i++) {

				for (int j = 0; j < column; j++) {
					if (sheet1.getCell(j, i).getContents().equals("")) {
						break;
					}
					object[i - 1][j] = sheet1.getCell(j, i).getContents()
							.trim();// 实测序列 此处第1列 ()
				}

			}

		} catch (FileNotFoundException e) {
			System.out.println("读取文件失败");
		} catch (BiffException e) {
			System.out.println("声明失败");
		} catch (IOException e) {
			System.out.println("声明失败");
		}

		return object;

	}

}
