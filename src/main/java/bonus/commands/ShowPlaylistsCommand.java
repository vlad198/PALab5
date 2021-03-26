package bonus.commands;

import bonus.catalog.Catalog;
import bonus.graph.Graph;
import bonus.items.ItemsList;
import freemarker.template.TemplateException;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Class that describes the command which shows us the 'minimal playlists'
 * generated according to the task.
 */
public class ShowPlaylistsCommand implements isExecutable{
    @Override
    public void executeCommand(List<String> args, Catalog catalog, ItemsList itemsList) throws IOException, TemplateException, TikaException, SAXException, ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Graph graph = new Graph(catalog);
        graph.printPlaylist();
    }
}
