package another.console;

public interface InputCommandConverter extends InputConverter {
    /**
     * Конвертация из строки в массив
     * @param s - строка
     * @return - массив с введенным (сама команда и возможное значение)
     */
    String[] convertToCommand(String s);


    /**
     * Конвертация из строки в строку (в ином виде)
     * @param s - строка
     * @return - конвертированная строка
     */
    String convertToString(String s);
}
