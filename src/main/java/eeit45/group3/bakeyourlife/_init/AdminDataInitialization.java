package eeit45.group3.bakeyourlife._init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;

@Component
public class AdminDataInitialization implements ApplicationListener<ContextRefreshedEvent> {


	UserService userService;

	@Autowired
	public AdminDataInitialization(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		User user = userService.findByUserName("user");
		//建立管理員帳戶
		if(user==null) {
    		user = new User("user","user","管理者","vison919@gmail.com"
    						,"0918583187","1994-09-19","男","桃園市楊梅區中山路121巷4弄9號");
    		userService.save(user);
	}else if ("user".equals(user.getPassword())) {
		//加密密碼
		user.setPassword("user");
		userService.updateUser(user);
	}
		
	}

//    public void contextDestroyed(ServletContextEvent sce)  { 
//    }
//
//	
//    public void contextInitialized(ServletContextEvent sce)  { 
//    	//建立管理員帳戶
//    	if(!userService.userIsExist("user")) {
//    		User user = new User("user","user","管理者","vison919@gmail.com"
//    				,"0918583187","1994-09-19","男","桃園市楊梅區中山路121巷4弄9號");
//    		userService.save(user);
//    	}
//    }
//	
}
