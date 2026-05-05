package ro.ulbs.proiectaresoftware.students;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Student {

    private final int numarMatricol;
    private final String prenume;
    private final String nume;
    private final String formatieDeStudiu;
    private float nota;

    public Student(int numarMatricol,String prenume,String nume,String formatieDeStudiu,float nota) {
        this.numarMatricol = numarMatricol;
        this.prenume=prenume;
        this.nume=nume;
        this.formatieDeStudiu=formatieDeStudiu;
        this.nota=nota;

    }

    public int getNumarMatricol() {
        return numarMatricol;
    }
    public String getPrenume() {
        return prenume;
    }
    public String getNume() {
        return nume;
    }
    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }
    public void setNota(float nota) {this.nota = nota;}

    public float getNota() { return nota;}

    @Override
    public String toString() {
        return String.format("%15d %20s %15s %2f",
                this.numarMatricol,
                this.prenume + " " + this.nume,
                this.formatieDeStudiu,
                this.nota);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;

        return Objects.equals(nume, s.nume) &&
                Objects.equals(prenume, s.prenume) &&
                Objects.equals(formatieDeStudiu, s.formatieDeStudiu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenume, nume, formatieDeStudiu);
    }

    public class lab9 {
        public static void main(String[] args) {
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
            System.out.println("a) Studenți cu nota 10:");
            studenti.stream().filter(s -> s.getNota() == 10).forEach(System.out::println);

            // b)
            System.out.println("\nb) Studenți cu nota sub 5:");
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
        }

    }
}
