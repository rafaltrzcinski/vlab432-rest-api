package ws.repository;

import ws.domain.Multimeter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MultimeterRepository extends JpaRepository<Multimeter, Long> {

    Multimeter findByAddressIgnoreCase(String address);

    List<Multimeter> findByTypeIgnoreCaseOrderByIdAsc(String type);

}
