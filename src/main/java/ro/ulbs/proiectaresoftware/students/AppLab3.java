package ro.ulbs.proiectaresoftware.students;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AppLab3
{public static void main(String[] args) {
    Path path = Paths.get("studenti_in.txt");
    Path pathOut = Paths.get("studenti_out.txt");
    Path pathOutSorted = Paths.get("studenti_out_sorted.txt");
    try {

        List<String> ss = Files.readAllLines(path);
        List<Student> listaStudenti = new ArrayList<>();

        for (String linie : ss) {
            if (!linie.trim().isEmpty()) {

                String[] bucati = linie.split(",");


                int nrMatricol = Integer.parseInt(bucati[0].trim());
                String prenume = bucati[1].trim();
                String nume = bucati[2].trim();
                String grupa = bucati[3].trim();


                Student s = new Student(nrMatricol, prenume, nume, grupa);

                listaStudenti.add(s);
                System.out.println(s);
            }
        }

        //listaStudenti.sort(Comparator.comparing(Student::getNume));
        /*List<String> liniiSortate = new ArrayList<>();
        for (Student s : listaStudenti) {
            // Folosim datele obiectului pentru a reconstrui linia (sau s.toString())
            liniiSortate.add(s.getNumarMatricol() + "," + s.getPrenume() + "," + s.getNume() + "," + s.getFormatieDeStudiu());
        }
        Files.write(pathOut, rezultat);
        */

        //Tema
        listaStudenti.sort(Comparator
                .comparing(Student::getFormatieDeStudiu)
                .thenComparing(Student::getNume));


        List<String> liniiSortate = new ArrayList<>();
        for (Student s : listaStudenti) {
            // Folosim datele obiectului pentru a reconstrui linia (sau s.toString())
            liniiSortate.add(s.getNumarMatricol() + "," + s.getPrenume() + "," + s.getNume() + "," + s.getFormatieDeStudiu());
        }

        Files.write(pathOutSorted, liniiSortate);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
