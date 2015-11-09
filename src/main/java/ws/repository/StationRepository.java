package ws.repository;

import ws.domain.Station;
import ws.domain.StationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;


public interface StationRepository extends JpaRepository<Station, Long> {

    Station findByAddress(String address);

    Station findByGeneratorIdAndMultimeterId(int generator, int multimeter);

    List<Station> findByStatusIgnoreCaseOrderByIdAsc(String status);

    List<Station> findByIdInOrderByIdAsc(ArrayList<Long> ids);

    @Query("select new ws.domain.StationStatus(id, status) from Station order by id")
    List<StationStatus> findAllStationStatus();

    @Query("select new ws.domain.StationStatus(id, status) from Station where id = ?1 order by id")
    StationStatus findStationStatusById(Long id);

    @Query("select new ws.domain.StationStatus(id, status) from Station where id in (?1) order by id")
    List<StationStatus> findStationStatusByIdIn(ArrayList<Long> ids);

}
