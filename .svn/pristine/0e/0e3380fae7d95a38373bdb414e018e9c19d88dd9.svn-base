package cn.et.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.et.shiro.dao.UserMapper;

@Controller
public class SpringLoginController {
	@Autowired
	UserMapper mapper;
	
	@RequestMapping("/login")
	public String login(String userName, String password, Model model){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		try{
			subject.login(token);
			model.addAttribute("menuList", mapper.selectMenuByName(userName));
			return "/layout.html";
		}catch (UnknownAccountException e) {
			System.out.println("’À∫≈¥ÌŒÛ");
		}catch (IncorrectCredentialsException e) {
			System.out.println("√‹¬Î¥ÌŒÛ");
		}catch (LockedAccountException e) {
			System.out.println("’À∫≈±ªÀ¯∂®");
		}catch (AuthenticationException e) {
			System.out.println("Œª÷√“Ï≥£");
		}
		
		return null;
	}
}
