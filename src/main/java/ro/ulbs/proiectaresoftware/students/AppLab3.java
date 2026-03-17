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

        listaStudenti.sort(Comparator.comparing(Student::getNume));

        List<String> rezultat = new ArrayList<>();
        for (Student s : listaStudenti) {
            rezultat.add(s.toString());
        }
        Files.write(pathOut, rezultat);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
