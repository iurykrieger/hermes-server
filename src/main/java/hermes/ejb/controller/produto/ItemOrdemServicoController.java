package hermes.ejb.controller.produto;

import hermes.ejb.entidades.ItemOrdemServico;
import hermes.ejb.entidades.ItemOrdemServico_;
import hermes.ejb.entidades.OrdemDeServico;
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
@Stateless(mappedName = "ejb/controlaItemOrdemServico/ControlaItemOrdemServico")
public class ItemOrdemServicoController extends Persist implements ItemOrdemServicoRemote {

    @Override
    public ItemOrdemServico cadastraItemOrdemServico(ItemOrdemServico item) {
        try {
            ItemOrdemServico i;
            i = (ItemOrdemServico) inserirObjeto(item);
            return i;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<ItemOrdemServico> consultaItensOrdemServico() {
        try {
            List<ItemOrdemServico> itens;
            itens = consultarObjetos(ItemOrdemServico.class);
            return itens;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }

    }

    @Override
    public List<ItemOrdemServico> consultaItensOrdemServicoByOrdemServico(OrdemDeServico os) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery();
            Root<ItemOrdemServico> from = query.from(ItemOrdemServico.class);
            query.select(from);
            query.where(cb.and(cb.equal(from.get(ItemOrdemServico_.idOrdemServico), os)));
            return (List<ItemOrdemServico>) em.createQuery(query).getResultList();
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }
}
