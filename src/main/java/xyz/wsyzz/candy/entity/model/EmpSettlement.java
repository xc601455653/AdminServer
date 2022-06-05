package xyz.wsyzz.candy.entity.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "t_emp_settlement")
public class EmpSettlement implements Serializable {
    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "from_hr")
    private String fromHr;

    @Column(name = "offer_salary")
    private BigDecimal offerSalary;

    @Column(name = "position_level")
    private String positionLevel;

    @Column(name = "business_price")
    private BigDecimal businessPrice;

    /**
     * 结算周期
     */
    @Column(name = "settlement_cycle")
    private String settlementCycle;

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
     * @return from_hr
     */
    public String getFromHr() {
        return fromHr;
    }

    /**
     * @param fromHr
     */
    public void setFromHr(String fromHr) {
        this.fromHr = fromHr == null ? null : fromHr.trim();
    }

    /**
     * @return offer_salary
     */
    public BigDecimal getOfferSalary() {
        return offerSalary;
    }

    /**
     * @param offerSalary
     */
    public void setOfferSalary(BigDecimal offerSalary) {
        this.offerSalary = offerSalary;
    }

    /**
     * @return position_level
     */
    public String getPositionLevel() {
        return positionLevel;
    }

    /**
     * @param positionLevel
     */
    public void setPositionLevel(String positionLevel) {
        this.positionLevel = positionLevel == null ? null : positionLevel.trim();
    }

    /**
     * @return business_price
     */
    public BigDecimal getBusinessPrice() {
        return businessPrice;
    }

    /**
     * @param businessPrice
     */
    public void setBusinessPrice(BigDecimal businessPrice) {
        this.businessPrice = businessPrice;
    }

    /**
     * 获取结算周期
     *
     * @return settlement_cycle - 结算周期
     */
    public String getSettlementCycle() {
        return settlementCycle;
    }

    /**
     * 设置结算周期
     *
     * @param settlementCycle 结算周期
     */
    public void setSettlementCycle(String settlementCycle) {
        this.settlementCycle = settlementCycle == null ? null : settlementCycle.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", employeeId=").append(employeeId);
        sb.append(", fromHr=").append(fromHr);
        sb.append(", offerSalary=").append(offerSalary);
        sb.append(", positionLevel=").append(positionLevel);
        sb.append(", businessPrice=").append(businessPrice);
        sb.append(", settlementCycle=").append(settlementCycle);
        sb.append("]");
        return sb.toString();
    }
}