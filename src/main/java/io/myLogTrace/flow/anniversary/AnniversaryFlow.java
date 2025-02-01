package io.myLogTrace.flow.anniversary;

import io.myLogTrace.command.ModifyAnniversary;
import io.myLogTrace.domain.entity.sdo.AnniversaryCdo;
import io.myLogTrace.service.AnniversaryService;
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

    @PatchMapping("")
    public String update(@Valid @RequestBody ModifyAnniversary command) {
        //
        return anniversaryService.update(command);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        //
        anniversaryService.delete(id);
    }
}
