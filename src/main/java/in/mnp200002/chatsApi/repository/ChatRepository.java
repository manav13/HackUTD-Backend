package in.mnp200002.chatsApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.mnp200002.chatsApi.model.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
	
	
	@Query("SELECT c FROM Chat c WHERE c.sub_id = ?1")
	public List<Chat> findChatBySubId(String sub_id);
	
}
