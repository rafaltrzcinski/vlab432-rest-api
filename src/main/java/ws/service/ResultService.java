package ws.service;

import ws.domain.Result;

import java.util.Date;
import java.util.List;

public interface ResultService {

    List<Result> findAllResults();

    Result findResultById(Long id);

    List<Result> findResultsByStationId(int stationId);

    List<Result> findResultsByFunction(String function);

    List<Result> findResultsByModulation(String modulation);

    List<Result> findResultsByValue(double value);

    List<Result> findResultsByUnit(String unit);

    List<Result> findResultsByTime(Date time);

    void saveResult(Result result);
}
