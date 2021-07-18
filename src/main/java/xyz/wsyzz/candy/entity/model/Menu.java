package xyz.wsyzz.candy.entity.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_menu")
public class Menu implements Serializable {
    /**
     * 主键ID
     */
    @Id
    private Long id;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 菜单描述
     */
    @Column(name = "menu_desc")
    private String menuDesc;

    /**
     * 菜单图标样式
     */
    @Column(name = "menu_icon")
    private String menuIcon;

    /**
     * 菜单样式
     */
    @Column(name = "menu_cls")
    private String menuCls;

    /**
     * 路由名称
     */
    @Column(name = "route_name")
    private String routeName;

    /**
     * 父级菜单ID
     */
    private Long pid;

    /**
     * 菜单级别
     */
    @Column(name = "menu_level")
    private Integer menuLevel;

    /**
     * 菜单状态
     */
    private Integer status;

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
     * 获取菜单名称
     *
     * @return menu_name - 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名称
     *
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * 获取菜单描述
     *
     * @return menu_desc - 菜单描述
     */
    public String getMenuDesc() {
        return menuDesc;
    }

    /**
     * 设置菜单描述
     *
     * @param menuDesc 菜单描述
     */
    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc == null ? null : menuDesc.trim();
    }

    /**
     * 获取菜单图标样式
     *
     * @return menu_icon - 菜单图标样式
     */
    public String getMenuIcon() {
        return menuIcon;
    }

    /**
     * 设置菜单图标样式
     *
     * @param menuIcon 菜单图标样式
     */
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    /**
     * 获取菜单样式
     *
     * @return menu_cls - 菜单样式
     */
    public String getMenuCls() {
        return menuCls;
    }

    /**
     * 设置菜单样式
     *
     * @param menuCls 菜单样式
     */
    public void setMenuCls(String menuCls) {
        this.menuCls = menuCls == null ? null : menuCls.trim();
    }

    /**
     * 获取路由名称
     *
     * @return route_name - 路由名称
     */
    public String getRouteName() {
        return routeName;
    }

    /**
     * 设置路由名称
     *
     * @param routeName 路由名称
     */
    public void setRouteName(String routeName) {
        this.routeName = routeName == null ? null : routeName.trim();
    }

    /**
     * 获取父级菜单ID
     *
     * @return pid - 父级菜单ID
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置父级菜单ID
     *
     * @param pid 父级菜单ID
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 获取菜单级别
     *
     * @return menu_level - 菜单级别
     */
    public Integer getMenuLevel() {
        return menuLevel;
    }

    /**
     * 设置菜单级别
     *
     * @param menuLevel 菜单级别
     */
    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    /**
     * 获取菜单状态
     *
     * @return status - 菜单状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置菜单状态
     *
     * @param status 菜单状态
     */
    public void setStatus(Integer status) {
        this.status = status;
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
        sb.append(", menuName=").append(menuName);
        sb.append(", menuDesc=").append(menuDesc);
        sb.append(", menuIcon=").append(menuIcon);
        sb.append(", menuCls=").append(menuCls);
        sb.append(", routeName=").append(routeName);
        sb.append(", pid=").append(pid);
        sb.append(", menuLevel=").append(menuLevel);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateId=").append(updateId);
        sb.append("]");
        return sb.toString();
    }
}