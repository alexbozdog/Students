package ro.ulbs.proiectaresoftware.students;
import java.util.Objects;

public class Student {

    private final int numarMatricol;
    private final String prenume;
    private final String nume;
    private final String formatieDeStudiu;
    private final float nota;

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
}
