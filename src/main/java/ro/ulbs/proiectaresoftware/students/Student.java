package ro.ulbs.proiectaresoftware.students;
import java.util.Objects;

public class Student {

    private int numarMatricol;
    private String prenume;
    private String nume;
    private String formatieDeStudiu;
    private float nota;

    public Student(int numarMatricol,String prenume,String nume,String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume=prenume;
        this.nume=nume;
        this.formatieDeStudiu=formatieDeStudiu;
    }

    public int getNumarMatricol() {
        return numarMatricol;
    }

    public void setNumarMatricol(int numarMatricol) {
        this.numarMatricol = numarMatricol;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }

    public void setFormatieDeStudiu(String formatieDeStudiu) {
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public float getNota() {
        return nota;
    }

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
