package dk.via.sep3.repository;

import dk.via.sep3.model.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackEntity, FeedbackEntity.FeedbackId>
{
}
