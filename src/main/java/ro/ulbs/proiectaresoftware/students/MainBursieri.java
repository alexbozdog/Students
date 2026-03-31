package ro.ulbs.proiectaresoftware.students;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainBursieri {

    public static void main(String[] args) {
        List<StudentBursieri> bursieri = new ArrayList<>();

        bursieri.add(new StudentBursieri(1025, "Andrei", "Popa", "ISM141/2", 8.70, 725.50));
        bursieri.add(new StudentBursieri(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10));
        bursieri.add(new StudentBursieri(1026, "Anamaria", "Prodan", "TI131/1", 8.90, 745.50));
        bursieri.add(new StudentBursieri(1029, "Bianca", "Popescu", "TI131/1", 9.10, 780.80));


        saveToFile("bursieri_out.txt", bursieri);
    }

    public static void saveToFile(String numeFisier, List<StudentBursieri> lista) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(numeFisier))) {
            for (StudentBursieri s : lista) {
                writer.println(s.toString());
            }
            System.out.println("Fișierul '" + numeFisier + "' a fost generat cu succes.");
        } catch (IOException e) {
            System.err.println("Eroare la scrierea fișierului: " + e.getMessage());
        }
    }
}
