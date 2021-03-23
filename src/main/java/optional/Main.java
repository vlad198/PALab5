package optional;

import optional.catalog.Catalog;
import optional.commands.*;
import optional.exceptions.NotACommandException;
import optional.items.Book;
import optional.items.ItemsList;
import optional.items.Movie;
import optional.items.Song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
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

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        while (true) {
            try {
                commandsList.runCommand(new Command(reader.readLine()), catalog, itemsList);
            } catch (NotACommandException e) {
                logger.warning("NotACommandException: " + e.getMessage());
            }
        }

    }
}
