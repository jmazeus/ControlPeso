package mx.com.solsist.control.peso.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static SimpleDateFormat sdfSave = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	public static SimpleDateFormat sdfSaveWithGuion = new SimpleDateFormat("dd-MM-yyyy HH:mm");

	public static String setMillisecondsTimeToDateToString(long timeInMillis) {
		String fecha = "";
		fecha = sdfSave.format(new Date(timeInMillis));
		System.out.println(fecha);
		
		return fecha;
	}
	
	public static Date convertStringToDate(String dateStr) {
		try {
			return sdfSave.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static Date setMillisecondsTimeToDateToStringToDate(long timeInMillis) {

		return convertStringToDate(sdfSave.format(new Date(timeInMillis)));
	}

}
