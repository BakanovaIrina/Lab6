package client;

import another.console.InputCommandConverter;

public class InputCommandConverterImpl implements InputCommandConverter {
    /**
     * Конвертация из строки в массив
     *
     * @param s - строка
     * @return - массив с введенным (сама команда и возможное значение)
     */
    @Override
    public String[] convertToCommand(String s) {
        String[] commandArgs = s.replaceAll("(\t| )+", " ")
                .replaceAll("^ | $", "")
                .split(" ");
        if(commandArgs[0] != null){
            commandArgs[0].toLowerCase();
        }
        return commandArgs;
    }

    @Override
    public String convertToString(String s) {
        return s.toLowerCase();
    }
}
