/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.common.attachment.web;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import servicedesk.common.attachment.domain.Attachment;
import servicedesk.common.attachment.service.AttachmentService;

/**
 *
 * @author Adrian
 */
@Controller
@RequestMapping(value = "/common/attachment/*")
//@PreAuthorize("hasRole('COMMON_ATTACHMENT_VIEW')")
public class AttachmentController {
    @Autowired
    private AttachmentService service;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> view(@PathVariable("id") Integer id) {
        Attachment attachment = service.load(id);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentLength(attachment.getData().length);
        responseHeaders.setContentDispositionFormData("attachment", attachment.getName());
        return new ResponseEntity<byte[]>(attachment.getData(), responseHeaders, HttpStatus.OK);
   }
}
