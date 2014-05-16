package service;

public class EmployeeServicePortTypeProxy implements service.EmployeeServicePortType {
  private String _endpoint = null;
  private service.EmployeeServicePortType employeeServicePortType = null;
  
  public EmployeeServicePortTypeProxy() {
    _initEmployeeServicePortTypeProxy();
  }
  
  public EmployeeServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmployeeServicePortTypeProxy();
  }
  
  private void _initEmployeeServicePortTypeProxy() {
    try {
      employeeServicePortType = (new service.EmployeeServiceLocator()).getEmployeeServiceHttpSoap11Endpoint();
      if (employeeServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)employeeServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)employeeServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (employeeServicePortType != null)
      ((javax.xml.rpc.Stub)employeeServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public service.EmployeeServicePortType getEmployeeServicePortType() {
    if (employeeServicePortType == null)
      _initEmployeeServicePortTypeProxy();
    return employeeServicePortType;
  }
  
  public java.lang.Integer calculateTax(java.lang.Integer baseSalary) throws java.rmi.RemoteException{
    if (employeeServicePortType == null)
      _initEmployeeServicePortTypeProxy();
    return employeeServicePortType.calculateTax(baseSalary);
  }
  
  
}