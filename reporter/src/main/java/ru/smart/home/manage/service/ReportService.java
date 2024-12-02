package ru.smart.home.manage.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smart.home.manage.entity.ReportRow;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ReportService {
    private static final Random rand = new Random();
    private static final int FROM = 50;
    private static final int TO = 100;
    public List<ReportRow> getReport() {

        List<ReportRow> rowList = new ArrayList<>();
        for (int i = 0; i < next(); i++) {
            rowList.add(new ReportRow(
                    next()
                    , next()
                    , LocalDateTime.now().minusMinutes(next())
                    , frase()));
        }
        return rowList;
    }

    private int next() {
        return rand.nextInt(FROM, TO);
    }

    private String frase() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < next(); i++) {
            sb.append(Character.toChars(next()));
        }
        return sb.toString();
    }

}
