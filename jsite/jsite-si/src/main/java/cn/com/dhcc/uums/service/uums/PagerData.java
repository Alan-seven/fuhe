/**
 * PagerData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.dhcc.uums.service.uums;

public class PagerData  implements java.io.Serializable {
    private java.lang.Object[] datas;

    private cn.com.dhcc.uums.service.uums.Pg pg;

    private int total;

    public PagerData() {
    }

    public PagerData(
           java.lang.Object[] datas,
           cn.com.dhcc.uums.service.uums.Pg pg,
           int total) {
           this.datas = datas;
           this.pg = pg;
           this.total = total;
    }


    /**
     * Gets the datas value for this PagerData.
     * 
     * @return datas
     */
    public java.lang.Object[] getDatas() {
        return datas;
    }


    /**
     * Sets the datas value for this PagerData.
     * 
     * @param datas
     */
    public void setDatas(java.lang.Object[] datas) {
        this.datas = datas;
    }

    public java.lang.Object getDatas(int i) {
        return this.datas[i];
    }

    public void setDatas(int i, java.lang.Object _value) {
        this.datas[i] = _value;
    }


    /**
     * Gets the pg value for this PagerData.
     * 
     * @return pg
     */
    public cn.com.dhcc.uums.service.uums.Pg getPg() {
        return pg;
    }


    /**
     * Sets the pg value for this PagerData.
     * 
     * @param pg
     */
    public void setPg(cn.com.dhcc.uums.service.uums.Pg pg) {
        this.pg = pg;
    }


    /**
     * Gets the total value for this PagerData.
     * 
     * @return total
     */
    public int getTotal() {
        return total;
    }


    /**
     * Sets the total value for this PagerData.
     * 
     * @param total
     */
    public void setTotal(int total) {
        this.total = total;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PagerData)) return false;
        PagerData other = (PagerData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.datas==null && other.getDatas()==null) || 
             (this.datas!=null &&
              java.util.Arrays.equals(this.datas, other.getDatas()))) &&
            ((this.pg==null && other.getPg()==null) || 
             (this.pg!=null &&
              this.pg.equals(other.getPg()))) &&
            this.total == other.getTotal();
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
        if (getDatas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDatas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDatas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPg() != null) {
            _hashCode += getPg().hashCode();
        }
        _hashCode += getTotal();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PagerData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "pagerData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "datas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "pg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("total");
        elemField.setXmlName(new javax.xml.namespace.QName("", "total"));
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
