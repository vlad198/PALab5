package bonus.commands;

import bonus.catalog.Catalog;
import bonus.items.ItemsList;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Class that describes the play command in our shell.
 */
public class ReportCommand implements isExecutable {
    private static final Logger logger = Logger.getLogger(ReportCommand.class.getName());

    @Override
    public void executeCommand(List<String> args, Catalog catalog, ItemsList itemsList) throws IOException, TemplateException {
        File f = new File(System.getProperty("user.dir").toString() + "\\" + "project_resources" + "\\" + "source.htm");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));

        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File("C:\\Users\\vlada\\IdeaProjects\\PALab5\\src\\main\\resources\\templates"));
        // Recommended settings for new projects:
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);

        Map<String, Object> root = new HashMap<>();
        root.put("user", "vlad");
        root.put("items",catalog.getItems());
        root.put("title",catalog.getName());
        root.put("path",catalog.getPath());

        Template template = cfg.getTemplate("report.ftl");
        template.process(root, bw);

        Desktop.getDesktop().browse(f.toURI());
    }
}
