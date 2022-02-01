package Model;

import java.util.Objects;

public final class Zakup {
    private final int id;
    private final String imie;
    private final String nazwisko;
    private final String dataZakupu;
    private final int idSamochodu;
    private final String nazwaSamochodu;

    public Zakup(int id, String imie, String nazwisko, String dataZakupu, int idSamochodu, String nazwaSamochodu) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataZakupu = dataZakupu;
        this.idSamochodu = idSamochodu;
        this.nazwaSamochodu = nazwaSamochodu;
    }

    public int id() {
        return id;
    }

    public String imie() {
        return imie;
    }

    public String nazwisko() {
        return nazwisko;
    }

    public String dataZakupu() {
        return dataZakupu;
    }

    public int idSamochodu() {
        return idSamochodu;
    }

    public String nazwaSamochodu() {
        return nazwaSamochodu;
    }





    @Override
    public String toString() {
        return "Zakup[" +
                "id=" + id + ", " +
                "imie=" + imie + ", " +
                "nazwisko=" + nazwisko + ", " +
                "dataZakupu=" + dataZakupu + ", " +
                "idSamochodu=" + idSamochodu + ", " +
                "nazwaSamochodu=" + nazwaSamochodu + ']';
    }

}
