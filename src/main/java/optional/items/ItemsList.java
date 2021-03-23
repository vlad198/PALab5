package optional.items;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode
public class ItemsList implements Serializable {
    private Map<String, CanRegenerate<? extends Item>> itemsList = new HashMap<>();

    public void add(String itemName, CanRegenerate<? extends Item> item) {
        itemsList.put(itemName, item);
    }
}
