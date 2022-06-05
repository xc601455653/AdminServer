package xyz.wsyzz.candy.entity.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "t_attendance_zr")
public class AttendanceZr implements Serializable {
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
     * 当月工作日
     */
    @Column(name = "curr_mon_weekdays")
    private BigDecimal currMonWeekdays;

    /**
     * 应出勤
     */
    @Column(name = "attendance_days")
    private BigDecimal attendanceDays;

    /**
     * 实际出勤天数
     */
    @Column(name = "real_attendance_days")
    private BigDecimal realAttendanceDays;

    /**
     * 旷工天数
     */
    @Column(name = "absenteeism_days")
    private BigDecimal absenteeismDays;

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
     * 获取当月工作日
     *
     * @return curr_mon_weekdays - 当月工作日
     */
    public BigDecimal getCurrMonWeekdays() {
        return currMonWeekdays;
    }

    /**
     * 设置当月工作日
     *
     * @param currMonWeekdays 当月工作日
     */
    public void setCurrMonWeekdays(BigDecimal currMonWeekdays) {
        this.currMonWeekdays = currMonWeekdays;
    }

    /**
     * 获取应出勤
     *
     * @return attendance_days - 应出勤
     */
    public BigDecimal getAttendanceDays() {
        return attendanceDays;
    }

    /**
     * 设置应出勤
     *
     * @param attendanceDays 应出勤
     */
    public void setAttendanceDays(BigDecimal attendanceDays) {
        this.attendanceDays = attendanceDays;
    }

    /**
     * 获取实际出勤天数
     *
     * @return real_attendance_days - 实际出勤天数
     */
    public BigDecimal getRealAttendanceDays() {
        return realAttendanceDays;
    }

    /**
     * 设置实际出勤天数
     *
     * @param realAttendanceDays 实际出勤天数
     */
    public void setRealAttendanceDays(BigDecimal realAttendanceDays) {
        this.realAttendanceDays = realAttendanceDays;
    }

    /**
     * 获取旷工天数
     *
     * @return absenteeism_days - 旷工天数
     */
    public BigDecimal getAbsenteeismDays() {
        return absenteeismDays;
    }

    /**
     * 设置旷工天数
     *
     * @param absenteeismDays 旷工天数
     */
    public void setAbsenteeismDays(BigDecimal absenteeismDays) {
        this.absenteeismDays = absenteeismDays;
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
        sb.append(", currMonWeekdays=").append(currMonWeekdays);
        sb.append(", attendanceDays=").append(attendanceDays);
        sb.append(", realAttendanceDays=").append(realAttendanceDays);
        sb.append(", absenteeismDays=").append(absenteeismDays);
        sb.append(", compassionateLeave=").append(compassionateLeave);
        sb.append(", annualLeave=").append(annualLeave);
        sb.append(", sickLeave=").append(sickLeave);
        sb.append(", compensatoryLeave=").append(compensatoryLeave);
        sb.append(", maternityLeave=").append(maternityLeave);
        sb.append(", marriageHoliday=").append(marriageHoliday);
        sb.append(", dataFrom=").append(dataFrom);
        sb.append("]");
        return sb.toString();
    }
}