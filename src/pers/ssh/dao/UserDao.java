package pers.ssh.dao;
import pers.ssh.domain.User;


public interface UserDao {
    public User login(User user);
}
