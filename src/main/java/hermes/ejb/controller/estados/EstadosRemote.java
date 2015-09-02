package hermes.ejb.controller.estados;

import hermes.ejb.entidades.Cidades;
import hermes.ejb.entidades.Estados;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author iury
 */
@Remote
public interface EstadosRemote {

    public List<Estados> consultaEstados();

    public List<Cidades> consultarCidades();

    public List<Cidades> consultarCidadesByEstado(Estados estado);
}
