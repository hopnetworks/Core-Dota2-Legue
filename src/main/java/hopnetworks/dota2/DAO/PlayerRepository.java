package hopnetworks.dota2.DAO;

import hopnetworks.dota2.domain.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

     Player findByTeamId(int teamId);
    Player findByAccountId(int account_id);


}
