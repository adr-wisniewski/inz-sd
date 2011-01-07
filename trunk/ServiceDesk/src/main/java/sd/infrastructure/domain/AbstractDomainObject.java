/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.infrastructure.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Adrian
 */
@MappedSuperclass
public abstract class AbstractDomainObject<IdType extends Serializable> implements DomainObject<IdType> {

    protected IdType id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, precision = 10)
    @Override
    public IdType getId() {
        return id;
    }

    @Override
    public void setId(IdType id) {
        this.id = id;
    }

}
