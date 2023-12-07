package tn.esprit.gestionfoyer_rami.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.gestionfoyer_rami.entities.Chambre;
import tn.esprit.gestionfoyer_rami.entities.Etudiant;
import tn.esprit.gestionfoyer_rami.entities.Reservation;
import tn.esprit.gestionfoyer_rami.enums.TypeChambre;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface ChambreRepository extends CrudRepository<Chambre,Long> {
    //List<Chambre> findByNumeroChambre(Long numeroChambre);

    List<Chambre> findByNumeroChambreIn(Collection<Long> numeroChambre);

    List<Chambre> findByBloc_Foyer_UniversiteNomUniversite(String bloc_foyer_universite_nomUniversite);

    List<Chambre> findByBloc_IdBlocAndTypeC(Long bloc_idBloc, TypeChambre typeC);

    @Query(value = "SELECT c "+
    "FROM Chambre c "+
    "join Bloc b "+
    "where b.idBloc = :id and c.typeC = :type ")
    List<Chambre> getChambresByBlocIdAndTypeChambre(@Param("id") long id,@Param("type") String type);

    //List<Chambre> findByTypeCAndBloc_Foyer_UniversiteNomUniversite(TypeChambre typeC, String bloc_foyer_universite_nomUniversite);

    //List<Chambre> findByTypeCAndBloc_FoyerNomFoyer(TypeChambre typeC, String bloc_foyer_nomFoyer);

    Chambre findByReservationsIdReservation(String reservations_idReservation);

    @Query(value = "SELECT c "+
            "FROM Chambre c "+
            "join Bloc b on c.bloc = b " +
            "join Foyer f on b.foyer = f "+
            "where c.typeC = :type and f.universite.nomUniversite = :nom ")
    List<Chambre> getChambresNonReservesByTypeCAndNomUniversite(@Param("type") String type,@Param("nom") String nom);

}
