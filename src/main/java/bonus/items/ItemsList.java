package bonus.items;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that describes the items available to be instantiated in our catalogue.
 */
@Data
@EqualsAndHashCode
public class ItemsList implements Serializable {
    private Map<String, CanRegenerate<? extends Item>> itemsList = new HashMap<>();

    /**
     * This function adds a new item in the available items to be instantiated.
     * @param itemName the item name
     * @param item the item that can be instantiated in our catalogue.
     */
    public void add(String itemName, CanRegenerate<? extends Item> item) {
        itemsList.put(itemName, item);
    }
}
