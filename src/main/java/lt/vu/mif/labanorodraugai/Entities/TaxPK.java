/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.labanorodraugai.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sarunas
 */
@Embeddable
public class TaxPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMBER_ID")
    private int memberId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_FROM")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_TO")
    @Temporal(TemporalType.DATE)
    private Date dateTo;

    public TaxPK() {
    }

    public TaxPK(int memberId, Date dateFrom, Date dateTo) {
        this.memberId = memberId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) memberId;
        hash += (dateFrom != null ? dateFrom.hashCode() : 0);
        hash += (dateTo != null ? dateTo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxPK)) {
            return false;
        }
        TaxPK other = (TaxPK) object;
        if (this.memberId != other.memberId) {
            return false;
        }
        if ((this.dateFrom == null && other.dateFrom != null) || (this.dateFrom != null && !this.dateFrom.equals(other.dateFrom))) {
            return false;
        }
        if ((this.dateTo == null && other.dateTo != null) || (this.dateTo != null && !this.dateTo.equals(other.dateTo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TaxPK[ memberId=" + memberId + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + " ]";
    }
    
}
