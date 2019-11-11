package ExcelDownloaderAplication.util;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import ExcelDownloader.modelo.Grupo;

public class Utils {

	private Utils() {
		throw new IllegalStateException("Utility class");
	}

	public static int maxUsers(List<Grupo> grupos) {

		return grupos.stream().mapToInt(v -> v.getUsuarios().size()).max().orElseThrow(NoSuchElementException::new);

	}

	public static Font createFont(Workbook workbook, short color) {
		final Font font = workbook.createFont();
		font.setBold(true);
		font.setColor(color);
		return font;
	}

	public static void createCell(Row row, int index, CellStyle style, String cellValue) {
		final Cell cell = row.createCell(index);
		cell.setCellValue(cellValue);
		cell.setCellStyle(style);
	}

	public static String composeHeader(Grupo grupo) {
		return "Horario : " + grupo.getNombre().toString() + " Huecos: " + grupo.getHuecos();
	}

	public static String getUserFromGroup(Grupo grupo, int index) {

		String ret = "";
		if (!grupo.getUsuarios().isEmpty() && grupo.getUsuarios().size() > index) {
			ret = grupo.getUsuarios().get(index).getNombre() + " " + grupo.getUsuarios().get(index).getApellido();
		}

		return ret;
	}

}
