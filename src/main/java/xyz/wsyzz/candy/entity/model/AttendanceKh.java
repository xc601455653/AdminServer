package xyz.wsyzz.candy.entity.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "t_attendance_kh")
public class AttendanceKh implements Serializable {
    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Id
    @Column(name = "record_date")
    private Integer recordDate;

    /**
     * 工号
     */
    @Column(name = "job_no")
    private String jobNo;

    private String name;

    @Column(name = "curr_mon_weekdays")
    private BigDecimal currMonWeekdays;

    @Column(name = "attendance_days")
    private BigDecimal attendanceDays;

    @Column(name = "real_attendance_days")
    private BigDecimal realAttendanceDays;

    @Column(name = "leave_days")
    private BigDecimal leaveDays;

    /**
     * 迟到早退次数
     */
    @Column(name = "late_nums")
    private BigDecimal lateNums;

    @Column(name = "extra_hours")
    private BigDecimal extraHours;

    @Column(name = "extra_price")
    private BigDecimal extraPrice;

    @Column(name = "data_from")
    private String dataFrom;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return curr_mon_weekdays
     */
    public BigDecimal getCurrMonWeekdays() {
        return currMonWeekdays;
    }

    /**
     * @param currMonWeekdays
     */
    public void setCurrMonWeekdays(BigDecimal currMonWeekdays) {
        this.currMonWeekdays = currMonWeekdays;
    }

    /**
     * @return attendance_days
     */
    public BigDecimal getAttendanceDays() {
        return attendanceDays;
    }

    /**
     * @param attendanceDays
     */
    public void setAttendanceDays(BigDecimal attendanceDays) {
        this.attendanceDays = attendanceDays;
    }

    /**
     * @return real_attendance_days
     */
    public BigDecimal getRealAttendanceDays() {
        return realAttendanceDays;
    }

    /**
     * @param realAttendanceDays
     */
    public void setRealAttendanceDays(BigDecimal realAttendanceDays) {
        this.realAttendanceDays = realAttendanceDays;
    }

    /**
     * @return leave_days
     */
    public BigDecimal getLeaveDays() {
        return leaveDays;
    }

    /**
     * @param leaveDays
     */
    public void setLeaveDays(BigDecimal leaveDays) {
        this.leaveDays = leaveDays;
    }

    /**
     * 获取迟到早退次数
     *
     * @return late_nums - 迟到早退次数
     */
    public BigDecimal getLateNums() {
        return lateNums;
    }

    /**
     * 设置迟到早退次数
     *
     * @param lateNums 迟到早退次数
     */
    public void setLateNums(BigDecimal lateNums) {
        this.lateNums = lateNums;
    }

    /**
     * @return extra_hours
     */
    public BigDecimal getExtraHours() {
        return extraHours;
    }

    /**
     * @param extraHours
     */
    public void setExtraHours(BigDecimal extraHours) {
        this.extraHours = extraHours;
    }

    /**
     * @return extra_price
     */
    public BigDecimal getExtraPrice() {
        return extraPrice;
    }

    /**
     * @param extraPrice
     */
    public void setExtraPrice(BigDecimal extraPrice) {
        this.extraPrice = extraPrice;
    }

    /**
     * @return data_from
     */
    public String getDataFrom() {
        return dataFrom;
    }

    /**
     * @param dataFrom
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
        sb.append(", leaveDays=").append(leaveDays);
        sb.append(", lateNums=").append(lateNums);
        sb.append(", extraHours=").append(extraHours);
        sb.append(", extraPrice=").append(extraPrice);
        sb.append(", dataFrom=").append(dataFrom);
        sb.append("]");
        return sb.toString();
    }
}