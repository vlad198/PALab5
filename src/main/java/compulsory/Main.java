package compulsory;

import compulsory.catalog.Catalog;
import compulsory.exceptions.NotAPathException;
import compulsory.items.Book;
import compulsory.items.Movie;
import compulsory.items.Song;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        try {
            Catalog catalog = new Catalog("catalogue_meu", System.getProperty("user.dir").toString() + "\\catalogues");

            catalog.add(new Song("song", System.getProperty("user.dir").toString() + "\\project_resources" + "\\song.mp3", "catalog", "author"));
            catalog.add(new Movie("movie", System.getProperty("user.dir").toString() + "\\project_resources" + "\\movie.mp4", "intellij", "Eu"));
            catalog.add(new Book("book", System.getProperty("user.dir").toString() + "\\project_resources" + "\\book.pdf", "book", "me"));

            catalog.save();
            catalog.load("catalogue_meu");

            catalog.getItems().get(0).play();
            catalog.getItems().get(1).play();
            catalog.getItems().get(2).play();

            catalog.list();
        } catch (ClassNotFoundException classNotFoundException) {
            logger.info("ClassNotFoundException:" + classNotFoundException);
        } catch (IOException ioException) {
            logger.info("IOException: " + ioException);
        }


    }

}
