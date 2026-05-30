package Strategy;

import ro.ulbs.proiectaresoftware.students.Student;
import java.util.List;

public class ExportTimeDecorator implements IStudentiExport {

    private IStudentiExport exporterOriginal;

    public ExportTimeDecorator(IStudentiExport exporterOriginal) {
        this.exporterOriginal = exporterOriginal;
    }

    @Override
    public void doExport(List<Student> studenti) {

        long startTime = System.currentTimeMillis();

        exporterOriginal.doExport(studenti);

        long endTime = System.currentTimeMillis();
        long durata = endTime - startTime;

        System.out.println("Timpul de executie al exportului: " + durata + " milisecunde.");
    }
}