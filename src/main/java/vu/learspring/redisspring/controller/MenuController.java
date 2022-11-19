package but.learspring.redisspring.controller;

import but.learspring.redisspring.entity.Menu;
import but.learspring.redisspring.repo.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuRepo repo;

    @PostMapping("/")
    public Menu saveMenu(@RequestBody Menu menu){
        return repo.saveMenu(menu);
    }
    @GetMapping("/")
    public List<Menu> getMenus(){
        return repo.findAll();
    }
    @GetMapping("/{id}")
    public Menu findMenuById(@PathVariable int id){
        return repo.findItemById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteMenu(@PathVariable int id){
        return repo.deleteMenu(id);
    }
}
