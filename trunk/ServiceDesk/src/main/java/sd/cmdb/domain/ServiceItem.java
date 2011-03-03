/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import sd.scm.domain.Service;

/**
 *
 * @author Adrian
 */
@javax.persistence.Entity
@Table(name="C2_ITEMS_SERVICE")
public class ServiceItem extends Item {
    private Service service;

    /**
     * @return the service
     */
    @OneToOne(fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name = "SERVICE_ID")
    public Service getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(Service service) {
        this.service = service;
    }
}
