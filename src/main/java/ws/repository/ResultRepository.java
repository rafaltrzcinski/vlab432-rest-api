package ws.repository;

import ws.domain.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findByStationIdOrderByStationIdAsc(int stationId);

    List<Result> findByFunctionIgnoreCaseOrderByMeasurementIdAsc(String function);

    List<Result> findByModulationIgnoreCaseOrderByMeasurementIdAsc(String modulation);

    List<Result> findByResultValueOrderByMeasurementIdAsc(double resultValue);

    List<Result> findByResultUnitOrderByMeasurementIdAsc(String resultUnit);

    List<Result> findByMeasurementTimeGreaterThanEqual(Date measurementTime);
}
