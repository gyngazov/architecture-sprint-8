package ru.reports.controller;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.reports.entity.ReportRow;
import ru.reports.service.ReportService;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
@Authenticated
public class ReportController {

    private final ReportService reportService;

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
    private static final String ROLE = "prothetic_user";

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RolesAllowed(ROLE)
    public List<ReportRow> getReport() {
        logger.info("Запрос отчета");
        return reportService.getReport();
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    @ResponseStatus(HttpStatus.OK)
    @RolesAllowed(ROLE)
    public void handle() {
        logger.info("Запрос OPTIONS");
    }

}
