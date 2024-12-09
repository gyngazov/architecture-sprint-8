package ru.reporter;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReportEntry {

	int id;

	String name;

	String value;

}
