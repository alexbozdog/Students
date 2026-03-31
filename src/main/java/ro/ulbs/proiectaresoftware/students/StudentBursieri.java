package ro.ulbs.proiectaresoftware.students;

import java.util.Objects;

public class StudentBursieri extends Student{
    private Double cuantumBursa;

    public StudentBursieri(int numarMatricol, String prenume, String nume, String formatieDeStudiu,Double nota, Double cuantumBursa) {
        super(numarMatricol, prenume, nume, formatieDeStudiu);
        setNota(nota.floatValue());
        this.cuantumBursa = cuantumBursa;
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


}
