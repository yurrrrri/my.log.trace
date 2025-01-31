package io.myLogTrace.flow.anniversary;

import io.myLogTrace.domain.entity.sdo.AnniversaryCdo;
import io.myLogTrace.service.AnniversaryService;
import io.myLogTrace.service.sdo.AnniversaryUdo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/anniversaries")
@RestController
public class AnniversaryFlow {
    //
    private final AnniversaryService anniversaryService;

    @PostMapping("")
    public String create(@Valid @RequestBody AnniversaryCdo cdo) {
        //
        return anniversaryService.create(cdo);
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable String id, @Valid @RequestBody AnniversaryUdo udo) {
        //
        return anniversaryService.update(id, udo);
    }
}
