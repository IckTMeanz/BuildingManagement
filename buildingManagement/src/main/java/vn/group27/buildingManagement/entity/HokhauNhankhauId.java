package vn.group27.buildingManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class HokhauNhankhauId implements Serializable {
    private static final long serialVersionUID = 8790542982245553704L;
    @Column(name = "hokhau_id", nullable = false)
    private Integer hokhauId;

    @Column(name = "nhankhau_id", nullable = false)
    private Integer nhankhauId;

    public Integer getHokhauId() {
        return hokhauId;
    }

    public void setHokhauId(Integer hokhauId) {
        this.hokhauId = hokhauId;
    }

    public Integer getNhankhauId() {
        return nhankhauId;
    }

    public void setNhankhauId(Integer nhankhauId) {
        this.nhankhauId = nhankhauId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        HokhauNhankhauId entity = (HokhauNhankhauId) o;
        return Objects.equals(this.hokhauId, entity.hokhauId) &&
                Objects.equals(this.nhankhauId, entity.nhankhauId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hokhauId, nhankhauId);
    }

}