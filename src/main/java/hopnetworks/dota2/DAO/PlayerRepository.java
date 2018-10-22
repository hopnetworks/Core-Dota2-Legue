package hopnetworks.dota2.DAO;

import hopnetworks.dota2.domain.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, String> {

     Player findByTeamId(int teamId);
    Player findByAccountId(int account_id);


}
