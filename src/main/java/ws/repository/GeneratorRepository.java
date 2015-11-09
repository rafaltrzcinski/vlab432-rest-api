package ws.repository;

import ws.domain.Generator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneratorRepository extends JpaRepository<Generator, Long> {

    Generator findByAddressIgnoreCase(String address);

    List<Generator> findByTypeIgnoreCaseOrderByIdAsc(String type);
}
