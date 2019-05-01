package xyz.wsyzz.candy.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_dictionary")
public class Dictionary implements Serializable {
    /**
     * 主键ID
     */
    @Id
    private Long id;

    /**
     * 表名
     */
    @Column(name = "table_name")
    private String tableName;

    /**
     * 字段名
     */
    @Column(name = "field_name")
    private String fieldName;

    /**
     * 字段值
     */
    @Column(name = "field_value")
    private Integer fieldValue;

    /**
     * 字段标签
     */
    @Column(name = "field_label")
    private String fieldLabel;

    /**
     * 描述
     */
    private String des;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建人
     */
    @Column(name = "create_id")
    private Long createId;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 更新人
     */
    @Column(name = "update_id")
    private Long updateId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取表名
     *
     * @return table_name - 表名
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 设置表名
     *
     * @param tableName 表名
     */
    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    /**
     * 获取字段名
     *
     * @return field_name - 字段名
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * 设置字段名
     *
     * @param fieldName 字段名
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    /**
     * 获取字段值
     *
     * @return field_value - 字段值
     */
    public Integer getFieldValue() {
        return fieldValue;
    }

    /**
     * 设置字段值
     *
     * @param fieldValue 字段值
     */
    public void setFieldValue(Integer fieldValue) {
        this.fieldValue = fieldValue;
    }

    /**
     * 获取字段标签
     *
     * @return field_label - 字段标签
     */
    public String getFieldLabel() {
        return fieldLabel;
    }

    /**
     * 设置字段标签
     *
     * @param fieldLabel 字段标签
     */
    public void setFieldLabel(String fieldLabel) {
        this.fieldLabel = fieldLabel == null ? null : fieldLabel.trim();
    }

    /**
     * 获取描述
     *
     * @return des - 描述
     */
    public String getDes() {
        return des;
    }

    /**
     * 设置描述
     *
     * @param des 描述
     */
    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建人
     *
     * @return create_id - 创建人
     */
    public Long getCreateId() {
        return createId;
    }

    /**
     * 设置创建人
     *
     * @param createId 创建人
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取更新人
     *
     * @return update_id - 更新人
     */
    public Long getUpdateId() {
        return updateId;
    }

    /**
     * 设置更新人
     *
     * @param updateId 更新人
     */
    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tableName=").append(tableName);
        sb.append(", fieldName=").append(fieldName);
        sb.append(", fieldValue=").append(fieldValue);
        sb.append(", fieldLabel=").append(fieldLabel);
        sb.append(", des=").append(des);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateId=").append(updateId);
        sb.append("]");
        return sb.toString();
    }
}