package io.myLogTrace.flow.certification;

import io.myLogTrace.domain.entity.Certification;
import io.myLogTrace.service.CertificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/certifications")
@RestController
public class CertificationSeek {
    //
    private final CertificationService certificationService;

    @GetMapping("/{id}")
    public Certification findCertification(@PathVariable String id) {
        //
        return certificationService.findCertification(id);
    }

    @GetMapping("")
    public List<Certification> findCertifications() {
        //
        return certificationService.findCertifications();
    }
}
