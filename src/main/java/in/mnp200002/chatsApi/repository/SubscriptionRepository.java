package in.mnp200002.chatsApi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import in.mnp200002.chatsApi.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

	@Query("SELECT c FROM Subscription c WHERE c.sub_id = ?1")
	List<Subscription> findBySubId(String sub_id);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Subscription s WHERE s.sub_id = ?1 AND s.user_id = ?2")
	void deleteByUserId(String sub_id, Integer user_id);

}
