package dk.via.sep3.repository;

import dk.via.sep3.shared.CaretakerEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CaretakerRepository extends JpaRepository<CaretakerEntity, String> {
}