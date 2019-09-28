package sps2plc.ioTable;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOTableRepository extends JpaRepository<IOMap, Long> {

    List<IOMap> findByProjectIdOrderById(Long projectId);
}
