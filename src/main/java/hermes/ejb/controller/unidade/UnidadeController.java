package hermes.ejb.controller.unidade;

import hermes.ejb.entidades.Unidade;
import hermes.ejb.utils.Persist;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author iury
 */
@Stateless(mappedName = "ejb/controlaUnidade/ControlaUnidade")
public class UnidadeController extends Persist implements UnidadeRemote {

    @Override
    public Unidade cadastraUnidade(Unidade unidade) {
        try {
            Unidade c;
            c = (Unidade) inserirObjeto(unidade);
            return c;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<Unidade> consultaUnidades() {
        try {
            List<Unidade> unidades;
            unidades = consultarObjetos(Unidade.class);
            return unidades;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }
}
