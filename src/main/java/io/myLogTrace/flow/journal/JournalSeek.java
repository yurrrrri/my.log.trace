package io.myLogTrace.flow.journal;

import io.myLogTrace.domain.entity.Journal;
import io.myLogTrace.service.JournalService;
import io.myLogTrace.service.vo.ViewType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/journals")
@RestController
public class JournalSeek {
    //
    private final JournalService journalService;

    @PostMapping("/daily")
    public List<Journal> findDailyJournal(@RequestParam String date) {
        //
        return journalService.findJournals(date, ViewType.DAILY);
    }

    @PostMapping("/weekly")
    public List<Journal> findWeeklyJournal(@RequestParam String date) {
        //
        return journalService.findJournals(date, ViewType.WEEKLY);
    }

    @PostMapping("/monthly")
    public List<Journal> findMonthlyJournal(@RequestParam String date) {
        //
        return journalService.findJournals(date, ViewType.MONTHLY);
    }
}
