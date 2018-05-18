package yan.testdata;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class PogodaInput {
    private static String path = "src\\main\\java\\yan\\tmp\\";

    public static void writeIntoExcel(String file, ArrayList<DayInfo> listDays) {
        Workbook book = new HSSFWorkbook();
        file = path+file;
        Sheet sheet = book.createSheet("Etalon");

        int countRow = listDays.size();

        for(int i =0; i < countRow; i++){
            Row row = sheet.createRow(i);
            Cell name = row.createCell(0);
            name.setCellValue(listDays.get(i).nameDay);
            Cell temperatura = row.createCell(1);
            temperatura.setCellValue(listDays.get(i).temperature);
        }

        try {
            book.write(new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<DayInfo> readFromExcel(String file) {
        HSSFWorkbook myExcelBook = null;
        file = path+file;
        try {
            myExcelBook = new HSSFWorkbook(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        HSSFSheet myExcelSheet = myExcelBook.getSheet("Etalon"); // не обязательно

        int countRow = myExcelSheet.getLastRowNum();
        countRow++;
        ArrayList<DayInfo> listDays = new ArrayList<>();
        for(int i =0; i < countRow; i++){
            DayInfo day = new DayInfo();
            HSSFRow row = myExcelSheet.getRow(i);
            day.nameDay = row.getCell(0).getStringCellValue();
            day.temperature = row.getCell(1).getStringCellValue();
            listDays.add(day);
        }

        try {
            myExcelBook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listDays;

    }
}
