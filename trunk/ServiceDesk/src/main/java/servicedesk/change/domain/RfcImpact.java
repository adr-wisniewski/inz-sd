/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import servicedesk.infrastructure.general.domain.DomainObject;
import servicedesk.infrastructure.general.domain.ViewOrdered;

/**
 *
 * @author Adrian
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name="RFC_IMPACT")
public class RfcImpact implements DomainObject<Integer>, ViewOrdered, Serializable   {
    private Integer id;
    private String name;
    private Integer viewOrder;

    /**
     * @return the id
     */
    @Id
    @SequenceGenerator(name = "RFC_IMPACT_SEQ", sequenceName = "RFC_IMPACT_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RFC_IMPACT_SEQ")
    @Column(name = "ID", precision = 10)
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    @Column(name = "NAME", length = 200, nullable=false)
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the viewOrder
     */
    @Column(name = "VIEW_ORDER", precision = 4, nullable=false)
    @Override
    public Integer getViewOrder() {
        return viewOrder;
    }

    /**
     * @param viewOrder the viewOrder to set
     */
    public void setViewOrder(Integer viewOrder) {
        this.viewOrder = viewOrder;
    }
}
