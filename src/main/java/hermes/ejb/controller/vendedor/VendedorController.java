/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hermes.ejb.controller.vendedor;

import hermes.ejb.entidades.Vendedor;
import hermes.ejb.entidades.VendedorInfo;
import hermes.ejb.utils.Persist;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author iury
 */
@Stateless(mappedName = "ejb/controlaVendedor/ControlaVendedor")
public class VendedorController extends Persist implements VendedorRemote {

    @Override
    public Vendedor cadastraVendedor(Vendedor vendedor) {
        try {
            Vendedor m;
            m = (Vendedor) inserirObjeto(vendedor);
            return m;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<Vendedor> consultaVendedores() {
        try {
            List<Vendedor> vendedores;
            vendedores = consultarObjetos(Vendedor.class);
            return vendedores;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public VendedorInfo cadastraVendedorInfo(VendedorInfo vendedorinfo) {
        try {
            VendedorInfo mi;
            mi = (VendedorInfo) inserirObjeto(vendedorinfo);
            return mi;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<VendedorInfo> consultaVendedorInfos() {
        try {
            List<VendedorInfo> vendedores;
            vendedores = consultarObjetos(VendedorInfo.class);
            return vendedores;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }
}
