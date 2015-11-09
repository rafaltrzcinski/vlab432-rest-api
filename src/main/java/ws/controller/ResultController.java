package ws.controller;

import ws.domain.Result;
import ws.service.ResultService;
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
public class ResultController {

    private ResultService service;

    @Autowired
    public ResultController(ResultService service) {
        this.service = service;
    }

    @RequestMapping(value = "/result", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Result> findAllResults() {
        return service.findAllResults();
    }

    @RequestMapping(value = "/result/measurement_id/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public Result findResultById(@PathVariable Long id) {
        return service.findResultById(id);
    }

    @RequestMapping(value = "/result/station_id/{station_id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Result> findResultByStationId(@PathVariable int station_id) {
        return service.findResultsByStationId(station_id);
    }

    @RequestMapping(value = "/result/modulation/{modulation}", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Result> findResultsByModulation(@PathVariable String modulation) {
        return service.findResultsByModulation(modulation);
    }

    @RequestMapping(value = "/result/function/{function}", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Result> findResultsByFunction(@PathVariable String function) {
        return service.findResultsByFunction(function);
    }

    @RequestMapping(value = "/result/unit/{unit}", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Result> findResultsByUnit(@PathVariable String unit) {
        return service.findResultsByUnit(unit);
    }

    @RequestMapping(value = "/result/value/{value}", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Result> findResultsByValue(@PathVariable double value) {
        return service.findResultsByValue(value);
    }

    @RequestMapping(value = "/result/measure_time", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Result> findResultsByTime(@RequestParam(value = "time") @DateTimeFormat(pattern = "ddMMyyyyHHmmss") Date time) {
        return service.findResultsByTime(time);
    }

    @RequestMapping(value = "/result/save", method = POST, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveResult(@RequestBody Result result) {
        service.saveResult(result);
    }
}
