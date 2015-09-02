package hermes.ejb.controller.tipoProduto;

import hermes.ejb.entidades.TipoProduto;
import hermes.ejb.utils.Persist;
import java.util.List;
import javax.ejb.Stateless;

@Stateless(mappedName = "ejb/controlaTipoProduto/ControlaTipoProduto")
public class TipoProdutoController extends Persist implements TipoProdutoRemote {

    @Override
    public TipoProduto cadastraTipoProduto(TipoProduto tipoproduto) {
        try {
            TipoProduto tp;
            tp = (TipoProduto) inserirObjeto(tipoproduto);
            return tp;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<TipoProduto> consultaTipoProdutos() {
        try {
            List<TipoProduto> tipos;
            tipos = consultarObjetos(TipoProduto.class);
            return tipos;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

}
