package com.bksoft.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public static void main(String[] args) throws IOException {
		ReadExcel excel = new ReadExcel();
		excel.readExcelSheet("OnBoardData");
	}

	void readExcelSheet(String name) throws IOException {
		FileInputStream path;
		
			path = new FileInputStream(
					"C:\\Users\\bikashs\\eclipse-workspace\\seleniumPractice\\ExcelFiles\\Employee_data.xlsx");
			workbook = new XSSFWorkbook(path);

		sheet = workbook.getSheet(name);

		int lastRow = sheet.getLastRowNum();
		int lastCell = sheet.getRow(lastRow).getLastCellNum();

		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				XSSFCell cellData = sheet.getRow(i).getCell(j);
				System.out.print(cellData + " ");
			}
			System.out.println();
		}

	}

}
