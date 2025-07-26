package io.myLogTrace.flow.anniversary;

import io.myLogTrace.command.ModifyAnniversary;
import io.myLogTrace.domain.entity.sdo.AnniversaryCdo;
import io.myLogTrace.service.AnniversariesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/anniversaries")
@RestController
public class AnniversaryFlow {
    //
    private final AnniversariesService anniversaryService;

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
    public ResponseEntity<String> delete(@PathVariable String id) {
        //
        anniversaryService.delete(id);
        return ResponseEntity.ok(id);
    }
}
