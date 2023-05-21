package gr.uoi.cse;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class XLSXReaderExample 
{
    public static void main(String[] args) 
    {
        try
        {
            // Provide the path to the XLSX file
            String filePath = "resources/IncomebyCountry.xlsx";

            FileInputStream file = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(file);

            System.out.println(workbook.getSheet("Income Index").getSheetName());
            System.out.println(workbook.getSheet("Income Index").getLastRowNum());
            System.out.println("====================================");
            // Get the number of sheets in the workbook
            int sheetCount = workbook.getNumberOfSheets();
            System.out.println("Number of sheets: " + sheetCount);

            // Iterate over each sheet in the workbook
            for (int i = 0; i < sheetCount; i++) 
            {
                Sheet sheet = workbook.getSheetAt(i);
                
                System.out.println("Sheet Name: " + sheet.getSheetName());
                System.out.println("Sheet Name: " + sheet);
                // Iterate over each row in the sheet
                if ("Income Index".equalsIgnoreCase(sheet.getSheetName()))
                {
                	int rowCount = sheet.getLastRowNum();
                    System.out.println("Row Count: " + rowCount);
                    
                    Row row = sheet.getRow(rowCount);
                    for (Cell cell : row) {
                      // Extract the cell value based on its data type
                      switch (cell.getCellType()) {
                          case STRING:
                              System.out.print(cell.getStringCellValue() + "\t");
                              break;
                          case NUMERIC:
                              System.out.print(cell.getNumericCellValue() + "\t");
                              break;
                          case BOOLEAN:
                              System.out.print(cell.getBooleanCellValue() + "\t");
                              break;
                          case BLANK:
                              System.out.print("[BLANK]\t");
                              break;
                          default:
                              System.out.print("[UNKNOWN]\t");
                      }
                  }
                    
//                	for (Row row : sheet) {
//                		int cellCount = row.getLastCellNum();
//                		 System.out.println("Cell count: " + cellCount);
//                        // Iterate over each cell in the row
//                        for (Cell cell : row) {
//                            // Extract the cell value based on its data type
//                            switch (cell.getCellType()) {
//                                case STRING:
//                                    System.out.print(cell.getStringCellValue() + "\t");
//                                    break;
//                                case NUMERIC:
//                                    System.out.print(cell.getNumericCellValue() + "\t");
//                                    break;
//                                case BOOLEAN:
//                                    System.out.print(cell.getBooleanCellValue() + "\t");
//                                    break;
//                                case BLANK:
//                                    System.out.print("[BLANK]\t");
//                                    break;
//                                default:
//                                    System.out.print("[UNKNOWN]\t");
//                            }
//                        }
//                        System.out.println();
//                }
                
                	System.out.println();
                	break;
                }

                System.out.println();
            }

            workbook.close();
            file.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
