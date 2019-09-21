package sps2plc.requirements;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requirements")
public class RequirementController {

    private RequirementService requirementService;
    private RequirementRepository requirementRepository;

    @Autowired
    public RequirementController(RequirementService requirementService, RequirementRepository requirementRepository) {
        this.requirementService = requirementService;
        this.requirementRepository = requirementRepository;
    }

    @GetMapping
    public List<Requirement> getProjectRequirements(@RequestParam("project") Long projId) {
        return requirementService.getProjectRequirements(projId);
    }

    @GetMapping("/{id}")
    public Requirement getRequirement(@PathVariable("id") Long reqId) {
        return requirementService.getRequirement(reqId);
    }

    /**
     * curl -X POST localhost:8080/requirements -H 'Content-type:application/json' -d '{"text": "When Q, delayL = 100, Q0.0 exists.", "project": 2, "errorDescription": "", "state": "COMPLIANT", "disabled": false }'
     */
    @PostMapping
    public Requirement createRequirement(@RequestBody Requirement requirement) {
        return requirementService.createRequirement(requirement);
    }


    @PutMapping
    public Requirement updateRequirement(@RequestBody Requirement requirement) {
        return requirementService.createRequirement(requirement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRequirement(@PathVariable("id") Long id) {
        return requirementRepository.findById(id)
                .map(requirement -> {
                    requirementService.deleteRequirement(requirement.getId());
                    return new ResponseEntity<>(requirement, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
