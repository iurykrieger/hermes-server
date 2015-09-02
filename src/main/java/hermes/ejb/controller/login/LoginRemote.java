package hermes.ejb.controller.login;

import hermes.ejb.entidades.VendedorInfo;
import javax.ejb.Remote;

/**
 *
 * @author iury
 */
@Remote
public interface LoginRemote {

    VendedorInfo verificaVendedor(String usuario, String senha);

    VendedorInfo testConnection();
}
