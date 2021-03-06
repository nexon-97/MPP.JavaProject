package com.dao.impl;
import com.dao.BaseDAO;
import com.dao.DocumentDAO;
import com.model.Document;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DocumentDAOImpl extends BaseDAO implements DocumentDAO {
    @Override
    public Document getDocumentByID(int id) {
        Document document = null;
        Session session = getSessionFactory().openSession();
        if (session != null) {
            try{
                Transaction tx = session.beginTransaction();
                document = (Document)session.get(Document.class, id);
                tx.commit();
            }
            catch (HibernateException e){
                e.printStackTrace();
            } finally {
                closeSession();
            }
        }
       return document;
    }

    @Override
    public boolean updateDocument(Document document) {
        Session session = getSessionFactory().openSession();
        if (session != null) {
            try {
                Transaction tx = session.beginTransaction();
                session.update(document);
                tx.commit();
            } catch (HibernateException e) {
                return false;
            } finally {
                closeSession();
            }
        }

        return true;
    }

    @Override
    public boolean deleteDocument(Document document) {
        Session session = getSessionFactory().openSession();
        if (session != null) {
            try {
                Transaction tx = session.beginTransaction();
                session.delete(document);
                tx.commit();
            }
            catch (HibernateException e){
                return false;
            } finally {
                closeSession();
            }
        }

        return true;
    }

    @Override
    public boolean addDocument(Document document) {
        Session session = getSessionFactory().openSession();
        if (session != null) {
            try {
                Transaction tx = session.beginTransaction();
                session.save(document);
                tx.commit();
            } catch (HibernateException e) {
                System.out.println(e.getMessage());
                return false;
            } finally {
                closeSession();
            }
        }

        return true;
    }

}
