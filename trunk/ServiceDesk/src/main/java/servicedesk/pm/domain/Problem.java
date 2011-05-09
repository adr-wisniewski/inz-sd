/**
 * 
 */
package servicedesk.pm.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.Type;

import servicedesk.domain.Comment;
import servicedesk.domain.Employee;
import servicedesk.event.domain.IEvent;
import servicedesk.im.domain.Incident;
import servicedesk.im.domain.SupportGroup;
import servicedesk.infrastructure.general.domain.DomainObject;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Table(name = "PROBLEMS")
@NamedQueries({
    @NamedQuery(name = "Problem.get", query = "SELECT p FROM Problem p WHERE p.id = ?")})
public class Problem implements DomainObject<Integer>, IEvent, Serializable {

    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Id
    @SequenceGenerator(name = "problem_seq", sequenceName = "event_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "problem_seq")
    @Column(name = "PROBLEM_ID")
    private Integer id;

    /**
     * /**
     *  * @return the id
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Override
    public Integer getId() {
        // begin-user-code
        return id;
        // end-user-code
    }

    /**
     * /**
     *  * @param id the id to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Override
    public void setId(Integer id) {
        // begin-user-code
        this.id = id;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Column(name = "SUBJECT")
    private String subject;

    /**
     * /**
     *  * @return the subject
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getSubject() {
        // begin-user-code
        return subject;
        // end-user-code
    }

    /**
     * /**
     *  * @param subject the subject to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setSubject(String subject) {
        // begin-user-code
        this.subject = subject;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * /**
     *  * @return the description
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getDescription() {
        // begin-user-code
        return description;
        // end-user-code
    }

    /**
     * /**
     *  * @param description the description to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setDescription(String description) {
        // begin-user-code
        this.description = description;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Column(name = "CREATION_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date creationDate;

    /**
     * /**
     *  * @return the creationDate
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Date getCreationDate() {
        // begin-user-code
        return creationDate;
        // end-user-code
    }

    /**
     * /**
     *  * @param creationDate the creationDate to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Override
    public void setCreationDate(Date creationDate) {
        // begin-user-code
        this.creationDate = creationDate;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Column(name = "CLOSURE_DATE", updatable = false, insertable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date closureDate;

    /**
     * /**
     *  * @return the closureDate
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Date getClosureDate() {
        // begin-user-code
        return closureDate;
        // end-user-code
    }

    /**
     * /**
     *  * @param closureDate the closureDate to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setClosureDate(Date closureDate) {
        // begin-user-code
        this.closureDate = closureDate;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Column(name = "IMPACT_DETAILS")
    private String impactDetails;

    /**
     * /**
     *  * @return the impactDetails
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getImpactDetails() {
        // begin-user-code
        return impactDetails;
        // end-user-code
    }

    /**
     * /**
     *  * @param impactDetails the impactDetails to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setImpactDetails(String impactDetails) {
        // begin-user-code
        this.impactDetails = impactDetails;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Column(name = "ROOT_CAUSE")
    private String rootCause;

    /**
     * /**
     *  * @return the rootCause
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getRootCause() {
        // begin-user-code
        return rootCause;
        // end-user-code
    }

    /**
     * /**
     *  * @param rootCause the rootCause to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setRootCause(String rootCause) {
        // begin-user-code
        this.rootCause = rootCause;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Column(name = "SYMPTOMS")
    private String symptomsDetails;

    /**
     * /**
     *  * @return the symptomsDetails
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getSymptomsDetails() {
        // begin-user-code
        return symptomsDetails;
        // end-user-code
    }

    /**
     * /**
     *  * @param symptomsDetails the symptomsDetails to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setSymptomsDetails(String symptomsDetails) {
        // begin-user-code
        this.symptomsDetails = symptomsDetails;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CATEGORY_CODE")
    private ProblemCategory category;

    /**
     * /**
     *  * @return the category
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public ProblemCategory getCategory() {
        // begin-user-code
        return category;
        // end-user-code
    }

    /**
     * /**
     *  * @param category the category to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setCategory(ProblemCategory category) {
        // begin-user-code
        this.category = category;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "STATUS_CODE")
    private ProblemStatus status;

    /**
     * /**
     *  * @return the status
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public ProblemStatus getStatus() {
        // begin-user-code
        return status;
        // end-user-code
    }

    /**
     * /**
     *  * @param status the status to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setStatus(ProblemStatus status) {
        // begin-user-code
        this.status = status;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "URGENCY_CODE")
    private ProblemUrgency urgency;

    /**
     * /**
     *  * @return the urgency
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public ProblemUrgency getUrgency() {
        // begin-user-code
        return urgency;
        // end-user-code
    }

    /**
     * /**
     *  * @param urgency the urgency to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setUrgency(ProblemUrgency urgency) {
        // begin-user-code
        this.urgency = urgency;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "STAFF_MEMBER")
    private Employee supportGroupMember;

    /**
     * /**
     *  * @return the supportGroupMember
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Employee getSupportGroupMember() {
        // begin-user-code
        return supportGroupMember;
        // end-user-code
    }

    /**
     * /**
     *  * @param supportGroupMember the supportGroupMember to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setSupportGroupMember(Employee supportGroupMember) {
        // begin-user-code
        this.supportGroupMember = supportGroupMember;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GROUP_ID")
    private SupportGroup supportGroup;

    /**
     * /**
     *  * @return the supportGroup
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public SupportGroup getSupportGroup() {
        // begin-user-code
        return supportGroup;
        // end-user-code
    }

    /**
     * /**
     *  * @param supportGroup the supportGroup to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setSupportGroup(SupportGroup supportGroup) {
        // begin-user-code
        this.supportGroup = supportGroup;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IMPACT_CODE")
    private ProblemImpact impact;

    /**
     * /**
     *  * @return the impact
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public ProblemImpact getImpact() {
        // begin-user-code
        return impact;
        // end-user-code
    }

    /**
     * /**
     *  * @param impact the impact to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setImpact(ProblemImpact impact) {
        // begin-user-code
        this.impact = impact;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRIORITY_CODE")
    private ProblemPriority priority;

    /**
     * /**
     *  * @return the priority
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public ProblemPriority getPriority() {
        // begin-user-code
        return priority;
        // end-user-code
    }

    /**
     * /**
     *  * @param priority the priority to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setPriority(ProblemPriority priority) {
        // begin-user-code
        this.priority = priority;
        // end-user-code
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "problem")
    @OrderBy("creationDate")
    private List<Comment> comments = new LinkedList<Comment>();

    /**
     * /**
     *  * @return the comments
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Override
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * /**
     *  * @param comments the comments to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Override
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "problem")
    private Set<Solution> solutions = new HashSet<Solution>();

    /**
     * /**
     *  * @return the solutions
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Set<Solution> getSolutions() {
        // begin-user-code
        return solutions;
        // end-user-code
    }

    /**
     * /**
     *  * @param solutions the solutions to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setSolutions(Set<Solution> solutions) {
        // begin-user-code
        this.solutions = solutions;
        // end-user-code
    }
    @Column(name = "IS_KNOWN_ERROR")
    @Type(type = "true_false")
    private boolean knownError;

    public boolean isKnownError() {
        // begin-user-code
        return knownError;
        // end-user-code
    }

    public void setKnownError(boolean knownError) {
        this.knownError = knownError;
    }
    /*
    private HistoryAction history;

    public HistoryAction getHistory() {
    // begin-user-code
    return history;
    // end-user-code
    }

    public void setHistory(HistoryAction history) {
    // begin-user-code
    this.history = history;
    // end-user-code
    }
     */
    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "INCIDENT_PROBLEM", joinColumns = {
        @JoinColumn(name = "PROBLEM_ID", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "INCIDENT_ID", nullable = false, updatable = false)})
    private Set<Incident> incidents = new HashSet<Incident>();

    /**
     * /**
     *  * @return the incidents
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Set<Incident> getIncidents() {
        return incidents;
    }

    /**
     * /**
     *  * @param incidents the incidents to set
     *
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setIncidents(Set<Incident> incidents) {
        // begin-user-code
        this.incidents = incidents;
        // end-user-code
    }

    /**
     * Dodaje nowy incydent
     *
     * @param incident incydent do dodania
     */
    public void addIncident(Incident incident) {
        this.incidents.add(incident);
    }

    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @return
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Solution getWorkaround() {
        return getSolutionByCode(SolutionType.WORKAROUND.getCode());
    }

    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @return
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Solution getPermanentSolution() {
        return getSolutionByCode(SolutionType.PERMANENT.getCode());
    }

    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @param solution
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void addSolution(Solution solution) {
        Solution oldSolution = getSolutionByCode(solution.getType().getCode());

        if (oldSolution != null) {
            //solutions.remove(oldSolution);
            //do nothing
            oldSolution.setSubject(solution.getSubject());
            oldSolution.setDescription(solution.getDescription());
        }
        else {
            solution.setProblem(this);
            solutions.add(solution);
        }
    }

    /**
     * <!-- begin-UML-doc -->
     * <!-- end-UML-doc -->
     * @param code
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Solution getSolutionByCode(String code) {
        for (Solution s : solutions) {
            if (s.getType().getCode().equals(code)) {
                return s;
            }
        }

        return null;
    }

    @Override
    public void addComment(Comment comment) {
        comment.setProblem(this);
        comments.add(comment);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Problem other = (Problem) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    public void removeIncident(Incident incident) {
        incidents.remove(incident);
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AUTHOR")
    private Employee author;

    @Override
    public Employee getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(Employee author) {
        this.author = author;
    }
}
