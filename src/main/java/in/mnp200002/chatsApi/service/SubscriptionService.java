package in.mnp200002.chatsApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mnp200002.chatsApi.model.Subscription;
import in.mnp200002.chatsApi.repository.SubscriptionRepository;

@Service
public class SubscriptionService implements SubscriptionServiceInterface {

	public final SubscriptionRepository subscriptionRepository;
	
	@Autowired
	public SubscriptionService(SubscriptionRepository subscriptionRepository) {
		this.subscriptionRepository = subscriptionRepository;
	}

	public void join(Subscription subs) {
		subscriptionRepository.save(subs);
	}
	
	public List<Subscription> getSubs(String sub_id) {
		return subscriptionRepository.findBySubId(sub_id);
	}

	public void unSubscribe(String sub_id, Integer user_id) {
		
		subscriptionRepository.deleteByUserId(sub_id, user_id);
		
	}
	
}
