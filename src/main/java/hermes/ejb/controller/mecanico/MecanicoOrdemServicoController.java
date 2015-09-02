package hermes.ejb.controller.mecanico;

import hermes.ejb.entidades.MecanicoOrdemServico;
import hermes.ejb.entidades.MecanicoOrdemServico_;
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
@Stateless(mappedName = "ejb/controlaMecanicoOrdemServico/ControlaMecanicoOrdemServico")
public class MecanicoOrdemServicoController extends Persist implements MecanicoOrdemServicoRemote {

    @Override
    public MecanicoOrdemServico cadastraMecanicoOrdemServico(MecanicoOrdemServico mecanico) {
        try {
            MecanicoOrdemServico m;
            m = (MecanicoOrdemServico) inserirObjeto(mecanico);
            return m;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<MecanicoOrdemServico> consultaMecanicosOrdemServico() {
        try {
            List<MecanicoOrdemServico> mecanicos;
            mecanicos = consultarObjetos(MecanicoOrdemServico.class);
            return mecanicos;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<MecanicoOrdemServico> consultaMecanicosOrdemServicoByOrdemServico(OrdemDeServico os) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery();
            Root<MecanicoOrdemServico> from = query.from(MecanicoOrdemServico.class);
            query.select(from);
            query.where(cb.and(cb.equal(from.get(MecanicoOrdemServico_.idOrdemServico), os)));
            return (List<MecanicoOrdemServico>) em.createQuery(query).getResultList();
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }
}
