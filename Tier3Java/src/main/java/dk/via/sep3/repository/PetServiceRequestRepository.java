package dk.via.sep3.repository;

import dk.via.sep3.shared.PetServiceRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetServiceRequestRepository extends JpaRepository<PetServiceRequestEntity, Integer>
{
}
