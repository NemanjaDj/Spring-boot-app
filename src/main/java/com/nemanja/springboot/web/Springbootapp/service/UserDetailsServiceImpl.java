package com.nemanja.springboot.web.Springbootapp.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nemanja.springboot.web.Springbootapp.dao.UserDao;
import com.nemanja.springboot.web.Springbootapp.model.CustomUserDetails;
import com.nemanja.springboot.web.Springbootapp.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("username " + username + " not found");
		
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("User"));
		
		CustomUserDetails customUserDetail=new CustomUserDetails();
        customUserDetail.setUser(user);
        customUserDetail.setAuthorities(authorities);

        return customUserDetail;
	}

}
