package cn.com.dhcc.uums.service.uums;

public class UumsServiceProxy implements cn.com.dhcc.uums.service.uums.UumsService {
  private String _endpoint = null;
  private cn.com.dhcc.uums.service.uums.UumsService uumsService = null;
  
  public UumsServiceProxy() {
    _initUumsServiceProxy();
  }
  
  public UumsServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initUumsServiceProxy();
  }
  
  private void _initUumsServiceProxy() {
    try {
      uumsService = (new cn.com.dhcc.uums.service.uums.UumsServiceImplServiceLocator()).getUumsServiceImplPort();
      if (uumsService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)uumsService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)uumsService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (uumsService != null)
      ((javax.xml.rpc.Stub)uumsService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cn.com.dhcc.uums.service.uums.UumsService getUumsService() {
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService;
  }
  
  public java.lang.Integer updateUserInfo(cn.com.dhcc.uums.service.uums.UserInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.updateUserInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.DepInfo getDepInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getDepInfo(arg0);
  }
  
  public java.lang.Integer updateRoleInfo(cn.com.dhcc.uums.service.uums.RoleInfo[] arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.updateRoleInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.PagerData getJobInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getJobInfoPageList(arg0, arg1, arg2, arg3);
  }
  
  public java.lang.Integer insertJobInfo(cn.com.dhcc.uums.service.uums.JobInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.insertJobInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.RoleInfo[] getRoleInfoListByScode(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getRoleInfoListByScode(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.OrgInfo[] getOrgInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getOrgInfoListByTs(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.PersInfo[] getPersInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getPersInfoListByTs(arg0);
  }
  
  public java.lang.Integer updateJobInfo(cn.com.dhcc.uums.service.uums.JobInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.updateJobInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.DomainInfo[] getDomainInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getDomainInfoListByTs(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.DepInfo[] getDepInfoByUnit(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getDepInfoByUnit(arg0);
  }
  
  public java.lang.Integer updatePersInfo(cn.com.dhcc.uums.service.uums.PersInfo arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.updatePersInfo(arg0, arg1);
  }
  
  public cn.com.dhcc.uums.service.uums.UserInfo isUamsValidUser(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.isUamsValidUser(arg0, arg1);
  }
  
  public cn.com.dhcc.uums.service.uums.RelUserRole[] getUserRoleByUserSys(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getUserRoleByUserSys(arg0, arg1);
  }
  
  public java.lang.Integer insertDepInfo(cn.com.dhcc.uums.service.uums.DepInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.insertDepInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoByRole(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getUserInfoByRole(arg0, arg1);
  }
  
  public java.lang.Integer insertPersInfo(cn.com.dhcc.uums.service.uums.PersInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.insertPersInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.PersInfo[] getPersInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getPersInfoList();
  }
  
  public java.lang.Integer deleteRoleInfo(cn.com.dhcc.uums.service.uums.RoleInfo[] arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.deleteRoleInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.JobInfo[] getJobInfoByOrg(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getJobInfoByOrg(arg0);
  }
  
  public java.lang.Integer deleteDepInfo(cn.com.dhcc.uums.service.uums.DepInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.deleteDepInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoListByIds(java.lang.String[] arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getUserInfoListByIds(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.JobInfo[] getUserJobInfoList(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getUserJobInfoList(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.SysInfo[] getUserAdminSysInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getUserAdminSysInfo(arg0);
  }
  
  public java.lang.Integer insertOrgInfo(cn.com.dhcc.uums.service.uums.OrgInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.insertOrgInfo(arg0);
  }
  
  public java.lang.String changeUserPassword(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.changeUserPassword(arg0, arg1, arg2);
  }
  
  public cn.com.dhcc.uums.service.uums.JobInfo[] getJobInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getJobInfoListByTs(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.PagerData getSysInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getSysInfoPageList(arg0, arg1, arg2, arg3);
  }
  
  public cn.com.dhcc.uums.service.uums.RoleInfo[] getJobRoleInfoList(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getJobRoleInfoList(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.JobInfo getJobInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getJobInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.OrgInfo getOrgInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getOrgInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.DepInfo[] getDepInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getDepInfoList();
  }
  
  public cn.com.dhcc.uums.service.uums.PagerData getPersInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getPersInfoPageList(arg0, arg1, arg2, arg3);
  }
  
  public cn.com.dhcc.uums.service.uums.PagerData getUserInfoPageListWithStr(cn.com.dhcc.uums.service.uums.SearchStrProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getUserInfoPageListWithStr(arg0, arg1, arg2, arg3);
  }
  
  public cn.com.dhcc.uums.service.uums.PersInfo getPersInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getPersInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.DepInfo[] getSubDepInfoList(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getSubDepInfoList(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.PagerData getDepInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getDepInfoPageList(arg0, arg1, arg2, arg3);
  }
  
  public java.lang.Integer deleteRoleInfoBySys(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.deleteRoleInfoBySys(arg0, arg1);
  }
  
  public java.lang.Integer addUserRole(java.lang.String arg0, cn.com.dhcc.uums.service.uums.RoleInfo[] arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.addUserRole(arg0, arg1, arg2, arg3);
  }
  
  public cn.com.dhcc.uums.service.uums.PagerData getRoleInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getRoleInfoPageList(arg0, arg1, arg2, arg3);
  }
  
  public cn.com.dhcc.uums.service.uums.RoleInfo[] getRoleInfoByUser(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getRoleInfoByUser(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.UserInfo isUamsValidIdNo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.isUamsValidIdNo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.SysInfo getSysInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getSysInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoByOrg(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getUserInfoByOrg(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.RoleInfo[] getRoleInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getRoleInfoList();
  }
  
  public cn.com.dhcc.uums.service.uums.UserInfo[] getUserListByProperty(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getUserListByProperty(arg0, arg1);
  }
  
  public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getUserInfoList();
  }
  
  public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getUserInfoListByTs(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.SysInfo[] getSysInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getSysInfoList();
  }
  
  public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoByJob(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getUserInfoByJob(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.PersInfo[] getPersInfoLikePersName(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getPersInfoLikePersName(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.DepInfo[] getDepInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getDepInfoListByTs(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.PersInfo[] getOrgPersInfoListByPerscode(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getOrgPersInfoListByPerscode(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.SysInfo[] getSysInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getSysInfoListByTs(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.RelUserRole[] getReduceUserRole(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getReduceUserRole(arg0, arg1);
  }
  
  public java.lang.Integer insertUserInfo(cn.com.dhcc.uums.service.uums.UserInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.insertUserInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.OrgInfo getpOrgInfoByOrgCode(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getpOrgInfoByOrgCode(arg0);
  }
  
  public java.lang.Integer deletePersInfo(cn.com.dhcc.uums.service.uums.PersInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.deletePersInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.DomainInfo[] getDomainInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getDomainInfoList();
  }
  
  public java.lang.Integer deleteUserInfo(cn.com.dhcc.uums.service.uums.UserInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.deleteUserInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.OrgInfo[] getOrgInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getOrgInfoList();
  }
  
  public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoByOrgInRoles(java.lang.String arg0, cn.com.dhcc.uums.service.uums.RoleInfo[] arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getUserInfoByOrgInRoles(arg0, arg1);
  }
  
  public cn.com.dhcc.uums.service.uums.PagerData getUserInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getUserInfoPageList(arg0, arg1, arg2, arg3);
  }
  
  public cn.com.dhcc.uums.service.uums.DomainInfo getDomainInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getDomainInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.RoleInfo[] getRoleInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getRoleInfoListByTs(arg0);
  }
  
  public java.lang.Integer deleteOrgInfo(cn.com.dhcc.uums.service.uums.OrgInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.deleteOrgInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoByOrgAndSubOrg(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getUserInfoByOrgAndSubOrg(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.PersInfo[] getPersListByProperty(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getPersListByProperty(arg0, arg1);
  }
  
  public cn.com.dhcc.uums.service.uums.SysInfo[] getSysInfoByDomain(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getSysInfoByDomain(arg0);
  }
  
  public java.lang.Integer updateOrgInfo(java.lang.String arg0, cn.com.dhcc.uums.service.uums.OrgInfo arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.updateOrgInfo(arg0, arg1);
  }
  
  public cn.com.dhcc.uums.service.uums.OrgInfo[] getSubOrgInfoList(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getSubOrgInfoList(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.RoleInfo getRoleInfo(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getRoleInfo(arg0, arg1);
  }
  
  public cn.com.dhcc.uums.service.uums.PagerData getDomainInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getDomainInfoPageList(arg0, arg1, arg2, arg3);
  }
  
  public java.lang.Integer deleteJobInfo(cn.com.dhcc.uums.service.uums.JobInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.deleteJobInfo(arg0);
  }
  
  public java.lang.Integer pushRoleInfo(cn.com.dhcc.uums.service.uums.RoleInfo[] arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.pushRoleInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.JobInfo[] getJobInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getJobInfoList();
  }
  
  public cn.com.dhcc.uums.service.uums.PersInfo[] getPersInfoListByOrgCode(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getPersInfoListByOrgCode(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.RelUserRole[] getRelUserRole() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getRelUserRole();
  }
  
  public cn.com.dhcc.uums.service.uums.UserInfo[] getUsersByAdcdInRoles(cn.com.dhcc.uums.service.uums.RoleInfo[] arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getUsersByAdcdInRoles(arg0, arg1);
  }
  
  public java.lang.Integer updateDepInfo(cn.com.dhcc.uums.service.uums.DepInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.updateDepInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.RelUserRole[] getUserRoleByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getUserRoleByTs(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoLikeOrgInRoles(java.lang.String arg0, cn.com.dhcc.uums.service.uums.RoleInfo[] arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getUserInfoLikeOrgInRoles(arg0, arg1);
  }
  
  public cn.com.dhcc.uums.service.uums.SysInfo[] getUserSysInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getUserSysInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.JobInfo[] getJobInfoByDep(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getJobInfoByDep(arg0);
  }
  
  public java.lang.String syncUserInfo(cn.com.dhcc.uums.service.uums.UserInfo[] arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.syncUserInfo(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.PagerData getOrgInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getOrgInfoPageList(arg0, arg1, arg2, arg3);
  }
  
  public cn.com.dhcc.uums.service.uums.PersInfo[] getPersInfoBydepId(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getPersInfoBydepId(arg0);
  }
  
  public cn.com.dhcc.uums.service.uums.RelUserRole[] getUserRoleByUserCode(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException{
    if (uumsService == null)
      _initUumsServiceProxy();
    return uumsService.getUserRoleByUserCode(arg0);
  }
  
  
}