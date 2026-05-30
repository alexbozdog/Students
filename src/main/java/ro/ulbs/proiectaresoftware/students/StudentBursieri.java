package ro.ulbs.proiectaresoftware.students;

import java.util.Objects;

public class StudentBursieri extends Student implements Comparable<StudentBursieri>{
    private Double cuantumBursa;

    public StudentBursieri(int numarMatricol, String prenume, String nume, String formatieDeStudiu,Double nota, Double cuantumBursa) {
        super(numarMatricol, prenume, nume, formatieDeStudiu,nota.floatValue());
        //setNota(nota.floatValue());
        this.cuantumBursa = cuantumBursa;
    }

    public double getCuantumBursa() {
        return cuantumBursa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentBursieri)) return false;
        if (!super.equals(o)) return false;
        StudentBursieri that = (StudentBursieri) o;
        return Double.compare(that.cuantumBursa, cuantumBursa) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),cuantumBursa);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %10.2f", this.cuantumBursa);
    }

    @Override
    public int compareTo(StudentBursieri altul) {

        int rezultat = this.getFormatieDeStudiu().compareTo(altul.getFormatieDeStudiu());
        if (rezultat != 0) return rezultat;

        rezultat = this.getNume().compareTo(altul.getNume());
        if (rezultat != 0) return rezultat;

        rezultat = this.getPrenume().compareTo(altul.getPrenume());
        if (rezultat != 0) return rezultat;

        rezultat = Float.compare(this.getNota(), altul.getNota());
        if (rezultat != 0) return rezultat;

        return Double.compare(this.cuantumBursa, altul.cuantumBursa);
    }

}
