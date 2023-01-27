package de.web.timo_moosmann.entfernungsrechner_bahnhoefe.bahnhoflocationutils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BahnhofLocationRepository extends JpaRepository<BahnhofLocation, Long> {

    @Query("SELECT bl FROM BahnhofLocation bl JOIN bl.ds100List ds100 WHERE ds100 = :ds100")
    BahnhofLocation retrieveByDS100(@Param("ds100") String ds100);
}
