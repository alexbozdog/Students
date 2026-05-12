package Strategy;
import ro.ulbs.proiectaresoftware.students.Student;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierText implements IStudentiImport {
    private String fileName;

    public StudentiDinFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> doImport() {
        List<Student> lista = new ArrayList<>();
        try {
            List<String> linii = Files.readAllLines(Paths.get(fileName));
            for (String linie : linii) {
                if (linie.trim().isEmpty()) continue;
                String[] date = linie.split(",");
                if (date.length >= 4) {
                    lista.add(new Student(
                            Integer.parseInt(date[0].trim()),
                            date[1].trim(),
                            date[2].trim(),
                            date[3].trim(),
                            0f
                    ));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Eroare la importul din TXT: " + e.getMessage());
        }
        return lista;
    }

}
