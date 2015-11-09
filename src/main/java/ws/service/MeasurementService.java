package ws.service;

import ws.domain.Measurement;

import java.util.Date;
import java.util.List;

public interface MeasurementService {

    List<Measurement> findAllMeasurements();

    Measurement findMeasurementById(Long id);

    List<Measurement> findMeasurementsByFunction(String function);

    List<Measurement> findMeasurementsByStationId(Long stationId);

    List<Measurement> findMeasurementsByModulation(String modulation);

    List<Measurement> findMeasurementsByTime(Date time);

    List<Measurement> findMeasurementForUser(int userId);

    void saveMeasurement(Measurement measurement);
}
