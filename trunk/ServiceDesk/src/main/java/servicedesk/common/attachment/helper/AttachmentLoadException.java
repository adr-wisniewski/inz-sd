/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.common.attachment.helper;

/**
 *
 * @author Adrian
 */
public class AttachmentLoadException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AttachmentLoadException(Throwable cause) {
        super(cause);
    }
}
