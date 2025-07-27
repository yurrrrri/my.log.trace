package io.myLogTrace.flow.anniversary;

import io.myLogTrace.domain.entity.Anniversary;
import io.myLogTrace.service.AnniversariesService;
import io.myLogTrace.service.vo.ViewType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/anniversaries")
@RestController
public class AnniversarySeek {
    //
    private final AnniversariesService anniversaryService;

    @GetMapping("/{id}")
    public Anniversary findAnniversary(@PathVariable String id) {
        //
        return anniversaryService.findAnniversary(id);
    }

    @PostMapping("/daily")
    public List<Anniversary> findDailyAnniversaries(@RequestParam String date) {
        //
        return anniversaryService.findAnniversaries(date, ViewType.DAILY);
    }

    @PostMapping("/weekly")
    public List<Anniversary> findWeeklyAnniversaries(@RequestParam String date) {
        //
        return anniversaryService.findAnniversaries(date, ViewType.WEEKLY);
    }

    @PostMapping("/monthly")
    public List<Anniversary> findMonthlyAnniversaries(@RequestParam String date) {
        //
        return anniversaryService.findAnniversaries(date, ViewType.MONTHLY);
    }
}
