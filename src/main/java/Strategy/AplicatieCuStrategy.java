package Strategy;

import ro.ulbs.proiectaresoftware.students.Student;

import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {
    public static void main(String[] args) {

        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70f),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10f),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90f),
                new Student(1029, "Bianca", "Popescu", "TI131/1", 10f),
                new Student(1029, "Maria", "Pana", "TI131/2", 4.10f),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2", 7.33f),
                new Student(1029, "Marius", "Nasta", "TI131/2", 3.20f),
                new Student(1029, "Marius", "Nasta", "TI131/1", 5.12f),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22f)
        );

        Exporter exporter = new Exporter();
        SettingsHolder settings = SettingsHolder.getInstance();

        // a)
        exporter.startExport(new StudentiInConsola(), studenti);

        // b)
        String txtFile = settings.getSetting("txtExportPath");
        exporter.startExport(new StudentiInFisierText(txtFile), studenti);

        // c)
        String xlsxFile = settings.getSetting("xlsxExportPath");
        exporter.startExport(new StudentiInFisierXlsx(xlsxFile), studenti);

        System.out.println("\n --Toate strategiile de export au fost rulate.-- ");
    }
}
