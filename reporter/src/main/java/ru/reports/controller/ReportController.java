package ru.reports.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.reports.entity.ReportRow;
import ru.reports.service.ReportService;

import java.util.List;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ReportRow> getReport() {
        logger.info("Запрос отчета");
        return reportService.getReport();
    }

}
