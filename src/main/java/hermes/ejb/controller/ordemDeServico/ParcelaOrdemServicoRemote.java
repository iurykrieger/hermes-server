package hermes.ejb.controller.ordemDeServico;

import hermes.ejb.entidades.OrdemDeServico;
import hermes.ejb.entidades.ParcelaOdemDeServico;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author iury
 */
@Remote
public interface ParcelaOrdemServicoRemote {

    public ParcelaOdemDeServico cadastraOrdemDeServico(ParcelaOdemDeServico pos);

    public List<ParcelaOdemDeServico> consultaParcelasByOrdemDeServico(OrdemDeServico os);
    
    public void removeAllParcelasByOrdemDeServico(OrdemDeServico os);
}
