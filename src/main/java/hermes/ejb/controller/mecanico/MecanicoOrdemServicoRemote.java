package hermes.ejb.controller.mecanico;

import hermes.ejb.entidades.MecanicoOrdemServico;
import hermes.ejb.entidades.OrdemDeServico;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author iury
 */
@Remote
public interface MecanicoOrdemServicoRemote {

    public MecanicoOrdemServico cadastraMecanicoOrdemServico(MecanicoOrdemServico mecanico);

    public List<MecanicoOrdemServico> consultaMecanicosOrdemServico();

    public List<MecanicoOrdemServico> consultaMecanicosOrdemServicoByOrdemServico(OrdemDeServico os);
}
