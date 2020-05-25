/**
 * UumsServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.dhcc.uums.service.uums;

public class UumsServiceImplServiceLocator extends org.apache.axis.client.Service implements cn.com.dhcc.uums.service.uums.UumsServiceImplService {

    public UumsServiceImplServiceLocator() {
    }


    public UumsServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UumsServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UumsServiceImplPort
    private java.lang.String UumsServiceImplPort_address = "http://10.136.4.162:8088/uams_new/ws/uums";

    public java.lang.String getUumsServiceImplPortAddress() {
        return UumsServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UumsServiceImplPortWSDDServiceName = "UumsServiceImplPort";

    public java.lang.String getUumsServiceImplPortWSDDServiceName() {
        return UumsServiceImplPortWSDDServiceName;
    }

    public void setUumsServiceImplPortWSDDServiceName(java.lang.String name) {
        UumsServiceImplPortWSDDServiceName = name;
    }

    public cn.com.dhcc.uums.service.uums.UumsService getUumsServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UumsServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUumsServiceImplPort(endpoint);
    }

    public cn.com.dhcc.uums.service.uums.UumsService getUumsServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.dhcc.uums.service.uums.UumsServiceImplServiceSoapBindingStub _stub = new cn.com.dhcc.uums.service.uums.UumsServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getUumsServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUumsServiceImplPortEndpointAddress(java.lang.String address) {
        UumsServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cn.com.dhcc.uums.service.uums.UumsService.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.dhcc.uums.service.uums.UumsServiceImplServiceSoapBindingStub _stub = new cn.com.dhcc.uums.service.uums.UumsServiceImplServiceSoapBindingStub(new java.net.URL(UumsServiceImplPort_address), this);
                _stub.setPortName(getUumsServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("UumsServiceImplPort".equals(inputPortName)) {
            return getUumsServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "UumsServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://uums.service.uums.dhcc.com.cn/", "UumsServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("UumsServiceImplPort".equals(portName)) {
            setUumsServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
