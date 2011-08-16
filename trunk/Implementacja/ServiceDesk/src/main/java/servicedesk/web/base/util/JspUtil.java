/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.web.base.util;

import java.util.Formatter;
import servicedesk.core.itil.cmdb.domain.Item;

/**
 *
 * @author Adrian
 */
public abstract class JspUtil {
    public static String stripTags(String text) {
        return text.replaceAll("<.*?>","");
    }
    
    public static String formatVararg(String text, Object... args) {
        Formatter formatter = new Formatter();
        formatter.format(text, args);
        return formatter.toString();
    }
    
    public static String format(String text, Object arg) {
        return formatVararg(text, arg);
    }

    private JspUtil() {
    }
}
