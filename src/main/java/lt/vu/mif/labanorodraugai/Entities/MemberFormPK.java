/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.labanorodraugai.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sarunas
 */
@Embeddable
public class MemberFormPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMBER_ID")
    private int memberId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FIELD_ID")
    private int fieldId;

    public MemberFormPK() {
    }

    public MemberFormPK(int memberId, int fieldId) {
        this.memberId = memberId;
        this.fieldId = fieldId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) memberId;
        hash += (int) fieldId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberFormPK)) {
            return false;
        }
        MemberFormPK other = (MemberFormPK) object;
        if (this.memberId != other.memberId) {
            return false;
        }
        if (this.fieldId != other.fieldId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.MemberFormPK[ memberId=" + memberId + ", fieldId=" + fieldId + " ]";
    }
    
}
