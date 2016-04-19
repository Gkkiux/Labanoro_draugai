/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.labanorodraugai.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Sarunas
 */
@Entity
@Table(name = "RESERVATION")
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r"),
    @NamedQuery(name = "Reservation.findByHouseId", query = "SELECT r FROM Reservation r WHERE r.reservationPK.houseId = :houseId"),
    @NamedQuery(name = "Reservation.findByDateFrom", query = "SELECT r FROM Reservation r WHERE r.reservationPK.dateFrom = :dateFrom"),
    @NamedQuery(name = "Reservation.findByDateTo", query = "SELECT r FROM Reservation r WHERE r.reservationPK.dateTo = :dateTo")})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservationPK reservationPK;
    @JoinColumn(name = "HOUSE_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private House house;
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "ID")
    @ManyToOne
    private Member memberId;

    public Reservation() {
    }

    public Reservation(ReservationPK reservationPK) {
        this.reservationPK = reservationPK;
    }

    public Reservation(int houseId, Date dateFrom, Date dateTo) {
        this.reservationPK = new ReservationPK(houseId, dateFrom, dateTo);
    }

    public ReservationPK getReservationPK() {
        return reservationPK;
    }

    public void setReservationPK(ReservationPK reservationPK) {
        this.reservationPK = reservationPK;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Member getMemberId() {
        return memberId;
    }

    public void setMemberId(Member memberId) {
        this.memberId = memberId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservationPK != null ? reservationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.reservationPK == null && other.reservationPK != null) || (this.reservationPK != null && !this.reservationPK.equals(other.reservationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Reservation[ reservationPK=" + reservationPK + " ]";
    }
    
}
