package dk.via.sep3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dk.via.sep3.shared.PetEntity;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Integer> {
}
