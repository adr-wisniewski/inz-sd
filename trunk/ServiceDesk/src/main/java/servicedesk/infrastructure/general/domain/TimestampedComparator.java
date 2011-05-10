/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.general.domain;

import java.util.Comparator;
import org.springframework.stereotype.Component;

/**
 *
 * @author Adrian
 */
@Component
public class TimestampedComparator implements Comparator<Timestamped> {

    @Override
    public int compare(Timestamped o1, Timestamped o2) {
        long t1 = o1.getTimestamp().getTime();
        long t2 = o2.getTimestamp().getTime();
        return  t1 < t2 ? -1 : (t1 == t2 ? 0 : 1) ;
    }
    
}
