package butte.emily.hrproject.repository;

import butte.emily.hrproject.domain.TimeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//goes to DB and return a timecard object

@Transactional
@RepositoryRestResource(path = "timecarddb", collectionResourceRel = "time_cards")
public interface TimeCardRepository extends JpaRepository<TimeCard, Long> {

    List<TimeCard> findByUserId(@Param("user_id") long id);
}
