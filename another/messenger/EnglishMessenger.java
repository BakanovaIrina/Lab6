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
public class EnglishMessenger implements Messenger {


    HashMap<String, String> commandDescription;

    HashMap<String, String> inputMessages;

    HashMap<String, String> exceptionMessages;

    /**
     * Поле для конвертации даты при выводе (для красоты)
     */
    private final DateConverter dateConverter;

    /**
     * Конструктор
     * @param dateConverter - то, что будет конвертировать дату
     */
    public EnglishMessenger(DateConverter dateConverter) {
        this.dateConverter = dateConverter;
        initCommandDescription();
        initInputMessages();
        initExceptionMessages();
    }

    private void initCommandDescription(){
        commandDescription = new HashMap<>();
        commandDescription.put("add", "add {element}: add a new element to the collection");
        commandDescription.put("add_if_min", "add_if_min {element}: add a new element to the collection " +
                "if its value is less than the smallest element in this collection");
        commandDescription.put("average_of_health", "average_of_health: display the average " +
                "of the health field for all elements of the collection");
        commandDescription.put("clear", "clear : clear the collection");
        commandDescription.put("execute_script", "execute_script file_name: read and execute " +
                "the script from the specified file. \n" + "The script contains commands " +
                "in the same form in which the user enters them interactively");
        commandDescription.put("exit", "exit : exit the program (without saving to file)");
        commandDescription.put("group_counting_by_chapter", "group_counting_by_chapter: " +
                "group elements of the collection by field value " +
                "chapter, print the number of elements in each group");
        commandDescription.put("help", "help : display help for available commands");
        commandDescription.put("insert_at", "insert_at index {element} : add a new element at the " +
                "given position");
        commandDescription.put("info", "info: print information about the collection to standard output " +
                "(type, date of initialization, number of elements)");
        commandDescription.put("remove_by_id", "remove_by_id id : remove an element from the collection " +
                "by its id");
        commandDescription.put("reorder", "reorder : sort the collection in reverse order");
        commandDescription.put("save", "save : save collection to file");
        commandDescription.put("show", "show: print all elements of the collection to standard output" +
                "in string representation");
        commandDescription.put("sum_of_health", "sum_of_health : print the sum of the health field values " +
                "for all items in the collection");
        commandDescription.put("update", "update id {element}: update the id value of the collection " +
                "element whose id is equal to the given one");
    }

    private void initInputMessages(){
        inputMessages = new HashMap<>();
        inputMessages.put("name", "Enter the name:");
        inputMessages.put("coordinateX", "Enter a value for the X coordinate:");
        inputMessages.put("coordinateY", "Enter a value for the Y coordinate:");
        inputMessages.put("health", "Enter health:");
        inputMessages.put("category", "Enter Astartes Category:");
        inputMessages.put("weapon", "Enter Weapon:");
        inputMessages.put("meleeWeapon", "Enter MeleeWeapon:");
        inputMessages.put("chapterName", "Enter the Chapter Name:");
        inputMessages.put("parentLegion", "Enter the Parent Legion:");
        inputMessages.put("numberMarines", "Enter the number of marines:");
    }

    private void initExceptionMessages(){
        exceptionMessages = new HashMap<>();
        exceptionMessages.put("NoSuchCommand", "This command is unknown");
        exceptionMessages.put("UncorrectedSize", "Entered size is not correct");
        exceptionMessages.put("UncorrectedField", "One or more fields were entered incorrectly. " +
                "Element not created");
        exceptionMessages.put("UncorrectedFile", "The file is not correct");
        exceptionMessages.put("NoInputValue", "You don't input value to this command");
        exceptionMessages.put("UncorrectedScript", "An attempt was found to loop the program, " +
                "execute_script command will not be executed");
    }

    @Override
    public String getPrintSumOfHealthMessage(Float sum) {
        return "Sum of health: " + sum;
    }

    @Override
    public String getExitMessage() {
        return "You will exit from this app";
    }

    @Override
    public String getExceptionMessage(String exceptionName) {
        return exceptionMessages.get(exceptionName);
    }

    @Override
    public String getCommandDescription(String commandName) {
        return commandDescription.get(commandName);
    }

    @Override
    public String getInputMessage(String inputField) {
        return inputMessages.get(inputField);
    }

    /**
     * Метод для получения сообщения о существующих значениях enum
     *
     * @param stream - поток значений
     * @return String message
     */
    @Override
    public String getEnumMessage(Stream<String> stream) {
        String s = "Available Fields:";
        List<String> list = stream.collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            s = s + "\n" + list.get(i);
        }
        return s;
    }

    @Override
    public String getNoInputArgs(String fileName) {
        return "There are not any input args. File name will be change on \""
                + fileName + "\"";
    }

    @Override
    public String getHelloMessage() {
        return "You choose English language";
    }

    @Override
    public String getCommandIsExecutedSuccessfully(String commandName) {
        return "Command " + commandName + " is executed successfully";
    }

    @Override
    public String getPrintAverageOfHealthMessage(Float average) {
        return "Average of health: " + average;
    }

    @Override
    public String getSumMarinesInChapterMessage(String chapter, Long sum) {
        return "On chapter " + chapter + ": " + sum + "SpaceMarine(s)";
    }

    @Override
    public String getPrintInfo(String type, Date date, int size) {
        return "The type of this collection: " + type + "\n" +
                "Initialisation date: " + date + "\n" +
                "Size Of Collection: " + size;
    }

    @Override
    public String getNoElementsInCollection() {
        return "This collection is empty";
    }

    @Override
    public String getElementMessage(SpaceMarine spaceMarine) {
        return "Collection element id: " + spaceMarine.getId() + "\n" +
                "Collection element name: " + spaceMarine.getName() + "\n" +
                "Creation date: " + dateConverter.convertDateToStringFormat(spaceMarine.getCreationDate()) + "\n" +
                "Coordinates: " + "\n" +
                "Coordinate X: " + spaceMarine.getCoordinates().getX() + "\n" +
                "Coordinate Y: " + spaceMarine.getCoordinates().getY() + "\n" +
                "Health: " + spaceMarine.getHealth() + "\n" +
                "Astartes Category: " + spaceMarine.getCategory() + "\n" +
                "Weapon: " + spaceMarine.getWeaponType() + "\n" +
                "Melee Weapon: " + spaceMarine.getMeleeWeapon() + "\n" +
                "Chapter: " + spaceMarine.getChapter().getName() + "\n" +
                "Parent Legion: " + spaceMarine.getChapter().getParentLegion() + "\n" +
                "Space Marines count: " + spaceMarine.getChapter().getMarinesCount() + "\n";
    }

    @Override
    public String getNoSuchElementInCollection() {
        return "There is not such element in collection";
    }

    @Override
    public String getIsNotMinMessage() {
        return "This element is not min";
    }

    @Override
    public String getInputLanguageIsSuccessful() {
        return "Language entered successfully";
    }
}
