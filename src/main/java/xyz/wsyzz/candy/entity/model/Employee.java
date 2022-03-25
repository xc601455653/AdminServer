package xyz.wsyzz.candy.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
@ApiModel("人员新增修改入参")
@Table(name = "t_employee")
public class Employee implements Serializable {
    /**
     * id
     */
    @Column(name = "id")
    @ApiModelProperty(value = "序号")
    @Id
    private Integer id;
    /**
     * 员工序号
     */
    @Column(name = "employee_id")
    @ApiModelProperty(value = "员工序号")
    private Integer employeeId;

    /**
     * 服务公司
     */
    @ApiModelProperty(value = "服务公司")
    @Column(name = "to_company")
    private String toCompany;

    /**
     * 恒生子公司
     */
    @ApiModelProperty(value = "恒生子公司")
    @Column(name = "hs_sub_company")
    private String hsSubCompany;

    /**
     * 对接hr
     */
    @ApiModelProperty(value = "对接hr")
    @Column(name = "from_hr")
    private String fromHr;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @Column(name = "employee_name")
    private String employeeName;

    /**
     * 英文名/花名
     */
    @ApiModelProperty(value = "英文名/花名")
    @Column(name = "en_name")
    private String enName;

    /**
     * 奖金是否兑现
     */
    @ApiModelProperty(value = "奖金是否兑现")
    @Column(name = "bonus_cashing")
    private String bonusCashing;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    @Column(name = "phone")
    private String phone;

    /**
     * 身份证号
     */
    @ApiModelProperty(value = "身份证号")
    @Column(name = "id_card")
    private String idCard;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    @Column(name = "sex")
    private String sex;

    /**
     * 生日月份
     */
    @ApiModelProperty(value = "生日月份")
    @Column(name = "birthday")
    private String birthday;

    /**
     * 招商卡号
     */
    @Column(name = "zs_bank_card")
    @ApiModelProperty(value = "招商卡号")
    private String zsBankCard;

    /**
     * 试用期工资
     */
    @ApiModelProperty(value = "试用期工资")
    @Column(name = "probation_salary")
    private BigDecimal probationSalary;

    /**
     * 转正工资
     */
    @ApiModelProperty(value = "转正工资")
    @Column(name = "regular_salary")
    private BigDecimal regularSalary;

    /**
     * 商务价
     */
    @ApiModelProperty(value = "商务价")
    @Column(name = "business_price")
    private BigDecimal businessPrice;

    /**
     * 入职日期
     */
    @ApiModelProperty(value = "入职日期")
    @Column(name = "join_date")
    private Integer joinDate;

    /**
     * 转正日期
     */
    @ApiModelProperty(value = "转正日期")
    @Column(name = "regular_date")
    private Integer regularDate;

    /**
     * 岗位类型
     */
    @ApiModelProperty(value = "岗位类型")
    @Column(name = "position_type")
    private String positionType;

    /**
     * 岗位级别
     */
    @ApiModelProperty(value = "岗位级别")
    @Column(name = "position_level")
    private String positionLevel;

    /**
     * 社保起缴时间
     */
    @ApiModelProperty(value = "社保起缴时间")
    @Column(name = "social_start_date")
    private Integer socialStartDate;

    /**
     * 交纳地区
     */
    @ApiModelProperty(value = "交纳地区")
    @Column(name = "payment_area")
    private String paymentArea;

    /**
     * 公积金起缴时间
     */
    @ApiModelProperty(value = "公积金起缴时间")
    @Column(name = "commfund_start_date")
    private Integer commfundStartDate;

    /**
     * 最高毕业学校
     */
    @ApiModelProperty(value = "最高毕业学校")
    @Column(name = "max_school")
    private String maxSchool;

    /**
     * 毕业时间
     */
    @ApiModelProperty(value = "毕业时间")
    @Column(name = "graduation_date")
    private Integer graduationDate;

    /**
     * 最高学历
     */
    @ApiModelProperty(value = "最高学历")
    @Column(name = "max_education")
    private String maxEducation;

    /**
     * 工作年限
     */
    @ApiModelProperty(value = "工作年限")
    @Column(name = "work_years")
    private String workYears;

    /**
     * 专业
     */
    @ApiModelProperty(value = "专业")
    @Column(name = "major")
    private String major;

    /**
     * 离职日期
     */
    @Column(name = "resignation_date")
    @ApiModelProperty(value = "离职日期")
    private Integer resignationDate;

    /**
     * 离职原因
     */
    @Column(name = "resignation_reason")
    @ApiModelProperty(value = "离职原因")
    private String resignationReason;

    /**
     * offer日期
     */
    @Column(name = "offer_date")
    @ApiModelProperty(value = "offer日期")
    private Integer offerDate;

    /**
     * 合同签订日期
     */
    @Column(name = "contract_date")
    @ApiModelProperty(value = "合同签订日期")
    private Integer contractDate;

    /**
     * 合同到期日期
     */
    @Column(name = "contract_end_date")
    @ApiModelProperty(value = "合同到期日期")
    private Integer contractEndDate;

    /**
     * 籍贯
     */
    @Column(name = "native_place")
    @ApiModelProperty(value = "籍贯")
    private String nativePlace;

    /**
     * 民族
     */
    @Column(name = "nation")
    @ApiModelProperty(value = "民族")
    private String nation;

    /**
     * 政治面貌
     */
    @Column(name = "political_outlook")
    @ApiModelProperty(value = "政治面貌")
    private String politicalOutlook;

    /**
     * 联系地址
     */
    @Column(name = "contact_address")
    @ApiModelProperty(value = "民族")
    private String contactAddress;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 紧急联系人关系
     */
    @Column(name = "contact_relationship")
    @ApiModelProperty(value = "紧急联系人关系")
    private String contactRelationship;

    /**
     * 紧急联系人姓名
     */
    @Column(name = "contact_name")
    @ApiModelProperty(value = "紧急联系人姓名")
    private String contactName;

    /**
     * 紧急联系人手机
     */
    @Column(name = "contact_phone")
    @ApiModelProperty(value = "紧急联系人手机")
    private String contactPhone;

    /**
     * 档案所在地
     */
    @Column(name = "location_archives")
    @ApiModelProperty(value = "档案所在地")
    private String locationArchives;

    /**
     * 档案转入时间
     */
    @Column(name = "archives_join_date")
    @ApiModelProperty(value = "档案转入时间")
    private String archivesJoinDate;

    /**
     * 户口所在地
     */
    @Column(name = "registered_residence")
    @ApiModelProperty(value = "户口所在地")
    private String registeredResidence;

    /**
     * 户口转入时间
     */
    @Column(name = "account_join_date")
    @ApiModelProperty(value = "户口转入时间")
    private Integer accountJoinDate;

    /**
     * 统筹和公积金
     */
    @Column(name = "overall_commfund")
    @ApiModelProperty(value = "统筹和公积金")
    private String overallCommfund;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取员工序号
     *
     * @return employee_id - 员工序号
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * 设置员工序号
     *
     * @param employeeId 员工序号
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * 获取服务公司
     *
     * @return to_company - 服务公司
     */
    public String getToCompany() {
        return toCompany;
    }

    /**
     * 设置服务公司
     *
     * @param toCompany 服务公司
     */
    public void setToCompany(String toCompany) {
        this.toCompany = toCompany == null ? null : toCompany.trim();
    }

    /**
     * 获取恒生子公司
     *
     * @return hs_sub_company - 恒生子公司
     */
    public String getHsSubCompany() {
        return hsSubCompany;
    }

    /**
     * 设置恒生子公司
     *
     * @param hsSubCompany 恒生子公司
     */
    public void setHsSubCompany(String hsSubCompany) {
        this.hsSubCompany = hsSubCompany == null ? null : hsSubCompany.trim();
    }

    /**
     * 获取对接hr
     *
     * @return from_hr - 对接hr
     */
    public String getFromHr() {
        return fromHr;
    }

    /**
     * 设置对接hr
     *
     * @param fromHr 对接hr
     */
    public void setFromHr(String fromHr) {
        this.fromHr = fromHr == null ? null : fromHr.trim();
    }

    /**
     * 获取姓名
     *
     * @return employee_name - 姓名
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * 设置姓名
     *
     * @param employeeName 姓名
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    /**
     * 获取英文名/花名
     *
     * @return en_name - 英文名/花名
     */
    public String getEnName() {
        return enName;
    }

    /**
     * 设置英文名/花名
     *
     * @param enName 英文名/花名
     */
    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    /**
     * 获取奖金是否兑现
     *
     * @return bonus_cashing - 奖金是否兑现
     */
    public String getBonusCashing() {
        return bonusCashing;
    }

    /**
     * 设置奖金是否兑现
     *
     * @param bonusCashing 奖金是否兑现
     */
    public void setBonusCashing(String bonusCashing) {
        this.bonusCashing = bonusCashing == null ? null : bonusCashing.trim();
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取身份证号
     *
     * @return id_card - 身份证号
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置身份证号
     *
     * @param idCard 身份证号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取生日月份
     *
     * @return birthday - 生日月份
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置生日月份
     *
     * @param birthday 生日月份
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * 获取招商卡号
     *
     * @return zs_bank_card - 招商卡号
     */
    public String getZsBankCard() {
        return zsBankCard;
    }

    /**
     * 设置招商卡号
     *
     * @param zsBankCard 招商卡号
     */
    public void setZsBankCard(String zsBankCard) {
        this.zsBankCard = zsBankCard == null ? null : zsBankCard.trim();
    }

    /**
     * 获取试用期工资
     *
     * @return probation_salary - 试用期工资
     */
    public BigDecimal getProbationSalary() {
        return probationSalary;
    }

    /**
     * 设置试用期工资
     *
     * @param probationSalary 试用期工资
     */
    public void setProbationSalary(BigDecimal probationSalary) {
        this.probationSalary = probationSalary;
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
     * 获取商务价
     *
     * @return business_price - 商务价
     */
    public BigDecimal getBusinessPrice() {
        return businessPrice;
    }

    /**
     * 设置商务价
     *
     * @param businessPrice 商务价
     */
    public void setBusinessPrice(BigDecimal businessPrice) {
        this.businessPrice = businessPrice;
    }

    /**
     * 获取入职日期
     *
     * @return join_date - 入职日期
     */
    public Integer getJoinDate() {
        return joinDate;
    }

    /**
     * 设置入职日期
     *
     * @param joinDate 入职日期
     */
    public void setJoinDate(Integer joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * 获取转正日期
     *
     * @return regular_date - 转正日期
     */
    public Integer getRegularDate() {
        return regularDate;
    }

    /**
     * 设置转正日期
     *
     * @param regularDate 转正日期
     */
    public void setRegularDate(Integer regularDate) {
        this.regularDate = regularDate;
    }

    /**
     * 获取岗位类型
     *
     * @return position_type - 岗位类型
     */
    public String getPositionType() {
        return positionType;
    }

    /**
     * 设置岗位类型
     *
     * @param positionType 岗位类型
     */
    public void setPositionType(String positionType) {
        this.positionType = positionType == null ? null : positionType.trim();
    }

    /**
     * 获取岗位级别
     *
     * @return position_level - 岗位级别
     */
    public String getPositionLevel() {
        return positionLevel;
    }

    /**
     * 设置岗位级别
     *
     * @param positionLevel 岗位级别
     */
    public void setPositionLevel(String positionLevel) {
        this.positionLevel = positionLevel == null ? null : positionLevel.trim();
    }

    /**
     * 获取社保起缴时间
     *
     * @return social_start_date - 社保起缴时间
     */
    public Integer getSocialStartDate() {
        return socialStartDate;
    }

    /**
     * 设置社保起缴时间
     *
     * @param socialStartDate 社保起缴时间
     */
    public void setSocialStartDate(Integer socialStartDate) {
        this.socialStartDate = socialStartDate;
    }

    /**
     * 获取交纳地区
     *
     * @return payment_area - 交纳地区
     */
    public String getPaymentArea() {
        return paymentArea;
    }

    /**
     * 设置交纳地区
     *
     * @param paymentArea 交纳地区
     */
    public void setPaymentArea(String paymentArea) {
        this.paymentArea = paymentArea == null ? null : paymentArea.trim();
    }

    /**
     * 获取公积金起缴时间
     *
     * @return commfund_start_date - 公积金起缴时间
     */
    public Integer getCommfundStartDate() {
        return commfundStartDate;
    }

    /**
     * 设置公积金起缴时间
     *
     * @param commfundStartDate 公积金起缴时间
     */
    public void setCommfundStartDate(Integer commfundStartDate) {
        this.commfundStartDate = commfundStartDate;
    }

    /**
     * 获取最高毕业学校
     *
     * @return max_school - 最高毕业学校
     */
    public String getMaxSchool() {
        return maxSchool;
    }

    /**
     * 设置最高毕业学校
     *
     * @param maxSchool 最高毕业学校
     */
    public void setMaxSchool(String maxSchool) {
        this.maxSchool = maxSchool == null ? null : maxSchool.trim();
    }

    /**
     * 获取毕业时间
     *
     * @return graduation_date - 毕业时间
     */
    public Integer getGraduationDate() {
        return graduationDate;
    }

    /**
     * 设置毕业时间
     *
     * @param graduationDate 毕业时间
     */
    public void setGraduationDate(Integer graduationDate) {
        this.graduationDate = graduationDate;
    }

    /**
     * 获取最高学历
     *
     * @return max_education - 最高学历
     */
    public String getMaxEducation() {
        return maxEducation;
    }

    /**
     * 设置最高学历
     *
     * @param maxEducation 最高学历
     */
    public void setMaxEducation(String maxEducation) {
        this.maxEducation = maxEducation == null ? null : maxEducation.trim();
    }

    /**
     * 获取工作年限
     *
     * @return work_years - 工作年限
     */
    public String getWorkYears() {
        return workYears;
    }

    /**
     * 设置工作年限
     *
     * @param workYears 工作年限
     */
    public void setWorkYears(String workYears) {
        this.workYears = workYears == null ? null : workYears.trim();
    }

    /**
     * 获取专业
     *
     * @return major - 专业
     */
    public String getMajor() {
        return major;
    }

    /**
     * 设置专业
     *
     * @param major 专业
     */
    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    /**
     * 获取离职日期
     *
     * @return resignation_date - 离职日期
     */
    public Integer getResignationDate() {
        return resignationDate;
    }

    /**
     * 设置离职日期
     *
     * @param resignationDate 离职日期
     */
    public void setResignationDate(Integer resignationDate) {
        this.resignationDate = resignationDate;
    }

    /**
     * 获取离职原因
     *
     * @return resignation_reason - 离职原因
     */
    public String getResignationReason() {
        return resignationReason;
    }

    /**
     * 设置离职原因
     *
     * @param resignationReason 离职原因
     */
    public void setResignationReason(String resignationReason) {
        this.resignationReason = resignationReason == null ? null : resignationReason.trim();
    }

    /**
     * 获取offer日期
     *
     * @return offer_date - offer日期
     */
    public Integer getOfferDate() {
        return offerDate;
    }

    /**
     * 设置offer日期
     *
     * @param offerDate offer日期
     */
    public void setOfferDate(Integer offerDate) {
        this.offerDate = offerDate;
    }

    /**
     * 获取合同签订日期
     *
     * @return contract_date - 合同签订日期
     */
    public Integer getContractDate() {
        return contractDate;
    }

    /**
     * 设置合同签订日期
     *
     * @param contractDate 合同签订日期
     */
    public void setContractDate(Integer contractDate) {
        this.contractDate = contractDate;
    }

    /**
     * 获取合同到期日期
     *
     * @return contract_end_date - 合同到期日期
     */
    public Integer getContractEndDate() {
        return contractEndDate;
    }

    /**
     * 设置合同到期日期
     *
     * @param contractEndDate 合同到期日期
     */
    public void setContractEndDate(Integer contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    /**
     * 获取籍贯
     *
     * @return native_place - 籍贯
     */
    public String getNativePlace() {
        return nativePlace;
    }

    /**
     * 设置籍贯
     *
     * @param nativePlace 籍贯
     */
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    /**
     * 获取民族
     *
     * @return nation - 民族
     */
    public String getNation() {
        return nation;
    }

    /**
     * 设置民族
     *
     * @param nation 民族
     */
    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    /**
     * 获取政治面貌
     *
     * @return political_outlook - 政治面貌
     */
    public String getPoliticalOutlook() {
        return politicalOutlook;
    }

    /**
     * 设置政治面貌
     *
     * @param politicalOutlook 政治面貌
     */
    public void setPoliticalOutlook(String politicalOutlook) {
        this.politicalOutlook = politicalOutlook == null ? null : politicalOutlook.trim();
    }

    /**
     * 获取联系地址
     *
     * @return contact_address - 联系地址
     */
    public String getContactAddress() {
        return contactAddress;
    }

    /**
     * 设置联系地址
     *
     * @param contactAddress 联系地址
     */
    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress == null ? null : contactAddress.trim();
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取紧急联系人关系
     *
     * @return contact_relationship - 紧急联系人关系
     */
    public String getContactRelationship() {
        return contactRelationship;
    }

    /**
     * 设置紧急联系人关系
     *
     * @param contactRelationship 紧急联系人关系
     */
    public void setContactRelationship(String contactRelationship) {
        this.contactRelationship = contactRelationship == null ? null : contactRelationship.trim();
    }

    /**
     * 获取紧急联系人姓名
     *
     * @return contact_name - 紧急联系人姓名
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 设置紧急联系人姓名
     *
     * @param contactName 紧急联系人姓名
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * 获取紧急联系人手机
     *
     * @return contact_phone - 紧急联系人手机
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * 设置紧急联系人手机
     *
     * @param contactPhone 紧急联系人手机
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    /**
     * 获取档案所在地
     *
     * @return location_archives - 档案所在地
     */
    public String getLocationArchives() {
        return locationArchives;
    }

    /**
     * 设置档案所在地
     *
     * @param locationArchives 档案所在地
     */
    public void setLocationArchives(String locationArchives) {
        this.locationArchives = locationArchives == null ? null : locationArchives.trim();
    }

    /**
     * 获取档案转入时间
     *
     * @return archives_join_date - 档案转入时间
     */
    public String getArchivesJoinDate() {
        return archivesJoinDate;
    }

    /**
     * 设置档案转入时间
     *
     * @param archivesJoinDate 档案转入时间
     */
    public void setArchivesJoinDate(String archivesJoinDate) {
        this.archivesJoinDate = archivesJoinDate == null ? null : archivesJoinDate.trim();
    }

    /**
     * 获取户口所在地
     *
     * @return registered_residence - 户口所在地
     */
    public String getRegisteredResidence() {
        return registeredResidence;
    }

    /**
     * 设置户口所在地
     *
     * @param registeredResidence 户口所在地
     */
    public void setRegisteredResidence(String registeredResidence) {
        this.registeredResidence = registeredResidence == null ? null : registeredResidence.trim();
    }

    /**
     * 获取户口转入时间
     *
     * @return account_join_date - 户口转入时间
     */
    public Integer getAccountJoinDate() {
        return accountJoinDate;
    }

    /**
     * 设置户口转入时间
     *
     * @param accountJoinDate 户口转入时间
     */
    public void setAccountJoinDate(Integer accountJoinDate) {
        this.accountJoinDate = accountJoinDate;
    }

    /**
     * 获取统筹和公积金
     *
     * @return overall_commfund - 统筹和公积金
     */
    public String getOverallCommfund() {
        return overallCommfund;
    }

    /**
     * 设置统筹和公积金
     *
     * @param overallCommfund 统筹和公积金
     */
    public void setOverallCommfund(String overallCommfund) {
        this.overallCommfund = overallCommfund == null ? null : overallCommfund.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", employeeId=").append(employeeId);
        sb.append(", toCompany=").append(toCompany);
        sb.append(", hsSubCompany=").append(hsSubCompany);
        sb.append(", fromHr=").append(fromHr);
        sb.append(", employeeName=").append(employeeName);
        sb.append(", enName=").append(enName);
        sb.append(", bonusCashing=").append(bonusCashing);
        sb.append(", phone=").append(phone);
        sb.append(", idCard=").append(idCard);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", zsBankCard=").append(zsBankCard);
        sb.append(", probationSalary=").append(probationSalary);
        sb.append(", regularSalary=").append(regularSalary);
        sb.append(", businessPrice=").append(businessPrice);
        sb.append(", joinDate=").append(joinDate);
        sb.append(", regularDate=").append(regularDate);
        sb.append(", positionType=").append(positionType);
        sb.append(", positionLevel=").append(positionLevel);
        sb.append(", socialStartDate=").append(socialStartDate);
        sb.append(", paymentArea=").append(paymentArea);
        sb.append(", commfundStartDate=").append(commfundStartDate);
        sb.append(", maxSchool=").append(maxSchool);
        sb.append(", graduationDate=").append(graduationDate);
        sb.append(", maxEducation=").append(maxEducation);
        sb.append(", workYears=").append(workYears);
        sb.append(", major=").append(major);
        sb.append(", resignationDate=").append(resignationDate);
        sb.append(", resignationReason=").append(resignationReason);
        sb.append(", offerDate=").append(offerDate);
        sb.append(", contractDate=").append(contractDate);
        sb.append(", contractEndDate=").append(contractEndDate);
        sb.append(", nativePlace=").append(nativePlace);
        sb.append(", nation=").append(nation);
        sb.append(", politicalOutlook=").append(politicalOutlook);
        sb.append(", contactAddress=").append(contactAddress);
        sb.append(", email=").append(email);
        sb.append(", contactRelationship=").append(contactRelationship);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", locationArchives=").append(locationArchives);
        sb.append(", archivesJoinDate=").append(archivesJoinDate);
        sb.append(", registeredResidence=").append(registeredResidence);
        sb.append(", accountJoinDate=").append(accountJoinDate);
        sb.append(", overallCommfund=").append(overallCommfund);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}