/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import servicedesk.domain.Employee;
import servicedesk.infrastructure.general.domain.CreationAutomaticallyMarked;
import servicedesk.infrastructure.general.domain.DomainObject;

/**
 *
 * @author Adrian
 */
@Entity
public class RfcComment implements DomainObject<RfcCommentId>, CreationAutomaticallyMarked, Serializable {
    private RfcCommentId id;
    private Employee author;
    private String content;

    /**
     * @return the id
     */
    @Id
    @Override
    public RfcCommentId getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(RfcCommentId id) {
        this.id = id;
    }

    /**
     * @return the author
     */
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="AUTHOR")
    public Employee getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(Employee author) {
        this.author = author;
    }

    /**
     * @return the content
     */
    @Lob
    @Column(name="CONTENT")
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Transient
    @Override
    public Employee getCreator() {
        return author;
    }

    @Override
    public void setCreator(Employee employee) {
        this.author = employee;
    }

    @Transient
    @Override
    public Date getTimestamp() {
        return this.getId() != null ? this.getId().getTimestamp() : null;
    }

    @Override
    public void setTimestamp(Date timestamp) {
        this.getId().setTimestamp(timestamp);
    }
    
}
