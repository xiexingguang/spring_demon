import com.spencer.ioc.UserDaoInterface;

/**
 * Created by 沾雨 on 2017/7/5 上午10:21
 */
public class UserDao implements UserDaoInterface {
    public void add() {
        System.out.println("dao add");

    }

    public void update() {
        System.out.println("update dao");
    }

    public void select() {
        System.out.println("select dao");
    }
}
