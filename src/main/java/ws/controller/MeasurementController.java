package ws.controller;

import ws.domain.Measurement;
import ws.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class MeasurementController {

    private MeasurementService service;

    @Autowired
    public MeasurementController(MeasurementService service) {
        this.service = service;
    }

    @RequestMapping(value = "/measurement", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Measurement> findAllMeasurements() {
        return service.findAllMeasurements();
    }

    @RequestMapping(value = "/measurement/id/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public Measurement findMeasById(@PathVariable Long id) {
        return service.findMeasurementById(id);
    }

    @RequestMapping(value = "/measurement/station_id/{stationId}", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Measurement> findMeasByStation(@PathVariable Long stationId) {
        return service.findMeasurementsByStationId(stationId);
    }

    @RequestMapping(value = "/measurement/modulation/{modulation}", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Measurement> findMeasByModulation(@PathVariable String modulation) {
        return service.findMeasurementsByModulation(modulation);
    }

    @RequestMapping(value = "/measurement/function/{function}", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Measurement> findMeasByFunction(@PathVariable String function) {
        return service.findMeasurementsByFunction(function);
    }

    @RequestMapping(value = "/measurement/time/{time}", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Measurement> findMeasByTime(@PathVariable @DateTimeFormat(pattern = "ddMMyyyyHHmmss") Date time) {
        return service.findMeasurementsByTime(time);
    }

    @RequestMapping(value = "/measurement/user/{userId}", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Measurement> findMeasForUser(@PathVariable int userId) {
        return service.findMeasurementForUser(userId);
    }


    @RequestMapping(value = "/measurement/measure", method = POST, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void measure(@RequestBody Measurement measurement) {
        service.saveMeasurement(measurement);
    }

}
