package com.edu.commonConfig.bean;

import com.edu.common.bean.BaseEntity;

/**
 * Created by lc on 2015/6/4.
 * 知识点实体对象
 */
public class KnowlegePoint extends BaseEntity {
    /**
     * 主键
     * @mbggenerated
     */
    private Integer ID;

    /**
     * 知识点名称
     * @mbggenerated
     */
    private String knowledgeName;

    /**
     * 知识点所属学段
     * @mbggenerated
     */
    private Integer knowledgeStage;

    /**
     * 知识点所属学科
     * @mbggenerated
     */
    private Integer knowledgeSubject;

    /**
     * 知识点所属年级
     * @mbggenerated
     */
    private Integer knowledgeGrade;

    /**
     * 状态：0为关闭，1为开启
     * @mbggenerated
     */
    private int isEnable;

    /**
     * 知识点所属章节
     * @mbggenerated
     */
    private Integer knowledgeChapter;

    /**
     * 创建时间
     * @mbggenerated
     */
    private String createDate;

    /**
     * 更新时间
     * @mbggenerated
     */
    private String updateDate;

    /**
     * 是否删除：0没有被删除，1已经删除
     * @mbggenerated
     */
    private Integer isDelete;

    /**
     * 修改版本
     * @mbggenerated
     */
    private Integer version;

    /**
     * 知识点描述
     * @mbggenerated
     */
    private String knowledgeDesc;

    
    /**
     * 试题数量
     * @mbggenerated
     */
    private  String questionsCount;
    
    public String getQuestionsCount() {
		return questionsCount;
	}

	public void setQuestionsCount(String questionsCount) {
		this.questionsCount = questionsCount;
	}
    
    /**
    
     * @return 
     * @mbggenerated
     */
    public KnowlegePoint(Integer ID, String knowledgeName, Integer knowledgeStage, Integer knowledgeSubject, Integer
            knowledgeGrade, Integer isEnable, Integer knowledgeChapter, String createDate, String updateDate, Integer
            isDelete, Integer version, String knowledgeDesc) {
        this.ID = ID;
        this.knowledgeName = knowledgeName;
        this.knowledgeStage = knowledgeStage;
        this.knowledgeSubject = knowledgeSubject;
        this.knowledgeGrade = knowledgeGrade;
        this.isEnable = isEnable;
        this.knowledgeChapter = knowledgeChapter;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.isDelete = isDelete;
        this.version = version;
        this.knowledgeDesc = knowledgeDesc;
    }

    public KnowlegePoint() {
    }

    /**
     * 主键
     * @return ep_knowledgepoints_info.ID
     * @mbggenerated
     */
    public Integer getID() {
        return ID;
    }

    /**
     * 知识点名称
     * @return ep_knowledgepoints_info.knowledgeName
     * @mbggenerated
     */
    public String getKnowledgeName() {
        return knowledgeName;
    }

    /**
     * 知识点所属学段
     * @return ep_knowledgepoints_info.knowledgeStage
     * @mbggenerated
     */
    public Integer getKnowledgeStage() {
        return knowledgeStage;
    }

    /**
     * 知识点所属学科
     * @return ep_knowledgepoints_info.knowledgeSubject
     * @mbggenerated
     */
    public Integer getKnowledgeSubject() {
        return knowledgeSubject;
    }

    /**
     * 知识点所属年级
     * @return ep_knowledgepoints_info.knowledgeGrade
     * @mbggenerated
     */
    public Integer getKnowledgeGrade() {
        return knowledgeGrade;
    }

    /**
     * 状态：0为关闭，1为开启
     * @return ep_knowledgepoints_info.isEnable
     * @mbggenerated
     */
    public int getIsEnable() {
        return isEnable;
    }

    /**
     * 知识点所属章节
     * @return ep_knowledgepoints_info.knowledgeChapter
     * @mbggenerated
     */
    public Integer getKnowledgeChapter() {
        return knowledgeChapter;
    }

    /**
     * 创建时间
     * @return ep_knowledgepoints_info.createDate
     * @mbggenerated
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * 更新时间
     * @return ep_knowledgepoints_info.updateDate
     * @mbggenerated
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * 是否删除：0没有被删除，1已经删除
     * @return ep_knowledgepoints_info.isDelete
     * @mbggenerated
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 修改版本
     * @return ep_knowledgepoints_info.version
     * @mbggenerated
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 知识点描述
     * @return ep_knowledgepoints_info.knowledgeDesc
     * @mbggenerated
     */
    public String getKnowledgeDesc() {
        return knowledgeDesc;
    }

    @Override
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setKnowledgeName(String knowledgeName) {
        this.knowledgeName = knowledgeName;
    }

    public void setKnowledgeStage(Integer knowledgeStage) {
        this.knowledgeStage = knowledgeStage;
    }

    public void setKnowledgeSubject(Integer knowledgeSubject) {
        this.knowledgeSubject = knowledgeSubject;
    }

    public void setKnowledgeGrade(Integer knowledgeGrade) {
        this.knowledgeGrade = knowledgeGrade;
    }

    public void setIsEnable(int isEnable) {
        this.isEnable = isEnable;
    }

    public void setKnowledgeChapter(Integer knowledgeChapter) {
        this.knowledgeChapter = knowledgeChapter;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setKnowledgeDesc(String knowledgeDesc) {
        this.knowledgeDesc = knowledgeDesc;
    }

    @Override
    public String toString() {
        return "KnowlegePoints{" +
                "ID=" + ID +
                ", knowledgeName='" + knowledgeName + '\'' +
                ", knowledgeStage=" + knowledgeStage +
                ", knowledgeSubject=" + knowledgeSubject +
                ", knowledgeGrade=" + knowledgeGrade +
                ", isEnable=" + isEnable +
                ", knowledgeChapter=" + knowledgeChapter +
                ", createDate='" + createDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", isDelete=" + isDelete +
                ", version=" + version +
                ", knowledgeDesc='" + knowledgeDesc + '\'' +
                '}';
    }
}