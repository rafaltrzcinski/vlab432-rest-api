package ws.controller;

import ws.domain.Station;
import ws.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class StationController {

    private StationService service;

    @Autowired
    public StationController(StationService service) {
        this.service = service;
    }


    @RequestMapping(value = "/stations", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Station> listAllStations() {
        return service.findAllStations();
    }

    @RequestMapping(value = "/station/id/{stationId}", method = GET, produces = APPLICATION_JSON_VALUE)
    public Station findStationById(@PathVariable Long stationId) {
        return service.findStationById(stationId);
    }

    @RequestMapping(value = "/station/id", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Station> findStationsByIds(@RequestParam(value = "ids") ArrayList<Long> ids) {
        return service.findStationsByManyId(ids);
    }

    @RequestMapping(value = "/station/address", method = GET, produces = APPLICATION_JSON_VALUE)
    public Station findStationByAddress(@RequestParam(value = "ip") String address) {
        return service.findStationByAddress(address);
    }

    @RequestMapping(value = "/station/devices", method = GET, produces = APPLICATION_JSON_VALUE)
    public Station findStationByDevices(@RequestParam(value = "multimeter_id") int generator,
                                        @RequestParam(value = "generator_id") int multimeter) {
        return service.findStationByDevices(generator, multimeter);
    }

    @RequestMapping(value = "/station/status/{status}", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Station> findStationByStatus(@PathVariable String status) {
        return service.findStationByStatus(status);
    }

    @RequestMapping(value = "/station/update", method = POST)
    public ModelAndView updateStationStatus(@RequestParam(value = "id") Long id,
                                            @RequestParam(value = "status") String status) {
        service.updateStationStatus(id, status.toUpperCase());
        return new ModelAndView("redirect:/");
    }


    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNoSuchElementException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

}
