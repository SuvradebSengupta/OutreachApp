package com.cts.project.outreachApp.model;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JoinedEventExporter {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<JoinedEvent> list;

	public JoinedEventExporter(List<JoinedEvent> list) {
		this.list = list;
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Details");
	}

	private void writeHeaderLine() {
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Volunteer-ID");
		cell = row.createCell(1);
		cell.setCellValue("User-Name");
		cell = row.createCell(2);
		cell.setCellValue("Event-Name");
		cell = row.createCell(3);
		cell.setCellValue("Feedback-One");
		cell = row.createCell(4);
		cell.setCellValue("Feedback-Two");
		cell = row.createCell(5);
		cell.setCellValue("Feedback-Three");
		cell = row.createCell(6);
		cell.setCellValue("Feedback-Four");
		cell = row.createCell(7);
		cell.setCellValue("Feedback-Five");
	}

	private void writeDataLines() {
		int rowCount = 1;
		for (JoinedEvent user : list) {
			Row row = sheet.createRow(rowCount++);
			Cell cell = row.createCell(0);
			cell.setCellValue(user.getId());
			cell = row.createCell(1);
			cell.setCellValue(user.getUsername());
			cell = row.createCell(2);
			cell.setCellValue(user.getEventName());
			cell = row.createCell(3);
			cell.setCellValue(user.getFeedbackOne());
			cell = row.createCell(4);
			cell.setCellValue(user.getFeedbackTwo());
			cell = row.createCell(5);
			cell.setCellValue(user.getFeedbackThree());
			cell = row.createCell(6);
			cell.setCellValue(user.getFeedbackFour());
			cell = row.createCell(7);
			cell.setCellValue(user.getFeedbackFive());
		}
	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine();
		writeDataLines();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}

}
