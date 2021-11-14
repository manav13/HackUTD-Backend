package in.mnp200002.chatsApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mnp200002.chatsApi.model.Chat;
import in.mnp200002.chatsApi.repository.ChatRepository;


@Service
public class ChatService implements ChatServiceInterface {

	public final ChatRepository chatRepository;
	
	@Autowired
	public ChatService(ChatRepository chatRepository) {
		this.chatRepository = chatRepository;
	}
	
	@Override
	public List<Chat> getChat(String sub_id) {
		return chatRepository.findChatBySubId(sub_id);
	}
	
	@Override
	public void addMessage(Chat chat, String sub_id) {
		chatRepository.save(chat);
	}

}
