package ws.repository;

import ws.domain.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

    List<Measurement> findByStationIdOrderByIdAsc(Long stationId);

    List<Measurement> findByFunctionIgnoreCaseOrderByIdAsc(String function);

    List<Measurement> findByModulationIgnoreCaseOrderByIdAsc(String modulation);

    List<Measurement> findByMeasurementTimeGreaterThanEqualOrderByMeasurementTimeDesc(Date measurementTime);

    List<Measurement> findByUserIdOrderByMeasurementTimeDesc(int userId);

}
