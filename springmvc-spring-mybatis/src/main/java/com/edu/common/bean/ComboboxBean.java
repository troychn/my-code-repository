package com.edu.common.bean;

/**
 * Created by lc on 2015/6/7.
 * 用于前台显示combobox显示的bean
 */
public class ComboboxBean {
    /**
     * 选择项值
     */
    private Integer id;

    /**
     * 选择项显示的值
     */
    private String name;

    /**
     * 选择项是否选中
     */
    private boolean selected;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", selected=" + selected +
                '}';
    }

    public ComboboxBean(Integer id, String name, boolean selected) {
        this.id = id;
        this.name = name;
        this.selected = selected;
    }

    public ComboboxBean(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ComboboxBean() {
    }
}
