package in.mnp200002.chatsApi.service;

import java.util.List;

import in.mnp200002.chatsApi.model.Chat;

public interface ChatServiceInterface {
	
	List<Chat> getChat(String sub_id);

	void addMessage(Chat chat, String sub_id);

}
