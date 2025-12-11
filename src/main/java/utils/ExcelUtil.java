package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;

public class ExcelUtil {

    public static String getCellData(String sheetName, int rowNumber, int columnNumber) {
        try {
            // Load/open the file, allows java to read
            FileInputStream fis = new FileInputStream("src/main/resources/TestData.xlsx");
            //contains entire Excel file,contains all sheets inside it
            Workbook workbook = WorkbookFactory.create(fis);
            //this will go to the sheet inside excel
            Sheet sheet = workbook.getSheet(sheetName);
            // Read values from the row and columns inside excel
            Row row = sheet.getRow(rowNumber);
            Cell cell = row.getCell(columnNumber);
            // Return data as String, so we can use it in our test
            return cell.getStringCellValue();
        }
        catch (Exception e) { //file is missing,sheet/row/column name is wrong
            e.printStackTrace();
            return null;
        }
    }
}
