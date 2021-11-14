package in.mnp200002.chatsApi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import in.mnp200002.chatsApi.model.Chat;
import in.mnp200002.chatsApi.model.FinalChat;
import in.mnp200002.chatsApi.model.IsJoin;
import in.mnp200002.chatsApi.model.Login;
import in.mnp200002.chatsApi.model.Subscription;
import in.mnp200002.chatsApi.model.UserStatus;
import in.mnp200002.chatsApi.service.ChatService;
import in.mnp200002.chatsApi.service.LoginService;
import in.mnp200002.chatsApi.service.SubscriptionService;
import in.mnp200002.chatsApi.service.UserService;

@CrossOrigin(origins = "*")
@RestController
public class MasterController {
	
	private final ChatService chatService;
	private final UserService userService;
	private final LoginService loginService;
	private final SubscriptionService subscriptionService;
	
	@Bean
	public WebMvcConfigurer configure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/*").allowedOrigins("*");
			}
			
		};
	}
	
	@Autowired
	public MasterController(ChatService chatService, UserService userService, LoginService loginService, SubscriptionService subscriptionService) {
		this.chatService = chatService;
		this.userService = userService;
		this.loginService = loginService;
		this.subscriptionService = subscriptionService;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/chat/{id}")
	public List<FinalChat> getChat(@PathVariable(value="id") String id) {
		List<Chat> chat = chatService.getChat(id);
		List<FinalChat> result = new ArrayList<FinalChat>();
		for(int i=0; i<chat.size(); i++) {
			FinalChat fchat = new FinalChat();
			String user_name = userService.getUserName(chat.get(i).getUser_id());
			fchat.setIs_sent(chat.get(i).getIs_sent());
			fchat.setMsg(chat.get(i).getMsg());
			fchat.setMsg_id(chat.get(i).getMsg_id());
			fchat.setName(user_name);
			fchat.setSub_id(chat.get(i).getSub_id());
			fchat.setTime_stamp(chat.get(i).getTime_stamp());
			fchat.setUser_id(chat.get(i).getUser_id());
			
			result.add(fchat);
		}
		return result;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, value="/chat/addMessage")
	public void addMessage(@RequestBody Chat chat) {
		String sub_id = chat.getSub_id();	
		chatService.addMessage(chat, sub_id);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, value="/chat/userAuth")
	public UserStatus login(@RequestBody Login login) {
		UserStatus status = new UserStatus();
		status.setStatus("failed");
		status.setName("");
		status.setUser_id(login.getUser_id());
		if(loginService.authorize(login)) {
			status.setName(userService.getUserName(login.getUser_id()));
			status.setStatus("200 Success");
		}
		return status;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, value="/chat/join")
	public void subscribe(@RequestBody Subscription subs) {
		subscriptionService.join(subs);
	}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.GET, value="/chat/checkJoin/{id1}/{id2}")
	public IsJoin checkSubscription(@PathVariable(value="id1") String id1, @PathVariable(value="id2") Integer id2) {
		List<Subscription> users = subscriptionService.getSubs(id1);
		IsJoin result = new IsJoin();
		result.setJoin(false);
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).getUser_id().equals(id2)) {
				result.setJoin(true);
				break;
			}
		}
		return result;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.DELETE, value="/chat/disJoin/{id1}/{id2}")
	public void deleteSubscription(@PathVariable(value="id1") String id1, @PathVariable(value="id2") Integer id2) {
		subscriptionService.unSubscribe(id1, id2);
	}
}
