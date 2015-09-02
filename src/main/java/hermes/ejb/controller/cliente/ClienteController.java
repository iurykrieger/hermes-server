package hermes.ejb.controller.cliente;

import hermes.ejb.utils.Persist;
import hermes.ejb.entidades.Cliente;
import hermes.ejb.entidades.ClienteInfo;
import hermes.ejb.entidades.ClienteInfo_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

@Stateless(mappedName = "ejb/controlaCliente/ControlaCliente")
public class ClienteController extends Persist implements ClienteRemote {

    @Override
    public Cliente cadastraCliente(Cliente cliente) {
        try {
            Cliente c;
            c = (Cliente) inserirObjeto(cliente);
            return c;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

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
    public ClienteInfo cadastraClienteInfo(ClienteInfo cliente) {
        try {
            ClienteInfo c;
            c = (ClienteInfo) inserirObjeto(cliente);
            return c;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<ClienteInfo> consultaClienteInfos() {
        try {
            List<ClienteInfo> clientes;
            clientes = consultarObjetos(ClienteInfo.class);
            return clientes;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<ClienteInfo> consultaClienteInfoByIdAtivo() {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery();
            Root<ClienteInfo> from = query.from(ClienteInfo.class);
            query.select(from);
            query.where(cb.and(cb.equal(from.get(ClienteInfo_.idAtivo), true)));
            query.orderBy(cb.asc(from.get(ClienteInfo_.idCliente.getName())));
            List<ClienteInfo> lista = (List<ClienteInfo>) em.createQuery(query).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public void setClienteInfosInactive(Cliente c) {
        try {
            em.getTransaction().begin();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaUpdate update = cb.createCriteriaUpdate(ClienteInfo.class);
            Root<ClienteInfo> e = update.from(ClienteInfo.class);
            update.set(ClienteInfo_.idAtivo, false);
            update.where(cb.equal(e.get(ClienteInfo_.idCliente), c));
            Query query = em.createQuery(update);
            int rowCount = query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    @Override
    public ClienteInfo getClienteInfoByCliente(Cliente c) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery();
            Root<ClienteInfo> from = query.from(ClienteInfo.class);
            query.select(from);
            query.where(cb.and(cb.equal(from.get(ClienteInfo_.idCliente), c), cb.equal(from.get(ClienteInfo_.idAtivo), true)));
            ClienteInfo ci = (ClienteInfo) em.createQuery(query).getSingleResult();
            return ci;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }
}
