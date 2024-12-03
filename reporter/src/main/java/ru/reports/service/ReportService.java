package ru.reports.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.reports.entity.ReportRow;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ReportService {
    private static final Random rand = new Random();
    private static final int FROM = 11;
    private static final int TO = 23;
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public List<ReportRow> getReport() {

        List<ReportRow> rowList = new ArrayList<>();
        int id = next();
        LocalDateTime now = LocalDateTime.now();
        for (int i = 0; i < next(); i++) {
            rowList.add(new ReportRow(
                    id + i
                    , next()
                    , now.minusMinutes(next()).format(DTF)
                    , frase()));
        }
        return rowList;
    }

    private int next() {
        return rand.nextInt(FROM, TO);
    }
    private char symbol() {
        int i = rand.nextBoolean() ? 65 : 97;
        return (char) rand.nextInt(i, i + 26);
    }

    private String frase() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < next(); i++) {
            sb.append(symbol());
        }
        return sb.toString();
    }

}
