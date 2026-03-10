package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static boolean existaStudent(List<Student> lista, Student s) {
        for (Student st : lista) {
            if (st.getPrenume().equals(s.getPrenume()) &&
                    st.getNume().equals(s.getNume()) &&
                    st.getFormatieDeStudiu().equals(s.getFormatieDeStudiu())) {
                return true;
            }
        }
        return false;
    }

    public static void main() {

        Set<Student> studenti = new HashSet<>();

        studenti.add(new Student(112, "Ioan", "Popa", "TI21/1"));
        studenti.add(new Student(112, "Maria", "Oprea", "TI21/1"));
        studenti.add(new Student(120, "Alis", "Popa", "TI21/2"));
        studenti.add(new Student(122, "Mihai", "Vecerdea", "TI22/1"));
        studenti.add(new Student(122, "Eugen", "Uritescu", "TI22/2"));

     /*
        System.out.println(String.format("%15s %20s %15s",
                "numar matricol", "prenume nume", "formatieDeStudiu"));


        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
       */

        // a)
        for(Student s : studenti){
            System.out.println(s);
        }
        // b)
        System.out.println(studenti.contains(
                new Student(120,"Alis","Popa","TI21/2")));


        //c)
        System.out.println(studenti.contains(
                new Student(112,"Maria","Popa","TI21/1")));

    }


}

