package hanoi.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;

@javax.persistence.Entity
@Table(name = "derivative", uniqueConstraints = {@UniqueConstraint(columnNames = "derivative_code")})

public class derivative {
    @Column(name = "deri_composite_code", nullable = false)
    private String deriCode;
    @Id
    @Column(name = "derivative_code", unique = true, nullable = false)
    private String code;
    @Column(name = "effective_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date effectiveDate;
    @Column(name = "expiration_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expirationDate;
    @Column(name = "underlying_type", length = 100)

    private String underlyingType;

    public derivative() {
    }

    public derivative(String deriCode, String code, Date effectiveDate, Date expirationDate, String underlyingType) {
        this.deriCode = deriCode;
        this.code = code;
        this.effectiveDate = effectiveDate;
        this.expirationDate = expirationDate;
        this.underlyingType = underlyingType;
    }

    public String getDeriCode() {
        return deriCode;
    }

    public void setDeriCode(String deriCode) {
        this.deriCode = deriCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getUnderlyingType() {
        return underlyingType;
    }

    public void setUnderlyingType(String underlyingType) {
        this.underlyingType = underlyingType;
    }
}
