package com.edu.commonConfig.bean;

import com.edu.common.bean.BaseEntity;

/**
 *Created by lc on 2015/6/4.
 * 学科实体对象
 */
public class Subject extends BaseEntity {
    /**
     * 主键
     * @mbggenerated
     */
    private Integer ID;

    /**
     * 学科名称
     * @mbggenerated
     */
    private String subjectName;

    /**
     * 学科状态，1启用0不启用
     * @mbggenerated
     */
    private int isEnable;

    /**
     * 创建时间
     * @mbggenerated
     */
    private String created;

    /**
     * 更新时间
     * @mbggenerated
     */
    private String modified;

    /**
     * 年级ID: 如果加年级ID那得存所有年级的语文
     * @mbggenerated
     */
    private Integer gradestageId;

    /**
     * 学段年级对象
     */
    private Gradestage gradestage;

    /**
     * 修改版本
     * @mbggenerated
     */
    private Integer version;

    /**
     * 学科描述
     * @mbggenerated
     */
    private String subjectDesc;

    /**
    
     * @return 
     * @mbggenerated
     */
    public Subject(Integer ID, String subjectName, Integer isEnable, String created, String modified, Integer
            gradestageId, Integer version, String subjectDesc) {
        this.ID = ID;
        this.subjectName = subjectName;
        this.isEnable = isEnable;
        this.created = created;
        this.modified = modified;
        this.gradestageId = gradestageId;
        this.version = version;
        this.subjectDesc = subjectDesc;
    }

    public Subject() {
    }

    @Override
    public String toString() {
        return "Subject{" +
                "ID=" + ID +
                ", subjectName='" + subjectName + '\'' +
                ", isEnable=" + isEnable +
                ", created='" + created + '\'' +
                ", modified='" + modified + '\'' +
                ", gradestageId=" + gradestageId +
                ", gradestage=" + gradestage +
                ", version=" + version +
                ", subjectDesc='" + subjectDesc + '\'' +
                '}';
    }

    /**
     * 主键
     * @return ep_subject_info.ID
     * @mbggenerated
     */
    public Integer getID() {
        return ID;
    }

    /**
     * 学科名称
     * @return ep_subject_info.subjectName
     * @mbggenerated
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * 学科状态，1启用0不启用
     * @return ep_subject_info.isEnable
     * @mbggenerated
     */
    public int getIsEnable() {
        return isEnable;
    }

    /**
     * 创建时间
     * @return ep_subject_info.created
     * @mbggenerated
     */
    public String getCreated() {
        return created;
    }

    /**
     * 更新时间
     * @return ep_subject_info.modified
     * @mbggenerated
     */
    public String getModified() {
        return modified;
    }

    /**
     * 年级ID: 有问题如果加年级ID那得存所有年级的语文
     * @return ep_subject_info.gradestageId
     * @mbggenerated
     */
    public Integer getGradestageId() {
        return gradestageId;
    }

    public Gradestage getGradestage() {
        return gradestage;
    }

    public void setGradestage(Gradestage gradestage) {
        this.gradestage = gradestage;
    }

    /**
     * 修改版本
     * @return ep_subject_info.version
     * @mbggenerated
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 学科描述
     * @return ep_subject_info.subjectDesc
     * @mbggenerated
     */
    public String getSubjectDesc() {
        return subjectDesc;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setIsEnable(int isEnable) {
        this.isEnable = isEnable;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public void setGradestageId(Integer gradestageId) {
        this.gradestageId = gradestageId;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setSubjectDesc(String subjectDesc) {
        this.subjectDesc = subjectDesc;
    }
}