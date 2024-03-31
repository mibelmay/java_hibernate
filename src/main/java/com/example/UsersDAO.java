package com.example;

import com.example.model.UserProfile;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.sql.*;

public class UsersDAO {
    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public void insertUser(UserProfile user) {
        session.save(user);
    }

    public UserProfile getUserByLogin(String login) {
        Criteria criteria = session.createCriteria(UserProfile.class);
        return (UserProfile) criteria.add(Restrictions.eq("login", login)).uniqueResult();
    }
}

