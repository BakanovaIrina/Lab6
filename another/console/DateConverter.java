package another.console;

import java.text.ParseException;
import java.util.Date;

/**
 * Интерфейс для конвертирования даты в красивом формате
 */
public interface DateConverter {

    /**
     * Конвертирование строки в дату
     * @param date дата
     * @return дату в Date
     * @throws ParseException исключение при парсинге
     */
    Date convertStringToDate(String date) throws ParseException;

    /**
     * Конвертирование даты в строку
     * @param date - дата
     * @return дату в String
     */
    String convertDateToStringFormat(Date date);
}
