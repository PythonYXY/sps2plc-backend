package sps2plc.requirements;


import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sps2plc.core.fe.SPSFrontEnd;
import sps2plc.core.fe.sps.SpsParserException;
import sps2plc.requirements.dao.RequirementMapper;

import java.awt.image.ImagingOpException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class RequirementService {
    private RequirementMapper requirementMapper;

    @Autowired
    public RequirementService(RequirementMapper requirementMapper) {
        this.requirementMapper = requirementMapper;
    }

    public List<Requirement> getProjectRequirements(Long projId) {
        return requirementMapper.findByProjectOrderById(projId);
    }

    public List<Requirement> getProjectRequirementsEnabled(Long projId) {
        return requirementMapper.findByProjectAndDisabledOrderById(projId, false);
    }

    public Optional<Requirement> createRequirement(Requirement req) {
        if (requirementMapper.save(req) == 1) {
            return Optional.of(req);
        }
        return Optional.empty();
    }

    public void deleteRequirement(Long id) {
        requirementMapper.deleteById(id);
    }

    public Optional<Requirement> getRequirement(Long reqId) {
        return Optional.ofNullable(requirementMapper.findById(reqId));
    }

    public Optional<Requirement> updateRequirement(Requirement requirement) {
        SPSFrontEnd fe = new SPSFrontEnd();
        try {
            fe.parseString(requirement.getText());
            requirement.setState(Requirement.ReqState.COMPLIANT);
            requirement.setErrorDescription("");
        } catch (SpsParserException err) {
            requirement.setState(Requirement.ReqState.ERROR);
            requirement.setErrorDescription(err.toString());
        }
        if (requirementMapper.updateRequirement(requirement) == 1) return Optional.of(requirement);
        return Optional.empty();
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
                createRequirement(req).orElseThrow(() -> new FailedToCreateRequirementException(req));
                requirements.add(req);
            }

            return requirements;
        } catch (IOException e) {
            return null;
        }
    }
}
