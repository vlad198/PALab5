package bonus.commands;

import bonus.catalog.Catalog;
import bonus.items.Item;
import bonus.items.ItemsList;
import freemarker.template.TemplateException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Class that describes the info command for our shell.
 */
public class InfoCommand implements isExecutable {
    private static final Logger logger = Logger.getLogger(InfoCommand.class.getName());

    /**
     * This function searches an item in a list of items
     * @param name the search criteria: search by the name of the item
     * @param catalogItemList the list of items in which we want to search the item with the given name
     * @return the item if it finds it, otherwise null.
     */
    private Item findByName(String name, List<Item> catalogItemList) {
        for (Item item : catalogItemList) {
            if (item.getName().equals(name))
                return item;
        }
        return null;
    }

    @Override
    public void executeCommand(List<String> args, Catalog catalog, ItemsList itemsList) throws IOException, TemplateException, TikaException, SAXException {
        Item item = findByName(args.get(0), catalog.getItems());

        if (item != null) {
            File file = new File(item.getPath());

            //Parser method parameters
            Parser parser = new AutoDetectParser();
            BodyContentHandler handler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            FileInputStream inputStream = new FileInputStream(file);
            ParseContext context = new ParseContext();

            parser.parse(inputStream, handler, metadata, context);
            logger.info(handler.toString());

            //getting the list of all meta data elements
            String[] metadataNames = metadata.names();

            for (String name : metadataNames) {
               logger.info(name + ": " + metadata.get(name));
            }
        }
    }
}
