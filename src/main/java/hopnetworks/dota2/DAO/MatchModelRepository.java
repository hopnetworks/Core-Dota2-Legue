package hopnetworks.dota2.DAO;

import hopnetworks.dota2.domain.MatchModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchModelRepository extends MongoRepository<MatchModel, String> {



}
