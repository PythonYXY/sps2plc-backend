package sps2plc.requirements;


import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequirementService {
    private RequirementRepository requirementRepository;

    @Autowired
    public RequirementService(RequirementRepository requirementRepository) {
        this.requirementRepository = requirementRepository;
    }

    public List<Requirement> getProjectRequirements(Long projId) {
        return requirementRepository.findByProjectOrderById(projId);
    }

    public List<Requirement> getProjectRequirementsEnabled(Long projId) {
        return requirementRepository.findByProjectAndDisabledOrderById(projId, false);
    }

    public Requirement createRequirement(Requirement req) {
        return requirementRepository.save(req);
    }

    public void deleteRequirement(Long id) {
        requirementRepository.deleteById(id);
    }

    public Requirement getRequirement(Long reqId) {
        return requirementRepository.findById(reqId).orElseThrow(() -> new RequirementNotFoundException(reqId));
    }

}
