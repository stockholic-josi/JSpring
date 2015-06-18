package com.taxholic.core.authority;


import java.util.ArrayList;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.taxholic.core.web.dao.CommonDao;

@Service
public class AuthService  implements UserDetailsService {
	
	@Autowired
	private CommonDao commonDao;

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException, DataAccessException {
    	
		if (userId == null || "".equals(userId.trim()) || userId == null) {
			return null;
		}
    	
//		AuthDto dto = new AuthDto();
		List role = new ArrayList();
		role.add("ADMIN");
		role.add("USER");
//		dto.setRoleList(role);
		
		System.out.println(">>>>>>>>>>>>>" + userId);
		
		AuthDto dto = new AuthDto();
		dto.setUserId(userId);
		dto.setPassword("1111");
		dto.setUserNm("메렁");
		dto.setRoleList(role);
    	
		//로그인 정보
//		AuthDto user = new AuthDto();
//		user.setUserId(userId);
//		user.setUseYn("Y");
//		AuthDto dto = (AuthDto)this.commonDao.getObject("front.User.getUserInfo",user);
		
		//회원 권한
//		if(dto != null){
//			
//			List roleList = new ArrayList();
//			List<AuthDto> authList = this.commonDao.getList("front.User.getUserAuthList",userId);
//			int authCount = authList.size();
//			if(authCount > 0){
//				for(int i = 0; i < authCount; i++){
//					roleList.add( authList.get(i).getRole());
//				}
//			}else{
//				roleList.add( "USR");
//			}
//			
//			dto.setRoleList(roleList);
//		}

		return new AuthInfo(dto);
    }
    
}