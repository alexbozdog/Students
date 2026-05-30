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

        // a) Export in consola + Măsurare timp
        System.out.println("--- Export Consola ---");
        IStudentiExport exportConsola = new StudentiInConsola();
        IStudentiExport exportConsolaDecorat = new ExportTimeDecorator(exportConsola);
        exporter.startExport(exportConsolaDecorat, studenti);

        // b) Export fisier Text + Măsurare timp
        System.out.println("\n--- Export Fisier Text ---");
        String txtFile = settings.getSetting("txtExportPath");
        IStudentiExport exportText = new StudentiInFisierText(txtFile);
        IStudentiExport exportTextDecorat = new ExportTimeDecorator(exportText);
        exporter.startExport(exportTextDecorat, studenti);

        // c) Export fisier XLSX + Măsurare timp
        System.out.println("\n--- Export Fisier XLSX ---");
        String xlsxFile = settings.getSetting("xlsxExportPath");
        IStudentiExport exportXlsx = new StudentiInFisierXlsx(xlsxFile);
        IStudentiExport exportXlsxDecorat = new ExportTimeDecorator(exportXlsx);
        exporter.startExport(exportXlsxDecorat, studenti);

        System.out.println("\n --Toate strategiile de export au fost rulate.-- ");
    }
}