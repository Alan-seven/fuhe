/**
 * DomainInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.dhcc.uums.service.uums;

public class DomainInfo  implements java.io.Serializable {
    private java.lang.String domainCode;

    private java.lang.String domainName;

    private java.lang.Integer domainOrder;

    private java.lang.String domainType;

    private java.lang.String modifier;

    private java.lang.String modifierName;

    private java.lang.String note;

    private java.lang.String status;

    private java.util.Calendar ts;

    public DomainInfo() {
    }

    public DomainInfo(
           java.lang.String domainCode,
           java.lang.String domainName,
           java.lang.Integer domainOrder,
           java.lang.String domainType,
           java.lang.String modifier,
           java.lang.String modifierName,
           java.lang.String note,
           java.lang.String status,
           java.util.Calendar ts) {
           this.domainCode = domainCode;
           this.domainName = domainName;
           this.domainOrder = domainOrder;
           this.domainType = domainType;
           this.modifier = modifier;
           this.modifierName = modifierName;
           this.note = note;
           this.status = status;
           this.ts = ts;
    }


    /**
     * Gets the domainCode value for this DomainInfo.
     * 
     * @return domainCode
     */
    public java.lang.String getDomainCode() {
        return domainCode;
    }


    /**
     * Sets the domainCode value for this DomainInfo.
     * 
     * @param domainCode
     */
    public void setDomainCode(java.lang.String domainCode) {
        this.domainCode = domainCode;
    }


    /**
     * Gets the domainName value for this DomainInfo.
     * 
     * @return domainName
     */
    public java.lang.String getDomainName() {
        return domainName;
    }


    /**
     * Sets the domainName value for this DomainInfo.
     * 
     * @param domainName
     */
    public void setDomainName(java.lang.String domainName) {
        this.domainName = domainName;
    }


    /**
     * Gets the domainOrder value for this DomainInfo.
     * 
     * @return domainOrder
     */
    public java.lang.Integer getDomainOrder() {
        return domainOrder;
    }


    /**
     * Sets the domainOrder value for this DomainInfo.
     * 
     * @param domainOrder
     */
    public void setDomainOrder(java.lang.Integer domainOrder) {
        this.domainOrder = domainOrder;
    }


    /**
     * Gets the domainType value for this DomainInfo.
     * 
     * @return domainType
     */
    public java.lang.String getDomainType() {
        return domainType;
    }


    /**
     * Sets the domainType value for this DomainInfo.
     * 
     * @param domainType
     */
    public void setDomainType(java.lang.String domainType) {
        this.domainType = domainType;
    }


    /**
     * Gets the modifier value for this DomainInfo.
     * 
     * @return modifier
     */
    public java.lang.String getModifier() {
        return modifier;
    }


    /**
     * Sets the modifier value for this DomainInfo.
     * 
     * @param modifier
     */
    public void setModifier(java.lang.String modifier) {
        this.modifier = modifier;
    }


    /**
     * Gets the modifierName value for this DomainInfo.
     * 
     * @return modifierName
     */
    public java.lang.String getModifierName() {
        return modifierName;
    }


    /**
     * Sets the modifierName value for this DomainInfo.
     * 
     * @param modifierName
     */
    public void setModifierName(java.lang.String modifierName) {
        this.modifierName = modifierName;
    }


    /**
     * Gets the note value for this DomainInfo.
     * 
     * @return note
     */
    public java.lang.String getNote() {
        return note;
    }


    /**
     * Sets the note value for this DomainInfo.
     * 
     * @param note
     */
    public void setNote(java.lang.String note) {
        this.note = note;
    }


    /**
     * Gets the status value for this DomainInfo.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this DomainInfo.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the ts value for this DomainInfo.
     * 
     * @return ts
     */
    public java.util.Calendar getTs() {
        return ts;
    }


    /**
     * Sets the ts value for this DomainInfo.
     * 
     * @param ts
     */
    public void setTs(java.util.Calendar ts) {
        this.ts = ts;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DomainInfo)) return false;
        DomainInfo other = (DomainInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.domainCode==null && other.getDomainCode()==null) || 
             (this.domainCode!=null &&
              this.domainCode.equals(other.getDomainCode()))) &&
            ((this.domainName==null && other.getDomainName()==null) || 
             (this.domainName!=null &&
              this.domainName.equals(other.getDomainName()))) &&
            ((this.domainOrder==null && other.getDomainOrder()==null) || 
             (this.domainOrder!=null &&
              this.domainOrder.equals(other.getDomainOrder()))) &&
            ((this.domainType==null && other.getDomainType()==null) || 
             (this.domainType!=null &&
              this.domainType.equals(other.getDomainType()))) &&
            ((this.modifier==null && other.getModifier()==null) || 
             (this.modifier!=null &&
              this.modifier.equals(other.getModifier()))) &&
            ((this.modifierName==null && other.getModifierName()==null) || 
             (this.modifierName!=null &&
              this.modifierName.equals(other.getModifierName()))) &&
            ((this.note==null && other.getNote()==null) || 
             (this.note!=null &&
              this.note.equals(other.getNote()))) &&
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
        if (getDomainCode() != null) {
            _hashCode += getDomainCode().hashCode();
        }
        if (getDomainName() != null) {
            _hashCode += getDomainName().hashCode();
        }
        if (getDomainOrder() != null) {
            _hashCode += getDomainOrder().hashCode();
        }
        if (getDomainType() != null) {
            _hashCode += getDomainType().hashCode();
        }
        if (getModifier() != null) {
            _hashCode += getModifier().hashCode();
        }
        if (getModifierName() != null) {
            _hashCode += getModifierName().hashCode();
        }
        if (getNote() != null) {
            _hashCode += getNote().hashCode();
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
        new org.apache.axis.description.TypeDesc(DomainInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "domainInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domainCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "domainCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domainName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "domainName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domainOrder");
        elemField.setXmlName(new javax.xml.namespace.QName("", "domainOrder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domainType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "domainType"));
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
        elemField.setFieldName("modifierName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modifierName"));
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
