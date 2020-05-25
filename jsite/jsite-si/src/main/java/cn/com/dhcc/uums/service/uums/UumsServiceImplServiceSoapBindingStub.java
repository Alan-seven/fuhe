/**
 * UumsServiceImplServiceSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.dhcc.uums.service.uums;

public class UumsServiceImplServiceSoapBindingStub extends org.apache.axis.client.Stub implements cn.com.dhcc.uums.service.uums.UumsService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[88];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
        _initOperationDesc5();
        _initOperationDesc6();
        _initOperationDesc7();
        _initOperationDesc8();
        _initOperationDesc9();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateUserInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo"), cn.com.dhcc.uums.service.uums.UserInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"),
                      "cn.com.dhcc.uums.service.uums.NiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDepInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "depInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.DepInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getJobInfoPageList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "searchProperty"), cn.com.dhcc.uums.service.uums.SearchProperty[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orderProperty"), cn.com.dhcc.uums.service.uums.OrderProperty[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg3"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "pagerData"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.PagerData.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateRoleInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo"), cn.com.dhcc.uums.service.uums.RoleInfo[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("insertJobInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "jobInfo"), cn.com.dhcc.uums.service.uums.JobInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"),
                      "cn.com.dhcc.uums.service.uums.NiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRoleInfoListByScode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.RoleInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPersInfoListByTs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "persInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.PersInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getOrgInfoListByTs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orgInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.OrgInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateJobInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "jobInfo"), cn.com.dhcc.uums.service.uums.JobInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"),
                      "cn.com.dhcc.uums.service.uums.NiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDomainInfoListByTs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "domainInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.DomainInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDepInfoByUnit");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "depInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.DepInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("isUamsValidUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.UserInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updatePersInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "persInfo"), cn.com.dhcc.uums.service.uums.PersInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"),
                      "cn.com.dhcc.uums.service.uums.NiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserRoleByUserSys");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "relUserRole"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.RelUserRole[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("insertDepInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "depInfo"), cn.com.dhcc.uums.service.uums.DepInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"),
                      "cn.com.dhcc.uums.service.uums.NiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"), 
                      true
                     ));
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserInfoByRole");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.UserInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("insertPersInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "persInfo"), cn.com.dhcc.uums.service.uums.PersInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"),
                      "cn.com.dhcc.uums.service.uums.NiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPersInfoList");
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "persInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.PersInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteRoleInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo"), cn.com.dhcc.uums.service.uums.RoleInfo[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getJobInfoByOrg");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "jobInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.JobInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteDepInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "depInfo"), cn.com.dhcc.uums.service.uums.DepInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"),
                      "cn.com.dhcc.uums.service.uums.NiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"), 
                      true
                     ));
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserInfoListByIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.UserInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserAdminSysInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "sysInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.SysInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserJobInfoList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "jobInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.JobInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("insertOrgInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orgInfo"), cn.com.dhcc.uums.service.uums.OrgInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("changeUserPassword");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getJobInfoListByTs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "jobInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.JobInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSysInfoPageList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "searchProperty"), cn.com.dhcc.uums.service.uums.SearchProperty[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orderProperty"), cn.com.dhcc.uums.service.uums.OrderProperty[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg3"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "pagerData"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.PagerData.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getJobRoleInfoList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.RoleInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getJobInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "jobInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.JobInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getOrgInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orgInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.OrgInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDepInfoList");
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "depInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.DepInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPersInfoPageList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "searchProperty"), cn.com.dhcc.uums.service.uums.SearchProperty[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orderProperty"), cn.com.dhcc.uums.service.uums.OrderProperty[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg3"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "pagerData"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.PagerData.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserInfoPageListWithStr");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "searchStrProperty"), cn.com.dhcc.uums.service.uums.SearchStrProperty[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orderProperty"), cn.com.dhcc.uums.service.uums.OrderProperty[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg3"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "pagerData"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.PagerData.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPersInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "persInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.PersInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteRoleInfoBySys");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[35] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDepInfoPageList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "searchProperty"), cn.com.dhcc.uums.service.uums.SearchProperty[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orderProperty"), cn.com.dhcc.uums.service.uums.OrderProperty[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg3"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "pagerData"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.PagerData.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[36] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSubDepInfoList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "depInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.DepInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[37] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addUserRole");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo"), cn.com.dhcc.uums.service.uums.RoleInfo[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg3"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[38] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRoleInfoPageList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "searchProperty"), cn.com.dhcc.uums.service.uums.SearchProperty[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orderProperty"), cn.com.dhcc.uums.service.uums.OrderProperty[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg3"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "pagerData"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.PagerData.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[39] = oper;

    }

    private static void _initOperationDesc5(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRoleInfoByUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.RoleInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[40] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("isUamsValidIdNo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.UserInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[41] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSysInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "sysInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.SysInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[42] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserInfoByOrg");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.UserInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[43] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRoleInfoList");
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.RoleInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[44] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserListByProperty");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.UserInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[45] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserInfoList");
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.UserInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[46] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserInfoListByTs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.UserInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[47] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSysInfoList");
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "sysInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.SysInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[48] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPersInfoLikePersName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "persInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.PersInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[49] = oper;

    }

    private static void _initOperationDesc6(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserInfoByJob");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.UserInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[50] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDepInfoListByTs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "depInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.DepInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[51] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getOrgPersInfoListByPerscode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "persInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.PersInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[52] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSysInfoListByTs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "sysInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.SysInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[53] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getReduceUserRole");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "relUserRole"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.RelUserRole[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[54] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("insertUserInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo"), cn.com.dhcc.uums.service.uums.UserInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"),
                      "cn.com.dhcc.uums.service.uums.NiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"), 
                      true
                     ));
        _operations[55] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getpOrgInfoByOrgCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orgInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.OrgInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[56] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deletePersInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "persInfo"), cn.com.dhcc.uums.service.uums.PersInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"),
                      "cn.com.dhcc.uums.service.uums.NiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"), 
                      true
                     ));
        _operations[57] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDomainInfoList");
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "domainInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.DomainInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[58] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteUserInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo"), cn.com.dhcc.uums.service.uums.UserInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"),
                      "cn.com.dhcc.uums.service.uums.NiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"), 
                      true
                     ));
        _operations[59] = oper;

    }

    private static void _initOperationDesc7(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getOrgInfoList");
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orgInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.OrgInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[60] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserInfoByOrgInRoles");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo"), cn.com.dhcc.uums.service.uums.RoleInfo[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.UserInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"),
                      "cn.com.dhcc.uums.service.uums.NiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"), 
                      true
                     ));
        _operations[61] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDomainInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "domainInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.DomainInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[62] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserInfoPageList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "searchProperty"), cn.com.dhcc.uums.service.uums.SearchProperty[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orderProperty"), cn.com.dhcc.uums.service.uums.OrderProperty[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg3"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "pagerData"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.PagerData.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[63] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteOrgInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orgInfo"), cn.com.dhcc.uums.service.uums.OrgInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"),
                      "cn.com.dhcc.uums.service.uums.NiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"), 
                      true
                     ));
        _operations[64] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRoleInfoListByTs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.RoleInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[65] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPersListByProperty");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "persInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.PersInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[66] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserInfoByOrgAndSubOrg");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.UserInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[67] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSysInfoByDomain");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "sysInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.SysInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[68] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSubOrgInfoList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orgInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.OrgInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[69] = oper;

    }

    private static void _initOperationDesc8(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateOrgInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orgInfo"), cn.com.dhcc.uums.service.uums.OrgInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"),
                      "cn.com.dhcc.uums.service.uums.NiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"), 
                      true
                     ));
        _operations[70] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRoleInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.RoleInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[71] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteJobInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "jobInfo"), cn.com.dhcc.uums.service.uums.JobInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"),
                      "cn.com.dhcc.uums.service.uums.NiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"), 
                      true
                     ));
        _operations[72] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDomainInfoPageList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "searchProperty"), cn.com.dhcc.uums.service.uums.SearchProperty[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orderProperty"), cn.com.dhcc.uums.service.uums.OrderProperty[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg3"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "pagerData"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.PagerData.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[73] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("pushRoleInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo"), cn.com.dhcc.uums.service.uums.RoleInfo[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[74] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getJobInfoList");
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "jobInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.JobInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[75] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPersInfoListByOrgCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "persInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.PersInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[76] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRelUserRole");
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "relUserRole"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.RelUserRole[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[77] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUsersByAdcdInRoles");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo"), cn.com.dhcc.uums.service.uums.RoleInfo[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.UserInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[78] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateDepInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "depInfo"), cn.com.dhcc.uums.service.uums.DepInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(java.lang.Integer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"),
                      "cn.com.dhcc.uums.service.uums.NiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"), 
                      true
                     ));
        _operations[79] = oper;

    }

    private static void _initOperationDesc9(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserRoleByTs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "relUserRole"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.RelUserRole[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[80] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserInfoLikeOrgInRoles");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo"), cn.com.dhcc.uums.service.uums.RoleInfo[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.UserInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"),
                      "cn.com.dhcc.uums.service.uums.NiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException"), 
                      true
                     ));
        _operations[81] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserSysInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "sysInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.SysInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[82] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getJobInfoByDep");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "jobInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.JobInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[83] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getOrgInfoPageList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "searchProperty"), cn.com.dhcc.uums.service.uums.SearchProperty[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orderProperty"), cn.com.dhcc.uums.service.uums.OrderProperty[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg3"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "pagerData"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.PagerData.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[84] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("syncUserInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo"), cn.com.dhcc.uums.service.uums.UserInfo[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[85] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPersInfoBydepId");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "persInfo"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.PersInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[86] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserRoleByUserCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "relUserRole"));
        oper.setReturnClass(cn.com.dhcc.uums.service.uums.RelUserRole[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"),
                      "cn.com.dhcc.uums.service.uums.ServiceException",
                      new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException"), 
                      true
                     ));
        _operations[87] = oper;

    }

    public UumsServiceImplServiceSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public UumsServiceImplServiceSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public UumsServiceImplServiceSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
        addBindings0();
        addBindings1();
    }

    private void addBindings0() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "addUserRole");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.AddUserRole.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "addUserRoleResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.AddUserRoleResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "changeUserPassword");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.ChangeUserPassword.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "changeUserPasswordResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.ChangeUserPasswordResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "condition");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.Condition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deleteDepInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DeleteDepInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deleteDepInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DeleteDepInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deleteJobInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DeleteJobInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deleteJobInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DeleteJobInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deleteOrgInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DeleteOrgInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deleteOrgInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DeleteOrgInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deletePersInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DeletePersInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deletePersInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DeletePersInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deleteRoleInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.RoleInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo");
            qName2 = new javax.xml.namespace.QName("", "arg0");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deleteRoleInfoBySys");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DeleteRoleInfoBySys.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deleteRoleInfoBySysResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DeleteRoleInfoBySysResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deleteRoleInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DeleteRoleInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deleteUserInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DeleteUserInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deleteUserInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DeleteUserInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "depInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DepInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "domainInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DomainInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDepInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetDepInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDepInfoByUnit");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetDepInfoByUnit.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDepInfoByUnitResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DepInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "depInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDepInfoList");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetDepInfoList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDepInfoListByTs");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetDepInfoListByTs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDepInfoListByTsResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DepInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "depInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDepInfoListResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DepInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "depInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDepInfoPageList");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetDepInfoPageList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDepInfoPageListResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetDepInfoPageListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDepInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetDepInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDomainInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetDomainInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDomainInfoList");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetDomainInfoList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDomainInfoListByTs");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetDomainInfoListByTs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDomainInfoListByTsResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DomainInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "domainInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDomainInfoListResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DomainInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "domainInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDomainInfoPageList");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetDomainInfoPageList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDomainInfoPageListResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetDomainInfoPageListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDomainInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetDomainInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetJobInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobInfoByDep");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetJobInfoByDep.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobInfoByDepResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.JobInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "jobInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobInfoByOrg");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetJobInfoByOrg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobInfoByOrgResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.JobInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "jobInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobInfoList");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetJobInfoList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobInfoListByTs");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetJobInfoListByTs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobInfoListByTsResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.JobInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "jobInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobInfoListResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.JobInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "jobInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobInfoPageList");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetJobInfoPageList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobInfoPageListResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetJobInfoPageListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetJobInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobRoleInfoList");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetJobRoleInfoList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobRoleInfoListResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.RoleInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getOrgInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetOrgInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getOrgInfoList");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetOrgInfoList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getOrgInfoListByTs");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetOrgInfoListByTs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getOrgInfoListByTsResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.OrgInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orgInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getOrgInfoListResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.OrgInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orgInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getOrgInfoPageList");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetOrgInfoPageList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getOrgInfoPageListResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetOrgInfoPageListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getOrgInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetOrgInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getOrgPersInfoListByPerscode");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetOrgPersInfoListByPerscode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getOrgPersInfoListByPerscodeResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.PersInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "persInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetPersInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfoBydepId");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetPersInfoBydepId.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfoBydepIdResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.PersInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "persInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfoLikePersName");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetPersInfoLikePersName.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfoLikePersNameResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.PersInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "persInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfoList");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetPersInfoList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfoListByOrgCode");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetPersInfoListByOrgCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfoListByOrgCodeResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.PersInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "persInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfoListByTs");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetPersInfoListByTs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfoListByTsResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.PersInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "persInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfoListResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.PersInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "persInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfoPageList");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetPersInfoPageList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfoPageListResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetPersInfoPageListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetPersInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersListByProperty");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetPersListByProperty.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersListByPropertyResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.PersInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "persInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getpOrgInfoByOrgCode");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetpOrgInfoByOrgCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getpOrgInfoByOrgCodeResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetpOrgInfoByOrgCodeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getReduceUserRole");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetReduceUserRole.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getReduceUserRoleResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.RelUserRole[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "relUserRole");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRelUserRole");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetRelUserRole.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRelUserRoleResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.RelUserRole[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "relUserRole");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRoleInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetRoleInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRoleInfoByUser");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetRoleInfoByUser.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRoleInfoByUserResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.RoleInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRoleInfoList");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetRoleInfoList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRoleInfoListByScode");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetRoleInfoListByScode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRoleInfoListByScodeResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.RoleInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRoleInfoListByTs");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetRoleInfoListByTs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRoleInfoListByTsResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.RoleInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRoleInfoListResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.RoleInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRoleInfoPageList");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetRoleInfoPageList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRoleInfoPageListResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetRoleInfoPageListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRoleInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetRoleInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSubDepInfoList");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetSubDepInfoList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSubDepInfoListResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.DepInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "depInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSubOrgInfoList");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetSubOrgInfoList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings1() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSubOrgInfoListResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.OrgInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orgInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSysInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetSysInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSysInfoByDomain");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetSysInfoByDomain.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSysInfoByDomainResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.SysInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "sysInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSysInfoList");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetSysInfoList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSysInfoListByTs");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetSysInfoListByTs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSysInfoListByTsResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.SysInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "sysInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSysInfoListResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.SysInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "sysInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSysInfoPageList");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetSysInfoPageList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSysInfoPageListResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetSysInfoPageListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSysInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetSysInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserAdminSysInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetUserAdminSysInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserAdminSysInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.SysInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "sysInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoByJob");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetUserInfoByJob.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoByJobResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UserInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoByOrg");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetUserInfoByOrg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoByOrgAndSubOrg");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetUserInfoByOrgAndSubOrg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoByOrgAndSubOrgResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UserInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoByOrgInRoles");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetUserInfoByOrgInRoles.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoByOrgInRolesResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UserInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoByOrgResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UserInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoByRole");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetUserInfoByRole.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoByRoleResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UserInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoLikeOrgInRoles");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetUserInfoLikeOrgInRoles.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoLikeOrgInRolesResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UserInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoList");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetUserInfoList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoListByIds");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("", "arg0");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoListByIdsResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UserInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoListByTs");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetUserInfoListByTs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoListByTsResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UserInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoListResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UserInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoPageList");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetUserInfoPageList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoPageListResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetUserInfoPageListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoPageListWithStr");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetUserInfoPageListWithStr.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoPageListWithStrResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetUserInfoPageListWithStrResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserJobInfoList");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetUserJobInfoList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserJobInfoListResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.JobInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "jobInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserListByProperty");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetUserListByProperty.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserListByPropertyResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UserInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserRoleByTs");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetUserRoleByTs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserRoleByTsResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.RelUserRole[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "relUserRole");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserRoleByUserCode");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetUserRoleByUserCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserRoleByUserCodeResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.RelUserRole[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "relUserRole");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserRoleByUserSys");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetUserRoleByUserSys.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserRoleByUserSysResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.RelUserRole[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "relUserRole");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUsersByAdcdInRoles");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetUsersByAdcdInRoles.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUsersByAdcdInRolesResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UserInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserSysInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.GetUserSysInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserSysInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.SysInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "sysInfo");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "insertDepInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.InsertDepInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "insertDepInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.InsertDepInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "insertJobInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.InsertJobInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "insertJobInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.InsertJobInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "insertOrgInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.InsertOrgInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "insertOrgInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.InsertOrgInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "insertPersInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.InsertPersInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "insertPersInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.InsertPersInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "insertUserInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.InsertUserInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "insertUserInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.InsertUserInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "isUamsValidIdNo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.IsUamsValidIdNo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "isUamsValidIdNoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.IsUamsValidIdNoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "isUamsValidUser");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.IsUamsValidUser.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "isUamsValidUserResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.IsUamsValidUserResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "jobInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.JobInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "NiceException");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.NiceException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orderProperty");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.OrderProperty.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "orgInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.OrgInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "pagerData");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.PagerData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "persInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.PersInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "pg");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.Pg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "pushRoleInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.RoleInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo");
            qName2 = new javax.xml.namespace.QName("", "arg0");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "pushRoleInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.PushRoleInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "relUserRole");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.RelUserRole.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.RoleInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "searchProperty");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.SearchProperty.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "searchStrProperty");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.SearchStrProperty.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "ServiceException");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.ServiceException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "syncUserInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UserInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo");
            qName2 = new javax.xml.namespace.QName("", "arg0");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "syncUserInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.SyncUserInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "sysInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.SysInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "updateDepInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UpdateDepInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "updateDepInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UpdateDepInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "updateJobInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UpdateJobInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "updateJobInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UpdateJobInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "updateOrgInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UpdateOrgInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "updateOrgInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UpdateOrgInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "updatePersInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UpdatePersInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "updatePersInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UpdatePersInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "updateRoleInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.RoleInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "roleInfo");
            qName2 = new javax.xml.namespace.QName("", "arg0");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "updateRoleInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UpdateRoleInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "updateUserInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UpdateUserInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "updateUserInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UpdateUserInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "userInfo");
            cachedSerQNames.add(qName);
            cls = cn.com.dhcc.uums.service.uums.UserInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public java.lang.Integer updateUserInfo(cn.com.dhcc.uums.service.uums.UserInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "updateUserInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.NiceException) {
              throw (cn.com.dhcc.uums.service.uums.NiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.DepInfo getDepInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDepInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.DepInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.DepInfo) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.DepInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.PagerData getJobInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobInfoPageList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1, new java.lang.Integer(arg2), new java.lang.Integer(arg3)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.PagerData) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.PagerData) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.PagerData.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Integer updateRoleInfo(cn.com.dhcc.uums.service.uums.RoleInfo[] arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "updateRoleInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Integer insertJobInfo(cn.com.dhcc.uums.service.uums.JobInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "insertJobInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.NiceException) {
              throw (cn.com.dhcc.uums.service.uums.NiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.RoleInfo[] getRoleInfoListByScode(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRoleInfoListByScode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.RoleInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.RoleInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.RoleInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.PersInfo[] getPersInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfoListByTs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.PersInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.PersInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.PersInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.OrgInfo[] getOrgInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getOrgInfoListByTs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.OrgInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.OrgInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.OrgInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Integer updateJobInfo(cn.com.dhcc.uums.service.uums.JobInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "updateJobInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.NiceException) {
              throw (cn.com.dhcc.uums.service.uums.NiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.DomainInfo[] getDomainInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDomainInfoListByTs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.DomainInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.DomainInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.DomainInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.DepInfo[] getDepInfoByUnit(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDepInfoByUnit"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.DepInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.DepInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.DepInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.UserInfo isUamsValidUser(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "isUamsValidUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.UserInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.UserInfo) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.UserInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Integer updatePersInfo(cn.com.dhcc.uums.service.uums.PersInfo arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "updatePersInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.NiceException) {
              throw (cn.com.dhcc.uums.service.uums.NiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.RelUserRole[] getUserRoleByUserSys(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserRoleByUserSys"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.RelUserRole[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.RelUserRole[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.RelUserRole[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Integer insertDepInfo(cn.com.dhcc.uums.service.uums.DepInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "insertDepInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.NiceException) {
              throw (cn.com.dhcc.uums.service.uums.NiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoByRole(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoByRole"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.UserInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Integer insertPersInfo(cn.com.dhcc.uums.service.uums.PersInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "insertPersInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.NiceException) {
              throw (cn.com.dhcc.uums.service.uums.NiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.PersInfo[] getPersInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfoList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.PersInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.PersInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.PersInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Integer deleteRoleInfo(cn.com.dhcc.uums.service.uums.RoleInfo[] arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deleteRoleInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.JobInfo[] getJobInfoByOrg(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobInfoByOrg"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.JobInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.JobInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.JobInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Integer deleteDepInfo(cn.com.dhcc.uums.service.uums.DepInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deleteDepInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.NiceException) {
              throw (cn.com.dhcc.uums.service.uums.NiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoListByIds(java.lang.String[] arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoListByIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.UserInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.SysInfo[] getUserAdminSysInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserAdminSysInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.SysInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.SysInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.SysInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.JobInfo[] getUserJobInfoList(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserJobInfoList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.JobInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.JobInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.JobInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Integer insertOrgInfo(cn.com.dhcc.uums.service.uums.OrgInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "insertOrgInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String changeUserPassword(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "changeUserPassword"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1, arg2});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.JobInfo[] getJobInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobInfoListByTs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.JobInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.JobInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.JobInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.PagerData getSysInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSysInfoPageList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1, new java.lang.Integer(arg2), new java.lang.Integer(arg3)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.PagerData) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.PagerData) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.PagerData.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.RoleInfo[] getJobRoleInfoList(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobRoleInfoList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.RoleInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.RoleInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.RoleInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.JobInfo getJobInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.JobInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.JobInfo) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.JobInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.OrgInfo getOrgInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getOrgInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.OrgInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.OrgInfo) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.OrgInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.DepInfo[] getDepInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDepInfoList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.DepInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.DepInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.DepInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.PagerData getPersInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfoPageList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1, new java.lang.Integer(arg2), new java.lang.Integer(arg3)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.PagerData) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.PagerData) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.PagerData.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.PagerData getUserInfoPageListWithStr(cn.com.dhcc.uums.service.uums.SearchStrProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoPageListWithStr"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1, new java.lang.Integer(arg2), new java.lang.Integer(arg3)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.PagerData) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.PagerData) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.PagerData.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.PersInfo getPersInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.PersInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.PersInfo) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.PersInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Integer deleteRoleInfoBySys(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deleteRoleInfoBySys"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.PagerData getDepInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[36]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDepInfoPageList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1, new java.lang.Integer(arg2), new java.lang.Integer(arg3)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.PagerData) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.PagerData) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.PagerData.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.DepInfo[] getSubDepInfoList(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[37]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSubDepInfoList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.DepInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.DepInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.DepInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Integer addUserRole(java.lang.String arg0, cn.com.dhcc.uums.service.uums.RoleInfo[] arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[38]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "addUserRole"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1, arg2, arg3});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.PagerData getRoleInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[39]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRoleInfoPageList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1, new java.lang.Integer(arg2), new java.lang.Integer(arg3)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.PagerData) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.PagerData) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.PagerData.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.RoleInfo[] getRoleInfoByUser(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[40]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRoleInfoByUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.RoleInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.RoleInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.RoleInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.UserInfo isUamsValidIdNo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[41]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "isUamsValidIdNo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.UserInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.UserInfo) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.UserInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.SysInfo getSysInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[42]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSysInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.SysInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.SysInfo) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.SysInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoByOrg(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[43]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoByOrg"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.UserInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.RoleInfo[] getRoleInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[44]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRoleInfoList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.RoleInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.RoleInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.RoleInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.UserInfo[] getUserListByProperty(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[45]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserListByProperty"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.UserInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[46]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.UserInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[47]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoListByTs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.UserInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.SysInfo[] getSysInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[48]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSysInfoList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.SysInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.SysInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.SysInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.PersInfo[] getPersInfoLikePersName(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[49]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfoLikePersName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.PersInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.PersInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.PersInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoByJob(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[50]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoByJob"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.UserInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.DepInfo[] getDepInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[51]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDepInfoListByTs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.DepInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.DepInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.DepInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.PersInfo[] getOrgPersInfoListByPerscode(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[52]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getOrgPersInfoListByPerscode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.PersInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.PersInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.PersInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.SysInfo[] getSysInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[53]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSysInfoListByTs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.SysInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.SysInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.SysInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.RelUserRole[] getReduceUserRole(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[54]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getReduceUserRole"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.RelUserRole[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.RelUserRole[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.RelUserRole[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Integer insertUserInfo(cn.com.dhcc.uums.service.uums.UserInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[55]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "insertUserInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.NiceException) {
              throw (cn.com.dhcc.uums.service.uums.NiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.OrgInfo getpOrgInfoByOrgCode(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[56]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getpOrgInfoByOrgCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.OrgInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.OrgInfo) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.OrgInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Integer deletePersInfo(cn.com.dhcc.uums.service.uums.PersInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[57]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deletePersInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.NiceException) {
              throw (cn.com.dhcc.uums.service.uums.NiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.DomainInfo[] getDomainInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[58]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDomainInfoList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.DomainInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.DomainInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.DomainInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Integer deleteUserInfo(cn.com.dhcc.uums.service.uums.UserInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[59]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deleteUserInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.NiceException) {
              throw (cn.com.dhcc.uums.service.uums.NiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.OrgInfo[] getOrgInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[60]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getOrgInfoList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.OrgInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.OrgInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.OrgInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoByOrgInRoles(java.lang.String arg0, cn.com.dhcc.uums.service.uums.RoleInfo[] arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[61]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoByOrgInRoles"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.UserInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.NiceException) {
              throw (cn.com.dhcc.uums.service.uums.NiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.DomainInfo getDomainInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[62]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDomainInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.DomainInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.DomainInfo) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.DomainInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.PagerData getUserInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[63]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoPageList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1, new java.lang.Integer(arg2), new java.lang.Integer(arg3)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.PagerData) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.PagerData) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.PagerData.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Integer deleteOrgInfo(cn.com.dhcc.uums.service.uums.OrgInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[64]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deleteOrgInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.NiceException) {
              throw (cn.com.dhcc.uums.service.uums.NiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.RoleInfo[] getRoleInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[65]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRoleInfoListByTs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.RoleInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.RoleInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.RoleInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.PersInfo[] getPersListByProperty(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[66]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersListByProperty"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.PersInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.PersInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.PersInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoByOrgAndSubOrg(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[67]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoByOrgAndSubOrg"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.UserInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.SysInfo[] getSysInfoByDomain(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[68]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSysInfoByDomain"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.SysInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.SysInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.SysInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.OrgInfo[] getSubOrgInfoList(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[69]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getSubOrgInfoList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.OrgInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.OrgInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.OrgInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Integer updateOrgInfo(java.lang.String arg0, cn.com.dhcc.uums.service.uums.OrgInfo arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[70]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "updateOrgInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.NiceException) {
              throw (cn.com.dhcc.uums.service.uums.NiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.RoleInfo getRoleInfo(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[71]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRoleInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.RoleInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.RoleInfo) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.RoleInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Integer deleteJobInfo(cn.com.dhcc.uums.service.uums.JobInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[72]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "deleteJobInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.NiceException) {
              throw (cn.com.dhcc.uums.service.uums.NiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.PagerData getDomainInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[73]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getDomainInfoPageList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1, new java.lang.Integer(arg2), new java.lang.Integer(arg3)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.PagerData) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.PagerData) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.PagerData.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Integer pushRoleInfo(cn.com.dhcc.uums.service.uums.RoleInfo[] arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[74]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "pushRoleInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.JobInfo[] getJobInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[75]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobInfoList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.JobInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.JobInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.JobInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.PersInfo[] getPersInfoListByOrgCode(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[76]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfoListByOrgCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.PersInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.PersInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.PersInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.RelUserRole[] getRelUserRole() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[77]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getRelUserRole"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.RelUserRole[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.RelUserRole[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.RelUserRole[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.UserInfo[] getUsersByAdcdInRoles(cn.com.dhcc.uums.service.uums.RoleInfo[] arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[78]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUsersByAdcdInRoles"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.UserInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.Integer updateDepInfo(cn.com.dhcc.uums.service.uums.DepInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[79]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "updateDepInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Integer) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Integer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.NiceException) {
              throw (cn.com.dhcc.uums.service.uums.NiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.RelUserRole[] getUserRoleByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[80]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserRoleByTs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.RelUserRole[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.RelUserRole[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.RelUserRole[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoLikeOrgInRoles(java.lang.String arg0, cn.com.dhcc.uums.service.uums.RoleInfo[] arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[81]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserInfoLikeOrgInRoles"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.UserInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.UserInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.NiceException) {
              throw (cn.com.dhcc.uums.service.uums.NiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.SysInfo[] getUserSysInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[82]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserSysInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.SysInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.SysInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.SysInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.JobInfo[] getJobInfoByDep(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[83]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getJobInfoByDep"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.JobInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.JobInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.JobInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.PagerData getOrgInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[84]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getOrgInfoPageList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1, new java.lang.Integer(arg2), new java.lang.Integer(arg3)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.PagerData) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.PagerData) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.PagerData.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String syncUserInfo(cn.com.dhcc.uums.service.uums.UserInfo[] arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[85]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "syncUserInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.PersInfo[] getPersInfoBydepId(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[86]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getPersInfoBydepId"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.PersInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.PersInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.PersInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public cn.com.dhcc.uums.service.uums.RelUserRole[] getUserRoleByUserCode(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[87]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "getUserRoleByUserCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.com.dhcc.uums.service.uums.RelUserRole[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.com.dhcc.uums.service.uums.RelUserRole[]) org.apache.axis.utils.JavaUtils.convert(_resp, cn.com.dhcc.uums.service.uums.RelUserRole[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof cn.com.dhcc.uums.service.uums.ServiceException) {
              throw (cn.com.dhcc.uums.service.uums.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
