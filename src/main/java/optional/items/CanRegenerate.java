package optional.items;

import java.util.List;

public interface CanRegenerate<T extends Item> {
    T generateObject(String... args);
}
