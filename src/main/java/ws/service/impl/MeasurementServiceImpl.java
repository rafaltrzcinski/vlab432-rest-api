package ws.service.impl;

import ws.domain.Measurement;
import ws.repository.MeasurementRepository;
import ws.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MeasurementServiceImpl implements MeasurementService {

    private MeasurementRepository repository;

    @Autowired
    public MeasurementServiceImpl(MeasurementRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Measurement> findAllMeasurements() {
        return repository.findAll(new Sort(Sort.Direction.DESC, "measurementTime"));
    }

    @Override
    public Measurement findMeasurementById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Measurement> findMeasurementsByFunction(String function) {
        return repository.findByFunctionIgnoreCaseOrderByIdAsc(function);
    }

    @Override
    public List<Measurement> findMeasurementsByStationId(Long stationId) {
        return repository.findByStationIdOrderByIdAsc(stationId);
    }

    @Override
    public List<Measurement> findMeasurementsByModulation(String modulation) {
        return repository.findByModulationIgnoreCaseOrderByIdAsc(modulation);
    }

    @Override
    public List<Measurement> findMeasurementsByTime(Date time) {
        return repository.findByMeasurementTimeGreaterThanEqualOrderByMeasurementTimeDesc(time);
    }

    @Override
    public List<Measurement> findMeasurementForUser(int userId) {
        return repository.findByUserIdOrderByMeasurementTimeDesc(userId);
    }

    @Override
    public void saveMeasurement(Measurement measurement) {
        repository.save(measurement);
    }
}
