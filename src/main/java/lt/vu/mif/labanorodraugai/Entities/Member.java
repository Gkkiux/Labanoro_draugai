/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.labanorodraugai.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Sarunas
 */
@Entity
@Table(name = "MEMBER")
@NamedQueries({
    @NamedQuery(name = "Member.findAll", query = "SELECT m FROM Member m"),
    @NamedQuery(name = "Member.findById", query = "SELECT m FROM Member m WHERE m.id = :id"),
    @NamedQuery(name = "Member.findByPassword", query = "SELECT m FROM Member m WHERE m.password = :password"),
    @NamedQuery(name = "Member.findByClubPoints", query = "SELECT m FROM Member m WHERE m.clubPoints = :clubPoints"),
    @NamedQuery(name = "Member.findByTax", query = "SELECT m FROM Member m WHERE m.tax = :tax"),
    @NamedQuery(name = "Member.findByReservationGroup", query = "SELECT m FROM Member m WHERE m.reservationGroup = :reservationGroup"),
    @NamedQuery(name = "Member.findByHolidayDays", query = "SELECT m FROM Member m WHERE m.holidayDays = :holidayDays"),
    @NamedQuery(name = "Member.findByEmail", query = "SELECT m FROM Member m WHERE m.email = :email"),
    @NamedQuery(name = "Member.findByRole", query = "SELECT m FROM Member m WHERE m.role = :role"),
    @NamedQuery(name = "Member.findByConfirmationNumber", query = "SELECT m FROM Member m WHERE m.confirmationNumber = :confirmationNumber"),
    @NamedQuery(name = "Member.findByLoginPassword", query="SELECT m FROM Member m WHERE m.email = :email AND m.password = :password")})
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLUB_POINTS")
    private int clubPoints;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TAX")
    private Boolean tax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RESERVATION_GROUP")
    private int reservationGroup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOLIDAY_DAYS")
    private int holidayDays;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ROLE")
    private Integer role;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONFIRMATION_NUMBER")
    private int confirmationNumber;

    public Member() {
    }

    public Member(Integer id) {
        this.id = id;
    }

    public Member(Integer id, String password, int clubPoints, Boolean tax, int reservationGroup, int holidayDays, int confirmationNumber) {
        this.id = id;
        this.password = password;
        this.clubPoints = clubPoints;
        this.tax = tax;
        this.reservationGroup = reservationGroup;
        this.holidayDays = holidayDays;
        this.confirmationNumber = confirmationNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getClubPoints() {
        return clubPoints;
    }

    public void setClubPoints(int clubPoints) {
        this.clubPoints = clubPoints;
    }

    public Boolean getTax() {
        return tax;
    }

    public void setTax(Boolean tax) {
        this.tax = tax;
    }

    public int getReservationGroup() {
        return reservationGroup;
    }

    public void setReservationGroup(int reservationGroup) {
        this.reservationGroup = reservationGroup;
    }

    public int getHolidayDays() {
        return holidayDays;
    }

    public void setHolidayDays(int holidayDays) {
        this.holidayDays = holidayDays;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public int getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(int confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Member)) {
            return false;
        }
        Member other = (Member) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Member1[ id=" + id + " ]";
    }

}
