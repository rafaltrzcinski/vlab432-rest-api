package ws.controller;

import ws.domain.StationStatus;
import ws.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class StationStatusController {

    private StationService service;

    @Autowired
    public StationStatusController(StationService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<StationStatus> findIdAndStatus() {
        return service.findAllStationStatus();
    }

    @RequestMapping(value = "/id/{stationId}", method = GET, produces = APPLICATION_JSON_VALUE)
    public StationStatus findStationStatusById(@PathVariable Long stationId) {
        return service.findStationStatusById(stationId);
    }

    @RequestMapping(value = "/id", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<StationStatus> findStationStatusStatusByIdIn(@RequestParam(value = "ids") ArrayList<Long> ids) {
        return service.findStationStatusByIdIn(ids);
    }
}
