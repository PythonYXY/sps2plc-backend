package sps2plc.requirements;


import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sps2plc.core.fe.SPSFrontEnd;
import sps2plc.core.fe.sps.SpsParserException;

import java.awt.image.ImagingOpException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public Requirement updateRequirement(Requirement requirement) {
        SPSFrontEnd fe = new SPSFrontEnd();
        try {
            fe.parseString(requirement.getText());
            requirement.setState(Requirement.ReqState.COMPLIANT);
            requirement.setErrorDescription("");
        } catch (SpsParserException err) {
            requirement.setState(Requirement.ReqState.ERROR);
            requirement.setErrorDescription(err.toString());
        }
        return createRequirement(requirement);
    }

    public List<Requirement> parseFile(MultipartFile file, Long projectId) {
        try {
            List<Requirement> requirements = new ArrayList<>();
            Scanner scanner = new Scanner(file.getInputStream());

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                // Skip empty lines and comments
                if(line.isEmpty() || line.contains("#"))
                    continue;
                Requirement req = new Requirement(line, projectId, "", Requirement.ReqState.NOT_CHECKED, false);
                createRequirement(req);
                requirements.add(req);
            }

            return requirements;
        } catch (IOException e) {
            return null;
        }
    }
}
