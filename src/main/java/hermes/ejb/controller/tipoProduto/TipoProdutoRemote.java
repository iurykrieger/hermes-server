package hermes.ejb.controller.tipoProduto;

import hermes.ejb.entidades.TipoProduto;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author iury
 */
@Remote
public interface TipoProdutoRemote {

    public TipoProduto cadastraTipoProduto(TipoProduto tipoproduto);

    public List<TipoProduto> consultaTipoProdutos();
}
