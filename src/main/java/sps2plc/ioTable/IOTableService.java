package sps2plc.ioTable;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sps2plc.ioTable.dao.IOTableMapper;

import java.util.List;
import java.util.Optional;

@Service
public class IOTableService {

//    private IOTableRepository ioTableRepository;
    private IOTableMapper ioTableMapper;

    @Autowired
    public IOTableService(IOTableMapper ioTableMapper) {
        this.ioTableMapper = ioTableMapper;
    }

    public List<IOMap> getProjectIOTable(Long projectId) {
        List<IOMap> ret = ioTableMapper.findByProjectIdOrderById(projectId);
        return ret;
    }

    public Optional<IOMap> getIOMapById(Long id) {
        return Optional.ofNullable(ioTableMapper.findById(id));
    }

    public IOMap addIOMap(IOMap ioMap) {
        if (ioTableMapper.save(ioMap) == 1) {
            return ioMap;
        }
        return null;
    }

    public void deleteIOMap(Long id) { ioTableMapper.deleteById(id); }
}
