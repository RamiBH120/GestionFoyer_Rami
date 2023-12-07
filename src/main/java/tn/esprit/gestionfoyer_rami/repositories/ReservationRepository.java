package tn.esprit.gestionfoyer_rami.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.gestionfoyer_rami.entities.Reservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation,Long> {

    Reservation findByEtudiantsCin(Long etudiants_cin);

    List<Reservation> findByEtudiantsCinNotLike(Long etudiants_cin);

    @Query(value = "SELECT r " +
            "FROM Reservation r " +
            "JOIN Chambre c on r member c.reservations " +
            "JOIN Bloc b on b = c.bloc " +
            "JOIN Foyer f on f = b.foyer " +
            "WHERE f.universite.nomUniversite = :name and r.anneeUniversitaire = :date") //order by nbr piste skieurs
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(@Param("date") Date date, @Param("name") String name);

    boolean existsByAnneeUniversitaireBetweenAndEtudiantsCin(LocalDate anneeUniversitaire, LocalDate anneeUniversitaire2, Long etudiants_cin);
}
