package hopnetworks.dota2.DAO;

import hopnetworks.dota2.domain.Player;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

     List<Player> findByTeamId(ObjectId teamId);
    Player findByAccountId(int account_id);


}
