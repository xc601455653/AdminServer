package xyz.wsyzz.candy.entity.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "t_emp_salaryinfo")
public class EmpSalaryinfo implements Serializable {
    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    /**
     * 基本工资
     */
    @Column(name = "base_salary")
    private BigDecimal baseSalary;

    /**
     * 岗位工资
     */
    @Column(name = "position_salary")
    private BigDecimal positionSalary;

    /**
     * 绩效工资
     */
    @Column(name = "achievement_salary")
    private BigDecimal achievementSalary;

    /**
     * 试用期工资
     */
    @Column(name = "trial_salary")
    private BigDecimal trialSalary;

    /**
     * 转正工资
     */
    @Column(name = "regular_salary")
    private BigDecimal regularSalary;

    /**
     * 养老保险
     */
    @Column(name = "endowment_insurance")
    private BigDecimal endowmentInsurance;

    /**
     * 医疗险
     */
    @Column(name = "medical_insurance")
    private BigDecimal medicalInsurance;

    /**
     * 失业险
     */
    @Column(name = "unemployment_insurance")
    private BigDecimal unemploymentInsurance;

    /**
     * 公积金
     */
    private BigDecimal commfund;

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
     * 获取基本工资
     *
     * @return base_salary - 基本工资
     */
    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    /**
     * 设置基本工资
     *
     * @param baseSalary 基本工资
     */
    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    /**
     * 获取岗位工资
     *
     * @return position_salary - 岗位工资
     */
    public BigDecimal getPositionSalary() {
        return positionSalary;
    }

    /**
     * 设置岗位工资
     *
     * @param positionSalary 岗位工资
     */
    public void setPositionSalary(BigDecimal positionSalary) {
        this.positionSalary = positionSalary;
    }

    /**
     * 获取绩效工资
     *
     * @return achievement_salary - 绩效工资
     */
    public BigDecimal getAchievementSalary() {
        return achievementSalary;
    }

    /**
     * 设置绩效工资
     *
     * @param achievementSalary 绩效工资
     */
    public void setAchievementSalary(BigDecimal achievementSalary) {
        this.achievementSalary = achievementSalary;
    }

    /**
     * 获取试用期工资
     *
     * @return trial_salary - 试用期工资
     */
    public BigDecimal getTrialSalary() {
        return trialSalary;
    }

    /**
     * 设置试用期工资
     *
     * @param trialSalary 试用期工资
     */
    public void setTrialSalary(BigDecimal trialSalary) {
        this.trialSalary = trialSalary;
    }

    /**
     * 获取转正工资
     *
     * @return regular_salary - 转正工资
     */
    public BigDecimal getRegularSalary() {
        return regularSalary;
    }

    /**
     * 设置转正工资
     *
     * @param regularSalary 转正工资
     */
    public void setRegularSalary(BigDecimal regularSalary) {
        this.regularSalary = regularSalary;
    }

    /**
     * 获取养老保险
     *
     * @return endowment_insurance - 养老保险
     */
    public BigDecimal getEndowmentInsurance() {
        return endowmentInsurance;
    }

    /**
     * 设置养老保险
     *
     * @param endowmentInsurance 养老保险
     */
    public void setEndowmentInsurance(BigDecimal endowmentInsurance) {
        this.endowmentInsurance = endowmentInsurance;
    }

    /**
     * 获取医疗险
     *
     * @return medical_insurance - 医疗险
     */
    public BigDecimal getMedicalInsurance() {
        return medicalInsurance;
    }

    /**
     * 设置医疗险
     *
     * @param medicalInsurance 医疗险
     */
    public void setMedicalInsurance(BigDecimal medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    /**
     * 获取失业险
     *
     * @return unemployment_insurance - 失业险
     */
    public BigDecimal getUnemploymentInsurance() {
        return unemploymentInsurance;
    }

    /**
     * 设置失业险
     *
     * @param unemploymentInsurance 失业险
     */
    public void setUnemploymentInsurance(BigDecimal unemploymentInsurance) {
        this.unemploymentInsurance = unemploymentInsurance;
    }

    /**
     * 获取公积金
     *
     * @return commfund - 公积金
     */
    public BigDecimal getCommfund() {
        return commfund;
    }

    /**
     * 设置公积金
     *
     * @param commfund 公积金
     */
    public void setCommfund(BigDecimal commfund) {
        this.commfund = commfund;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", employeeId=").append(employeeId);
        sb.append(", baseSalary=").append(baseSalary);
        sb.append(", positionSalary=").append(positionSalary);
        sb.append(", achievementSalary=").append(achievementSalary);
        sb.append(", trialSalary=").append(trialSalary);
        sb.append(", regularSalary=").append(regularSalary);
        sb.append(", endowmentInsurance=").append(endowmentInsurance);
        sb.append(", medicalInsurance=").append(medicalInsurance);
        sb.append(", unemploymentInsurance=").append(unemploymentInsurance);
        sb.append(", commfund=").append(commfund);
        sb.append("]");
        return sb.toString();
    }
}