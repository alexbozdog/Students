package Strategy;

import ro.ulbs.proiectaresoftware.students.Student;

import java.util.List;

public class StudentiInConsola implements IStudentiExport {
    @Override
    public void doExport(List<Student> studenti) {
        System.out.println("--- Lista Studenti (Consola) ---");
        for (Student s : studenti) {
            System.out.println(s);
        }
    }
}
