package ro.ulbs.proiectaresoftware.students;

public class Student {

    private int numarMatricol;
    private String prenume;
    private String nume;
    private String formatieDeStudiu;

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

    @Override
    public String toString() {
       // return "Student [numarMatricol=" + numarMatricol + ", Nume=" + nume + ", Prenume=" + prenume + ", formatieDeStudiu=" + formatieDeStudiu + "]";
        return String.format("%15d %20s %15s",
                this.numarMatricol,
                this.prenume + " " + this.nume,
                this.formatieDeStudiu);
    }
}
