package sps2plc.ioTable;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ioMap")
public class IOTableController {

    private IOTableRepository ioTableRepository;
    private IOTableService ioTableService;

    @Autowired
    public IOTableController(IOTableRepository ioTableRepository, IOTableService ioTableService) {
        this.ioTableRepository = ioTableRepository;
        this.ioTableService = ioTableService;
    }

    @GetMapping
    public List<IOMap> getProjectIOTable(@RequestParam("project") Long projectId) { return ioTableService.getProjectIOTable(projectId); }

    @PostMapping
    public IOMap addIOMap(@RequestBody IOMap ioMap) { return ioTableService.addIOMap(ioMap); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIOMap(@PathVariable("id") Long id) {
        return ioTableRepository.findById(id)
                .map(ioMap -> {
                    ioTableService.deleteIOMap(ioMap.getId());
                    return new ResponseEntity<>(ioMap, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
