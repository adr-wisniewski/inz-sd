/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import servicedesk.infrastructure.interfaces.domain.NamedDomainObject;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "RFC_RESOLUTIONS")
public class RfcResolution implements NamedDomainObject<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Integer order;

    /**
     * @return the id
     */
    @Id
    @SequenceGenerator(name = "RFC_RESOLUTIONS_SEQ", sequenceName = "RFC_RESOLUTIONS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RFC_RESOLUTIONS_SEQ")
    @Column(name="RESOLUTION_ID")
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
    @Column(name="NAME", length=200)
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
    @Column(name="`ORDER`")
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
