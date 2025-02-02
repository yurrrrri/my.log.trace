package io.myLogTrace.flow.history;

import io.myLogTrace.domain.entity.History;
import io.myLogTrace.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/histories")
@RestController
public class HistorySeek {
    //
    private final HistoryService historyService;

    @GetMapping("/{id}")
    public History findHistory(@PathVariable String id) {
        //
        return historyService.findHistory(id);
    }

    @GetMapping("")
    public List<History> findHistories() {
        //
        return historyService.findHistories();
    }
}
