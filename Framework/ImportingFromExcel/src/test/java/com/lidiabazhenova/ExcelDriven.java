package com.lidiabazhenova;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDriven {

    public static XSSFWorkbook wb;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static FileInputStream fis;

    public static void main(String[] args) throws IOException {
        String value = getCelldata(2, 2);
        System.out.println(value);
        String value1 = getCelldata(1, 2);
        System.out.println(value1);
        value = setCelldata("automation",2,2);
        System.out.println(value);
    }

    public static String getCelldata(int rownum, int col) throws IOException {
        fis = new FileInputStream("C:\\projects\\Selenium\\Framework\\ImportingFromExcel\\src\\test\\java\\com\\lidiabazhenova\\Data.xlsx");
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet("screen");
        row = sheet.getRow(rownum);
        cell = row.getCell(col);

        return cell.getStringCellValue();
    }

    public static String setCelldata(String text, int rownum, int col) throws IOException {
        fis = new FileInputStream("C:\\projects\\Selenium\\Framework\\ImportingFromExcel\\src\\test\\java\\com\\lidiabazhenova\\Data.xlsx");
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet("screen");
        row = sheet.getRow(rownum);
        cell = row.getCell(col);
        cell.setCellValue(text);

        return cell.getStringCellValue();
    }
}
