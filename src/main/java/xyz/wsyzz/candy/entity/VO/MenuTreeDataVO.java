package xyz.wsyzz.candy.entity.VO;

import lombok.Data;

import java.util.List;

/**
 * Created by xucan on 2022/3/28.
 */
public class MenuTreeDataVO {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单描述
     */
    private String menuDesc;

    /**
     * 菜单图标样式
     */
    private String menuIcon;

    /**
     * 菜单样式
     */
    private String menuCls;

    /**
     * 路由名称
     */
    private String routeName;

    /**
     * 父级菜单ID
     */
    private Long pid;

    /**
     * 菜单级别
     */
    private Integer menuLevel;

    /**
     * 子节点
     */
    private List<MenuTreeDataVO> children;

    public static Long getParamId(MenuTreeDataVO vo) {
        return vo.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuCls() {
        return menuCls;
    }

    public void setMenuCls(String menuCls) {
        this.menuCls = menuCls;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public static Long getParamPid(MenuTreeDataVO vo) {
        return vo.pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public List<MenuTreeDataVO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTreeDataVO> children) {
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public Long getPid() {
        return pid;
    }

    @Override
    public String toString() {
        return "MenuTreeDataVO{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", menuDesc='" + menuDesc + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuCls='" + menuCls + '\'' +
                ", routeName='" + routeName + '\'' +
                ", pid=" + pid +
                ", menuLevel=" + menuLevel +
                ", children=" + children +
                '}';
    }
}
