package hermes.ejb.controller.equipamento;

import hermes.ejb.entidades.Cliente;
import hermes.ejb.entidades.Equipamento;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface EquipamentoRemote {

    public List<Cliente> consultaClientes();

    public Equipamento cadastraEquipamento(Equipamento equipamento);

    public List<Equipamento> getEquipamentosByCliente(Cliente c);
}
