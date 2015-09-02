package hermes.ejb.controller.produto;

import hermes.ejb.entidades.ItemOrdemServico;
import hermes.ejb.entidades.OrdemDeServico;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author iury
 */
@Remote
public interface ItemOrdemServicoRemote {

    public ItemOrdemServico cadastraItemOrdemServico(ItemOrdemServico item);

    public List<ItemOrdemServico> consultaItensOrdemServico();

    public List<ItemOrdemServico> consultaItensOrdemServicoByOrdemServico(OrdemDeServico os);
}
