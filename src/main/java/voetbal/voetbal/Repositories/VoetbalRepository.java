package voetbal.voetbal.Repositories;

import org.springframework.stereotype.Repository;
import voetbal.voetbal.models.Voetbal;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class VoetbalRepository {

    private static int lastID = 1;
    private Map<Integer, Voetbal> voetbal = new HashMap<>();

    @PostConstruct
    public void addSoccerPlayers(){
        for(int i=0; i < 5; i++){
            Voetbal voetbal = new Voetbal();
            voetbal.setPlayerName("Ronaldo");
            this.save(voetbal);
        }
    }

    //Create
    public void save(Voetbal newVoetbal){
        newVoetbal.setId(lastID++);
        this.voetbal.put(newVoetbal.getId(), newVoetbal);
    }

    //Read
    public Collection<Voetbal> findAll(){
        return this.voetbal.values();
    }

    //Read 1 soccerGame
    public Voetbal findById(int id){
        Voetbal find = this.voetbal.get(id);
        return find;
    }

    //Update
    public Voetbal update(int id, Voetbal update){
        Voetbal victim = this.findById(id);
        victim.setPlayerName(update.getPlayerName());
        victim.setHomeTeam(update.getHomeTeam());
        victim.setAwayTeam(update.getAwayTeam());
        victim.setGoal(update.getGoal());
        return victim;
    }

    //Delete
    public void deleteGameById(int id){
        this.voetbal.remove(id);
    }
}
