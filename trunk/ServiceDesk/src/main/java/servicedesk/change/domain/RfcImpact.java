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
import servicedesk.infrastructure.general.domain.NamedDomainObject;

/**
 *
 * @author Adrian
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name="RFC_IMPACTS")
public class RfcImpact implements NamedDomainObject<Integer>, Serializable   {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Integer order;

    /**
     * @return the id
     */
    @Id
    @SequenceGenerator(name = "RFC_IMPACTS_SEQ", sequenceName = "RFC_IMPACTS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RFC_IMPACTS_SEQ")
    @Column(name = "IMPACT_ID", precision = 10)
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
    @Override
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
     * @return the order
     */
    @Column(name = "`ORDER`", precision = 4, nullable=false)
    public Integer getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Integer order) {
        this.order = order;
    }
}
