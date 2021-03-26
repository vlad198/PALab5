package bonus.graph;

import bonus.commands.AddCommand;
import bonus.items.Item;
import bonus.catalog.Catalog;
import lombok.Data;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.logging.Logger;

/**
 * Class that describes a graph of items.
 */
@Data
public class Graph {
    private static final Logger logger = Logger.getLogger(Graph.class.getName());
    private Map<Item, List<Item>> adjacencyList = new HashMap<>();

    /**
     * This function adds a new edge to our graph
     * @param itemToAdd node 1
     * @param neighbor node 2
     */
    private void addEdge(Item itemToAdd, Item neighbor) {
        adjacencyList.get(itemToAdd).add(neighbor);
        adjacencyList.get(neighbor).add(itemToAdd);
    }

    /**
     * Tests if two items have common features
     * @param item1 first item
     * @param item2 second item
     * @return true if the given items have common features; false otherwise
     * @throws IllegalAccessException exception
     * @throws NoSuchMethodException exception
     * @throws InvocationTargetException exception
     */
    private boolean commonFeature(Item item1, Item item2) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map<String, String> propertiesItem1 = BeanUtils.describe(item1);
        Map<String, String> propertiesItem2 = BeanUtils.describe(item2);

        for (String valueItem1 : propertiesItem1.values()) {
            for (String valueItem2 : propertiesItem2.values()) {
                if (valueItem1 != null && valueItem1.equals(valueItem2))
                    return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Graph: \n");
        for (Item key : adjacencyList.keySet()) {
            for (Item node : adjacencyList.get(key))
                result.append(key.getName()).append(" -> ").append(node.getName()).append("\n");
        }
        return result.toString();
    }

    /**
     * Generates the adjacency list of the graph based on a given catalogue.
     * @param catalog the catalogue on which we want to generate the graph
     * @throws IllegalAccessException exception
     * @throws NoSuchMethodException exception
     * @throws InvocationTargetException exception
     */
    public Graph(Catalog catalog) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        List<Item> itemList = catalog.getItems();

        for (int i = 0; i < itemList.size() - 1; i++) {
            Item item1 = itemList.get(i);


            adjacencyList.computeIfAbsent(item1, k -> new LinkedList<>());

            for (int j = i + 1; j < itemList.size(); j++) {
                Item item2 = itemList.get(j);

                adjacencyList.computeIfAbsent(item2, k -> new LinkedList<>());

                if ((item1.getClass() != item2.getClass() || !item1.equals(item2)) && commonFeature(item1, item2)) {
                    addEdge(item1, item2);
                }
            }
        }
    }

    /**
     * This function assigns a playlist number to all items that have common features with a given item
     * @param node the item with which we start assigning playlists numbers.
     * @param colors
     */
    private void colorConnectedComponent(Item node, Map<Item, Integer> colors) {
        Queue<Item> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Item z = queue.remove();

            Set<Integer> colorsTaken = new HashSet<>();

            for (Item neighbor : adjacencyList.get(z)) {
                int value = colors.get(neighbor);
                if (value != -1)
                    colorsTaken.add(value);
                else
                    queue.add(neighbor);
            }

            for (int i = 0; i < adjacencyList.keySet().size(); i++)
                if (!colorsTaken.contains(i)) {
                    colors.put(z, i);
                    break;
                }
        }
    }

    /**
     * This function goes through all items that are 'unrelated' and assigns
     * the playlists number to all the items that are related with an item.
     * @return a map which contains the playlist number for each item.
     */
    private Map<Item, Integer> graphColoring() {
        Map<Item, Integer> colors = new HashMap<>();

        for (Item item : adjacencyList.keySet())
            colors.put(item, -1);

        for (Item item : adjacencyList.keySet())
            if (colors.get(item) == -1) {
                colorConnectedComponent(item, colors);
            }

        return colors;
    }

    /**
     * This function calculates the maximum playlist number in the playlist
     * @param colors the playlist map which contains the playlist number for each item.
     * @return the maximum color
     */
    private int maxColor(Map<Item, Integer> colors) {
        int maxCol = 0;
        for (Item item : colors.keySet())
            if (maxCol < colors.get(item))
                maxCol = colors.get(item);
        return maxCol;
    }

    /**
     * This function prints the playlists according to the task
     */
    public void printPlaylist() {
        Map<Item, Integer> colors = graphColoring();
        for (int playlistNumber = 0; playlistNumber <= maxColor(colors); playlistNumber++) {
            logger.info("Playlist " + playlistNumber);
            for (Item item : colors.keySet())
                if (colors.get(item).equals(playlistNumber))
                    logger.info(item.getName());
        }
    }

}
