package de.web.timo_moosmann.entfernungsrechner_bahnhoefe.bahnhoflocationutils;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

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
    private Double latitude;

    @Column(nullable=false)
    private Double longitude;

    public BahnhofLocation(List<String> ds100List, String fullName, Double latitude, Double longitude) {
        this.ds100List = ds100List;
        this.fullName = fullName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BahnhofLocation that = (BahnhofLocation) o;
        return Objects.equals(ds100List, that.ds100List) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(latitude, that.latitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ds100List, fullName, longitude, latitude);
    }
}
