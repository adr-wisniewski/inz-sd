/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.common.attachment.helper;

import java.io.File;
import java.util.Random;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Adrian
 */
@Component
public class RandomFolderFileNameGenerator implements FileNameGenerator {

    private @Autowired WebApplicationContext appContext;
    private Random randomGenerator = new Random();
    private Integer depth = new Integer(3);
    private Integer breadth = new Integer(10);
    private String basepath;


    public String getBasepath() {
        return basepath;
    }

    @Value("#{webApplicationContext.getServletContext().getRealPath(\"\")}")
    public void setBasepath(String basepath) {
        this.basepath = basepath;
    }

    /*
    @PostConstruct
    void postConstruct() {
        setBasepath(appContext.getServletContext().getRealPath(""));
    }*/

    @Override
    public String getFileName(String filename, Integer id) {
        StringBuilder builder = new StringBuilder();
        builder.append(getBasepath());
        builder.append(getRandomPath());
        builder.append(File.separatorChar);
        builder.append(id);
        builder.append('-');
        builder.append(filename);
        return builder.toString();
    }

    protected String getRandomPath() {
        StringBuilder builder = new StringBuilder();

        for (int current_depth = 0; current_depth < depth; ++current_depth) {
            int random = randomGenerator.nextInt(breadth);
            builder.append(File.separatorChar).append(random);
        }

        return builder.toString();
    }
}
