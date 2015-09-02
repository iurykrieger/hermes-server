package hermes.ejb.controller.equipamento;

import hermes.ejb.utils.Persist;
import hermes.ejb.entidades.Cliente;
import hermes.ejb.entidades.Equipamento;
import hermes.ejb.entidades.Equipamento_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author iury
 */
@Stateless(mappedName = "ejb/controlaEquipamento/ControlaEquipamento")
public class EquipamentoController extends Persist implements EquipamentoRemote {

    @Override
    public List<Cliente> consultaClientes() {
        try {
            List<Cliente> clientes;
            clientes = consultarObjetos(Cliente.class);
            return clientes;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public Equipamento cadastraEquipamento(Equipamento equipamento) {
        try {
            Equipamento e;
            e = (Equipamento) inserirObjeto(equipamento);
            return e;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<Equipamento> getEquipamentosByCliente(Cliente c) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery();
            Root<Equipamento> from = query.from(Equipamento.class);
            query.select(from);
            query.where(cb.equal(from.get(Equipamento_.idCliente), c));
            List<Equipamento> lista = (List<Equipamento>) em.createQuery(query).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }
}
