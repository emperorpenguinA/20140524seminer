package data;

import data.dao.MessageDao;
import data.dao.UserDao;
import data.dao.entity.Message;
import data.dao.entity.User;

public class Sample {
    public static void main(String[] args) {
        UserDao dao = new UserDao();
        User user = dao.selectByPrimaryKey(1);
        System.out.println(user.getInsertTime());
        MessageDao dao2 = new MessageDao();
        Message in = new Message();
        in.setUserId(1);
        in.setContent("test");
        dao2.insert(in);
        Message message = dao2.selectByPrimaryKey(1);
        System.out.println(message);
    }
}
