package server.file;

import another.baseClass.SpaceMarine;
import another.exceptions.UncorrectedFieldException;
import another.exceptions.UncorrectedSizeException;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Интерфейс для примитивного парсера
 */
public interface Parser {

    /**
     * Метод, получающий из строки элемент SpaceMarine
     * @param input - строки элементов
     * @return - элементы SpaceMarine
     * @throws UncorrectedSizeException - бросается, если ввод не соответствует количеству требуемых полей
     * @throws ParseException - бросается при парсинге
     * @throws UncorrectedFieldException - бросается, если поле некорректно
     */
    ArrayList<SpaceMarine> parseToSpaceMarine(ArrayList<String> input) throws UncorrectedSizeException, ParseException,
            UncorrectedFieldException;
}
