package com.whut.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;

import com.whut.pojo.SysKc;

public class ExcelTools {

	public ExcelTools() {

	}

	//课程简介导入
	public List<SysKc> getKcjjList(String path) {
		List<SysKc> list = new ArrayList<SysKc>();
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(path));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();

			for (int i = 1; i < rows; i++) {
				SysKc sysKc = new SysKc();
				HSSFRow row = sheet.getRow(i);
				sysKc.setKcdm(getValueString(row.getCell(0)));
				sysKc.setKcjj(getValueString(row.getCell(1)));
				list.add(sysKc);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;

	}

	public String getValueString(HSSFCell cell) {
		cell.setCellType(Cell.CELL_TYPE_STRING);
		return cell.getRichStringCellValue().getString();
	}

}
