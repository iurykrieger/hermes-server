package hermes.ejb.controller.unidade;

import hermes.ejb.entidades.Unidade;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author iury
 */
@Remote
public interface UnidadeRemote {

    public Unidade cadastraUnidade(Unidade unidade);

    public List<Unidade> consultaUnidades();

}
