package com.fs.general.common.general;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;

public class GeneralObject implements Cloneable, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 6774198837306294678L;

    private static final Logger LOGGER = Logger.getLogger(GeneralObject.class);
    
    public Date createDate;
    
    public Long createUserId;
    
    public Date updateDate;
    
    public Long updateUserId;
    
    public Long isValid;
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Long getCreateUserId() {
        return createUserId;
    }
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }
    public Date getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public Long getUpdateUserId() {
        return updateUserId;
    }
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }
    public Long getIsValid() {
        return isValid;
    }
    public void setIsValid(Long isValid) {
        this.isValid = isValid;
    }
}
