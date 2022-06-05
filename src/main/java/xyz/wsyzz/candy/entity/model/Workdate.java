package xyz.wsyzz.candy.entity.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "t_workdate")
public class Workdate implements Serializable {
    @Id
    @Column(name = "natural_day")
    private Integer naturalDay;

    @Id
    private String type;

    @Column(name = "week_day")
    private Integer weekDay;

    @Column(name = "work_flag")
    private String workFlag;

    private static final long serialVersionUID = 1L;

    /**
     * @return natural_day
     */
    public Integer getNaturalDay() {
        return naturalDay;
    }

    /**
     * @param naturalDay
     */
    public void setNaturalDay(Integer naturalDay) {
        this.naturalDay = naturalDay;
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
     * @return week_day
     */
    public Integer getWeekDay() {
        return weekDay;
    }

    /**
     * @param weekDay
     */
    public void setWeekDay(Integer weekDay) {
        this.weekDay = weekDay;
    }

    /**
     * @return work_flag
     */
    public String getWorkFlag() {
        return workFlag;
    }

    /**
     * @param workFlag
     */
    public void setWorkFlag(String workFlag) {
        this.workFlag = workFlag == null ? null : workFlag.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", naturalDay=").append(naturalDay);
        sb.append(", type=").append(type);
        sb.append(", weekDay=").append(weekDay);
        sb.append(", workFlag=").append(workFlag);
        sb.append("]");
        return sb.toString();
    }
}