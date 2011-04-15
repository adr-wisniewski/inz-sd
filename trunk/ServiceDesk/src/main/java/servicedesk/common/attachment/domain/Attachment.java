/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.common.attachment.domain;

import com.sun.istack.internal.NotNull;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import servicedesk.infrastructure.domain.DomainObject;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name="ATTACHMENTS")
public class Attachment implements DomainObject<Integer>, Serializable {
    private Integer id;
    private String name;
    private byte[] data;

    /**
     * @return the id
     */
    @Id
    @Column(name="ATTACHMENT_ID", length = 10)
    @SequenceGenerator(name = "ATTACHMENTS_SEQ", sequenceName = "ATTACHMENTS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ATTACHMENTS_SEQ")
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
     * @return the fileName
     */
    @NotNull
    @Column(name="NAME", length = 500)
    public String getName() {
        return name;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setName(String name) {
        this.name = name;
    }

   
    /**
     * @return the fileSize
     */
    @Lob
    @NotNull
    @Column(name="`DATA`")
    public byte[] getData() {
        return data;
    }

    /**
     * @param fileSize the fileSize to set
     */
    public void setData(byte[] data) {
        this.data = data;
    }
}
