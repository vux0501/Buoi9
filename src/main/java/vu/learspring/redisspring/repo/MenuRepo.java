package but.learspring.redisspring.repo;

import but.learspring.redisspring.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuRepo {
    public static final  String HASH_KEY_NAME = "MENU_ITEM";

    @Autowired
    private RedisTemplate redisTemplate;

    public Menu saveMenu(Menu menu){
        // SETS menu object in MENU-ITEM hashmap at menuId key
        redisTemplate.opsForHash().put(HASH_KEY_NAME,menu.getId(),menu);
        return menu;
    }
    public List<Menu> findAll(){
        //GET all menu values
        return redisTemplate.opsForHash().values(HASH_KEY_NAME);
    }
    public Menu findItemById(int id){
        // GET menu object from MENU-ITEM hashmap by menuId key
        return (Menu) redisTemplate.opsForHash().get(HASH_KEY_NAME,id);
    }
    public String deleteMenu(int id){
        // DELETE the hashkey by menuId from MENU-ITEM hashmap
        redisTemplate.opsForHash().delete(HASH_KEY_NAME,id);
        return "deleted successful";
    }
}
