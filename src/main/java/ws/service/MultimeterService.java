package ws.service;

import ws.domain.Multimeter;

import java.util.List;

public interface MultimeterService {

    List<Multimeter> findAllMultimeters();

    Multimeter findMultimeterById(Long id);

    Multimeter findMultimeterByAddress(String gpib);

    List<Multimeter> findMultimeterByType(String type);
}
