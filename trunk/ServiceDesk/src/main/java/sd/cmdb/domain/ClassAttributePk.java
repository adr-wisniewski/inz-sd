/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Adrian
 */
@Embeddable
public class ClassAttributePk implements Serializable {
    private Integer classId;
    private Integer attributeNo;

    public ClassAttributePk() {
        // empty
    }

    public ClassAttributePk(Integer classId, Integer attributeNo) {
        this.classId = classId;
        this.attributeNo = attributeNo;
    }

    @Column(name = "CLASS_ID", precision = 10)
    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    @SequenceGenerator(name = "C2_CLASS_ATTRIBUTES_SEQ", sequenceName = "C2_CLASS_ATTRIBUTES_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "C2_CLASS_ATTRIBUTES_SEQ")
    @Column(name = "ATTRIBUTE_NO", precision = 10)
    public Integer getAttributeNo() {
        return attributeNo;
    }

    public void setAttributeNo(Integer attributeNo) {
        this.attributeNo = attributeNo;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ClassAttributePk)) {
            return false;
        }
        final ClassAttributePk other = (ClassAttributePk) obj;
        if (getClassId() != other.getClassId() && (getClassId() == null || !getClassId().equals(other.getClassId()))) {
            return false;
        }
        if (getAttributeNo() != other.getAttributeNo() && (getAttributeNo() == null || !getAttributeNo().equals(other.getAttributeNo()))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (getClassId() != null ? getClassId().hashCode() : 0);
        hash = 59 * hash + (getAttributeNo() != null ? getAttributeNo().hashCode() : 0);
        return hash;
    }
    
}
