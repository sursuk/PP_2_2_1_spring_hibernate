package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CarDaoImp implements CarDao{

    @Autowired
    private SessionFactory sessionFactory;
    public List getUsersByCar(String model, int series) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User where car in (from Car where model = :model and series = :series)")
                .setParameter("model", model)
                .setParameter("series", series);
        return query.getResultList();
    }
}
