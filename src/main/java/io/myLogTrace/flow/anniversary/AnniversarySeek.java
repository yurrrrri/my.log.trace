package io.myLogTrace.flow.anniversary;

import io.myLogTrace.domain.entity.Anniversary;
import io.myLogTrace.service.AnniversaryService;
import io.myLogTrace.service.vo.AnniversarySearchType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/anniversaries")
@RestController
public class AnniversarySeek {
    //
    private final AnniversaryService anniversaryService;

    @GetMapping("/daily/{date}")
    public List<Anniversary> findDailyAnniversaries(@PathVariable String date) {
        //
        return anniversaryService.findAnniversaries(date, AnniversarySearchType.DAILY);
    }

    @GetMapping("/weekly/{date}")
    public List<Anniversary> findWeeklyAnniversaries(@PathVariable String date) {
        //
        return anniversaryService.findAnniversaries(date, AnniversarySearchType.WEEKLY);
    }

    @GetMapping("/monthly/{date}")
    public List<Anniversary> findMonthlyAnniversaries(@PathVariable String date) {
        //
        return anniversaryService.findAnniversaries(date, AnniversarySearchType.MONTHLY);
    }
}
