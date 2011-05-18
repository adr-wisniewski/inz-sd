/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.base.util;

/**
 *
 * @author Adrian
 */
public abstract class JspUtil {
    public static String stripTags(String text) {
        return text.replaceAll("<.*?>","");
    }

    private JspUtil() {
    }
}
