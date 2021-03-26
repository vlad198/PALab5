package bonus;

import bonus.catalog.Catalog;
import bonus.commands.*;
import bonus.exceptions.NotACommandException;
import bonus.graph.Graph;
import bonus.items.Book;
import bonus.items.ItemsList;
import bonus.items.Movie;
import bonus.items.Song;
import freemarker.template.TemplateException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.varia.NullAppender;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException, ClassNotFoundException, TemplateException, TikaException, SAXException, NotACommandException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        BasicConfigurator.configure(new NullAppender());

        Catalog catalog = new Catalog("catalogue_meu", System.getProperty("user.dir").toString() + "\\catalogues");

        // ItemsList
        ItemsList itemsList = new ItemsList();

        itemsList.add("movie", new Movie());
        itemsList.add("song", new Song());
        itemsList.add("book", new Book());

        // Commands List
        CommandsList commandsList = new CommandsList();

        commandsList.add("add", new AddCommand());
        commandsList.add("exit", new ExitCommand());
        commandsList.add("list", new ListCommand());
        commandsList.add("play", new PlayCommand());
        commandsList.add("save", new SaveCommand());
        commandsList.add("report", new ReportCommand());
        commandsList.add("info", new InfoCommand());
        commandsList.add("load", new LoadCommand());
        commandsList.add("playlists", new ShowPlaylistsCommand());

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        while (true) {
            try {
                commandsList.runCommand(new Command(reader.readLine()), catalog, itemsList);
            } catch (NotACommandException | TemplateException e) {
                logger.warning("NotACommandException: " + e.getMessage());
            } catch (TikaException | SAXException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
