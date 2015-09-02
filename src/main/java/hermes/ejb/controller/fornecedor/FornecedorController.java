package hermes.ejb.controller.fornecedor;

import hermes.ejb.entidades.Fornecedor;
import hermes.ejb.entidades.FornecedorInfo;
import hermes.ejb.entidades.FornecedorInfo_;
import hermes.ejb.utils.Persist;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

/**
 *
 * @author iury
 */
@Stateless(mappedName = "ejb/controlaFornecedor/ControlaFornecedor")
public class FornecedorController extends Persist implements FornecedorRemote {

    @Override
    public Fornecedor cadastraFornecedor(Fornecedor fornecedor) {
        try {
            Fornecedor f;
            f = (Fornecedor) inserirObjeto(fornecedor);
            return f;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<Fornecedor> consultaFornecedores() {
        try {
            List<Fornecedor> fornecedores;
            fornecedores = consultarObjetos(Fornecedor.class);
            return fornecedores;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public FornecedorInfo cadastraFornecedorInfo(FornecedorInfo fornecedor) {
        try {
            FornecedorInfo f;
            f = (FornecedorInfo) inserirObjeto(fornecedor);
            return f;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }

    }

    @Override
    public List<FornecedorInfo> consultaFornecedorInfos() {
        try {
            List<FornecedorInfo> fornecedors;
            fornecedors = consultarObjetos(FornecedorInfo.class);
            return fornecedors;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }

    }

    @Override
    public List<FornecedorInfo> consultaFornecedorInfoByIdAtivo() {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery();
            Root<FornecedorInfo> from = query.from(FornecedorInfo.class);
            query.select(from);
            query.where(cb.and(cb.equal(from.get(FornecedorInfo_.idAtivo), true)));
            query.orderBy(cb.asc(from.get(FornecedorInfo_.idFornecedor.getName())));
            List<FornecedorInfo> lista = (List<FornecedorInfo>) em.createQuery(query).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public void setFornecedorInfosInactive(Fornecedor f) {
        try {
            em.getTransaction().begin();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaUpdate update = cb.createCriteriaUpdate(FornecedorInfo.class);
            Root<FornecedorInfo> e = update.from(FornecedorInfo.class);
            update.set(FornecedorInfo_.idAtivo, false);
            update.where(cb.equal(e.get(FornecedorInfo_.idFornecedor), f));
            Query query = em.createQuery(update);
            int rowCount = query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }
}
