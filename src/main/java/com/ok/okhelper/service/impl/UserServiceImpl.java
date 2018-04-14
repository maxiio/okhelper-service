package com.ok.okhelper.service.impl;

import com.ok.okhelper.common.ServerResponse;
import com.ok.okhelper.dao.RoleMapper;
import com.ok.okhelper.dao.UserMapper;
import com.ok.okhelper.po.Role;
import com.ok.okhelper.po.User;
import com.ok.okhelper.pojo.bo.UserBo;
import com.ok.okhelper.service.PermissionService;
import com.ok.okhelper.service.UserService;
import com.ok.okhelper.shiro.JWTUtil;
import com.ok.okhelper.until.PasswordHelp;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
*Author:zhangxin_an
*Description:
*Data:Created in 21:27 2018/4/10
*/
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private PermissionService permissionService;
	

	
	@Override
	public User findUserByUserNme(String username) {
		return userMapper.findUserByUserName(username);
	}
	
	@Override
	public ServerResponse loginUser(String userName, String password) {
		
		if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
			throw new UnauthenticatedException("用户名或密码为空");
//			return ServerResponse.createByErrorCodeMessage(401, "");
		}
		
		User user = findUserByUserNme(userName);
		
		
		
		if(user == null){
			throw new UnauthenticatedException("用户名不存在");
		}
		
		//加密
		String inPassword = PasswordHelp.passwordSalt(userName, password).toString();
		
		String dbPassword = user.getUserPassword();
		if(!dbPassword.equals(inPassword)){
			throw new UnauthenticatedException("密码不正确");
		}
		
		Long userId = user.getId();
		
		//传值给前端封装类
		UserBo userBo = new UserBo();
		BeanUtils.copyProperties(user,userBo);
		
		List<Role> roles = roleMapper.findRoleByUserId(user.getId());
		if(!CollectionUtils.isEmpty(roles)){
			userBo.setRoleList(roles);
		}
		
		//获取用户权限
		List<String> permissionList = permissionService.findAddPermissionCode(userId);
		String [] permissionArrays = null;
		
		if(!CollectionUtils.isEmpty(permissionList)) {
			permissionArrays = permissionList.toArray(new String[permissionList.size()]);
			userBo.setPermissionCodes(permissionList);
		}
		String token = JWTUtil.sign(userName, inPassword,permissionArrays);
		
		
		List<Long> storeIds= userMapper.findStoreIdByUserId(userId);
		
		if(!CollectionUtils.isEmpty(storeIds)){
			userBo.setStoreIds(storeIds);
		}
		userBo.setToken(token);
		
		return ServerResponse.createBySuccess(userBo);
	}
	
	
}