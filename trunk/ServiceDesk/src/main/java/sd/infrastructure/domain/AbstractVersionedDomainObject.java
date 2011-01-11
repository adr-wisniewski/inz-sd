/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.infrastructure.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 *
 * @author Adrian
 */
@MappedSuperclass
public class AbstractVersionedDomainObject<Id extends Serializable> extends AbstractDomainObject<Id> implements VersionedDomainObject<Id> {
    private Integer version;

    @Version
    @Column(name = "VERSION", precision = 10)
    @Override
    public Integer getVersion() {
            return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}
