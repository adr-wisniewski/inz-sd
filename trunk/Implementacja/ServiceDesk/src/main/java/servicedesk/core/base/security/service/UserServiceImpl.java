/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.base.security.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicedesk.core.base.security.dao.UserDao;
import servicedesk.core.base.security.domain.User;

/**
 *
 * @author Adrian
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public User getByLogin(String login) {
        return dao.getByLogin(login);
    }

    @Override
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    public User load(Integer id) {
        return dao.load(id);   
    }

    @Override
    public User get(Integer id) {
        return dao.get(id);
    }
}
