package hermes.ejb.controller.produto;

import hermes.ejb.entidades.ItemExternoOrdemServico;
import hermes.ejb.entidades.OrdemDeServico;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author iury
 */
@Remote
public interface ItemExternoRemote {

    public ItemExternoOrdemServico cadastraItemExterno(ItemExternoOrdemServico item);

    public List<ItemExternoOrdemServico> consultaItensExternos();

    public List<ItemExternoOrdemServico> consultaItensExternosByOrdemServico(OrdemDeServico os);

}
