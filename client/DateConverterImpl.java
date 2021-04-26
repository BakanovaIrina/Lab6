package client;

import another.console.DateConverter;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс для конвертирования даты
 */
public class DateConverterImpl implements DateConverter, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Красивый формат даты
     */
    private final SimpleDateFormat dateFormat;

    /**
     * Конструктор
     * @param dateFormat формат
     */
    public DateConverterImpl(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public String convertDateToStringFormat(Date date) {
        return dateFormat.format(date);
    }

    @Override
    public Date convertStringToDate(String date) throws ParseException {
        return dateFormat.parse(date);
    }
}
