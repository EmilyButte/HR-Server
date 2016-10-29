package butte.emily.hrproject.repository;

import butte.emily.hrproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RepositoryRestResource(collectionResourceRel = "users", path = "timecarddb")
public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByUserName(@Param("user_name") String string);
    //List<User> findByUserId(@Param("id") Long id);
}
