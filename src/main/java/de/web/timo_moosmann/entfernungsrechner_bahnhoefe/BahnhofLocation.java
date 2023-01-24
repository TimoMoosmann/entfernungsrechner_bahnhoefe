package de.web.timo_moosmann.entfernungsrechner_bahnhoefe;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class BahnhofLocation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(length=6, nullable=false, unique=true)
    private String ds100;

    @Column(nullable=false)
    private String fullName;

    @Column(nullable=false)
    private Double laenge;

    @Column(nullable=false)
    private Double breite;

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
