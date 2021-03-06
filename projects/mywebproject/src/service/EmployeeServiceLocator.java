/**
 * EmployeeServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public class EmployeeServiceLocator extends org.apache.axis.client.Service implements service.EmployeeService {

    public EmployeeServiceLocator() {
    }


    public EmployeeServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EmployeeServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EmployeeServiceHttpSoap11Endpoint
    private java.lang.String EmployeeServiceHttpSoap11Endpoint_address = "http://localhost:8060/mysoapwebservice/services/EmployeeService.EmployeeServiceHttpSoap11Endpoint/";

    public java.lang.String getEmployeeServiceHttpSoap11EndpointAddress() {
        return EmployeeServiceHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EmployeeServiceHttpSoap11EndpointWSDDServiceName = "EmployeeServiceHttpSoap11Endpoint";

    public java.lang.String getEmployeeServiceHttpSoap11EndpointWSDDServiceName() {
        return EmployeeServiceHttpSoap11EndpointWSDDServiceName;
    }

    public void setEmployeeServiceHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        EmployeeServiceHttpSoap11EndpointWSDDServiceName = name;
    }

    public service.EmployeeServicePortType getEmployeeServiceHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EmployeeServiceHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEmployeeServiceHttpSoap11Endpoint(endpoint);
    }

    public service.EmployeeServicePortType getEmployeeServiceHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            service.EmployeeServiceSoap11BindingStub _stub = new service.EmployeeServiceSoap11BindingStub(portAddress, this);
            _stub.setPortName(getEmployeeServiceHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEmployeeServiceHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        EmployeeServiceHttpSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (service.EmployeeServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                service.EmployeeServiceSoap11BindingStub _stub = new service.EmployeeServiceSoap11BindingStub(new java.net.URL(EmployeeServiceHttpSoap11Endpoint_address), this);
                _stub.setPortName(getEmployeeServiceHttpSoap11EndpointWSDDServiceName());
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
        if ("EmployeeServiceHttpSoap11Endpoint".equals(inputPortName)) {
            return getEmployeeServiceHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service", "EmployeeService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service", "EmployeeServiceHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EmployeeServiceHttpSoap11Endpoint".equals(portName)) {
            setEmployeeServiceHttpSoap11EndpointEndpointAddress(address);
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
