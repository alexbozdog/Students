package Strategy;

import ro.ulbs.proiectaresoftware.students.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentiInFisierText implements IStudentiExport{
    private String fileName;

    public StudentiInFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        try {
            List<String> linii = new ArrayList<>();
            for (Student s : studenti) {
                linii.add(s.toString());
            }
            Files.write(Paths.get(fileName), linii);
            System.out.println("Export TXT finalizat cu succes in: " + fileName);
        } catch (IOException e) {
            System.err.println("Eroare la scrierea fisierului TXT: " + e.getMessage());
        }
    }
}
