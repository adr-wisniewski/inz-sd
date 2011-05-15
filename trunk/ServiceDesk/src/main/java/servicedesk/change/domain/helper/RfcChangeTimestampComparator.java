/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.domain.helper;

import java.util.Comparator;
import org.springframework.stereotype.Component;
import servicedesk.change.domain.RfcChange;

/**
 *
 * @author Adrian
 */
@Component
public class RfcChangeTimestampComparator implements Comparator<RfcChange> {

    @Override
    public int compare(RfcChange o1, RfcChange o2) {
        long t1 = o1.getTimestamp().getTime();
        long t2 = o2.getTimestamp().getTime();
        return  t1 < t2 ? -1 : (t1 == t2 ? 0 : 1) ;
    }
    
}
