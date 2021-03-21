package compulsory.items;

import compulsory.exceptions.NotAVideoException;
import lombok.*;
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
class Movie extends Item {
    private List<String> movieDirectors;
    private String movieName;

    public Movie(String name, String path, String movieName, String... movieDirectors) {
        super(name, path);
        this.movieDirectors = new LinkedList<>(Arrays.asList(movieDirectors));
        this.movieName = movieName;
    }

    public void play() throws IOException {
        File f = new File(getPath());

        Tika tika = new Tika();
        String type = tika.detect(f);

        if (!type.startsWith("video/")) {
            throw new NotAVideoException("File must be a video.");
        }

        Desktop.getDesktop().open(new File(this.getPath()));
    }
}
