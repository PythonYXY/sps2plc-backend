package sps2plc.ioTable;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IOTableService {

    private IOTableRepository ioTableRepository;

    @Autowired
    public IOTableService(IOTableRepository ioTableRepository) {
        this.ioTableRepository = ioTableRepository;
    }

    public List<IOMap> getProjectIOTable(Long projectId) { return ioTableRepository.findByProjectIdOrderById(projectId); }

    public IOMap addIOMap(IOMap ioMap) { return ioTableRepository.save(ioMap); }

    public void deleteIOMap(Long id) { ioTableRepository.deleteById(id); }
}
