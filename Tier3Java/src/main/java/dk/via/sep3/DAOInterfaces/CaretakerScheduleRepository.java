package dk.via.sep3.DAOInterfaces;

import dk.via.sep3.shared.CaretakerDatePeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaretakerScheduleRepository extends JpaRepository<CaretakerDatePeriod, CaretakerDatePeriod.CaretakerTimePeriodId>
{
}
