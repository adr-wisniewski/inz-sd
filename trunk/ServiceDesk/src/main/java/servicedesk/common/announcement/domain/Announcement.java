/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.common.announcement.domain;

import com.sun.istack.internal.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import servicedesk.common.attachment.domain.Attachment;
import servicedesk.common.attachment.domain.HasAttachments;
import servicedesk.domain.Employee;
import servicedesk.infrastructure.domain.AuthoredDomainObject;
import servicedesk.infrastructure.domain.DomainObject;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name="ANNOUNCEMENTS")
@NamedQueries(
    @NamedQuery(name="Announcement.upToDate", query="from Announcement as a where a.publicationTime <= :date")
)
public class Announcement implements AuthoredDomainObject<Integer>, HasAttachments, Serializable {
    private Integer id;
    private String title;
    private String content;
    private Employee author;
    private Date publicationTime;
    private Set<Attachment> attachments;

    /**
     * @return the id
     */
    @Id
    @Column(name="ANNOUNCEMENT_ID", length = 10)
    @SequenceGenerator(name = "ANNOUNCEMENTS_SEQ", sequenceName = "ANNOUNCEMENTS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANNOUNCEMENTS_SEQ")
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
     * @return the title
     */
    @NotNull
    @Column(name="TITLE", length = 500)
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the content
     */
    @NotNull
    @Column(name="CONTENT", length = 4000)
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the author
     */
    @ManyToOne(fetch=FetchType.EAGER, optional=false)
    @JoinColumn(name="AUTHOR")
    @Override
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
     * @return the publishDate
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name="PUBLICATION_TIME")
    public Date getPublicationTime() {
        return publicationTime;
    }

    /**
     * @param publishDate the publishDate to set
     */
    public void setPublicationTime(Date publicationTime) {
        this.publicationTime = publicationTime;
    }

    /**
     * @return the attachments
     */
    @Override
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="ANNOUNCEMENT_ATTACHMENTS",
        joinColumns=@JoinColumn(name="ANNOUNCEMENT_ID"),
        inverseJoinColumns=@JoinColumn(name="ATTACHMENT_ID")
    )
    public Set<Attachment> getAttachments() {
        return attachments;
    }

    /**
     * @param attachments the attachments to set
     */
    public void setAttachments(Set<Attachment> attachments) {
        this.attachments = attachments;
    }
}
