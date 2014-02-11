package org.lichee.simple.example.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.lichee.simple.example.entity.SeRolePermission;
import org.lichee.simple.example.entity.SeUser;
import org.lichee.simple.example.entity.SeUserRole;
import org.lichee.simple.example.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroDbRealm extends AuthorizingRealm {

	@Autowired
	private UserDao userDao;

	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		 SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前登录的用户名
        String account = (String) super.getAvailablePrincipal(principals);
        
        List<String> roles = new ArrayList<String>();  
        List<String> permissions = new ArrayList<String>();
//        User user = userService.getByAccount(account);
        SeUser user = userDao.getByUserName(account);
        if(user != null){
            if (user.getUserRoles() != null && user.getUserRoles().size() > 0) {
                for (SeUserRole sur : user.getUserRoles()) {
                    roles.add(sur.getRole().getRoleName());
                    if (sur.getRole().getRolePermissions() != null && sur.getRole().getRolePermissions().size() > 0) {
                        for (SeRolePermission srp : sur.getRole().getRolePermissions()) {
//                            if(!StringUtils.isEmpty(pmss.getPermission())){
                        		permissions.add(srp.getPermission().getPermissionUrl());
//                            }
                        }
                    }
                }
            }
        }else{
            throw new AuthorizationException();
        }
        //给当前用户设置角色
        info.addRoles(roles);
        //给当前用户设置权限
        info.addStringPermissions(permissions); 
        return info;
	}

	/**
	 * 认证回调函数,登录时调用.
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		System.out.println("db里面---------------------登录调用-----------------------");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		SeUser user = userDao.getByUserName(token.getUsername());
		if (user != null) {
			return new SimpleAuthenticationInfo(user.getUserName(),
					user.getUserPassword(), user.getUserAccount());
		} else {
			return null;
		}
	}

}
