package hanoi.example.dao.Impl;

import hanoi.example.dao.derivativeDAO;
import hanoi.example.model.derivative;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Component("derivative")
public class derivativeDAOImpl implements derivativeDAO {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<derivative> GetDerivativeByCode(List<String> codes, String sort, int start, int size) {
        Session session = sessionFactory.getObject().openSession();
        String SQL_Query = "from derivative ";
        if (codes.size() == 0 && sort == null) {
            Query query = session.createQuery(SQL_Query);
//            query.setFirstResult(start);
//            query.setMaxResults(size);
            return (List<derivative>) query.list();
        } else if (codes.size() == 0) {
            Query query = session.createQuery(SQL_Query + " d order by d.code " + sort);
//            query.setFirstResult(start);
//            query.setMaxResults(size);
            return (List<derivative>) query.list();
        } else if (sort == null) {
            Query query = session.createQuery(SQL_Query + " where code in (:paramcode)");
            query.setParameter("paramcode", codes);
//            query.setFirstResult(start);
//            query.setMaxResults(size);
            return (List<derivative>) query.list();
        } else {
            Query query = session.createQuery(SQL_Query + " d where code in (:paramcode) order by d.code " + sort);
            query.setParameter("paramcode", codes);
//            query.setFirstResult(start);
//            query.setMaxResults(size);
            return (List<derivative>) query.list();
        }

    }

    public int totalPages(int totalElements, int size) {
        int totalPages = 0;
        if (totalElements % size == 0) {
            totalPages = totalElements / size;
        } else {
            totalPages = totalElements / size + 1;
        }
        return totalPages;
    }

}
