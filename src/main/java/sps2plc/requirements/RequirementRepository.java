package sps2plc.requirements;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequirementRepository extends JpaRepository<Requirement, Long> {
    List<Requirement> findByProjectOrderById(Long project);

    List<Requirement> findByProjectAndDisabledOrderById(Long project, boolean disabled);
}
