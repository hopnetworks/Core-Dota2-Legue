package hopnetworks.dota2.DAO;

import hopnetworks.dota2.domain.MatchModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchModelRepository extends MongoRepository<MatchModel, String> {



}
