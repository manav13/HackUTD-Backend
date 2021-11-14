package in.mnp200002.chatsApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.mnp200002.chatsApi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
