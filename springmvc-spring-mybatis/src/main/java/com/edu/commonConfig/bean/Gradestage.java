package com.edu.commonConfig.bean;

import com.edu.common.bean.BaseEntity;

import java.util.List;

/**
 * 学段年级实体BEAN
 * Created by lc on 2015/5/26.
 */
public class Gradestage extends BaseEntity {


    private Integer ID;

    /**
     * 名称
     */
    private String gName;
    /**
     * 描述
     */
    private String description;
    /**
     * 是否启用:0不启用，1启用
     */
    private int isEnable;
    /**
     * 父ID,本表嵌套
     */
    private int parentId;

    /**
     * 年级父节点对象
     */
    private Gradestage gradestageParent;

    /**
     * 学段年级子节点集合
     */
    private List<Gradestage> childrenGradestages;

    /**
     * 创建时间
     */
    private String createDate;
    /**
     * 更新时间
     */
    private String updateDate;
    /**
     * 修改版本
     */
    private int version;

    public Gradestage(int pid, String gName) {
        this.ID = pid;
        this.gName = gName;
    }

    @Override
    public String toString() {
        return "Gradestage{" +
                "id=" + ID +
                ", gName='" + gName + '\'' +
                ", description='" + description + '\'' +
                ", isEnable=" + isEnable +
                ", parentId=" + parentId +
                ", createDate='" + createDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", version=" + version +
                '}';
    }

    public Gradestage() {
    }

    public Gradestage(String gName, String description, int isEnable, int parentId, String createDate, String
            updateDate, int version) {
        this.gName = gName;
        this.description = description;
        this.isEnable = isEnable;
        this.parentId = parentId;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.version = version;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public List<Gradestage> getChildrenGradestages() {
        return childrenGradestages;
    }

    public void setChildrenGradestages(List<Gradestage> childrenGradestages) {
        this.childrenGradestages = childrenGradestages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(int isEnable) {
        this.isEnable = isEnable;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Gradestage getGradestageParent() {
        if(gradestageParent == null){
            gradestageParent = new Gradestage(0,"顶级");
        }
        return gradestageParent;
    }

    public void setGradestageParent(Gradestage gradestageParent) {
        this.gradestageParent = gradestageParent;
    }

}
