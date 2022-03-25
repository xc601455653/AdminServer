package xyz.wsyzz.candy.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "t_salary_details")
@ApiModel("工资明细新增修改入参")
public class SalaryDetails implements Serializable {
    /**
     * 序号
     */
    @Id
    @ApiModelProperty(value = "序号")
    private Integer id;

    /**
     * 明细当前日期
     */
    @ApiModelProperty(value = "明细当前日期")
    @Column(name = "curr_date")
    private Integer currDate;

    /**
     * 人员序号
     */
    @ApiModelProperty(value = "人员序号")
    @Column(name = "employee_id")
    private Integer employeeId;

    /**
     * 服务公司
     */
    @ApiModelProperty(value = "服务公司")
    @Column(name = "to_company")
    private String toCompany;

    /**
     * 地区
     */
    @ApiModelProperty(value = "地区")
    private String area;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 是否研发
     */
    @ApiModelProperty(value = "是否研发")
    @Column(name = "development_flag")
    private String developmentFlag;

    /**
     * 基本工资单位（元）
     */
    @ApiModelProperty(value = "基本工资单位（元）")
    @Column(name = "base_salary")
    private BigDecimal baseSalary;

    /**
     * 当月工作日
     */
    @ApiModelProperty(value = "当月工作日")
    @Column(name = "curr_mon_weekdays")
    private String currMonWeekdays;

    /**
     * 试用期薪资
     */
    @ApiModelProperty(value = "试用期薪资")
    @Column(name = "trial_salary")
    private BigDecimal trialSalary;

    /**
     * 转正日期
     */
    @ApiModelProperty(value = "转正日期")
    @Column(name = "regular_date")
    private Integer regularDate;

    /**
     * 当月试用期天数
     */
    @ApiModelProperty(value = "当月试用期天数")
    @Column(name = "curr_mon_trialday")
    private Integer currMonTrialday;

    /**
     * 转正薪资
     */
    @ApiModelProperty(value = "转正薪资")
    @Column(name = "regular_salary")
    private BigDecimal regularSalary;

    /**
     * 当月转正天数
     */
    @ApiModelProperty(value = "当月转正天数")
    @Column(name = "curr_mon_regularday")
    private Integer currMonRegularday;

    /**
     * 宏利加班工时1倍（小时）
     */
    @ApiModelProperty(value = "宏利加班工时1倍（小时）")
    @Column(name = "overtime_one")
    private Double overtimeOne;

    /**
     * 宏利加班工时1.5倍（小时）
     */
    @ApiModelProperty(value = "宏利加班工时1.5倍（小时）")
    @Column(name = "overtime_onemore")
    private Double overtimeOnemore;

    /**
     * 宏利加班工时2倍（小时）
     */
    @ApiModelProperty(value = "宏利加班工时2倍（小时）")
    @Column(name = "overtime_two")
    private Double overtimeTwo;

    /**
     * 宏利加班工时3倍（小时）
     */
    @ApiModelProperty(value = "宏利加班工时3倍（小时）")
    @Column(name = "overtime_three")
    private Double overtimeThree;

    /**
     * 宏利加班报销款
     */
    @ApiModelProperty(value = "宏利加班报销款")
    @Column(name = "overtime_reimburse")
    private BigDecimal overtimeReimburse;

    /**
     * 招聘人数
     */
    @ApiModelProperty(value = "招聘人数")
    @Column(name = "recruits_num")
    private Integer recruitsNum;

    /**
     * 恒生额外工时次
     */
    @ApiModelProperty(value = "恒生额外工时次")
    @Column(name = "hs_extra_hours")
    private Integer hsExtraHours;

    /**
     * 恒生额外工时费
     */
    @ApiModelProperty(value = "恒生额外工时费")
    @Column(name = "hs_extra_cost")
    private BigDecimal hsExtraCost;

    /**
     * 其他应发（元）
     */
    @ApiModelProperty(value = "其他应发（元）")
    @Column(name = "other_send")
    private BigDecimal otherSend;

    /**
     * 考勤扣款（元）
     */
    @ApiModelProperty(value = "考勤扣款（元）")
    @Column(name = "attendance_deduction")
    private BigDecimal attendanceDeduction;

    /**
     * 工会会费（元）
     */
    @ApiModelProperty(value = "工会会费（元）")
    @Column(name = "union_dues")
    private BigDecimal unionDues;

    /**
     * 其他扣款（元）
     */
    @ApiModelProperty(value = "其他扣款（元）")
    @Column(name = "other_deductions")
    private BigDecimal otherDeductions;

    /**
     * 应发工资（元）
     */
    @ApiModelProperty(value = "应发工资（元）")
    @Column(name = "wages_payable")
    private BigDecimal wagesPayable;

    /**
     * 养老险（元）
     */
    @ApiModelProperty(value = "养老险（元）")
    @Column(name = "endowment_insurance")
    private BigDecimal endowmentInsurance;

    /**
     * 医疗险（元）
     */
    @ApiModelProperty(value = "医疗险（元）")
    @Column(name = "medical_insurance")
    private BigDecimal medicalInsurance;

    /**
     * 失业险（元）
     */
    @ApiModelProperty(value = "失业险（元）")
    @Column(name = "unemployment_insurance")
    private BigDecimal unemploymentInsurance;

    /**
     * 养老公司部分
     */
    @ApiModelProperty(value = "养老公司部分")
    @Column(name = "endowment_company")
    private BigDecimal endowmentCompany;

    /**
     * 医疗公司部分
     */
    @ApiModelProperty(value = "医疗公司部分")
    @Column(name = "medical_company")
    private BigDecimal medicalCompany;

    /**
     * 失业公司部分
     */
    @ApiModelProperty(value = "失业公司部分")
    @Column(name = "unemployment_company")
    private BigDecimal unemploymentCompany;

    /**
     * 工伤公司部分
     */
    @ApiModelProperty(value = "工伤公司部分")
    @Column(name = "Industrial_company")
    private String industrialCompany;

    /**
     * 生育公司部分
     */
    @ApiModelProperty(value = "生育公司部分")
    @Column(name = "maternity_company")
    private String maternityCompany;

    /**
     * 大病公司部分
     */
    @ApiModelProperty(value = "大病公司部分")
    @Column(name = "serious_company")
    private String seriousCompany;

    /**
     * 残障金公司部分
     */
    @ApiModelProperty(value = "残障金公司部分")
    @Column(name = "handicap_company")
    private String handicapCompany;

    /**
     * 公积金公司部分
     */
    @ApiModelProperty(value = "公积金公司部分")
    @Column(name = "commfund_company")
    private BigDecimal commfundCompany;

    /**
     * 五险一金公司部分
     */
    @ApiModelProperty(value = "五险一金公司部分")
    @Column(name = "five_one_company")
    private BigDecimal fiveOneCompany;

    /**
     * 公积金（元）
     */
    @ApiModelProperty(value = "公积金（元）")
    private BigDecimal commfund;

    /**
     * 社保合计（元）
     */
    @ApiModelProperty(value = "社保合计（元）")
    @Column(name = "social_security_count")
    private BigDecimal socialSecurityCount;

    /**
     * 应缴个税
     */
    @ApiModelProperty(value = "应缴个税")
    @Column(name = "self_tax")
    private BigDecimal selfTax;

    /**
     *
     * 实发工资（元）
     */
    @ApiModelProperty(value = "实发工资（元）")
    @Column(name = "net_salary")
    private BigDecimal netSalary;

    /**
     * 其他应发/扣款备注
     */
    @ApiModelProperty(value = "其他应发/扣款备注")
    @Column(name = "other_salary")
    private BigDecimal otherSalary;

    /**
     * 累计缺勤（天）
     */
    @ApiModelProperty(value = "累计缺勤（天）")
    @Column(name = "cumulative_absence")
    private Double cumulativeAbsence;

    /**
     * 病假（天）
     */
    @ApiModelProperty(value = "病假（天）")
    @Column(name = "sick_leave")
    private Double sickLeave;

    /**
     * 事假（天）
     */
    @ApiModelProperty(value = "事假（天）")
    @Column(name = "compassionate_leave")
    private Double compassionateLeave;

    /**
     * 年休假（天）
     */
    @ApiModelProperty(value = "年休假（天）")
    @Column(name = "annual_leave")
    private Double annualLeave;

    /**
     * 调休（天）
     */
    @ApiModelProperty(value = "调休（天）")
    @Column(name = "compensatory_leave")
    private Double compensatoryLeave;

    /**
     * 产假/陪产假/丧假（天）
     */
    @ApiModelProperty(value = "产假/陪产假/丧假（天）")
    @Column(name = "maternity_leave")
    private Double maternityLeave;

    /**
     * 婚假（天）
     */
    @ApiModelProperty(value = "婚假（天）")
    @Column(name = "marriage_holiday")
    private Double marriageHoliday;

    /**
     * 未入职（天）
     */
    @ApiModelProperty(value = "未入职（天）")
    @Column(name = "not_employed")
    private Double notEmployed;

    /**
     * 离职（天）
     */
    @ApiModelProperty(value = "离职（天）")
    @Column(name = "leave_office")
    private Double leaveOffice;

    /**
     * 病假工资（元）
     */
    @ApiModelProperty(value = "病假工资（元）")
    @Column(name = "sick_salary")
    private BigDecimal sickSalary;

    /**
     * 事假工资（元）
     */
    @ApiModelProperty(value = "事假工资（元）")
    @Column(name = "compassionate_salary")
    private BigDecimal compassionateSalary;

    /**
     * 未入职工资（元）
     */
    @ApiModelProperty(value = "未入职工资（元）")
    @Column(name = "not_emp_salary")
    private BigDecimal notEmpSalary;

    /**
     * 离职工资（元）
     */
    @ApiModelProperty(value = "离职工资（元）")
    @Column(name = "leave_office_salary")
    private BigDecimal leaveOfficeSalary;

    /**
     * 小计（元）
     */
    @ApiModelProperty(value = "小计（元）")
    private BigDecimal subtotal;

    private static final long serialVersionUID = 1L;

    /**
     * 获取序号
     *
     * @return id - 序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置序号
     *
     * @param id 序号
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取地区
     *
     * @return area - 地区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置地区
     *
     * @param area 地区
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
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
     * 获取是否研发
     *
     * @return development_flag - 是否研发
     */
    public String getDevelopmentFlag() {
        return developmentFlag;
    }

    /**
     * 设置是否研发
     *
     * @param developmentFlag 是否研发
     */
    public void setDevelopmentFlag(String developmentFlag) {
        this.developmentFlag = developmentFlag == null ? null : developmentFlag.trim();
    }

    /**
     * 获取基本工资单位（元）
     *
     * @return base_salary - 基本工资单位（元）
     */
    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    /**
     * 设置基本工资单位（元）
     *
     * @param baseSalary 基本工资单位（元）
     */
    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    /**
     * 获取当月工作日
     *
     * @return curr_mon_weekdays - 当月工作日
     */
    public String getCurrMonWeekdays() {
        return currMonWeekdays;
    }

    /**
     * 设置当月工作日
     *
     * @param currMonWeekdays 当月工作日
     */
    public void setCurrMonWeekdays(String currMonWeekdays) {
        this.currMonWeekdays = currMonWeekdays == null ? null : currMonWeekdays.trim();
    }

    /**
     * 获取试用期薪资
     *
     * @return trial_salary - 试用期薪资
     */
    public BigDecimal getTrialSalary() {
        return trialSalary;
    }

    /**
     * 设置试用期薪资
     *
     * @param trialSalary 试用期薪资
     */
    public void setTrialSalary(BigDecimal trialSalary) {
        this.trialSalary = trialSalary;
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
     * 获取当月试用期天数
     *
     * @return curr_mon_trialday - 当月试用期天数
     */
    public Integer getCurrMonTrialday() {
        return currMonTrialday;
    }

    /**
     * 设置当月试用期天数
     *
     * @param currMonTrialday 当月试用期天数
     */
    public void setCurrMonTrialday(Integer currMonTrialday) {
        this.currMonTrialday = currMonTrialday;
    }

    /**
     * 获取转正薪资
     *
     * @return regular_salary - 转正薪资
     */
    public BigDecimal getRegularSalary() {
        return regularSalary;
    }

    /**
     * 设置转正薪资
     *
     * @param regularSalary 转正薪资
     */
    public void setRegularSalary(BigDecimal regularSalary) {
        this.regularSalary = regularSalary;
    }

    /**
     * 获取当月转正天数
     *
     * @return curr_mon_regularday - 当月转正天数
     */
    public Integer getCurrMonRegularday() {
        return currMonRegularday;
    }

    /**
     * 设置当月转正天数
     *
     * @param currMonRegularday 当月转正天数
     */
    public void setCurrMonRegularday(Integer currMonRegularday) {
        this.currMonRegularday = currMonRegularday;
    }

    /**
     * 获取宏利加班工时1倍（小时）
     *
     * @return overtime_one - 宏利加班工时1倍（小时）
     */
    public Double getOvertimeOne() {
        return overtimeOne;
    }

    /**
     * 设置宏利加班工时1倍（小时）
     *
     * @param overtimeOne 宏利加班工时1倍（小时）
     */
    public void setOvertimeOne(Double overtimeOne) {
        this.overtimeOne = overtimeOne;
    }

    /**
     * 获取宏利加班工时1.5倍（小时）
     *
     * @return overtime_onemore - 宏利加班工时1.5倍（小时）
     */
    public Double getOvertimeOnemore() {
        return overtimeOnemore;
    }

    /**
     * 设置宏利加班工时1.5倍（小时）
     *
     * @param overtimeOnemore 宏利加班工时1.5倍（小时）
     */
    public void setOvertimeOnemore(Double overtimeOnemore) {
        this.overtimeOnemore = overtimeOnemore;
    }

    /**
     * 获取宏利加班工时2倍（小时）
     *
     * @return overtime_two - 宏利加班工时2倍（小时）
     */
    public Double getOvertimeTwo() {
        return overtimeTwo;
    }

    /**
     * 设置宏利加班工时2倍（小时）
     *
     * @param overtimeTwo 宏利加班工时2倍（小时）
     */
    public void setOvertimeTwo(Double overtimeTwo) {
        this.overtimeTwo = overtimeTwo;
    }

    /**
     * 获取宏利加班工时3倍（小时）
     *
     * @return overtime_three - 宏利加班工时3倍（小时）
     */
    public Double getOvertimeThree() {
        return overtimeThree;
    }

    /**
     * 设置宏利加班工时3倍（小时）
     *
     * @param overtimeThree 宏利加班工时3倍（小时）
     */
    public void setOvertimeThree(Double overtimeThree) {
        this.overtimeThree = overtimeThree;
    }

    /**
     * 获取宏利加班报销款
     *
     * @return overtime_reimburse - 宏利加班报销款
     */
    public BigDecimal getOvertimeReimburse() {
        return overtimeReimburse;
    }

    /**
     * 设置宏利加班报销款
     *
     * @param overtimeReimburse 宏利加班报销款
     */
    public void setOvertimeReimburse(BigDecimal overtimeReimburse) {
        this.overtimeReimburse = overtimeReimburse;
    }

    /**
     * 获取招聘人数
     *
     * @return recruits_num - 招聘人数
     */
    public Integer getRecruitsNum() {
        return recruitsNum;
    }

    /**
     * 设置招聘人数
     *
     * @param recruitsNum 招聘人数
     */
    public void setRecruitsNum(Integer recruitsNum) {
        this.recruitsNum = recruitsNum;
    }

    /**
     * 获取恒生额外工时次
     *
     * @return hs_extra_hours - 恒生额外工时次
     */
    public Integer getHsExtraHours() {
        return hsExtraHours;
    }

    /**
     * 设置恒生额外工时次
     *
     * @param hsExtraHours 恒生额外工时次
     */
    public void setHsExtraHours(Integer hsExtraHours) {
        this.hsExtraHours = hsExtraHours;
    }

    /**
     * 获取恒生额外工时费
     *
     * @return hs_extra_cost - 恒生额外工时费
     */
    public BigDecimal getHsExtraCost() {
        return hsExtraCost;
    }

    /**
     * 设置恒生额外工时费
     *
     * @param hsExtraCost 恒生额外工时费
     */
    public void setHsExtraCost(BigDecimal hsExtraCost) {
        this.hsExtraCost = hsExtraCost;
    }

    /**
     * 获取其他应发（元）
     *
     * @return other_send - 其他应发（元）
     */
    public BigDecimal getOtherSend() {
        return otherSend;
    }

    /**
     * 设置其他应发（元）
     *
     * @param otherSend 其他应发（元）
     */
    public void setOtherSend(BigDecimal otherSend) {
        this.otherSend = otherSend;
    }

    /**
     * 获取考勤扣款（元）
     *
     * @return attendance_deduction - 考勤扣款（元）
     */
    public BigDecimal getAttendanceDeduction() {
        return attendanceDeduction;
    }

    /**
     * 设置考勤扣款（元）
     *
     * @param attendanceDeduction 考勤扣款（元）
     */
    public void setAttendanceDeduction(BigDecimal attendanceDeduction) {
        this.attendanceDeduction = attendanceDeduction;
    }

    /**
     * 获取工会会费（元）
     *
     * @return union_dues - 工会会费（元）
     */
    public BigDecimal getUnionDues() {
        return unionDues;
    }

    /**
     * 设置工会会费（元）
     *
     * @param unionDues 工会会费（元）
     */
    public void setUnionDues(BigDecimal unionDues) {
        this.unionDues = unionDues;
    }

    /**
     * 获取其他扣款（元）
     *
     * @return other_deductions - 其他扣款（元）
     */
    public BigDecimal getOtherDeductions() {
        return otherDeductions;
    }

    /**
     * 设置其他扣款（元）
     *
     * @param otherDeductions 其他扣款（元）
     */
    public void setOtherDeductions(BigDecimal otherDeductions) {
        this.otherDeductions = otherDeductions;
    }

    /**
     * 获取应发工资（元）
     *
     * @return wages_payable - 应发工资（元）
     */
    public BigDecimal getWagesPayable() {
        return wagesPayable;
    }

    /**
     * 设置应发工资（元）
     *
     * @param wagesPayable 应发工资（元）
     */
    public void setWagesPayable(BigDecimal wagesPayable) {
        this.wagesPayable = wagesPayable;
    }

    /**
     * 获取养老险（元）
     *
     * @return endowment_insurance - 养老险（元）
     */
    public BigDecimal getEndowmentInsurance() {
        return endowmentInsurance;
    }

    /**
     * 设置养老险（元）
     *
     * @param endowmentInsurance 养老险（元）
     */
    public void setEndowmentInsurance(BigDecimal endowmentInsurance) {
        this.endowmentInsurance = endowmentInsurance;
    }

    /**
     * 获取医疗险（元）
     *
     * @return medical_insurance - 医疗险（元）
     */
    public BigDecimal getMedicalInsurance() {
        return medicalInsurance;
    }

    /**
     * 设置医疗险（元）
     *
     * @param medicalInsurance 医疗险（元）
     */
    public void setMedicalInsurance(BigDecimal medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    /**
     * 获取失业险（元）
     *
     * @return unemployment_insurance - 失业险（元）
     */
    public BigDecimal getUnemploymentInsurance() {
        return unemploymentInsurance;
    }

    /**
     * 设置失业险（元）
     *
     * @param unemploymentInsurance 失业险（元）
     */
    public void setUnemploymentInsurance(BigDecimal unemploymentInsurance) {
        this.unemploymentInsurance = unemploymentInsurance;
    }

    /**
     * 获取养老公司部分
     *
     * @return endowment_company - 养老公司部分
     */
    public BigDecimal getEndowmentCompany() {
        return endowmentCompany;
    }

    /**
     * 设置养老公司部分
     *
     * @param endowmentCompany 养老公司部分
     */
    public void setEndowmentCompany(BigDecimal endowmentCompany) {
        this.endowmentCompany = endowmentCompany;
    }

    /**
     * 获取医疗公司部分
     *
     * @return medical_company - 医疗公司部分
     */
    public BigDecimal getMedicalCompany() {
        return medicalCompany;
    }

    /**
     * 设置医疗公司部分
     *
     * @param medicalCompany 医疗公司部分
     */
    public void setMedicalCompany(BigDecimal medicalCompany) {
        this.medicalCompany = medicalCompany;
    }

    /**
     * 获取失业公司部分
     *
     * @return unemployment_company - 失业公司部分
     */
    public BigDecimal getUnemploymentCompany() {
        return unemploymentCompany;
    }

    /**
     * 设置失业公司部分
     *
     * @param unemploymentCompany 失业公司部分
     */
    public void setUnemploymentCompany(BigDecimal unemploymentCompany) {
        this.unemploymentCompany = unemploymentCompany;
    }

    /**
     * 获取工伤公司部分
     *
     * @return Industrial_company - 工伤公司部分
     */
    public String getIndustrialCompany() {
        return industrialCompany;
    }

    /**
     * 设置工伤公司部分
     *
     * @param industrialCompany 工伤公司部分
     */
    public void setIndustrialCompany(String industrialCompany) {
        this.industrialCompany = industrialCompany == null ? null : industrialCompany.trim();
    }

    /**
     * 获取生育公司部分
     *
     * @return maternity_company - 生育公司部分
     */
    public String getMaternityCompany() {
        return maternityCompany;
    }

    /**
     * 设置生育公司部分
     *
     * @param maternityCompany 生育公司部分
     */
    public void setMaternityCompany(String maternityCompany) {
        this.maternityCompany = maternityCompany == null ? null : maternityCompany.trim();
    }

    /**
     * 获取大病公司部分
     *
     * @return serious_company - 大病公司部分
     */
    public String getSeriousCompany() {
        return seriousCompany;
    }

    /**
     * 设置大病公司部分
     *
     * @param seriousCompany 大病公司部分
     */
    public void setSeriousCompany(String seriousCompany) {
        this.seriousCompany = seriousCompany == null ? null : seriousCompany.trim();
    }

    /**
     * 获取残障金公司部分
     *
     * @return handicap_company - 残障金公司部分
     */
    public String getHandicapCompany() {
        return handicapCompany;
    }

    /**
     * 设置残障金公司部分
     *
     * @param handicapCompany 残障金公司部分
     */
    public void setHandicapCompany(String handicapCompany) {
        this.handicapCompany = handicapCompany == null ? null : handicapCompany.trim();
    }

    /**
     * 获取公积金公司部分
     *
     * @return commfund_company - 公积金公司部分
     */
    public BigDecimal getCommfundCompany() {
        return commfundCompany;
    }

    /**
     * 设置公积金公司部分
     *
     * @param commfundCompany 公积金公司部分
     */
    public void setCommfundCompany(BigDecimal commfundCompany) {
        this.commfundCompany = commfundCompany;
    }

    /**
     * 获取五险一金公司部分
     *
     * @return five_one_company - 五险一金公司部分
     */
    public BigDecimal getFiveOneCompany() {
        return fiveOneCompany;
    }

    /**
     * 设置五险一金公司部分
     *
     * @param fiveOneCompany 五险一金公司部分
     */
    public void setFiveOneCompany(BigDecimal fiveOneCompany) {
        this.fiveOneCompany = fiveOneCompany;
    }

    /**
     * 获取公积金（元）
     *
     * @return commfund - 公积金（元）
     */
    public BigDecimal getCommfund() {
        return commfund;
    }

    /**
     * 设置公积金（元）
     *
     * @param commfund 公积金（元）
     */
    public void setCommfund(BigDecimal commfund) {
        this.commfund = commfund;
    }

    /**
     * 获取社保合计（元）
     *
     * @return social_security_count - 社保合计（元）
     */
    public BigDecimal getSocialSecurityCount() {
        return socialSecurityCount;
    }

    /**
     * 设置社保合计（元）
     *
     * @param socialSecurityCount 社保合计（元）
     */
    public void setSocialSecurityCount(BigDecimal socialSecurityCount) {
        this.socialSecurityCount = socialSecurityCount;
    }

    /**
     * 获取应缴个税
     *
     * @return self_tax - 应缴个税
     */
    public BigDecimal getSelfTax() {
        return selfTax;
    }

    /**
     * 设置应缴个税
     *
     * @param selfTax 应缴个税
     */
    public void setSelfTax(BigDecimal selfTax) {
        this.selfTax = selfTax;
    }

    /**
     * 获取实发工资（元）
     *
     * @return net_salary - 实发工资（元）
     */
    public BigDecimal getNetSalary() {
        return netSalary;
    }

    /**
     * 设置实发工资（元）
     *
     * @param netSalary 实发工资（元）
     */
    public void setNetSalary(BigDecimal netSalary) {
        this.netSalary = netSalary;
    }

    /**
     * 获取其他应发/扣款备注
     *
     * @return other_salary - 其他应发/扣款备注
     */
    public BigDecimal getOtherSalary() {
        return otherSalary;
    }

    /**
     * 设置其他应发/扣款备注
     *
     * @param otherSalary 其他应发/扣款备注
     */
    public void setOtherSalary(BigDecimal otherSalary) {
        this.otherSalary = otherSalary;
    }

    /**
     * 获取累计缺勤（天）
     *
     * @return cumulative_absence - 累计缺勤（天）
     */
    public Double getCumulativeAbsence() {
        return cumulativeAbsence;
    }

    /**
     * 设置累计缺勤（天）
     *
     * @param cumulativeAbsence 累计缺勤（天）
     */
    public void setCumulativeAbsence(Double cumulativeAbsence) {
        this.cumulativeAbsence = cumulativeAbsence;
    }

    /**
     * 获取病假（天）
     *
     * @return sick_leave - 病假（天）
     */
    public Double getSickLeave() {
        return sickLeave;
    }

    /**
     * 设置病假（天）
     *
     * @param sickLeave 病假（天）
     */
    public void setSickLeave(Double sickLeave) {
        this.sickLeave = sickLeave;
    }

    /**
     * 获取事假（天）
     *
     * @return compassionate_leave - 事假（天）
     */
    public Double getCompassionateLeave() {
        return compassionateLeave;
    }

    /**
     * 设置事假（天）
     *
     * @param compassionateLeave 事假（天）
     */
    public void setCompassionateLeave(Double compassionateLeave) {
        this.compassionateLeave = compassionateLeave;
    }

    /**
     * 获取年休假（天）
     *
     * @return annual_leave - 年休假（天）
     */
    public Double getAnnualLeave() {
        return annualLeave;
    }

    /**
     * 设置年休假（天）
     *
     * @param annualLeave 年休假（天）
     */
    public void setAnnualLeave(Double annualLeave) {
        this.annualLeave = annualLeave;
    }

    /**
     * 获取调休（天）
     *
     * @return compensatory_leave - 调休（天）
     */
    public Double getCompensatoryLeave() {
        return compensatoryLeave;
    }

    /**
     * 设置调休（天）
     *
     * @param compensatoryLeave 调休（天）
     */
    public void setCompensatoryLeave(Double compensatoryLeave) {
        this.compensatoryLeave = compensatoryLeave;
    }

    /**
     * 获取产假/陪产假/丧假（天）
     *
     * @return maternity_leave - 产假/陪产假/丧假（天）
     */
    public Double getMaternityLeave() {
        return maternityLeave;
    }

    /**
     * 设置产假/陪产假/丧假（天）
     *
     * @param maternityLeave 产假/陪产假/丧假（天）
     */
    public void setMaternityLeave(Double maternityLeave) {
        this.maternityLeave = maternityLeave;
    }

    /**
     * 获取婚假（天）
     *
     * @return marriage_holiday - 婚假（天）
     */
    public Double getMarriageHoliday() {
        return marriageHoliday;
    }

    /**
     * 设置婚假（天）
     *
     * @param marriageHoliday 婚假（天）
     */
    public void setMarriageHoliday(Double marriageHoliday) {
        this.marriageHoliday = marriageHoliday;
    }

    /**
     * 获取未入职（天）
     *
     * @return not_employed - 未入职（天）
     */
    public Double getNotEmployed() {
        return notEmployed;
    }

    /**
     * 设置未入职（天）
     *
     * @param notEmployed 未入职（天）
     */
    public void setNotEmployed(Double notEmployed) {
        this.notEmployed = notEmployed;
    }

    /**
     * 获取离职（天）
     *
     * @return leave_office - 离职（天）
     */
    public Double getLeaveOffice() {
        return leaveOffice;
    }

    /**
     * 设置离职（天）
     *
     * @param leaveOffice 离职（天）
     */
    public void setLeaveOffice(Double leaveOffice) {
        this.leaveOffice = leaveOffice;
    }

    /**
     * 获取病假工资（元）
     *
     * @return sick_salary - 病假工资（元）
     */
    public BigDecimal getSickSalary() {
        return sickSalary;
    }

    /**
     * 设置病假工资（元）
     *
     * @param sickSalary 病假工资（元）
     */
    public void setSickSalary(BigDecimal sickSalary) {
        this.sickSalary = sickSalary;
    }

    /**
     * 获取事假工资（元）
     *
     * @return compassionate_salary - 事假工资（元）
     */
    public BigDecimal getCompassionateSalary() {
        return compassionateSalary;
    }

    /**
     * 设置事假工资（元）
     *
     * @param compassionateSalary 事假工资（元）
     */
    public void setCompassionateSalary(BigDecimal compassionateSalary) {
        this.compassionateSalary = compassionateSalary;
    }

    /**
     * 获取未入职工资（元）
     *
     * @return not_emp_salary - 未入职工资（元）
     */
    public BigDecimal getNotEmpSalary() {
        return notEmpSalary;
    }

    /**
     * 设置未入职工资（元）
     *
     * @param notEmpSalary 未入职工资（元）
     */
    public void setNotEmpSalary(BigDecimal notEmpSalary) {
        this.notEmpSalary = notEmpSalary;
    }

    /**
     * 获取离职工资（元）
     *
     * @return leave_office_salary - 离职工资（元）
     */
    public BigDecimal getLeaveOfficeSalary() {
        return leaveOfficeSalary;
    }

    /**
     * 设置离职工资（元）
     *
     * @param leaveOfficeSalary 离职工资（元）
     */
    public void setLeaveOfficeSalary(BigDecimal leaveOfficeSalary) {
        this.leaveOfficeSalary = leaveOfficeSalary;
    }

    /**
     * 获取小计（元）
     *
     * @return subtotal - 小计（元）
     */
    public BigDecimal getSubtotal() {
        return subtotal;
    }

    /**
     * 设置小计（元）
     *
     * @param subtotal 小计（元）
     */
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getCurrDate() {
        return currDate;
    }

    public void setCurrDate(Integer currDate) {
        this.currDate = currDate;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", toCompany=").append(toCompany);
        sb.append(", area=").append(area);
        sb.append(", name=").append(name);
        sb.append(", developmentFlag=").append(developmentFlag);
        sb.append(", baseSalary=").append(baseSalary);
        sb.append(", currMonWeekdays=").append(currMonWeekdays);
        sb.append(", trialSalary=").append(trialSalary);
        sb.append(", regularDate=").append(regularDate);
        sb.append(", currMonTrialday=").append(currMonTrialday);
        sb.append(", regularSalary=").append(regularSalary);
        sb.append(", currMonRegularday=").append(currMonRegularday);
        sb.append(", overtimeOne=").append(overtimeOne);
        sb.append(", overtimeOnemore=").append(overtimeOnemore);
        sb.append(", overtimeTwo=").append(overtimeTwo);
        sb.append(", overtimeThree=").append(overtimeThree);
        sb.append(", overtimeReimburse=").append(overtimeReimburse);
        sb.append(", recruitsNum=").append(recruitsNum);
        sb.append(", hsExtraHours=").append(hsExtraHours);
        sb.append(", hsExtraCost=").append(hsExtraCost);
        sb.append(", otherSend=").append(otherSend);
        sb.append(", attendanceDeduction=").append(attendanceDeduction);
        sb.append(", unionDues=").append(unionDues);
        sb.append(", otherDeductions=").append(otherDeductions);
        sb.append(", wagesPayable=").append(wagesPayable);
        sb.append(", endowmentInsurance=").append(endowmentInsurance);
        sb.append(", medicalInsurance=").append(medicalInsurance);
        sb.append(", unemploymentInsurance=").append(unemploymentInsurance);
        sb.append(", endowmentCompany=").append(endowmentCompany);
        sb.append(", medicalCompany=").append(medicalCompany);
        sb.append(", unemploymentCompany=").append(unemploymentCompany);
        sb.append(", industrialCompany=").append(industrialCompany);
        sb.append(", maternityCompany=").append(maternityCompany);
        sb.append(", seriousCompany=").append(seriousCompany);
        sb.append(", handicapCompany=").append(handicapCompany);
        sb.append(", commfundCompany=").append(commfundCompany);
        sb.append(", fiveOneCompany=").append(fiveOneCompany);
        sb.append(", commfund=").append(commfund);
        sb.append(", socialSecurityCount=").append(socialSecurityCount);
        sb.append(", selfTax=").append(selfTax);
        sb.append(", netSalary=").append(netSalary);
        sb.append(", otherSalary=").append(otherSalary);
        sb.append(", cumulativeAbsence=").append(cumulativeAbsence);
        sb.append(", sickLeave=").append(sickLeave);
        sb.append(", compassionateLeave=").append(compassionateLeave);
        sb.append(", annualLeave=").append(annualLeave);
        sb.append(", compensatoryLeave=").append(compensatoryLeave);
        sb.append(", maternityLeave=").append(maternityLeave);
        sb.append(", marriageHoliday=").append(marriageHoliday);
        sb.append(", notEmployed=").append(notEmployed);
        sb.append(", leaveOffice=").append(leaveOffice);
        sb.append(", sickSalary=").append(sickSalary);
        sb.append(", compassionateSalary=").append(compassionateSalary);
        sb.append(", notEmpSalary=").append(notEmpSalary);
        sb.append(", leaveOfficeSalary=").append(leaveOfficeSalary);
        sb.append(", subtotal=").append(subtotal);
        sb.append("]");
        return sb.toString();
    }
}