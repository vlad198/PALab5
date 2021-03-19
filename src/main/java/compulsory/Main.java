package compulsory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Catalog catalog = new Catalog("catalogue_meu", System.getProperty("user.dir").toString());
//
//        catalog.add(new Song("melodia 1", "D:\\Udemy-Advanced.JavaScript.Concepts\\3. Javascript Foundation II\\2. Execution Context.mp4", "Chelutu cu bradutu", "Dorel"));
//        catalog.add(new Song("catalog.mp3", System.getProperty("user.dir").toString() + "catalog.mp3", "catalog", "Niai"));
//
//        catalog.list();
//        catalog.save();

        catalog.load("catalogue_meu.ser");
        catalog.play(0);

        System.out.println(catalog);

//        System.out.println(catalog.getPath());
    }

}
