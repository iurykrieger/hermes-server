package hermes.ejb.controller.mecanico;

import hermes.ejb.entidades.Mecanico;
import hermes.ejb.entidades.MecanicoInfo;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author iury
 */
@Remote
public interface MecanicoRemote {

    public Mecanico cadastraMecanico(Mecanico mecanico);

    public List<Mecanico> consultaMecanicos();

    public MecanicoInfo cadastraMecanicoInfo(MecanicoInfo mecanicoinfo);

    public List<MecanicoInfo> consultaMecanicoInfos();

    public List<MecanicoInfo> consultaMecanicoInfoByIdAtivo();

    public void setMecanicoInfosInactive(Mecanico m);

    public MecanicoInfo consultaMecanicoInfoByMecanico(Mecanico m);
}
