package xyz.wsyzz.candy.entity.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "t_employeebasicinfo")
public class Employeebasicinfo implements Serializable {
    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "job_no")
    private String jobNo;

    @Column(name = "to_company")
    private String toCompany;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "en_name")
    private String enName;

    private String phone;

    @Column(name = "id_card")
    private String idCard;

    @Column(name = "native_place")
    private String nativePlace;

    private String sex;

    private String birthday;

    private String nation;

    @Column(name = "political_outlook")
    private String politicalOutlook;

    @Column(name = "max_school")
    private String maxSchool;

    private String major;

    @Column(name = "max_education")
    private String maxEducation;

    @Column(name = "graduation_date")
    private String graduationDate;

    @Column(name = "work_years")
    private BigDecimal workYears;

    private String address;

    private String email;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_relationship")
    private String contactRelationship;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "join_date")
    private Integer joinDate;

    @Column(name = "position_type")
    private String positionType;

    @Column(name = "position_level")
    private String positionLevel;

    @Column(name = "zs_bank_card")
    private String zsBankCard;

    @Column(name = "payment_area")
    private String paymentArea;

    @Column(name = "operator_status")
    private String operatorStatus;

    @Column(name = "regular_date")
    private String regularDate;

    /**
     * 转正截至日期
     */
    @Column(name = "zz_stop_date")
    private Integer zzStopDate;

    /**
     * 人员状态
     */
    private String status;

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
     * @return job_no
     */
    public String getJobNo() {
        return jobNo;
    }

    /**
     * @param jobNo
     */
    public void setJobNo(String jobNo) {
        this.jobNo = jobNo == null ? null : jobNo.trim();
    }

    /**
     * @return to_company
     */
    public String getToCompany() {
        return toCompany;
    }

    /**
     * @param toCompany
     */
    public void setToCompany(String toCompany) {
        this.toCompany = toCompany == null ? null : toCompany.trim();
    }

    /**
     * @return employee_name
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @param employeeName
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    /**
     * @return en_name
     */
    public String getEnName() {
        return enName;
    }

    /**
     * @param enName
     */
    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * @return id_card
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * @return native_place
     */
    public String getNativePlace() {
        return nativePlace;
    }

    /**
     * @param nativePlace
     */
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * @return birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * @return nation
     */
    public String getNation() {
        return nation;
    }

    /**
     * @param nation
     */
    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    /**
     * @return political_outlook
     */
    public String getPoliticalOutlook() {
        return politicalOutlook;
    }

    /**
     * @param politicalOutlook
     */
    public void setPoliticalOutlook(String politicalOutlook) {
        this.politicalOutlook = politicalOutlook == null ? null : politicalOutlook.trim();
    }

    /**
     * @return max_school
     */
    public String getMaxSchool() {
        return maxSchool;
    }

    /**
     * @param maxSchool
     */
    public void setMaxSchool(String maxSchool) {
        this.maxSchool = maxSchool == null ? null : maxSchool.trim();
    }

    /**
     * @return major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major
     */
    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    /**
     * @return max_education
     */
    public String getMaxEducation() {
        return maxEducation;
    }

    /**
     * @param maxEducation
     */
    public void setMaxEducation(String maxEducation) {
        this.maxEducation = maxEducation == null ? null : maxEducation.trim();
    }

    /**
     * @return graduation_date
     */
    public String getGraduationDate() {
        return graduationDate;
    }

    /**
     * @param graduationDate
     */
    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate == null ? null : graduationDate.trim();
    }

    /**
     * @return work_years
     */
    public BigDecimal getWorkYears() {
        return workYears;
    }

    /**
     * @param workYears
     */
    public void setWorkYears(BigDecimal workYears) {
        this.workYears = workYears;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return contact_name
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * @param contactName
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * @return contact_relationship
     */
    public String getContactRelationship() {
        return contactRelationship;
    }

    /**
     * @param contactRelationship
     */
    public void setContactRelationship(String contactRelationship) {
        this.contactRelationship = contactRelationship == null ? null : contactRelationship.trim();
    }

    /**
     * @return contact_phone
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * @param contactPhone
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    /**
     * @return join_date
     */
    public Integer getJoinDate() {
        return joinDate;
    }

    /**
     * @param joinDate
     */
    public void setJoinDate(Integer joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * @return position_type
     */
    public String getPositionType() {
        return positionType;
    }

    /**
     * @param positionType
     */
    public void setPositionType(String positionType) {
        this.positionType = positionType == null ? null : positionType.trim();
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
     * @return zs_bank_card
     */
    public String getZsBankCard() {
        return zsBankCard;
    }

    /**
     * @param zsBankCard
     */
    public void setZsBankCard(String zsBankCard) {
        this.zsBankCard = zsBankCard == null ? null : zsBankCard.trim();
    }

    /**
     * @return payment_area
     */
    public String getPaymentArea() {
        return paymentArea;
    }

    /**
     * @param paymentArea
     */
    public void setPaymentArea(String paymentArea) {
        this.paymentArea = paymentArea == null ? null : paymentArea.trim();
    }

    /**
     * @return operator_status
     */
    public String getOperatorStatus() {
        return operatorStatus;
    }

    /**
     * @param operatorStatus
     */
    public void setOperatorStatus(String operatorStatus) {
        this.operatorStatus = operatorStatus == null ? null : operatorStatus.trim();
    }

    /**
     * @return regular_date
     */
    public String getRegularDate() {
        return regularDate;
    }

    /**
     * @param regularDate
     */
    public void setRegularDate(String regularDate) {
        this.regularDate = regularDate == null ? null : regularDate.trim();
    }

    /**
     * 获取转正截至日期
     *
     * @return zz_stop_date - 转正截至日期
     */
    public Integer getZzStopDate() {
        return zzStopDate;
    }

    /**
     * 设置转正截至日期
     *
     * @param zzStopDate 转正截至日期
     */
    public void setZzStopDate(Integer zzStopDate) {
        this.zzStopDate = zzStopDate;
    }

    /**
     * 获取人员状态
     *
     * @return status - 人员状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置人员状态
     *
     * @param status 人员状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", employeeId=").append(employeeId);
        sb.append(", jobNo=").append(jobNo);
        sb.append(", toCompany=").append(toCompany);
        sb.append(", employeeName=").append(employeeName);
        sb.append(", enName=").append(enName);
        sb.append(", phone=").append(phone);
        sb.append(", idCard=").append(idCard);
        sb.append(", nativePlace=").append(nativePlace);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", nation=").append(nation);
        sb.append(", politicalOutlook=").append(politicalOutlook);
        sb.append(", maxSchool=").append(maxSchool);
        sb.append(", major=").append(major);
        sb.append(", maxEducation=").append(maxEducation);
        sb.append(", graduationDate=").append(graduationDate);
        sb.append(", workYears=").append(workYears);
        sb.append(", address=").append(address);
        sb.append(", email=").append(email);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactRelationship=").append(contactRelationship);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", joinDate=").append(joinDate);
        sb.append(", positionType=").append(positionType);
        sb.append(", positionLevel=").append(positionLevel);
        sb.append(", zsBankCard=").append(zsBankCard);
        sb.append(", paymentArea=").append(paymentArea);
        sb.append(", operatorStatus=").append(operatorStatus);
        sb.append(", regularDate=").append(regularDate);
        sb.append(", zzStopDate=").append(zzStopDate);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}