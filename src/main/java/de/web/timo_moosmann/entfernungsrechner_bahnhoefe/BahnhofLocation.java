package de.web.timo_moosmann.entfernungsrechner_bahnhoefe;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
public class BahnhofLocation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(nullable = false)
    private List<String> ds100List;

    @Column(nullable=false)
    private String fullName;

    @Column(nullable=false)
    private Double laenge;

    @Column(nullable=false)
    private Double breite;

    public BahnhofLocation(List<String> ds100List, String fullName, Double laenge, Double breite) {
        this.ds100List = ds100List;
        this.fullName = fullName;
        this.laenge = laenge;
        this.breite = breite;
    }
    public void setLaenge(String laenge) {
        this.laenge = getDoubleFromGermanNumberFormat(laenge);
    }

    public void setBreite(String breite) {
        this.breite = getDoubleFromGermanNumberFormat(breite);
    }

    private Double getDoubleFromGermanNumberFormat(String germanNumber) {
        return Double.parseDouble(germanNumber.replace(',', '.'));
    }
}
