package tn.esprit.gestionfoyer_rami.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.gestionfoyer_rami.entities.Etudiant;

import java.util.List;

public interface EtudiantRepository extends CrudRepository<Etudiant,Long> {
    Etudiant findByCin(Long cin);
    List<Etudiant> findByCinNotLike(Long cin);

    List<Etudiant> findByReservationsIdReservation(String reservations_idReservation);

    @Query(value = "select e "+
    "from Etudiant e "+
    "join Reservation r on r member e.reservations "+
    "join Chambre c on r member c.reservations "+
    "where c.idChambre = :id ")

    List<Etudiant> getEtudiantsByNumChambre(@Param("id") long id);
}
