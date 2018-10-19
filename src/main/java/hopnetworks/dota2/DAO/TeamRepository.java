package hopnetworks.dota2.DAO;

import hopnetworks.dota2.domain.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team, String> {



        }
