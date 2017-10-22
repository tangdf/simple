package com.olivia.control;




import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.olivia.control.RolePlayer;
@Service
public class LoginService {
@Resource
  private RoleBasicDao roleBasicDao;
  
  public RolePlayer regist(RolePlayer rolePlayer){
	 return roleBasicDao.save(rolePlayer);
  }
  public List<RolePlayer> show(){
	 return roleBasicDao.findAll();
  }
  public List<RolePlayer> moneyBetween(int money1,int money2){
	  System.out.println(money1+"-----"+money2);
	 return roleBasicDao.findByMoney(money1, money2);
  }
}
