package dk.via.sep3.repository;

import dk.via.sep3.shared.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetServiceRepository extends JpaRepository<ServiceEntity, Integer>
{

}
