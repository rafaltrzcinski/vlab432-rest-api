package ws.service;

import ws.domain.Station;
import ws.domain.StationStatus;

import java.util.ArrayList;
import java.util.List;

public interface StationService {

    List<Station> findAllStations();

    Station findStationById(Long id);

    Station findStationByAddress(String ipAddress);

    Station findStationByDevices(int generator, int multimeter);

    List<Station> findStationByStatus(String status);

    void saveStation(Station station);

    void updateStationStatus(Long id, String status);

    List<Station> findStationsByManyId(ArrayList<Long> ids);

    StationStatus findStationStatusById(Long id);

    List<StationStatus> findStationStatusByIdIn(ArrayList<Long> ids);

    List<StationStatus> findAllStationStatus();

}
