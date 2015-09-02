package hermes.ejb.controller.produto;

import hermes.ejb.entidades.ItemExternoOrdemServico;
import hermes.ejb.entidades.ItemExternoOrdemServico_;
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
@Stateless(mappedName = "ejb/controlaItemExterno/ControlaItemExterno")
public class ItemExternoController extends Persist implements ItemExternoRemote {

    @Override
    public ItemExternoOrdemServico cadastraItemExterno(ItemExternoOrdemServico item) {
        try {
            ItemExternoOrdemServico i;
            i = (ItemExternoOrdemServico) inserirObjeto(item);
            return i;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<ItemExternoOrdemServico> consultaItensExternos() {
        try {
            List<ItemExternoOrdemServico> itens;
            itens = consultarObjetos(ItemExternoOrdemServico.class);
            return itens;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<ItemExternoOrdemServico> consultaItensExternosByOrdemServico(OrdemDeServico os) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery();
            Root<ItemExternoOrdemServico> from = query.from(ItemExternoOrdemServico.class);
            query.select(from);
            query.where(cb.and(cb.equal(from.get(ItemExternoOrdemServico_.idOrdemServico), os)));
            return (List<ItemExternoOrdemServico>) em.createQuery(query).getResultList();
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }
}
