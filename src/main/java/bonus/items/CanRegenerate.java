package bonus.items;

public interface CanRegenerate<T extends Item> {
    T generateObject(String... args);
}
