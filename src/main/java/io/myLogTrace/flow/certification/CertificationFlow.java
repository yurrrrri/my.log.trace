package io.myLogTrace.flow.certification;

import io.myLogTrace.command.ModifyCertification;
import io.myLogTrace.domain.entity.sdo.CertificationCdo;
import io.myLogTrace.service.CertificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/certifications")
@RestController
public class CertificationFlow {
    //
    private final CertificationService certificationService;

    @PostMapping("")
    public String create(@Valid @RequestBody CertificationCdo cdo) {
        //
        return certificationService.create(cdo);
    }

    @PutMapping("")
    public String update(@Valid @RequestBody ModifyCertification command) {
        //
        return certificationService.update(command);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        //
        certificationService.delete(id);
        return ResponseEntity.ok(id);
    }
}
