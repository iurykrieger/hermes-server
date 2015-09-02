package hermes.ejb.controller.ordemDeServico;

import hermes.ejb.entidades.OrdemDeServico;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author iury
 */
@Remote
public interface OrdemDeServicoRemote {

    public OrdemDeServico cadastraOrdemDeServico(OrdemDeServico os);

    public List<OrdemDeServico> consultaOrdemDeServicos();

    public List<OrdemDeServico> consultaOrdemDeServicoByNotPayed();
}
