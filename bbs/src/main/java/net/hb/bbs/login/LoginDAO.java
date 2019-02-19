package net.hb.bbs.login;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class LoginDAO {


@Autowired
SqlSessionTemplate temp;
	
 	 public List<LoginVO> dbselectAll( ){
		  List<LoginVO> list=temp.selectList("login.selectAll");
		  return list;
	 }//end
 	 
 	 public LoginVO login(LoginVO vo){
		  LoginVO dd=temp.selectOne("login.selectone",vo);
		  if(dd != null) {
			  System.out.println("LoginDAO userid=  " + dd.getUserid());
			  System.out.println("LoginDAO userpwd= " + dd.getPwd());
		  }
		  return dd;
	 }//end

 
}//LoginDAO end
