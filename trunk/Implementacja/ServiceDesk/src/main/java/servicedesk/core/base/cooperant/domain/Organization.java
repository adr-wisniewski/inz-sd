/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.base.cooperant.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import servicedesk.infrastructure.interfaces.domain.DomainObject;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name="ORGANIZATIONS")
public class Organization implements DomainObject<Integer>, Serializable {
    private Integer id;
    private String name;

    /**
     * @return the id
     */
    @Id
    @SequenceGenerator(name = "ORGANIZATIONS_SEQ", sequenceName = "ORGANIZATIONS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORGANIZATIONS_SEQ")
    @Column(name = "ORGANIZATION_ID")
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
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
