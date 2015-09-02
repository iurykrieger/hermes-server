package hermes.ejb.controller.ordemDeServico;

import hermes.ejb.entidades.OrdemDeServico;
import hermes.ejb.entidades.OrdemDeServico_;
import hermes.ejb.utils.Persist;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author iury
 */
@Stateless(mappedName = "ejb/controlaOrdemDeServico/ControlaOrdemDeServico")
public class OrdemDeServicoController extends Persist implements OrdemDeServicoRemote {

    @Override
    public OrdemDeServico cadastraOrdemDeServico(OrdemDeServico os) {
        try {
            OrdemDeServico ods;
            ods = (OrdemDeServico) inserirObjeto(os);
            return ods;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<OrdemDeServico> consultaOrdemDeServicos() {
        try {
            List<OrdemDeServico> os;
            os = consultarObjetos(OrdemDeServico.class);
            return os;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<OrdemDeServico> consultaOrdemDeServicoByNotPayed() {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery();
            Root<OrdemDeServico> from = query.from(OrdemDeServico.class);
            query.select(from);
            query.where(cb.and(cb.equal(from.get(OrdemDeServico_.pago), false)));
            query.orderBy(cb.asc(from.get(OrdemDeServico_.idOrdemServico)));
            List<OrdemDeServico> lista = (List<OrdemDeServico>) em.createQuery(query).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }
}
