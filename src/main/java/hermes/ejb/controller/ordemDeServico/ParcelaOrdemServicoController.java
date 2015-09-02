package hermes.ejb.controller.ordemDeServico;

import hermes.ejb.entidades.OrdemDeServico;
import hermes.ejb.entidades.ParcelaOdemDeServico;
import hermes.ejb.entidades.ParcelaOdemDeServico_;
import hermes.ejb.utils.Persist;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author iury
 */
@Stateless(mappedName = "ejb/controlaParcelaOrdemServico/ControlaParcelaOrdemServico")
public class ParcelaOrdemServicoController extends Persist implements ParcelaOrdemServicoRemote {

    @Override
    public ParcelaOdemDeServico cadastraOrdemDeServico(ParcelaOdemDeServico pos) {
        try {
            ParcelaOdemDeServico ods;
            ods = (ParcelaOdemDeServico) inserirObjeto(pos);
            return ods;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<ParcelaOdemDeServico> consultaParcelasByOrdemDeServico(OrdemDeServico os) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery();
            Root<ParcelaOdemDeServico> from = query.from(ParcelaOdemDeServico.class);
            query.select(from);
            query.where(cb.equal(from.get(ParcelaOdemDeServico_.idOrdemServico), os));
            List<ParcelaOdemDeServico> lista = (List<ParcelaOdemDeServico>) em.createQuery(query).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }

    }

    @Override
    public void removeAllParcelasByOrdemDeServico(OrdemDeServico os) {
        try {
            em.getTransaction().begin();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaDelete<ParcelaOdemDeServico> delete = cb.createCriteriaDelete(ParcelaOdemDeServico.class);
            Root<ParcelaOdemDeServico> from = delete.from(ParcelaOdemDeServico.class);
            delete.where(cb.equal(from.get(ParcelaOdemDeServico_.idOrdemServico), os));
            this.em.createQuery(delete).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }
}
