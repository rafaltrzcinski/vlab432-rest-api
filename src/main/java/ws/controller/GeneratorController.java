package ws.controller;

import ws.domain.Generator;
import ws.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class GeneratorController {

    private GeneratorService service;

    @Autowired
    public GeneratorController(GeneratorService service) {
        this.service = service;
    }

    @RequestMapping(value = "/generator", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Generator> findAllGenerators() {
        return service.findAllGenerators();
    }

    @RequestMapping(value = "/generator/id", method = GET, produces = APPLICATION_JSON_VALUE)
    public Generator findGeneratorById(@RequestParam(value = "id") Long id) {
        return service.findGeneratorById(id);
    }

    @RequestMapping(value = "/generator/address", method = GET, produces = APPLICATION_JSON_VALUE)
    public Generator findGeneratorByAddress(@RequestParam(value = "gpib") String address) {
        return service.findGeneratorByAddress(address);
    }

    @RequestMapping(value = "/generator/type", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Generator> findGeneratorByType(@RequestParam(value = "type") String type) {
        return service.findGeneratorByType(type);
    }

}
