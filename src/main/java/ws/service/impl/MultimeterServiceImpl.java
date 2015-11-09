package ws.service.impl;

import ws.domain.Multimeter;
import ws.repository.MultimeterRepository;
import ws.service.MultimeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultimeterServiceImpl implements MultimeterService {

    private MultimeterRepository repository;

    @Autowired
    public MultimeterServiceImpl(MultimeterRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Multimeter> findAllMultimeters() {
        return repository.findAll();
    }

    @Override
    public Multimeter findMultimeterById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Multimeter findMultimeterByAddress(String gpib) {
        return repository.findByAddressIgnoreCase(gpib);
    }

    @Override
    public List<Multimeter> findMultimeterByType(String type) {
        return repository.findByTypeIgnoreCaseOrderByIdAsc(type);
    }
}
