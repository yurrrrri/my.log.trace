package io.myLogTrace.flow.journal;

import io.myLogTrace.domain.entity.Journal;
import io.myLogTrace.service.JournalService;
import io.myLogTrace.service.vo.ViewType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/journals")
@RestController
public class JournalSeek {
    //
    private final JournalService journalService;

    @GetMapping("/daily")
    public List<Journal> findDailyJournal(@RequestParam String date) {
        //
        return journalService.findJournals(date, ViewType.DAILY);
    }

    @GetMapping("/weekly")
    public List<Journal> findWeeklyJournal(@RequestParam String date) {
        //
        return journalService.findJournals(date, ViewType.WEEKLY);
    }

    @GetMapping("/monthly")
    public List<Journal> findMonthlyJournal(@RequestParam String date) {
        //
        return journalService.findJournals(date, ViewType.MONTHLY);
    }
}
