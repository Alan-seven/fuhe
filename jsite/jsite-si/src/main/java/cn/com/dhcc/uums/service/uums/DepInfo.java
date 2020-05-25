/**
 * DepInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.dhcc.uums.service.uums;

public class DepInfo  implements java.io.Serializable {
    private java.lang.String depCode;

    private java.lang.String depLevel;

    private java.lang.String depName;

    private java.lang.String depResp;

    private java.lang.String modifier;

    private java.lang.String note;

    private java.lang.Integer ordernum;

    private java.lang.String orgCode;

    private java.lang.String orgName;

    private java.lang.String pcode;

    private java.lang.String pname;

    private java.lang.String status;

    private java.util.Calendar ts;

    public DepInfo() {
    }

    public DepInfo(
           java.lang.String depCode,
           java.lang.String depLevel,
           java.lang.String depName,
           java.lang.String depResp,
           java.lang.String modifier,
           java.lang.String note,
           java.lang.Integer ordernum,
           java.lang.String orgCode,
           java.lang.String orgName,
           java.lang.String pcode,
           java.lang.String pname,
           java.lang.String status,
           java.util.Calendar ts) {
           this.depCode = depCode;
           this.depLevel = depLevel;
           this.depName = depName;
           this.depResp = depResp;
           this.modifier = modifier;
           this.note = note;
           this.ordernum = ordernum;
           this.orgCode = orgCode;
           this.orgName = orgName;
           this.pcode = pcode;
           this.pname = pname;
           this.status = status;
           this.ts = ts;
    }


    /**
     * Gets the depCode value for this DepInfo.
     * 
     * @return depCode
     */
    public java.lang.String getDepCode() {
        return depCode;
    }


    /**
     * Sets the depCode value for this DepInfo.
     * 
     * @param depCode
     */
    public void setDepCode(java.lang.String depCode) {
        this.depCode = depCode;
    }


    /**
     * Gets the depLevel value for this DepInfo.
     * 
     * @return depLevel
     */
    public java.lang.String getDepLevel() {
        return depLevel;
    }


    /**
     * Sets the depLevel value for this DepInfo.
     * 
     * @param depLevel
     */
    public void setDepLevel(java.lang.String depLevel) {
        this.depLevel = depLevel;
    }


    /**
     * Gets the depName value for this DepInfo.
     * 
     * @return depName
     */
    public java.lang.String getDepName() {
        return depName;
    }


    /**
     * Sets the depName value for this DepInfo.
     * 
     * @param depName
     */
    public void setDepName(java.lang.String depName) {
        this.depName = depName;
    }


    /**
     * Gets the depResp value for this DepInfo.
     * 
     * @return depResp
     */
    public java.lang.String getDepResp() {
        return depResp;
    }


    /**
     * Sets the depResp value for this DepInfo.
     * 
     * @param depResp
     */
    public void setDepResp(java.lang.String depResp) {
        this.depResp = depResp;
    }


    /**
     * Gets the modifier value for this DepInfo.
     * 
     * @return modifier
     */
    public java.lang.String getModifier() {
        return modifier;
    }


    /**
     * Sets the modifier value for this DepInfo.
     * 
     * @param modifier
     */
    public void setModifier(java.lang.String modifier) {
        this.modifier = modifier;
    }


    /**
     * Gets the note value for this DepInfo.
     * 
     * @return note
     */
    public java.lang.String getNote() {
        return note;
    }


    /**
     * Sets the note value for this DepInfo.
     * 
     * @param note
     */
    public void setNote(java.lang.String note) {
        this.note = note;
    }


    /**
     * Gets the ordernum value for this DepInfo.
     * 
     * @return ordernum
     */
    public java.lang.Integer getOrdernum() {
        return ordernum;
    }


    /**
     * Sets the ordernum value for this DepInfo.
     * 
     * @param ordernum
     */
    public void setOrdernum(java.lang.Integer ordernum) {
        this.ordernum = ordernum;
    }


    /**
     * Gets the orgCode value for this DepInfo.
     * 
     * @return orgCode
     */
    public java.lang.String getOrgCode() {
        return orgCode;
    }


    /**
     * Sets the orgCode value for this DepInfo.
     * 
     * @param orgCode
     */
    public void setOrgCode(java.lang.String orgCode) {
        this.orgCode = orgCode;
    }


    /**
     * Gets the orgName value for this DepInfo.
     * 
     * @return orgName
     */
    public java.lang.String getOrgName() {
        return orgName;
    }


    /**
     * Sets the orgName value for this DepInfo.
     * 
     * @param orgName
     */
    public void setOrgName(java.lang.String orgName) {
        this.orgName = orgName;
    }


    /**
     * Gets the pcode value for this DepInfo.
     * 
     * @return pcode
     */
    public java.lang.String getPcode() {
        return pcode;
    }


    /**
     * Sets the pcode value for this DepInfo.
     * 
     * @param pcode
     */
    public void setPcode(java.lang.String pcode) {
        this.pcode = pcode;
    }


    /**
     * Gets the pname value for this DepInfo.
     * 
     * @return pname
     */
    public java.lang.String getPname() {
        return pname;
    }


    /**
     * Sets the pname value for this DepInfo.
     * 
     * @param pname
     */
    public void setPname(java.lang.String pname) {
        this.pname = pname;
    }


    /**
     * Gets the status value for this DepInfo.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this DepInfo.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the ts value for this DepInfo.
     * 
     * @return ts
     */
    public java.util.Calendar getTs() {
        return ts;
    }


    /**
     * Sets the ts value for this DepInfo.
     * 
     * @param ts
     */
    public void setTs(java.util.Calendar ts) {
        this.ts = ts;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DepInfo)) return false;
        DepInfo other = (DepInfo) obj;
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
            ((this.depLevel==null && other.getDepLevel()==null) || 
             (this.depLevel!=null &&
              this.depLevel.equals(other.getDepLevel()))) &&
            ((this.depName==null && other.getDepName()==null) || 
             (this.depName!=null &&
              this.depName.equals(other.getDepName()))) &&
            ((this.depResp==null && other.getDepResp()==null) || 
             (this.depResp!=null &&
              this.depResp.equals(other.getDepResp()))) &&
            ((this.modifier==null && other.getModifier()==null) || 
             (this.modifier!=null &&
              this.modifier.equals(other.getModifier()))) &&
            ((this.note==null && other.getNote()==null) || 
             (this.note!=null &&
              this.note.equals(other.getNote()))) &&
            ((this.ordernum==null && other.getOrdernum()==null) || 
             (this.ordernum!=null &&
              this.ordernum.equals(other.getOrdernum()))) &&
            ((this.orgCode==null && other.getOrgCode()==null) || 
             (this.orgCode!=null &&
              this.orgCode.equals(other.getOrgCode()))) &&
            ((this.orgName==null && other.getOrgName()==null) || 
             (this.orgName!=null &&
              this.orgName.equals(other.getOrgName()))) &&
            ((this.pcode==null && other.getPcode()==null) || 
             (this.pcode!=null &&
              this.pcode.equals(other.getPcode()))) &&
            ((this.pname==null && other.getPname()==null) || 
             (this.pname!=null &&
              this.pname.equals(other.getPname()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.ts==null && other.getTs()==null) || 
             (this.ts!=null &&
              this.ts.equals(other.getTs())));
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
        if (getDepLevel() != null) {
            _hashCode += getDepLevel().hashCode();
        }
        if (getDepName() != null) {
            _hashCode += getDepName().hashCode();
        }
        if (getDepResp() != null) {
            _hashCode += getDepResp().hashCode();
        }
        if (getModifier() != null) {
            _hashCode += getModifier().hashCode();
        }
        if (getNote() != null) {
            _hashCode += getNote().hashCode();
        }
        if (getOrdernum() != null) {
            _hashCode += getOrdernum().hashCode();
        }
        if (getOrgCode() != null) {
            _hashCode += getOrgCode().hashCode();
        }
        if (getOrgName() != null) {
            _hashCode += getOrgName().hashCode();
        }
        if (getPcode() != null) {
            _hashCode += getPcode().hashCode();
        }
        if (getPname() != null) {
            _hashCode += getPname().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getTs() != null) {
            _hashCode += getTs().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DepInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "depInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "depCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "depLevel"));
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
        elemField.setFieldName("depResp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "depResp"));
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
        elemField.setFieldName("ordernum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordernum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("orgName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orgName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
