package optional.items;

import java.util.List;

/**
 * Interface that describes the object that can generate an object of their type.
 * @param <T> a class that extends the Item abstract class
 */
public interface CanRegenerate<T extends Item> {
    T generateObject(String... args);
}
