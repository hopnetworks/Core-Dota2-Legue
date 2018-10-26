package hopnetworks.dota2.DAO;

import hopnetworks.dota2.domain.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository  extends MongoRepository<Match, String> {


    Match findByMatchId(int matchId);


}
