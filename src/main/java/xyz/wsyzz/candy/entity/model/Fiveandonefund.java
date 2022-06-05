package xyz.wsyzz.candy.entity.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "t_fiveandonefund")
public class Fiveandonefund implements Serializable {
    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Id
    @Column(name = "record_date")
    private Integer recordDate;

    private String type;

    @Column(name = "company_basic")
    private BigDecimal companyBasic;

    @Column(name = "company_scale")
    private BigDecimal companyScale;

    @Column(name = "company_price")
    private BigDecimal companyPrice;

    @Column(name = "person_basic")
    private BigDecimal personBasic;

    @Column(name = "person_scale")
    private BigDecimal personScale;

    @Column(name = "person_price")
    private BigDecimal personPrice;

    @Column(name = "service_fee")
    private BigDecimal serviceFee;

    private static final long serialVersionUID = 1L;

    /**
     * @return employee_id
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return record_date
     */
    public Integer getRecordDate() {
        return recordDate;
    }

    /**
     * @param recordDate
     */
    public void setRecordDate(Integer recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * @return company_basic
     */
    public BigDecimal getCompanyBasic() {
        return companyBasic;
    }

    /**
     * @param companyBasic
     */
    public void setCompanyBasic(BigDecimal companyBasic) {
        this.companyBasic = companyBasic;
    }

    /**
     * @return company_scale
     */
    public BigDecimal getCompanyScale() {
        return companyScale;
    }

    /**
     * @param companyScale
     */
    public void setCompanyScale(BigDecimal companyScale) {
        this.companyScale = companyScale;
    }

    /**
     * @return company_price
     */
    public BigDecimal getCompanyPrice() {
        return companyPrice;
    }

    /**
     * @param companyPrice
     */
    public void setCompanyPrice(BigDecimal companyPrice) {
        this.companyPrice = companyPrice;
    }

    /**
     * @return person_basic
     */
    public BigDecimal getPersonBasic() {
        return personBasic;
    }

    /**
     * @param personBasic
     */
    public void setPersonBasic(BigDecimal personBasic) {
        this.personBasic = personBasic;
    }

    /**
     * @return person_scale
     */
    public BigDecimal getPersonScale() {
        return personScale;
    }

    /**
     * @param personScale
     */
    public void setPersonScale(BigDecimal personScale) {
        this.personScale = personScale;
    }

    /**
     * @return person_price
     */
    public BigDecimal getPersonPrice() {
        return personPrice;
    }

    /**
     * @param personPrice
     */
    public void setPersonPrice(BigDecimal personPrice) {
        this.personPrice = personPrice;
    }

    /**
     * @return service_fee
     */
    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    /**
     * @param serviceFee
     */
    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", employeeId=").append(employeeId);
        sb.append(", recordDate=").append(recordDate);
        sb.append(", type=").append(type);
        sb.append(", companyBasic=").append(companyBasic);
        sb.append(", companyScale=").append(companyScale);
        sb.append(", companyPrice=").append(companyPrice);
        sb.append(", personBasic=").append(personBasic);
        sb.append(", personScale=").append(personScale);
        sb.append(", personPrice=").append(personPrice);
        sb.append(", serviceFee=").append(serviceFee);
        sb.append("]");
        return sb.toString();
    }
}