package optional.items;

import compulsory.exceptions.NotAVideoException;
import lombok.*;
import org.apache.tika.Tika;
import org.apache.tika.sax.Link;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
public @Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
class Movie extends Item implements CanRegenerate<Movie>, Serializable {
    private List<String> movieDirectors = new LinkedList<>();
    private String movieName;

    public Movie(String name, String path, String movieName, String... movieDirectors) {
        super(name, path);
        this.movieDirectors = new LinkedList<>(Arrays.asList(movieDirectors));
        this.movieName = movieName;
    }

    public Movie(String name, String path, String movieName, List<String> movieDirectors) {
        super(name, path);
        this.movieName = movieName;
        this.movieDirectors = new LinkedList<>(movieDirectors);
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

    @Override
    public Movie generateObject(String... args) {
        return new Movie(args[1], args[2], args[3], Arrays.asList(args).subList(4, args.length));
    }
}
