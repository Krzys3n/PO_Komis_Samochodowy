package Model;

import java.util.Objects;

public final class Samochod {
    private final Integer id;
    private final String model_samochodu;
    private final Double cena;
    private final Integer rocznik;

    public Samochod(Integer id, String model_samochodu, Double cena, Integer rocznik) {
        this.id = id;
        this.model_samochodu = model_samochodu;
        this.cena = cena;
        this.rocznik = rocznik;
    }

    @Override
    public String toString() {
        return this.model_samochodu();
    }

    public Integer id() {
        return id;
    }

    public String model_samochodu() {
        return model_samochodu;
    }

    public Double cena() {
        return cena;
    }

    public Integer rocznik() {
        return rocznik;
    }




}
