/**
 * UumsService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.dhcc.uums.service.uums;

public interface UumsService extends java.rmi.Remote {
    public java.lang.Integer updateUserInfo(cn.com.dhcc.uums.service.uums.UserInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException;
    public cn.com.dhcc.uums.service.uums.DepInfo getDepInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public java.lang.Integer updateRoleInfo(cn.com.dhcc.uums.service.uums.RoleInfo[] arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.PagerData getJobInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public java.lang.Integer insertJobInfo(cn.com.dhcc.uums.service.uums.JobInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException;
    public cn.com.dhcc.uums.service.uums.RoleInfo[] getRoleInfoListByScode(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.OrgInfo[] getOrgInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.PersInfo[] getPersInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public java.lang.Integer updateJobInfo(cn.com.dhcc.uums.service.uums.JobInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException;
    public cn.com.dhcc.uums.service.uums.DomainInfo[] getDomainInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.DepInfo[] getDepInfoByUnit(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public java.lang.Integer updatePersInfo(cn.com.dhcc.uums.service.uums.PersInfo arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException;
    public cn.com.dhcc.uums.service.uums.UserInfo isUamsValidUser(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.RelUserRole[] getUserRoleByUserSys(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public java.lang.Integer insertDepInfo(cn.com.dhcc.uums.service.uums.DepInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException;
    public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoByRole(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public java.lang.Integer insertPersInfo(cn.com.dhcc.uums.service.uums.PersInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException;
    public cn.com.dhcc.uums.service.uums.PersInfo[] getPersInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public java.lang.Integer deleteRoleInfo(cn.com.dhcc.uums.service.uums.RoleInfo[] arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.JobInfo[] getJobInfoByOrg(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public java.lang.Integer deleteDepInfo(cn.com.dhcc.uums.service.uums.DepInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException;
    public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoListByIds(java.lang.String[] arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.JobInfo[] getUserJobInfoList(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.SysInfo[] getUserAdminSysInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public java.lang.Integer insertOrgInfo(cn.com.dhcc.uums.service.uums.OrgInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public java.lang.String changeUserPassword(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.JobInfo[] getJobInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.PagerData getSysInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.RoleInfo[] getJobRoleInfoList(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.JobInfo getJobInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.OrgInfo getOrgInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.DepInfo[] getDepInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.PagerData getPersInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.PagerData getUserInfoPageListWithStr(cn.com.dhcc.uums.service.uums.SearchStrProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.PersInfo getPersInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.DepInfo[] getSubDepInfoList(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.PagerData getDepInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public java.lang.Integer deleteRoleInfoBySys(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public java.lang.Integer addUserRole(java.lang.String arg0, cn.com.dhcc.uums.service.uums.RoleInfo[] arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.PagerData getRoleInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.RoleInfo[] getRoleInfoByUser(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.UserInfo isUamsValidIdNo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.SysInfo getSysInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoByOrg(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.RoleInfo[] getRoleInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.UserInfo[] getUserListByProperty(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.SysInfo[] getSysInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoByJob(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.PersInfo[] getPersInfoLikePersName(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.DepInfo[] getDepInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.PersInfo[] getOrgPersInfoListByPerscode(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.SysInfo[] getSysInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.RelUserRole[] getReduceUserRole(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public java.lang.Integer insertUserInfo(cn.com.dhcc.uums.service.uums.UserInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException;
    public cn.com.dhcc.uums.service.uums.OrgInfo getpOrgInfoByOrgCode(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public java.lang.Integer deletePersInfo(cn.com.dhcc.uums.service.uums.PersInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException;
    public cn.com.dhcc.uums.service.uums.DomainInfo[] getDomainInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public java.lang.Integer deleteUserInfo(cn.com.dhcc.uums.service.uums.UserInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException;
    public cn.com.dhcc.uums.service.uums.OrgInfo[] getOrgInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoByOrgInRoles(java.lang.String arg0, cn.com.dhcc.uums.service.uums.RoleInfo[] arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException;
    public cn.com.dhcc.uums.service.uums.PagerData getUserInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.DomainInfo getDomainInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.RoleInfo[] getRoleInfoListByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public java.lang.Integer deleteOrgInfo(cn.com.dhcc.uums.service.uums.OrgInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException;
    public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoByOrgAndSubOrg(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.PersInfo[] getPersListByProperty(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.SysInfo[] getSysInfoByDomain(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public java.lang.Integer updateOrgInfo(java.lang.String arg0, cn.com.dhcc.uums.service.uums.OrgInfo arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException;
    public cn.com.dhcc.uums.service.uums.OrgInfo[] getSubOrgInfoList(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.RoleInfo getRoleInfo(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.PagerData getDomainInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public java.lang.Integer deleteJobInfo(cn.com.dhcc.uums.service.uums.JobInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException;
    public java.lang.Integer pushRoleInfo(cn.com.dhcc.uums.service.uums.RoleInfo[] arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.JobInfo[] getJobInfoList() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.PersInfo[] getPersInfoListByOrgCode(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.RelUserRole[] getRelUserRole() throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.UserInfo[] getUsersByAdcdInRoles(cn.com.dhcc.uums.service.uums.RoleInfo[] arg0, java.lang.String arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public java.lang.Integer updateDepInfo(cn.com.dhcc.uums.service.uums.DepInfo arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException;
    public cn.com.dhcc.uums.service.uums.RelUserRole[] getUserRoleByTs(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.UserInfo[] getUserInfoLikeOrgInRoles(java.lang.String arg0, cn.com.dhcc.uums.service.uums.RoleInfo[] arg1) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.NiceException;
    public cn.com.dhcc.uums.service.uums.SysInfo[] getUserSysInfo(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.JobInfo[] getJobInfoByDep(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public java.lang.String syncUserInfo(cn.com.dhcc.uums.service.uums.UserInfo[] arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.PagerData getOrgInfoPageList(cn.com.dhcc.uums.service.uums.SearchProperty[] arg0, cn.com.dhcc.uums.service.uums.OrderProperty[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.PersInfo[] getPersInfoBydepId(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
    public cn.com.dhcc.uums.service.uums.RelUserRole[] getUserRoleByUserCode(java.lang.String arg0) throws java.rmi.RemoteException, cn.com.dhcc.uums.service.uums.ServiceException;
}
