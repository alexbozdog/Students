package ro.ulbs.proiectaresoftware.students;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
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


    //TEMA LAB4
    public static float gasesteNota(String prenume, String nume, Map<String, Student> tineri) {

        Student s = tineri.get(nume);

        if (s != null && s.getPrenume().equals(prenume)) {
            return s.getNota();
        }

        return 0.0f;
    }

    // 7.6.3 - muta un student in alta formatie, returneaza obiect NOU (imutabilitate)
    static Student schimbaFormatia(Student st, String nouaFormatieDeStudiu) {
        return new Student(st.getNumarMatricol(), st.getPrenume(),
                st.getNume(), nouaFormatieDeStudiu, st.getNota());
    }

    // 7.6.3 - imparte studentii in doua formatii de studiu cu dimensiune egala
    static Set<Student> imparteInDouaFormatii(Set<Student> studenti, String formatia1, String formatia2) {
        Set<Student> rezultat = new HashSet<>();
        List<Student> lista = new ArrayList<>(studenti);
        int jumatate = (lista.size() + 1) / 2; // prima formatie are 1 student in plus daca e numar impar

        for (int i = 0; i < lista.size(); i++) {
            String formatie = (i < jumatate) ? formatia1 : formatia2;
            rezultat.add(schimbaFormatia(lista.get(i), formatie));
        }
        return rezultat;
    }

    public static void main(String[] args) {
        {

//        Set<Student> studenti = new HashSet<>();
//        studenti.add(new Student(112, "Ioan", "Popa", "TI21/1"));
//        studenti.add(new Student(112, "Maria", "Oprea", "TI21/1"));
//        studenti.add(new Student(120, "Alis", "Popa", "TI21/2"));
//        studenti.add(new Student(122, "Mihai", "Vecerdea", "TI22/1"));
//        studenti.add(new Student(122, "Eugen", "Uritescu", "TI22/2"));

     /*
        System.out.println(String.format("%15s %20s %15s",
                "numar matricol", "prenume nume", "formatieDeStudiu"));


        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);

/*
         // a)
        for (Student s : studenti) {
            System.out.println(s);
        }
        // b)
        System.out.println(studenti.contains(
                new Student(120, "Alis", "Popa", "TI21/2")));


        //c)
        System.out.println(studenti.contains(
                new Student(112, "Maria", "Popa", "TI21/1")));
*/

            //lab9
            List<Student> studenti = Arrays.asList(
                    new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70f),
                    new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10),
                    new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90f),
                    new Student(1029, "Bianca", "Popescu", "TI131/1", 10),
                    new Student(1029, "Maria", "Pana", "TI131/2", 4.10f),
                    new Student(1029, "Gabriela", "Mohanu", "TI131/2", 7.33f),
                    new Student(1029, "Marius", "Nasta", "TI131/2", 3.20f),
                    new Student(1029, "Marius", "Nasta", "TI131/1", 5.12f),
                    new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22f)
            );

            // a)
            System.out.println("a) Studenti cu nota 10:");
            studenti.stream().filter(s -> s.getNota() == 10).forEach(System.out::println);

            // b)
            System.out.println("\nb) Studenti cu nota sub 5:");
            studenti.stream().filter(s -> s.getNota() < 5).forEach(System.out::println);

            // c)
            List<Student> noteModificate = studenti.stream()
                    .map(s -> {
                        if (s.getNota() < 4) s.setNota(4.0f);
                        return s;
                    }).collect(Collectors.toList());
            System.out.println("\n c) Liste cu note sub 4 rotunjite la 4: " + noteModificate);

            // d)
            double sumaNote = studenti.stream()
                    .mapToDouble(Student::getNota)
                    .sum();
            System.out.println("\nd) Suma notelor: " + sumaNote);

            // e)
            double media = sumaNote / studenti.size();
            System.out.println("e) Media notelor: " + media);


            List<Student> students = readFromFile();
            Map<Integer, Float> note = citesteNote();
            List<Student> studentiCuNote = new ArrayList<>();
            for (Student s : students) {
                Float nota = note.getOrDefault(s.getNumarMatricol(), 0f);
                studentiCuNote.add(new Student(s.getNumarMatricol(), s.getPrenume(),
                        s.getNume(), s.getFormatieDeStudiu(), nota));
            }

            Map<String, Student> studMap = new HashMap<>();
            for (Student s : studentiCuNote) {
                studMap.put(s.getNume(), s);
            }

            float notaM = gasesteNota("Bianca", "Popescu", studMap);
            float notaN = gasesteNota("Ioan", "Popa", studMap);

            System.out.println("Nota pentru Bianca Popescu: " + notaM);
            System.out.println("Nota pentru Ioan Popa: " + notaN);


            writeFile(studentiCuNote);
/*
        Set<Student> studenti = new HashSet<>(studentiCuNote);
        studenti = imparteInDouaFormatii(studenti, "TI 211_1", "TI 211_2");

        System.out.println("\nStudenti dupa impartire in formatii:");
        for (Student s : studenti) {
            System.out.println(s);*/
        }
    }

    static List<Student> readFromFile() {
        Path path = Paths.get("studenti_in.txt");
        List<Student> listaStudenti = new ArrayList<>();
        try {

            List<String> ss = Files.readAllLines(path);
            for (String linie : ss) {
                if (!linie.trim().isEmpty()) {

                    String[] bucati = linie.split(",");

                    int nrMatricol = Integer.parseInt(bucati[0].trim());
                    String prenume = bucati[1].trim();
                    String nume = bucati[2].trim();
                    String grupa = bucati[3].trim();

                    Student s = new Student(nrMatricol, prenume, nume, grupa, 0f);
                    listaStudenti.add(s);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaStudenti;
    }

    static void writeFile(List<Student> listaStudenti) {
        Path pathOut = Paths.get("studenti_out.txt");
        Path pathOutSorted = Paths.get("studenti_out_sorted.txt");

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

            //liniiSortate.add(s.getNumarMatricol() + "," + s.getPrenume() + "," + s.getNume() + "," + s.getFormatieDeStudiu());
            liniiSortate.add(s.toString());
        }

        try {
            Files.write(pathOutSorted, liniiSortate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static Map<Integer, Float> citesteNote() {
        Path path = Paths.get("note_anon.txt");
        Map<Integer, Float> note = new HashMap<>();
        try {

            List<String> ss = Files.readAllLines(path);
            for (String linie : ss) {
                if (!linie.trim().isEmpty()) {

                    String[] bucati = linie.split(",");

                    int nrMatricol = Integer.parseInt(bucati[0].trim());
                    float nota = Float.parseFloat(bucati[1].trim());
                    note.put(nrMatricol, nota);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return note;

    }
}



