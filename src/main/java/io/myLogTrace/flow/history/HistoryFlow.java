package io.myLogTrace.flow.history;

import io.myLogTrace.command.ModifyHistory;
import io.myLogTrace.domain.entity.sdo.HistoryCdo;
import io.myLogTrace.service.HistoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/histories")
@RestController
public class HistoryFlow {
    //
    private final HistoryService historyService;

    @PostMapping("")
    public String create(@Valid @RequestBody HistoryCdo cdo) {
        //
        return historyService.create(cdo);
    }

    @PutMapping("")
    public String update(@Valid @RequestBody ModifyHistory command) {
        //
        return historyService.update(command);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        //
        historyService.delete(id);
        return ResponseEntity.ok(id);
    }
}
