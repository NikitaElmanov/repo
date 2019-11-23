package ru.web.app.dao.impl;

import org.junit.Assert;
import org.junit.Test;
import ru.web.app.dao.exception.DAOException;

public class UserDaoImplTest {

    @Test
    public void checkGettingAllUsers(){
        try {
            Assert.assertNotNull(UserDaoImpl.getInstance().getAllUsers());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

}