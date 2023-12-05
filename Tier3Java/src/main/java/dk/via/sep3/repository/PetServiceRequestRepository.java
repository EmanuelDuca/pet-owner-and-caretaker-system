package dk.via.sep3.repository;

import dk.via.sep3.model.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetServiceRequestRepository extends JpaRepository<RequestEntity, Integer>
{
}
