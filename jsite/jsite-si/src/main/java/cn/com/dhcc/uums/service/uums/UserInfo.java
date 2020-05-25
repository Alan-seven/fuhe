/**
 * UserInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.dhcc.uums.service.uums;

public class UserInfo  implements java.io.Serializable {
    private java.lang.String depCode;

    private java.lang.String depName;

    private java.lang.String id;

    private int isValidUser;

    private java.lang.String jurdAreaType;

    private java.lang.String modifier;

    private java.lang.String note;

    private java.lang.String orgCode;

    private java.lang.String orgJurd;

    private java.lang.String orgName;

    private java.lang.String persId;

    private java.lang.String persName;

    private cn.com.dhcc.uums.service.uums.RoleInfo[] roleInfoList;

    private java.lang.String status;

    private java.util.Calendar ts;

    private java.lang.String userCode;

    private java.lang.String userName;

    private java.lang.String userPassword;

    private java.lang.String userType;

    public UserInfo() {
    }

    public UserInfo(
           java.lang.String depCode,
           java.lang.String depName,
           java.lang.String id,
           int isValidUser,
           java.lang.String jurdAreaType,
           java.lang.String modifier,
           java.lang.String note,
           java.lang.String orgCode,
           java.lang.String orgJurd,
           java.lang.String orgName,
           java.lang.String persId,
           java.lang.String persName,
           cn.com.dhcc.uums.service.uums.RoleInfo[] roleInfoList,
           java.lang.String status,
           java.util.Calendar ts,
           java.lang.String userCode,
           java.lang.String userName,
           java.lang.String userPassword,
           java.lang.String userType) {
           this.depCode = depCode;
           this.depName = depName;
           this.id = id;
           this.isValidUser = isValidUser;
           this.jurdAreaType = jurdAreaType;
           this.modifier = modifier;
           this.note = note;
           this.orgCode = orgCode;
           this.orgJurd = orgJurd;
           this.orgName = orgName;
           this.persId = persId;
           this.persName = persName;
           this.roleInfoList = roleInfoList;
           this.status = status;
           this.ts = ts;
           this.userCode = userCode;
           this.userName = userName;
           this.userPassword = userPassword;
           this.userType = userType;
    }


    /**
     * Gets the depCode value for this UserInfo.
     * 
     * @return depCode
     */
    public java.lang.String getDepCode() {
        return depCode;
    }


    /**
     * Sets the depCode value for this UserInfo.
     * 
     * @param depCode
     */
    public void setDepCode(java.lang.String depCode) {
        this.depCode = depCode;
    }


    /**
     * Gets the depName value for this UserInfo.
     * 
     * @return depName
     */
    public java.lang.String getDepName() {
        return depName;
    }


    /**
     * Sets the depName value for this UserInfo.
     * 
     * @param depName
     */
    public void setDepName(java.lang.String depName) {
        this.depName = depName;
    }


    /**
     * Gets the id value for this UserInfo.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this UserInfo.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the isValidUser value for this UserInfo.
     * 
     * @return isValidUser
     */
    public int getIsValidUser() {
        return isValidUser;
    }


    /**
     * Sets the isValidUser value for this UserInfo.
     * 
     * @param isValidUser
     */
    public void setIsValidUser(int isValidUser) {
        this.isValidUser = isValidUser;
    }


    /**
     * Gets the jurdAreaType value for this UserInfo.
     * 
     * @return jurdAreaType
     */
    public java.lang.String getJurdAreaType() {
        return jurdAreaType;
    }


    /**
     * Sets the jurdAreaType value for this UserInfo.
     * 
     * @param jurdAreaType
     */
    public void setJurdAreaType(java.lang.String jurdAreaType) {
        this.jurdAreaType = jurdAreaType;
    }


    /**
     * Gets the modifier value for this UserInfo.
     * 
     * @return modifier
     */
    public java.lang.String getModifier() {
        return modifier;
    }


    /**
     * Sets the modifier value for this UserInfo.
     * 
     * @param modifier
     */
    public void setModifier(java.lang.String modifier) {
        this.modifier = modifier;
    }


    /**
     * Gets the note value for this UserInfo.
     * 
     * @return note
     */
    public java.lang.String getNote() {
        return note;
    }


    /**
     * Sets the note value for this UserInfo.
     * 
     * @param note
     */
    public void setNote(java.lang.String note) {
        this.note = note;
    }


    /**
     * Gets the orgCode value for this UserInfo.
     * 
     * @return orgCode
     */
    public java.lang.String getOrgCode() {
        return orgCode;
    }


    /**
     * Sets the orgCode value for this UserInfo.
     * 
     * @param orgCode
     */
    public void setOrgCode(java.lang.String orgCode) {
        this.orgCode = orgCode;
    }


    /**
     * Gets the orgJurd value for this UserInfo.
     * 
     * @return orgJurd
     */
    public java.lang.String getOrgJurd() {
        return orgJurd;
    }


    /**
     * Sets the orgJurd value for this UserInfo.
     * 
     * @param orgJurd
     */
    public void setOrgJurd(java.lang.String orgJurd) {
        this.orgJurd = orgJurd;
    }


    /**
     * Gets the orgName value for this UserInfo.
     * 
     * @return orgName
     */
    public java.lang.String getOrgName() {
        return orgName;
    }


    /**
     * Sets the orgName value for this UserInfo.
     * 
     * @param orgName
     */
    public void setOrgName(java.lang.String orgName) {
        this.orgName = orgName;
    }


    /**
     * Gets the persId value for this UserInfo.
     * 
     * @return persId
     */
    public java.lang.String getPersId() {
        return persId;
    }


    /**
     * Sets the persId value for this UserInfo.
     * 
     * @param persId
     */
    public void setPersId(java.lang.String persId) {
        this.persId = persId;
    }


    /**
     * Gets the persName value for this UserInfo.
     * 
     * @return persName
     */
    public java.lang.String getPersName() {
        return persName;
    }


    /**
     * Sets the persName value for this UserInfo.
     * 
     * @param persName
     */
    public void setPersName(java.lang.String persName) {
        this.persName = persName;
    }


    /**
     * Gets the roleInfoList value for this UserInfo.
     * 
     * @return roleInfoList
     */
    public cn.com.dhcc.uums.service.uums.RoleInfo[] getRoleInfoList() {
        return roleInfoList;
    }


    /**
     * Sets the roleInfoList value for this UserInfo.
     * 
     * @param roleInfoList
     */
    public void setRoleInfoList(cn.com.dhcc.uums.service.uums.RoleInfo[] roleInfoList) {
        this.roleInfoList = roleInfoList;
    }

    public cn.com.dhcc.uums.service.uums.RoleInfo getRoleInfoList(int i) {
        return this.roleInfoList[i];
    }

    public void setRoleInfoList(int i, cn.com.dhcc.uums.service.uums.RoleInfo _value) {
        this.roleInfoList[i] = _value;
    }


    /**
     * Gets the status value for this UserInfo.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this UserInfo.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the ts value for this UserInfo.
     * 
     * @return ts
     */
    public java.util.Calendar getTs() {
        return ts;
    }


    /**
     * Sets the ts value for this UserInfo.
     * 
     * @param ts
     */
    public void setTs(java.util.Calendar ts) {
        this.ts = ts;
    }


    /**
     * Gets the userCode value for this UserInfo.
     * 
     * @return userCode
     */
    public java.lang.String getUserCode() {
        return userCode;
    }


    /**
     * Sets the userCode value for this UserInfo.
     * 
     * @param userCode
     */
    public void setUserCode(java.lang.String userCode) {
        this.userCode = userCode;
    }


    /**
     * Gets the userName value for this UserInfo.
     * 
     * @return userName
     */
    public java.lang.String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this UserInfo.
     * 
     * @param userName
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }


    /**
     * Gets the userPassword value for this UserInfo.
     * 
     * @return userPassword
     */
    public java.lang.String getUserPassword() {
        return userPassword;
    }


    /**
     * Sets the userPassword value for this UserInfo.
     * 
     * @param userPassword
     */
    public void setUserPassword(java.lang.String userPassword) {
        this.userPassword = userPassword;
    }


    /**
     * Gets the userType value for this UserInfo.
     * 
     * @return userType
     */
    public java.lang.String getUserType() {
        return userType;
    }


    /**
     * Sets the userType value for this UserInfo.
     * 
     * @param userType
     */
    public void setUserType(java.lang.String userType) {
        this.userType = userType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserInfo)) return false;
        UserInfo other = (UserInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.depCode==null && other.getDepCode()==null) || 
             (this.depCode!=null &&
              this.depCode.equals(other.getDepCode()))) &&
            ((this.depName==null && other.getDepName()==null) || 
             (this.depName!=null &&
              this.depName.equals(other.getDepName()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            this.isValidUser == other.getIsValidUser() &&
            ((this.jurdAreaType==null && other.getJurdAreaType()==null) || 
             (this.jurdAreaType!=null &&
              this.jurdAreaType.equals(other.getJurdAreaType()))) &&
            ((this.modifier==null && other.getModifier()==null) || 
             (this.modifier!=null &&
              this.modifier.equals(other.getModifier()))) &&
            ((this.note==null && other.getNote()==null) || 
             (this.note!=null &&
              this.note.equals(other.getNote()))) &&
            ((this.orgCode==null && other.getOrgCode()==null) || 
             (this.orgCode!=null &&
              this.orgCode.equals(other.getOrgCode()))) &&
            ((this.orgJurd==null && other.getOrgJurd()==null) || 
             (this.orgJurd!=null &&
              this.orgJurd.equals(other.getOrgJurd()))) &&
            ((this.orgName==null && other.getOrgName()==null) || 
             (this.orgName!=null &&
              this.orgName.equals(other.getOrgName()))) &&
            ((this.persId==null && other.getPersId()==null) || 
             (this.persId!=null &&
              this.persId.equals(other.getPersId()))) &&
            ((this.persName==null && other.getPersName()==null) || 
             (this.persName!=null &&
              this.persName.equals(other.getPersName()))) &&
            ((this.roleInfoList==null && other.getRoleInfoList()==null) || 
             (this.roleInfoList!=null &&
              java.util.Arrays.equals(this.roleInfoList, other.getRoleInfoList()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.ts==null && other.getTs()==null) || 
             (this.ts!=null &&
              this.ts.equals(other.getTs()))) &&
            ((this.userCode==null && other.getUserCode()==null) || 
             (this.userCode!=null &&
              this.userCode.equals(other.getUserCode()))) &&
            ((this.userName==null && other.getUserName()==null) || 
             (this.userName!=null &&
              this.userName.equals(other.getUserName()))) &&
            ((this.userPassword==null && other.getUserPassword()==null) || 
             (this.userPassword!=null &&
              this.userPassword.equals(other.getUserPassword()))) &&
            ((this.userType==null && other.getUserType()==null) || 
             (this.userType!=null &&
              this.userType.equals(other.getUserType())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDepCode() != null) {
            _hashCode += getDepCode().hashCode();
        }
        if (getDepName() != null) {
            _hashCode += getDepName().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        _hashCode += getIsValidUser();
        if (getJurdAreaType() != null) {
            _hashCode += getJurdAreaType().hashCode();
        }
        if (getModifier() != null) {
            _hashCode += getModifier().hashCode();
        }
        if (getNote() != null) {
            _hashCode += getNote().hashCode();
        }
        if (getOrgCode() != null) {
            _hashCode += getOrgCode().hashCode();
        }
        if (getOrgJurd() != null) {
            _hashCode += getOrgJurd().hashCode();
        }
        if (getOrgName() != null) {
            _hashCode += getOrgName().hashCode();
        }
        if (getPersId() != null) {
            _hashCode += getPersId().hashCode();
        }
        if (getPersName() != null) {
            _hashCode += getPersName().hashCode();
        }
        if (getRoleInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRoleInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRoleInfoList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getTs() != null) {
            _hashCode += getTs().hashCode();
        }
        if (getUserCode() != null) {
            _hashCode += getUserCode().hashCode();
        }
        if (getUserName() != null) {
            _hashCode += getUserName().hashCode();
        }
        if (getUserPassword() != null) {
            _hashCode += getUserPassword().hashCode();
        }
        if (getUserType() != null) {
            _hashCode += getUserType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "depCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "depName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isValidUser");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isValidUser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jurdAreaType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jurdAreaType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modifier");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("note");
        elemField.setXmlName(new javax.xml.namespace.QName("", "note"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orgCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgJurd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orgJurd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orgName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("persId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "persId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("persName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "persName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roleInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "roleInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userPassword");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userPassword"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
