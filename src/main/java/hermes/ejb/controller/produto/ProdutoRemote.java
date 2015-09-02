package hermes.ejb.controller.produto;

import hermes.ejb.entidades.Aplicacao;
import hermes.ejb.entidades.Descricao;
import hermes.ejb.entidades.Estoque;
import hermes.ejb.entidades.Produto;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author iury
 */
@Remote
public interface ProdutoRemote {

    public Produto cadastraProduto(Produto produto);

    public List<Produto> consultaProdutos();

    public Estoque cadastraEstoque(Estoque estoque);

    public List<Estoque> consultaEstoques();

    public List<Estoque> consultaEstoquesByIdAtivo();

    public void setEstoquesInactive(Produto p);

    public Descricao cadastraDescricao(Descricao descricao);

    public Aplicacao cadastraAplicacao(Aplicacao aplicacao);

    public List<Descricao> getDescricoesByProduto(Produto p);

    public List<Aplicacao> getAplicacoesByProduto(Produto p);

    public List<Estoque> consultaValidIdAtivoEstoques();

    public Estoque consultaEstoqueByProduto(Produto p);
}
