package item;

public class ItemServiceImplementation implements ItemService {

    private static int count = 0;

    public String getName() {
        ItemServiceImplementation.count++;
        return "Item - " + ItemServiceImplementation.count;
    }
}
