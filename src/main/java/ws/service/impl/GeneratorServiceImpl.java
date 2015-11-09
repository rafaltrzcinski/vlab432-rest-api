package ws.service.impl;

import ws.domain.Generator;
import ws.repository.GeneratorRepository;
import ws.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneratorServiceImpl implements GeneratorService {

    private GeneratorRepository repository;

    @Autowired
    public GeneratorServiceImpl(GeneratorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Generator> findAllGenerators() {
        return repository.findAll();
    }

    @Override
    public Generator findGeneratorById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Generator findGeneratorByAddress(String address) {
        return repository.findByAddressIgnoreCase(address);
    }

    @Override
    public List<Generator> findGeneratorByType(String type) {
        return repository.findByTypeIgnoreCaseOrderByIdAsc(type);
    }
}
