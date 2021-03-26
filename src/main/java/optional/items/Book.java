package optional.items;

import compulsory.exceptions.NotAnAudioException;
import lombok.*;
import org.apache.tika.Tika;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Class that describes a 'book item' in our catalog.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Book extends Item implements CanRegenerate<Book>, Serializable {
    private List<String> authors = new LinkedList<>();
    private String bookName;

    public Book(String name, String path, String bookName, String... authors) {
        super(name, path);
        this.bookName = bookName;
        this.authors = new LinkedList<>(Arrays.asList(authors));
    }

    public Book(String name, String path, String bookName, List<String> authors) {
        super(name, path);
        this.bookName = bookName;
        this.authors = new LinkedList<>(authors);
    }

    /**
     * Method that opens the book if it's in pdf format.
     * @throws IOException exception
     */
    @Override
    public void play() throws IOException {
        File f = new File(getPath());

        Tika tika = new Tika();
        String type = tika.detect(f);

        if (!type.startsWith("application/pdf")) {
            throw new NotAnAudioException("File must be a pdf.");
        }

        Desktop.getDesktop().open(new File(this.getPath()));
    }

    @Override
    public Book generateObject(String... args) {
        return new Book(args[1], args[2], args[3], Arrays.asList(args).subList(4, args.length));
    }
}
