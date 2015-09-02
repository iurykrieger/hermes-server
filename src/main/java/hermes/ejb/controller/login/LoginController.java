package hermes.ejb.controller.login;

import hermes.ejb.utils.Persist;
import hermes.ejb.entidades.VendedorInfo;
import hermes.ejb.entidades.VendedorInfo_;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author iury
 */
@Stateless(mappedName = "ejb/controlaLogin/ControlaLogin")
public class LoginController extends Persist implements LoginRemote {

    @Override
    public VendedorInfo verificaVendedor(String usuario, String senha) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery();
            Root<VendedorInfo> from = query.from(VendedorInfo.class);
            query.select(from);
            query.where(cb.and(cb.equal(from.get(VendedorInfo_.usuario), usuario)), cb.equal(from.get(VendedorInfo_.senha), senha));
            return (VendedorInfo) em.createQuery(query).getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public VendedorInfo testConnection() {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery();
            Root<VendedorInfo> from = query.from(VendedorInfo.class);
            query.select(from);
            query.where(cb.and(cb.equal(from.get(VendedorInfo_.usuario), "admin")), cb.equal(from.get(VendedorInfo_.senha), "admin"));
            return (VendedorInfo) em.createQuery(query).getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }
}
