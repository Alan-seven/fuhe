/**
 * GetJobInfoPageList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.dhcc.uums.service.uums;

public class GetJobInfoPageList  implements java.io.Serializable {
    private cn.com.dhcc.uums.service.uums.SearchProperty[] arg0;

    private cn.com.dhcc.uums.service.uums.OrderProperty[] arg1;

    private int arg2;

    private int arg3;

    public GetJobInfoPageList() {
    }

    public GetJobInfoPageList(
           cn.com.dhcc.uums.service.uums.SearchProperty[] arg0,
           cn.com.dhcc.uums.service.uums.OrderProperty[] arg1,
           int arg2,
           int arg3) {
           this.arg0 = arg0;
           this.arg1 = arg1;
           this.arg2 = arg2;
           this.arg3 = arg3;
    }


    /**
     * Gets the arg0 value for this GetJobInfoPageList.
     * 
     * @return arg0
     */
    public cn.com.dhcc.uums.service.uums.SearchProperty[] getArg0() {
        return arg0;
    }


    /**
     * Sets the arg0 value for this GetJobInfoPageList.
     * 
     * @param arg0
     */
    public void setArg0(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0) {
        this.arg0 = arg0;
    }

    public cn.com.dhcc.uums.service.uums.SearchProperty getArg0(int i) {
        return this.arg0[i];
    }

    public void setArg0(int i, cn.com.dhcc.uums.service.uums.SearchProperty _value) {
        this.arg0[i] = _value;
    }


    /**
     * Gets the arg1 value for this GetJobInfoPageList.
     * 
     * @return arg1
     */
    public cn.com.dhcc.uums.service.uums.OrderProperty[] getArg1() {
        return arg1;
    }


    /**
     * Sets the arg1 value for this GetJobInfoPageList.
     * 
     * @param arg1
     */
    public void setArg1(cn.com.dhcc.uums.service.uums.OrderProperty[] arg1) {
        this.arg1 = arg1;
    }

    public cn.com.dhcc.uums.service.uums.OrderProperty getArg1(int i) {
        return this.arg1[i];
    }

    public void setArg1(int i, cn.com.dhcc.uums.service.uums.OrderProperty _value) {
        this.arg1[i] = _value;
    }


    /**
     * Gets the arg2 value for this GetJobInfoPageList.
     * 
     * @return arg2
     */
    public int getArg2() {
        return arg2;
    }


    /**
     * Sets the arg2 value for this GetJobInfoPageList.
     * 
     * @param arg2
     */
    public void setArg2(int arg2) {
        this.arg2 = arg2;
    }


    /**
     * Gets the arg3 value for this GetJobInfoPageList.
     * 
     * @return arg3
     */
    public int getArg3() {
        return arg3;
    }


    /**
     * Sets the arg3 value for this GetJobInfoPageList.
     * 
     * @param arg3
     */
    public void setArg3(int arg3) {
        this.arg3 = arg3;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetJobInfoPageList)) return false;
        GetJobInfoPageList other = (GetJobInfoPageList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arg0==null && other.getArg0()==null) || 
             (this.arg0!=null &&
              java.util.Arrays.equals(this.arg0, other.getArg0()))) &&
            ((this.arg1==null && other.getArg1()==null) || 
             (this.arg1!=null &&
              java.util.Arrays.equals(this.arg1, other.getArg1()))) &&
            this.arg2 == other.getArg2() &&
            this.arg3 == other.getArg3();
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
        if (getArg0() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArg0());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArg0(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getArg1() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArg1());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArg1(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getArg2();
        _hashCode += getArg3();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetJobInfoPageList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobInfoPageList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arg0");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arg0"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "searchProperty"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arg1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arg1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orderProperty"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arg2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arg2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arg3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arg3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
