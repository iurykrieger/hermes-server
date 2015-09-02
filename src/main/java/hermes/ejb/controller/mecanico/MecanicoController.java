package hermes.ejb.controller.mecanico;

import hermes.ejb.entidades.Mecanico;
import hermes.ejb.entidades.MecanicoInfo;
import hermes.ejb.entidades.MecanicoInfo_;
import hermes.ejb.utils.Persist;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

/**
 *
 * @author iury
 */
@Stateless(mappedName = "ejb/controlaMecanico/ControlaMecanico")
public class MecanicoController extends Persist implements MecanicoRemote {

    @Override
    public Mecanico cadastraMecanico(Mecanico mecanico) {
        try {
            Mecanico m;
            m = (Mecanico) inserirObjeto(mecanico);
            return m;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<Mecanico> consultaMecanicos() {
        try {
            List<Mecanico> mecanicos;
            mecanicos = consultarObjetos(Mecanico.class);
            return mecanicos;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public MecanicoInfo cadastraMecanicoInfo(MecanicoInfo mecanicoinfo) {
        try {
            MecanicoInfo mi;
            mi = (MecanicoInfo) inserirObjeto(mecanicoinfo);
            return mi;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<MecanicoInfo> consultaMecanicoInfos() {
        try {
            List<MecanicoInfo> mecanicos;
            mecanicos = consultarObjetos(MecanicoInfo.class);
            return mecanicos;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<MecanicoInfo> consultaMecanicoInfoByIdAtivo() {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery();
            Root<MecanicoInfo> from = query.from(MecanicoInfo.class);
            query.select(from);
            query.where(cb.and(cb.equal(from.get(MecanicoInfo_.idAtivo), true)));
            return (List<MecanicoInfo>) em.createQuery(query).getResultList();
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public MecanicoInfo consultaMecanicoInfoByMecanico(Mecanico m) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery();
            Root<MecanicoInfo> from = query.from(MecanicoInfo.class);
            query.select(from);
            query.where(cb.and(cb.equal(from.get(MecanicoInfo_.idAtivo), true), cb.equal(from.get(MecanicoInfo_.idMecanico), m)));
            return (MecanicoInfo) em.createQuery(query).getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public void setMecanicoInfosInactive(Mecanico m) {
        try {
            em.getTransaction().begin();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaUpdate update = cb.createCriteriaUpdate(MecanicoInfo.class);
            Root<MecanicoInfo> e = update.from(MecanicoInfo.class);
            update.set(MecanicoInfo_.idAtivo, false);
            update.where(cb.equal(e.get(MecanicoInfo_.idMecanico), m));
            Query query = em.createQuery(update);
            int rowCount = query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

}
