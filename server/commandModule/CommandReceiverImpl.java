package server.commandModule;

import another.baseClass.SpaceMarine;
import another.messenger.Messenger;
import server.collection.CollectionManager;
import server.application.ServerApplication;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс CommandReceiver
 */
public class CommandReceiverImpl implements CommandReceiver{
    /**
     * Поле application
     */
    private final ServerApplication application;

    /**
     * Поле CollectionManager
     */
    private final CollectionManager<SpaceMarine> collectionManager;

    /**
     * Поле CommandManager
     */
    private final CommandManager commandManager;

    private Messenger messenger;

    private ArrayList<String> lastScripts;

    /**
     * Конструктор
     * @param application - соответствующее поле
     * @param collectionManager - соответствующее поле
     * @param commandManager - соответствующее поле
     */
    public CommandReceiverImpl(ServerApplication application, CollectionManager<SpaceMarine> collectionManager,
                           CommandManager commandManager) {
        this.application = application;
        this.collectionManager = collectionManager;
        this.commandManager = commandManager;
        lastScripts = new ArrayList<>();
    }

    @Override
    public void clearLastScripts() {
        lastScripts.clear();
    }

    @Override
    public String averageOfHealth() {
        float sum = 0f;
        int size = 0;
        Stream<SpaceMarine> stream = collectionManager.getStream();
        List<Float> healthOfMarine = stream
                .filter(Objects::nonNull)
                .map(SpaceMarine::getHealth)
                .collect(Collectors.toList());
        for (Float health: healthOfMarine) {
            sum += health;
            size++;
        }

        if(size == 0){
            return messenger.getNoElementsInCollection();
        }
        else {
            return messenger.getPrintAverageOfHealthMessage(sum/size);
        }
    }

    @Override
    public String add(SpaceMarine spaceMarine) {
        if(spaceMarine != null){
            collectionManager.addElement(spaceMarine);
            return messenger.getCommandIsExecutedSuccessfully("add");
        }
        else {
            return messenger.getExceptionMessage("UncorrectedField");
        }
    }

    @Override
    public String addIfMin(SpaceMarine spaceMarine) {
        if(spaceMarine == null){
            return messenger.getExceptionMessage("UncorrectedField");
        }
        Comparator<SpaceMarine> comparator = Comparator.naturalOrder();
        Stream<SpaceMarine> stream = collectionManager.getStream();
        SpaceMarine min = stream.
                min(comparator).
                get();

        if (min.compareTo(spaceMarine) < 0){
            collectionManager.addElement(spaceMarine);
            return messenger.getCommandIsExecutedSuccessfully("add_if_min");
        }
        else {
            return messenger.getIsNotMinMessage();
        }
    }

    @Override
    public String clear() {
        collectionManager.clear();
        return messenger.getCommandIsExecutedSuccessfully("clear");
    }

    @Override
    public void exit() {
        save();
        application.exit();
    }

    @Override
    public String groupCountingByChapter() {
        Stream<SpaceMarine> stream = collectionManager.getStream();
        String result = "";
        Map<String, Long> map = stream
                .filter(spaceMarine -> spaceMarine != null)
                .map(spaceMarine -> spaceMarine.getChapter().getName())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Iterator<Map.Entry<String, Long>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Long> map1 = iterator.next();
            result += messenger.getSumMarinesInChapterMessage(map1.getKey(), map1.getValue());
        }
        return result;
    }

    @Override
    public String help() {
        String result = "";
        List<String> list = commandManager.getStreamOfCommands()
                .map(command -> command.writeInfo(messenger))
                .collect(Collectors.toList());
        for (String command: list) {
            result += command + "\n";
        }
        return result;
    }

    @Override
    public String info() {
        return messenger.getPrintInfo(collectionManager.getType().getName(), collectionManager.getDate(),
                collectionManager.getSize());
    }

    @Override
    public String reorder() {
        collectionManager.reorder();
        return  messenger.getCommandIsExecutedSuccessfully("reorder");
    }

    @Override
    public void save() {
        collectionManager.save();
    }

    @Override
    public String show() {
        String result = "";
        Stream<SpaceMarine> stream = collectionManager.getStream();
        List<String> list = stream.filter(spaceMarine -> spaceMarine != null)
                .map(spaceMarine -> messenger.getElementMessage(spaceMarine))
                .collect(Collectors.toList());
        if(list.size() == 0){
            return messenger.getNoElementsInCollection();
        }
        for (String element: list) {
            result += "\n" + element;
        }
        return result;
    }

    @Override
    public String sumOfHealth() {
        float sum = 0f;
        Stream<SpaceMarine> stream = collectionManager.getStream();
        List<Float> healthOfMarine = stream
                .filter(spaceMarine -> spaceMarine != null)
                .map(SpaceMarine::getHealth)
                .collect(Collectors.toList());
        for (Float health: healthOfMarine) {
            sum += health;
        }

        if(sum == 0){
            return messenger.getNoElementsInCollection();
        }
        else {
            return messenger.getPrintSumOfHealthMessage(sum);
        }
    }

    @Override
    public String removeById(int id) {
        SpaceMarine spaceMarine1;
        try {
            Stream<SpaceMarine> stream = collectionManager.getStream();
            spaceMarine1 = stream.filter(spaceMarine -> spaceMarine != null)
                    .filter(spaceMarine -> spaceMarine.getId() == id)
                    .findFirst().get();
        }
        catch (NoSuchElementException e){
            return messenger.getNoElementsInCollection();
        }
        collectionManager.removeElement(spaceMarine1);
        return messenger.getCommandIsExecutedSuccessfully("remove_by_id");
    }

    @Override
    public String updateId(int id, SpaceMarine spaceMarine) {
        if(spaceMarine == null){
            return messenger.getExceptionMessage("UncorrectedField");
        }
        Stream<SpaceMarine> stream = collectionManager.getStream();
        SpaceMarine spaceMarine1 = stream
                .filter(spaceMarine2 -> spaceMarine != null)
                .filter(spaceMarine2 -> spaceMarine.getId() == id)
                .findFirst()
                .get();
        if(spaceMarine1 != null && spaceMarine1.getId() == spaceMarine.getId()){
            changeFields( spaceMarine1,  spaceMarine);
            return messenger.getCommandIsExecutedSuccessfully("update");
        }
        else {
            return messenger.getNoSuchElementInCollection();
        }
    }

    @Override
    public String insertAt(int index, SpaceMarine spaceMarine) {
        if(spaceMarine == null){
            return messenger.getExceptionMessage("UncorrectedField");
        }
        collectionManager.addElement(spaceMarine, index);
        return messenger.getCommandIsExecutedSuccessfully("insert_at");
    }

    @Override
    public String executeScript(String fileName) {

        if (lastScripts.contains(fileName)){
            return null;
        }

        lastScripts.add(fileName);

        return fileName;
    }

    @Override
    public void setMessenger(Messenger messenger) {
        this.messenger = messenger;
    }

    private void changeFields(SpaceMarine spaceMarine1, SpaceMarine spaceMarine2){
        spaceMarine1.setName(spaceMarine2.getName());
        spaceMarine1.setCoordinates(spaceMarine2.getCoordinates());
        spaceMarine1.setCreationDate(spaceMarine2.getCreationDate());
        spaceMarine1.setHealth(spaceMarine2.getHealth());
        spaceMarine1.setCategory(spaceMarine2.getCategory());
        spaceMarine1.setWeaponType(spaceMarine2.getWeaponType());
        spaceMarine1.setMeleeWeapon(spaceMarine2.getMeleeWeapon());
        spaceMarine1.setChapter(spaceMarine2.getChapter());
    }

}
