package api.api.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import api.api.persistance.entity.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findById(int id);
    List<UserEntity> findAll();
}
