/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import servicedesk.cmdb.domain.helper.ItemVisitor;
import servicedesk.scm.domain.Service;

/**
 *
 * @author Adrian
 */
@javax.persistence.Entity
@Table(name="C2_ITEMS_SERVICE")
public class ServiceItem extends Item {
    private Service service;
    private ServiceItemClass serviceItemClass;

    @OneToOne(fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name = "SERVICE_ID")
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    @Transient
    public ServiceItemClass getItemClass() {
        return serviceItemClass;
    }

    public void setItemClass(ServiceItemClass serviceItemClass) {
        this.serviceItemClass = serviceItemClass;
    }

    @Override
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }

    @Transient
    @Override
    public String getOverview() {
        StringBuilder builder = new StringBuilder();
        builder.append(service.getName()).append(" ");
        return builder.toString();
    }
}
