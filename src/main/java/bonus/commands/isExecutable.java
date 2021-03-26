package bonus.commands;

import bonus.catalog.Catalog;
import bonus.items.ItemsList;
import freemarker.template.TemplateException;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Interface for all the commands in our commandsList that can be executable.
 */
public interface isExecutable {
    void executeCommand(List<String> args, Catalog catalog, ItemsList itemsList) throws IOException, TemplateException, TikaException, SAXException, ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException;
}
