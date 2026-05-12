package Strategy;

import ro.ulbs.proiectaresoftware.students.Student;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class StudentiInFisierXlsx implements IStudentiExport{
    private String fileName;

    public StudentiInFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fileOut = new FileOutputStream(fileName)) {

            Sheet sheet = workbook.createSheet("Studenti");
            int rowNum = 0;

            for (Student st : studenti) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(st.getNumarMatricol());
                row.createCell(1).setCellValue(st.getPrenume());
                row.createCell(2).setCellValue(st.getNume());
                row.createCell(3).setCellValue(st.getFormatieDeStudiu());
                row.createCell(4).setCellValue(st.getNota());
            }

            workbook.write(fileOut);
            System.out.println("Export XLSX finalizat cu succes in: " + fileName);
        } catch (IOException e) {
            System.err.println("Eroare la scrierea fisierului Excel: " + e.getMessage());
        }
    }
}
