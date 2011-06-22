/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicedesk.infrastructure.security.dao.UserDao;
import servicedesk.infrastructure.security.domain.User;

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
}
