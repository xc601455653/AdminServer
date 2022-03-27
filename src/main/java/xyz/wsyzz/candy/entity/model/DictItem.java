package xyz.wsyzz.candy.entity.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_dict_item")
public class DictItem implements Serializable {
    @Id
    private String id;

    /**
     * 字典id
     */
    @Column(name = "dict_id")
    private String dictId;

    /**
     * 字典项文本
     */
    @Column(name = "item_text")
    private String itemText;

    /**
     * 字典项值
     */
    @Column(name = "item_value")
    private String itemValue;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序
     */
    @Column(name = "sort_order")
    private Integer sortOrder;

    /**
     * 状态（1启用 0不启用）
     */
    private Integer status;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_id")
    private String createId;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "update_id")
    private String updateId;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取字典id
     *
     * @return dict_id - 字典id
     */
    public String getDictId() {
        return dictId;
    }

    /**
     * 设置字典id
     *
     * @param dictId 字典id
     */
    public void setDictId(String dictId) {
        this.dictId = dictId == null ? null : dictId.trim();
    }

    /**
     * 获取字典项文本
     *
     * @return item_text - 字典项文本
     */
    public String getItemText() {
        return itemText;
    }

    /**
     * 设置字典项文本
     *
     * @param itemText 字典项文本
     */
    public void setItemText(String itemText) {
        this.itemText = itemText == null ? null : itemText.trim();
    }

    /**
     * 获取字典项值
     *
     * @return item_value - 字典项值
     */
    public String getItemValue() {
        return itemValue;
    }

    /**
     * 设置字典项值
     *
     * @param itemValue 字典项值
     */
    public void setItemValue(String itemValue) {
        this.itemValue = itemValue == null ? null : itemValue.trim();
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取排序
     *
     * @return sort_order - 排序
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * 设置排序
     *
     * @param sortOrder 排序
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 获取状态（1启用 0不启用）
     *
     * @return status - 状态（1启用 0不启用）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态（1启用 0不启用）
     *
     * @param status 状态（1启用 0不启用）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return create_id
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * @param createId
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return update_id
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     * @param updateId
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dictId=").append(dictId);
        sb.append(", itemText=").append(itemText);
        sb.append(", itemValue=").append(itemValue);
        sb.append(", description=").append(description);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateId=").append(updateId);
        sb.append("]");
        return sb.toString();
    }
}