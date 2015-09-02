package hermes.ejb.controller.cliente;

import hermes.ejb.entidades.Cliente;
import hermes.ejb.entidades.ClienteInfo;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author iury
 */
@Remote
public interface ClienteRemote {

    public Cliente cadastraCliente(Cliente cliente);

    public List<Cliente> consultaClientes();

    public ClienteInfo cadastraClienteInfo(ClienteInfo cliente);

    public List<ClienteInfo> consultaClienteInfos();

    public List<ClienteInfo> consultaClienteInfoByIdAtivo();

    public void setClienteInfosInactive(Cliente c);

    public ClienteInfo getClienteInfoByCliente(Cliente c);
}
