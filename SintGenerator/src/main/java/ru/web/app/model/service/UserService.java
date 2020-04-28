package ru.web.app.model.service;

import ru.web.app.model.dao.UserDao;
import ru.web.app.model.dao.exception.DAOException;
import ru.web.app.model.dao.impl.UserDaoImpl;
import ru.web.app.model.pojo.User;

import java.util.List;

public final class UserService {

    /**
     * UserService class's instance.
     */
    private static UserService instance;

    /**
     * private constructor.
     */
    private UserService() {

    }

    /**
     * getter UserService class's instance.
     * @return
     */
    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }

        return instance;
    }

    /**
     * craete new user.
     * @param user
     * @return generated key
     */
    public Integer createUser(final User user) {
        UserDao dao = UserDaoImpl.getInstance();
        Integer id = null;

        try {
            id = dao.createUser(user);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        return id;
    }

    /**
     * @param id
     * @return user by unding id
     */
    public User getUserById(final Integer id) {
        UserDao dao = UserDaoImpl.getInstance();
        User user = null;

        try {
            user = dao.getUserById(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * @return all users from db.
     */
    public List<User> getAllUsers() {
        UserDao dao = UserDaoImpl.getInstance();
        List<User> users = null;

        try {
            users = dao.getAllUsers();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        return users;
    }

    /**
     * changes user's name.
     * @param login
     * @param password
     * @param newName
     */
    public void updateUserName(final String login,
                               final String password,
                               final String newName) {
        UserDao dao = UserDaoImpl.getInstance();

        try {
            dao.updateUserName(login, password, newName);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    /**
     * changes user's password.
     * @param login
     * @param password
     * @param newPassword
     */
    public void updateUserPassword(final String login,
                                   final String password,
                                   final String newPassword) {
        UserDao dao = UserDaoImpl.getInstance();

        try {
            dao.updateUserPassword(login, password, newPassword);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
