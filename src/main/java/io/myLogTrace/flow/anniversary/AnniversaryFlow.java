package io.myLogTrace.flow.anniversary;

import io.myLogTrace.domain.entity.sdo.AnniversaryCdo;
import io.myLogTrace.service.AnniversaryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/anniversary")
@RestController
public class AnniversaryFlow {
    //
    private final AnniversaryService anniversaryService;

    @PostMapping("/create")
    public String create(@Valid @RequestBody AnniversaryCdo cdo) {
        //
        return anniversaryService.create(cdo);
    }
}
