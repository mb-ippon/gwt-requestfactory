package com.ippon.formation.gwt.server.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.ippon.formation.gwt.server.util.HibernateUtil;

public class RFHibernateServlet extends RequestFactoryServlet {

    /**
     * 
     */
    private static final long serialVersionUID = -9142772473004371013L;

    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            super.service(arg0, arg1);
            session.getTransaction().commit();
        }
        catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
}
