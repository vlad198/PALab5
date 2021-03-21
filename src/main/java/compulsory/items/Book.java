package compulsory.items;

import compulsory.exceptions.NotAnAudioException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.tika.Tika;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
public @Data
@ToString(callSuper = true)
@AllArgsConstructor
class Book extends Item {
    private List<String> authors;
    private String bookName;

    public Book(String name, String path, String bookName, String... authors) {
        super(name, path);
        this.bookName = bookName;
        this.authors = new LinkedList<>(Arrays.asList(authors));
    }

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
}
