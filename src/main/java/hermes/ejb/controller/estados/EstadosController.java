package hermes.ejb.controller.estados;

import hermes.ejb.entidades.Cidades;
import hermes.ejb.entidades.Cidades_;
import hermes.ejb.entidades.Estados;
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
@Stateless(mappedName = "ejb/controlaEstados/ControlaEstados")
public class EstadosController extends Persist implements EstadosRemote {

    @Override
    public List<Estados> consultaEstados() {
        try {
            List<Estados> estados;
            estados = consultarObjetos(Estados.class);
            return estados;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<Cidades> consultarCidades() {
        try {
            List<Cidades> cidades;
            cidades = consultarObjetos(Cidades.class);
            return cidades;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<Cidades> consultarCidadesByEstado(Estados estado) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery();
            Root<Cidades> from = query.from(Cidades.class);
            query.select(from);
            query.where(cb.and(cb.equal(from.get(Cidades_.estadoId), estado)));
            return (List<Cidades>) em.createQuery(query).getResultList();
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }
}
