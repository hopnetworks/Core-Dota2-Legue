package hopnetworks.dota2.DAO;

import hopnetworks.dota2.domain.Team;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<Team, String> {

        Team  findByTeamId(ObjectId teamId);
        }
