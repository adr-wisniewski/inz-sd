/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.common.announcement.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import servicedesk.common.announcement.domain.Announcement;
import servicedesk.infrastructure.validation.AbstractValidator;

/**
 *
 * @author Adrian
 */
@Component
public class AnnouncementSimpleValidator extends AbstractValidator<Announcement> {

    @Override
    protected void doValidate(Announcement target, Errors errors) {
        checkSimple(target, errors);
    }

    protected void checkSimple(Announcement target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "validate.common.announcement.title.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "validate.common.announcement.title.content");
    }

}