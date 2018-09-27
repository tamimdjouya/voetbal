package voetbal.voetbal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import voetbal.voetbal.Repositories.VoetbalRepository;
import voetbal.voetbal.models.Voetbal;

import java.util.Collection;

@RestController
@RequestMapping("api/voetbal")
public class VoetbalController {

    @Autowired
    private VoetbalRepository voetbalRepository;

    @PostMapping
    public Voetbal create(@RequestBody Voetbal newVoetbal){
        this.voetbalRepository.save(newVoetbal);
        return newVoetbal;
    }

    @GetMapping
    public Collection<Voetbal> list(){
        return this.voetbalRepository.findAll();
    }

    @GetMapping("find/{id}")
    public Voetbal findById(@PathVariable int id){
        Voetbal result = this.voetbalRepository.findById(id);
        return result;
    }

    @PutMapping("update/{id}")
    public Voetbal updateById(@PathVariable int id, @RequestBody Voetbal update){
        return this.voetbalRepository.update(id, update);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable int id){
        this.voetbalRepository.deleteGameById(id);
    }
}
