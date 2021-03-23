package optional.commands;

import optional.catalog.Catalog;
import optional.items.Item;
import optional.items.ItemsList;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportCommand implements isExecutable {
    @Override
    public void executeCommand(List<String> args, Catalog catalog, ItemsList itemsList) throws IOException {
        File f = new File(System.getProperty("user.dir").toString() + "\\" + "project_resources" + "\\" + "source.htm");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));

        // src/main/resources/templates/report.vm

        bw.write("<html><body>");

        bw.write("<h2>Title: " + catalog.getName() + "</h2>");
        bw.write("<h2>Path: " + catalog.getPath() + "</h2>");
        bw.write("<h2>" + "Items" + "</h2>");
        bw.write("<ul>");

        for (Item item : catalog.getItems()) {
            bw.write("<li>");
            bw.write("<p>" + item + "</p>");
            bw.write("</li>");
        }

        bw.write("</ul></body></html>");
        bw.close();

        Desktop.getDesktop().browse(f.toURI());
    }
}
