package xyz.wsyzz.candy.entity.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "t_attendance_zz")
public class AttendanceZz implements Serializable {
    /**
     * 员工号
     */
    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    /**
     * 月份
     */
    @Id
    @Column(name = "record_date")
    private Integer recordDate;

    /**
     * 工号
     */
    @Column(name = "job_no")
    private String jobNo;

    /**
     * 姓名
     */
    private String name;

    /**
     * 累计缺勤
     */
    @Column(name = "cumulative_absence")
    private BigDecimal cumulativeAbsence;

    /**
     * 事假
     */
    @Column(name = "compassionate_leave")
    private BigDecimal compassionateLeave;

    /**
     * 年假
     */
    @Column(name = "annual_leave")
    private BigDecimal annualLeave;

    /**
     * 病假
     */
    @Column(name = "sick_leave")
    private BigDecimal sickLeave;

    /**
     * 调休
     */
    @Column(name = "compensatory_leave")
    private BigDecimal compensatoryLeave;

    /**
     * 陪产假
     */
    @Column(name = "maternity_leave")
    private BigDecimal maternityLeave;

    /**
     * 婚假
     */
    @Column(name = "marriage_holiday")
    private BigDecimal marriageHoliday;

    /**
     * 未入职
     */
    @Column(name = "not_join")
    private String notJoin;

    /**
     * 其他（加班）
     */
    private String other;

    /**
     * 备注
     */
    private String remark;

    /**
     * 数据来源
     */
    @Column(name = "data_from")
    private String dataFrom;

    private static final long serialVersionUID = 1L;

    /**
     * 获取员工号
     *
     * @return employee_id - 员工号
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * 设置员工号
     *
     * @param employeeId 员工号
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * 获取月份
     *
     * @return record_date - 月份
     */
    public Integer getRecordDate() {
        return recordDate;
    }

    /**
     * 设置月份
     *
     * @param recordDate 月份
     */
    public void setRecordDate(Integer recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * 获取工号
     *
     * @return job_no - 工号
     */
    public String getJobNo() {
        return jobNo;
    }

    /**
     * 设置工号
     *
     * @param jobNo 工号
     */
    public void setJobNo(String jobNo) {
        this.jobNo = jobNo == null ? null : jobNo.trim();
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取累计缺勤
     *
     * @return cumulative_absence - 累计缺勤
     */
    public BigDecimal getCumulativeAbsence() {
        return cumulativeAbsence;
    }

    /**
     * 设置累计缺勤
     *
     * @param cumulativeAbsence 累计缺勤
     */
    public void setCumulativeAbsence(BigDecimal cumulativeAbsence) {
        this.cumulativeAbsence = cumulativeAbsence;
    }

    /**
     * 获取事假
     *
     * @return compassionate_leave - 事假
     */
    public BigDecimal getCompassionateLeave() {
        return compassionateLeave;
    }

    /**
     * 设置事假
     *
     * @param compassionateLeave 事假
     */
    public void setCompassionateLeave(BigDecimal compassionateLeave) {
        this.compassionateLeave = compassionateLeave;
    }

    /**
     * 获取年假
     *
     * @return annual_leave - 年假
     */
    public BigDecimal getAnnualLeave() {
        return annualLeave;
    }

    /**
     * 设置年假
     *
     * @param annualLeave 年假
     */
    public void setAnnualLeave(BigDecimal annualLeave) {
        this.annualLeave = annualLeave;
    }

    /**
     * 获取病假
     *
     * @return sick_leave - 病假
     */
    public BigDecimal getSickLeave() {
        return sickLeave;
    }

    /**
     * 设置病假
     *
     * @param sickLeave 病假
     */
    public void setSickLeave(BigDecimal sickLeave) {
        this.sickLeave = sickLeave;
    }

    /**
     * 获取调休
     *
     * @return compensatory_leave - 调休
     */
    public BigDecimal getCompensatoryLeave() {
        return compensatoryLeave;
    }

    /**
     * 设置调休
     *
     * @param compensatoryLeave 调休
     */
    public void setCompensatoryLeave(BigDecimal compensatoryLeave) {
        this.compensatoryLeave = compensatoryLeave;
    }

    /**
     * 获取陪产假
     *
     * @return maternity_leave - 陪产假
     */
    public BigDecimal getMaternityLeave() {
        return maternityLeave;
    }

    /**
     * 设置陪产假
     *
     * @param maternityLeave 陪产假
     */
    public void setMaternityLeave(BigDecimal maternityLeave) {
        this.maternityLeave = maternityLeave;
    }

    /**
     * 获取婚假
     *
     * @return marriage_holiday - 婚假
     */
    public BigDecimal getMarriageHoliday() {
        return marriageHoliday;
    }

    /**
     * 设置婚假
     *
     * @param marriageHoliday 婚假
     */
    public void setMarriageHoliday(BigDecimal marriageHoliday) {
        this.marriageHoliday = marriageHoliday;
    }

    /**
     * 获取未入职
     *
     * @return not_join - 未入职
     */
    public String getNotJoin() {
        return notJoin;
    }

    /**
     * 设置未入职
     *
     * @param notJoin 未入职
     */
    public void setNotJoin(String notJoin) {
        this.notJoin = notJoin == null ? null : notJoin.trim();
    }

    /**
     * 获取其他（加班）
     *
     * @return other - 其他（加班）
     */
    public String getOther() {
        return other;
    }

    /**
     * 设置其他（加班）
     *
     * @param other 其他（加班）
     */
    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取数据来源
     *
     * @return data_from - 数据来源
     */
    public String getDataFrom() {
        return dataFrom;
    }

    /**
     * 设置数据来源
     *
     * @param dataFrom 数据来源
     */
    public void setDataFrom(String dataFrom) {
        this.dataFrom = dataFrom == null ? null : dataFrom.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", employeeId=").append(employeeId);
        sb.append(", recordDate=").append(recordDate);
        sb.append(", jobNo=").append(jobNo);
        sb.append(", name=").append(name);
        sb.append(", cumulativeAbsence=").append(cumulativeAbsence);
        sb.append(", compassionateLeave=").append(compassionateLeave);
        sb.append(", annualLeave=").append(annualLeave);
        sb.append(", sickLeave=").append(sickLeave);
        sb.append(", compensatoryLeave=").append(compensatoryLeave);
        sb.append(", maternityLeave=").append(maternityLeave);
        sb.append(", marriageHoliday=").append(marriageHoliday);
        sb.append(", notJoin=").append(notJoin);
        sb.append(", other=").append(other);
        sb.append(", remark=").append(remark);
        sb.append(", dataFrom=").append(dataFrom);
        sb.append("]");
        return sb.toString();
    }
}