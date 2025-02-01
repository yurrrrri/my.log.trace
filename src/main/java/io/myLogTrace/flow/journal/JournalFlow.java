package io.myLogTrace.flow.journal;

import io.myLogTrace.command.journal.ChangeJournalImage;
import io.myLogTrace.command.journal.ChangeJournalLocked;
import io.myLogTrace.command.journal.ModifyJournal;
import io.myLogTrace.domain.entity.sdo.JournalCdo;
import io.myLogTrace.service.JournalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/journals")
@RestController
public class JournalFlow {
    //
    private final JournalService journalService;

    @PostMapping("")
    public String create(@Valid @RequestBody JournalCdo cdo) {
        //
        return journalService.create(cdo);
    }

    @PutMapping("")
    public String update(@Valid @RequestBody ModifyJournal command) {
        //
        return journalService.update(command);
    }

    @PatchMapping(value = "", headers = { "command=ChangeJournalImage"})
    public String update(@Valid @RequestBody ChangeJournalImage command) {
        //
        return journalService.update(command);
    }

    @PatchMapping(value = "", headers = { "command=ChangeJournalLocked"})
    public String update(@Valid @RequestBody ChangeJournalLocked command) {
        //
        return journalService.update(command);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        //
        journalService.delete(id);
    }
}
