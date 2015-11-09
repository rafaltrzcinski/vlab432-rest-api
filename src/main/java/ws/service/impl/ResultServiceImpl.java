package ws.service.impl;

import ws.domain.Result;
import ws.repository.ResultRepository;
import ws.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    private ResultRepository repository;

    @Autowired
    public ResultServiceImpl(ResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Result> findAllResults() {
        return repository.findAll(new Sort(Sort.Direction.ASC, "measurementId"));
    }

    @Override
    public Result findResultById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Result> findResultsByStationId(int stationId) {
        return repository.findByStationIdOrderByStationIdAsc(stationId);
    }

    @Override
    public List<Result> findResultsByFunction(String function) {
        return repository.findByFunctionIgnoreCaseOrderByMeasurementIdAsc(function);
    }

    @Override
    public List<Result> findResultsByModulation(String modulation) {
        return repository.findByModulationIgnoreCaseOrderByMeasurementIdAsc(modulation);
    }

    @Override
    public List<Result> findResultsByValue(double value) {
        return repository.findByResultValueOrderByMeasurementIdAsc(value);
    }

    @Override
    public List<Result> findResultsByUnit(String unit) {
        return repository.findByResultUnitOrderByMeasurementIdAsc(unit);
    }

    @Override
    public List<Result> findResultsByTime(Date time) {
        return repository.findByMeasurementTimeGreaterThanEqual(time);
    }

    @Override
    public void saveResult(Result result) {
        repository.save(result);
    }
}
