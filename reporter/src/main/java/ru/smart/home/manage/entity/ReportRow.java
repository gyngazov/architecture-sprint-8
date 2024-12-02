package ru.smart.home.manage.entity;

import java.time.LocalDateTime;

/**
 * Условное событие от протеза.
 * @param id - ид события
 * @param dateTime
 * @param bionicId - ид протеза
 * @param description - описание события
 */
public record ReportRow(int id, int bionicId, LocalDateTime dateTime, String description) {}
