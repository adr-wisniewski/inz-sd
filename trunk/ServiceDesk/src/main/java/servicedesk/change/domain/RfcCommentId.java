/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Adrian
 */
@Embeddable
public class RfcCommentId implements Serializable {
    private Rfc rfc;
    private Date timestamp;

    /**
     * @return the rfc
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "RFC_ID")
    public Rfc getRfc() {
        return rfc;
    }

    /**
     * @param rfc the rfc to set
     */
    public void setRfc(Rfc rfc) {
        this.rfc = rfc;
    }

    /**
     * @return the timestamp
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name="`TIMESTAMP`")
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RfcCommentId other = (RfcCommentId) obj;
        if (this.rfc != other.rfc && (this.rfc == null || !this.rfc.equals(other.rfc))) {
            return false;
        }
        if (this.timestamp != other.timestamp && (this.timestamp == null || !this.timestamp.equals(other.timestamp))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.rfc != null ? this.rfc.hashCode() : 0);
        hash = 71 * hash + (this.timestamp != null ? this.timestamp.hashCode() : 0);
        return hash;
    }
}
