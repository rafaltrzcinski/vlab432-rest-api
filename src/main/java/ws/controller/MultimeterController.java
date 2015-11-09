package ws.controller;

import ws.domain.Multimeter;
import ws.service.MultimeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class MultimeterController {

    private MultimeterService service;

    @Autowired
    public MultimeterController(MultimeterService service) {
        this.service = service;
    }

    @RequestMapping(value = "/multimeter", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Multimeter> listAllMultimeters() {
        return service.findAllMultimeters();
    }

    @RequestMapping(value = "/multimeter/id/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public Multimeter findMultimeterById(@PathVariable Long id) {
        return service.findMultimeterById(id);
    }

    @RequestMapping(value = "/multimeter/gpib/{address}", method = GET, produces = APPLICATION_JSON_VALUE)
    public Multimeter findMultimeterByAddress(@PathVariable String address) {
        return service.findMultimeterByAddress(address);
    }

    @RequestMapping(value = "/multimeter/type/{type}", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Multimeter> findMultimeterByType(@PathVariable String type) {
        return service.findMultimeterByType(type);
    }
}
