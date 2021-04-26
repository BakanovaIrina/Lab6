package another.messenger;

import another.baseClass.SpaceMarine;
import another.console.DateConverter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс для получения сообщений на английском языке
 */
public class RussianMessenger implements Messenger {

    /**
     * Карта для хранения описания команд
     */
    HashMap<String, String> commandDescription;

    /**
     * Карта для хранения ввода полей
     */
    HashMap<String, String> inputMessages;

    /**
     * Карта для хранения сообщений об исключениях
     */
    HashMap<String, String> exceptionMessages;

    /**
     * Поле для конвертации даты при выводе (для красоты)
     */
    private final DateConverter dateConverter;

    /**
     * Конструктор
     * @param dateConverter - то, что будет конвертировать дату
     */
    public RussianMessenger(DateConverter dateConverter) {
        this.dateConverter = dateConverter;
        initCommandDescription();
        initInputMessages();
        initExceptionMessages();
    }

    private void initCommandDescription(){
        commandDescription = new HashMap<>();
        commandDescription.put("add", "add {element}: добавить новый элемент в коллекцию");
        commandDescription.put("add_if_min", "add_if_min {element} : добавить новый элемент в коллекцию, " +
                "если его значение меньше, чем у наименьшего элемента этой коллекции");
        commandDescription.put("average_of_health", "average_of_health : вывести среднее значение поля" +
                " health для всех элементов коллекции");
        commandDescription.put("clear", "clear : очистить коллекцию");
        commandDescription.put("execute_script", "execute_script file_name : считать и исполнить скрипт" +
                " из указанного файла. \nВ скрипте содержатся команды в таком же виде, в котором их " +
                "вводит пользователь в интерактивном режиме");
        commandDescription.put("exit", "exit : завершить программу (без сохранения в файл)");
        commandDescription.put("group_counting_by_chapter", "group_counting_by_chapter : " +
                "сгруппировать элементы коллекции по значению поля chapter, " +
                "вывести количество элементов в каждой группе");
        commandDescription.put("help", "help : вывести справку по доступным командам");
        commandDescription.put("insert_at", "insert_at index {element} : добавить новый элемент " +
                "в заданную позицию");
        commandDescription.put("info", "info : вывести в стандартный поток вывода информацию о коллекции " +
                "(тип, дата инициализации, количество элементов)");
        commandDescription.put("remove_by_id", "remove_by_id id : удалить элемент из коллекции по его id");
        commandDescription.put("reorder", "reorder : отсортировать коллекцию в порядке, обратном нынешнему");
        commandDescription.put("save", "save : сохранить коллекцию в файл");
        commandDescription.put("show", "show : вывести в стандартный поток вывода все элементы коллекции " +
                "в строковом представлении");
        commandDescription.put("sum_of_health", "sum_of_health : вывести сумму значений поля health " +
                "для всех элементов коллекции");
        commandDescription.put("update", "update id {element} : обновить значение id элемента коллекции, " +
                "id которого равен заданному");
    }

    private void initInputMessages(){
        inputMessages = new HashMap<>();
        inputMessages.put("name", "Введите имя бойца:");
        inputMessages.put("coordinateX", "Введите значение координаты X:");
        inputMessages.put("coordinateY", "Введите значение координаты Y:");
        inputMessages.put("health", "Введите значение здоровья бойца:");
        inputMessages.put("category", "Введите категорию бойца:");
        inputMessages.put("weapon", "Введите основное оружие бойца:");
        inputMessages.put("meleeWeapon", "Введите оружие ближнего боя бойца:");
        inputMessages.put("chapterName", "Введите название главы:");
        inputMessages.put("parentLegion", "Введите родительский регион:");
        inputMessages.put("numberMarines", "Введите количество бойцов:");
    }

    private void initExceptionMessages(){
        exceptionMessages = new HashMap<>();
        exceptionMessages.put("NoSuchCommand", "Мы не знаем данную команду");
        exceptionMessages.put("UncorrectedSize", "Размер введенного не соответствует требованиям");
        exceptionMessages.put("UncorrectedField", "Одно или несколько полей было введено некорректно. " +
                "Элемент не создан");
        exceptionMessages.put("UncorrectedFile", "Извините, но данный файл не доступен");
        exceptionMessages.put("NoInputValue", "Не было введено значение, нужное для исполнения команды");
        exceptionMessages.put("UncorrectedScript", "Была найдена попытка зациклить программу. " +
                "Команда execute_script не будет выполнена");
        exceptionMessages.put("ConnectionException", "Произошла ошибка с подключением к серверу");
        exceptionMessages.put("ForbiddenCommand", "Будет выполнен выход из клиентского приложения");
    }

    @Override
    public String getNoInputArgs(String fileName) {
        return "Не были введены аргументы командной строки. Имя файла будет заменено на \""
                + fileName + "\"";
    }

    @Override
    public String getExceptionMessage(String exceptionName) {
        return exceptionMessages.get(exceptionName);
    }

    @Override
    public String getHelloMessage() {
        return "Вы выбрали русский язык";
    }

    @Override
    public String getCommandIsExecutedSuccessfully(String commandName) {
        return "Команда " + commandName + " завершилась успешно";
    }

    @Override
    public String getInputLanguageIsSuccessful() {
        return "Русский язык успешно установлен";
    }

    @Override
    public String getPrintInfo(String type, Date date, int size) {
        return  "Тип данной коллекции: " + type + "\n" +
                "Дата инициализации коллекции: " + dateConverter.convertDateToStringFormat(date) + "\n" +
                "Размер данной коллекции: " + size;
    }

    @Override
    public String getPrintSumOfHealthMessage(Float sum) {
        return "Сумма здоровья элементов коллекции: " + sum;
    }

    @Override
    public String getExitMessage() {
        return "Будет осуществлен выход из приложения";
    }

    @Override
    public String getSumMarinesInChapterMessage(String chapter, Long sum) {
        return "На главе " + chapter + " находятся: " + sum + " бойцов";
    }

    @Override
    public String getCommandDescription(String commandName) {
        return commandDescription.get(commandName);
    }

    @Override
    public String getPrintAverageOfHealthMessage(Float average) {
        return "Среднее значение здоровья: " + average;
    }

    @Override
    public String getNoElementsInCollection() {
        return "Данная коллекция пуста";
    }

    @Override
    public String getElementMessage(SpaceMarine spaceMarine) {
        return  "Id элемента коллекции: " + spaceMarine.getId() + "\n" +
                "Имя элемента коллекции: " + spaceMarine.getName() + "\n" +
                "Дата создания элемента: "
                + dateConverter.convertDateToStringFormat(spaceMarine.getCreationDate()) + "\n" +
                "Координаты элемента: " + "\n" +
                "Координата X: " + spaceMarine.getCoordinates().getX() + "\n" +
                "Координата Y: " + spaceMarine.getCoordinates().getY() + "\n" +
                "Здоровье: " + spaceMarine.getHealth() + "\n" +
                "Категория Астартес: " + spaceMarine.getCategory() + "\n" +
                "Оружие: " + spaceMarine.getWeaponType() + "\n" +
                "Оружие ближнего боя: " + spaceMarine.getMeleeWeapon() + "\n" +
                "Глава: " + spaceMarine.getChapter().getName() + "\n" +
                "Родительский регион: " + spaceMarine.getChapter().getParentLegion() + "\n" +
                "Морских пехотинцев: " + spaceMarine.getChapter().getMarinesCount() + "\n";
    }

    @Override
    public String getNoSuchElementInCollection() {
        return "Нет подходящего элемента в коллеции";
    }

    @Override
    public String getIsNotMinMessage() {
        return "Элемент не является минимальным";
    }

    @Override
    public String getInputMessage(String inputField) {
        return inputMessages.get(inputField);
    }

    @Override
    public String getEnumMessage(Stream<String> stream) {
        String s = "Доступные поля:";
        List<String> list = stream.collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            s = s + "\n" + list.get(i);
        }
        return s;
    }
}
