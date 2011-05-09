/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.general.util;

import java.util.Comparator;
import org.springframework.stereotype.Component;
import servicedesk.change.domain.RfcPriority;

/**
 *
 * @author Adrian
 */
@Component
public class ViewOrderedComparator implements Comparator<RfcPriority> {
    @Override
    public int compare(RfcPriority o1, RfcPriority o2) {
        return o1.getViewOrder() - o2.getViewOrder();
    }
}
