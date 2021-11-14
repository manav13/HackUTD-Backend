package in.mnp200002.chatsApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mnp200002.chatsApi.model.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {
	
}
