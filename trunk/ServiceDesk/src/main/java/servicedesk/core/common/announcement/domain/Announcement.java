/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.common.announcement.domain;


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
import org.hibernate.annotations.Immutable;
import servicedesk.core.common.attachment.domain.Attachment;
import servicedesk.core.common.attachment.domain.HasAttachments;
import servicedesk.core.hr.domain.Employee;
import servicedesk.infrastructure.interfaces.domain.CreatorAutomaticallyMarked;
import servicedesk.infrastructure.interfaces.domain.DomainObject;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name="ANNOUNCEMENTS")
@NamedQueries(
    @NamedQuery(name="Announcement.upToDate", query="from Announcement as a where a.publicationTime <= :date order by a.publicationTime desc")
)
public class Announcement implements DomainObject<Integer>, CreatorAutomaticallyMarked, HasAttachments, Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String title;
    private String content;
    private Employee creator;
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
    
    @Column(name="TITLE", length = 500, nullable=false)
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
    @Column(name="CONTENT", length = 4000, nullable=false)
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
    @Immutable
    @Override
    public Employee getCreator() {
        return creator;
    }

    /**
     * @param author the author to set
     */
    @Override
    public void setCreator(Employee creator) {
        this.creator = creator;
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
    @ManyToMany(cascade=CascadeType.ALL)
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
