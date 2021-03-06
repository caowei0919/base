package com.datacvg.dimp.bean;

import androidx.annotation.Keep;

import com.datacvg.dimp.baseandroid.config.Constants;

import java.io.Serializable;

/**
 * @Author : T-Bag (茶包)
 * @Time : 2020-11-03
 * @Description : 报告实体对象
 */
@Keep
public class ReportBean implements Serializable {

    /**
     * pkid : 908323600084178474662
     * share_id : 908323589177929933184
     * share_clname : 测试字体颜色（共享）-初始状态_副本_副本_副本
     * share_flname : 测试字体颜色（共享）-初始状态_副本_副本_副本
     * share_showtype : share_report
     * share_parentid : 100000000
     * share_rootid : 100000000
     * update_user : 1691179324035185017442
     * update_time : 2020-10-28 14:39:18
     * res_level :
     * level_sort :
     * status : T
     * combination_id :
     * classify : screen
     * sign : s
     * model_id : 960280779015900852953
     * model_clname : 1副本2020-11-03 14:58:50
     * model_flname : 1副本2020-11-03 14:58:50
     * model_type : model_report
     * parent_id : 1953619
     * root_id : 1953619
     */

    private String pkid;
    private String share_id;
    private String share_clname;
    private String share_flname;
    private String share_showtype;
    private String share_parentid;
    private String share_rootid;
    private String update_user;
    private String update_time;
    private String res_level;
    private String level_sort;
    private String status;
    private String combination_id;
    private String classify;
    private String sign;
    private String model_id;
    private String model_clname;
    private String model_flname;
    private String model_type;
    private String parent_id;
    private String root_id;
    private int level = -1;
    private boolean isOpen = false ;
    private String report_type = Constants.REPORT_MINE ;

    public String getReport_type() {
        return report_type;
    }

    public void setReport_type(String report_type) {
        this.report_type = report_type;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getPkid() {
        return pkid;
    }

    public void setPkid(String pkid) {
        this.pkid = pkid;
    }

    public String getShare_id() {
        return share_id;
    }

    public void setShare_id(String share_id) {
        this.share_id = share_id;
    }

    public String getShare_clname() {
        return share_clname;
    }

    public void setShare_clname(String share_clname) {
        this.share_clname = share_clname;
    }

    public String getShare_flname() {
        return share_flname;
    }

    public void setShare_flname(String share_flname) {
        this.share_flname = share_flname;
    }

    public String getShare_showtype() {
        return share_showtype;
    }

    public void setShare_showtype(String share_showtype) {
        this.share_showtype = share_showtype;
    }

    public String getShare_parentid() {
        return share_parentid;
    }

    public void setShare_parentid(String share_parentid) {
        this.share_parentid = share_parentid;
    }

    public String getShare_rootid() {
        return share_rootid;
    }

    public void setShare_rootid(String share_rootid) {
        this.share_rootid = share_rootid;
    }

    public String getUpdate_user() {
        return update_user;
    }

    public void setUpdate_user(String update_user) {
        this.update_user = update_user;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getRes_level() {
        return res_level;
    }

    public void setRes_level(String res_level) {
        this.res_level = res_level;
    }

    public String getLevel_sort() {
        return level_sort;
    }

    public void setLevel_sort(String level_sort) {
        this.level_sort = level_sort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCombination_id() {
        return combination_id;
    }

    public void setCombination_id(String combination_id) {
        this.combination_id = combination_id;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getModel_id() {
        return model_id;
    }

    public void setModel_id(String model_id) {
        this.model_id = model_id;
    }

    public String getModel_clname() {
        return model_clname;
    }

    public void setModel_clname(String model_clname) {
        this.model_clname = model_clname;
    }

    public String getModel_flname() {
        return model_flname;
    }

    public void setModel_flname(String model_flname) {
        this.model_flname = model_flname;
    }

    public String getModel_type() {
        return model_type;
    }

    public void setModel_type(String model_type) {
        this.model_type = model_type;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getRoot_id() {
        return root_id;
    }

    public void setRoot_id(String root_id) {
        this.root_id = root_id;
    }

    public void setLevel(int level) {
        this.level = level ;
    }

    public int getLevel() {
        return level;
    }
}
