/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.common.attachment.helper;

/**
 *
 * @author Adrian
 */
public interface FileNameGenerator {
    String getFileName(String filename, Integer id);
}
