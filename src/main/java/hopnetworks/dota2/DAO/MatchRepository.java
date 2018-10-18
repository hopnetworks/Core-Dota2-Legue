package hopnetworks.dota2.DAO;

import hopnetworks.dota2.domain.Match;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchRepository  extends MongoRepository<Match, String> {





}
