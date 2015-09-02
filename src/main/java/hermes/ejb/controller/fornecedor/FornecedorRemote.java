package hermes.ejb.controller.fornecedor;

import hermes.ejb.entidades.Fornecedor;
import hermes.ejb.entidades.FornecedorInfo;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author iury
 */
@Remote
public interface FornecedorRemote {

    public Fornecedor cadastraFornecedor(Fornecedor fornecedor);

    public List<Fornecedor> consultaFornecedores();

    public FornecedorInfo cadastraFornecedorInfo(FornecedorInfo fornecedor);

    public List<FornecedorInfo> consultaFornecedorInfos();

    public List<FornecedorInfo> consultaFornecedorInfoByIdAtivo();

    public void setFornecedorInfosInactive(Fornecedor c);

}
