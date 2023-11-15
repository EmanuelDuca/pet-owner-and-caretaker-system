package dk.via.sep3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dk.via.sep3.shared.AnnouncementEntity;

@Repository
public interface AnnouncementRepository extends JpaRepository<AnnouncementEntity, Integer> {
}
