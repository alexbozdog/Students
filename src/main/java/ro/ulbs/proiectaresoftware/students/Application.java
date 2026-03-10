package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.util.List;

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

        List<Student> listaStudenti = new ArrayList<>();

        listaStudenti.add(new Student(112, "Ioan", "Popa", "TI21/1"));
        listaStudenti.add(new Student(112, "Maria", "Oprea", "TI21/1"));
        listaStudenti.add(new Student(120, "Alis", "Popa", "TI21/2"));
        listaStudenti.add(new Student(122, "Mihai", "Vecerdea", "TI22/1"));
        listaStudenti.add(new Student(122, "Eugen", "Uritescu", "TI22/2"));

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
        for(Student s : listaStudenti){
            System.out.println(s);
        }
        // b)
        Student s1 = new Student(120,"Alis","Popa","TI21/2");
        System.out.println(existaStudent(listaStudenti, s1));

        //c)
        Student s2=new Student(112, "Maria", "Popa", "TI21/1");
        System.out.println(existaStudent(listaStudenti, s2));

    }


}

