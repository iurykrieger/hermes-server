package hermes.ejb.controller.vendedor;

import hermes.ejb.entidades.Vendedor;
import hermes.ejb.entidades.VendedorInfo;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author iury
 */
@Remote
public interface VendedorRemote {

    public Vendedor cadastraVendedor(Vendedor vendedor);

    public List<Vendedor> consultaVendedores();

    public VendedorInfo cadastraVendedorInfo(VendedorInfo vendedorinfo);

    public List<VendedorInfo> consultaVendedorInfos();

}
