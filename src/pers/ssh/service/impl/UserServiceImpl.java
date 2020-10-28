package pers.ssh.service.impl;

import org.springframework.transaction.annotation.Transactional;
import pers.ssh.dao.UserDao;
import pers.ssh.domain.User;
import pers.ssh.service.UserService;
import pers.ssh.utils.MD5Utils;


@Transactional
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(User user) {
        user.setPassword(MD5Utils.text2md5(user.getPassword()));
        return userDao.login(user);
    }

}
