package hermes.ejb.controller.produto;

import hermes.ejb.entidades.Aplicacao;
import hermes.ejb.entidades.Aplicacao_;
import hermes.ejb.entidades.Descricao;
import hermes.ejb.entidades.Descricao_;
import hermes.ejb.entidades.Estoque;
import hermes.ejb.entidades.Estoque_;
import hermes.ejb.entidades.Produto;
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
@Stateless(mappedName = "ejb/controlaProduto/ControlaProduto")
public class ProdutoController extends Persist implements ProdutoRemote {

    @Override
    public Produto cadastraProduto(Produto produto) {
        try {
            Produto p;
            p = (Produto) inserirObjeto(produto);
            return p;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<Produto> consultaProdutos() {
        try {
            List<Produto> produtos;
            produtos = consultarObjetos(Produto.class);
            return produtos;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public Estoque cadastraEstoque(Estoque estoque) {
        try {
            Estoque e;
            e = (Estoque) inserirObjeto(estoque);
            return e;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<Estoque> consultaEstoques() {
        try {
            List<Estoque> estoques;
            estoques = consultarObjetos(Estoque.class);
            return estoques;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<Estoque> consultaEstoquesByIdAtivo() {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery();
            Root<Estoque> from = query.from(Estoque.class);
            query.select(from);
            query.where(cb.and(cb.equal(from.get(Estoque_.idAtivo), true)));
            return (List<Estoque>) em.createQuery(query).getResultList();
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<Estoque> consultaValidIdAtivoEstoques() {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery();
            Root<Estoque> from = query.from(Estoque.class);
            query.select(from);
            query.where(cb.and(cb.equal(from.get(Estoque_.idAtivo), true), cb.greaterThan(from.get(Estoque_.quantidade), Long.valueOf("0"))));
            return (List<Estoque>) em.createQuery(query).getResultList();
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public Estoque consultaEstoqueByProduto(Produto p) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery();
            Root<Estoque> from = query.from(Estoque.class);
            query.select(from);
            query.where(cb.and(cb.equal(from.get(Estoque_.idAtivo), true), cb.equal(from.get(Estoque_.idProduto), p)));
            return (Estoque) em.createQuery(query).getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public void setEstoquesInactive(Produto p) {
        try {
            em.getTransaction().begin();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaUpdate update = cb.createCriteriaUpdate(Estoque.class);
            Root<Estoque> e = update.from(Estoque.class);
            update.set(Estoque_.idAtivo, false);
            update.where(cb.equal(e.get(Estoque_.idProduto), p));
            Query query = em.createQuery(update);
            int rowCount = query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    @Override
    public Descricao cadastraDescricao(Descricao descricao) {
        try {
            Descricao d;
            d = (Descricao) inserirObjeto(descricao);
            return d;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public Aplicacao cadastraAplicacao(Aplicacao aplicacao) {
        try {
            Aplicacao a;
            a = (Aplicacao) inserirObjeto(aplicacao);
            return a;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<Descricao> getDescricoesByProduto(Produto p) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery();
            Root<Descricao> from = query.from(Descricao.class);
            query.select(from);
            query.where(cb.equal(from.get(Descricao_.idProduto), p));
            List<Descricao> lista = (List<Descricao>) em.createQuery(query).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

    @Override
    public List<Aplicacao> getAplicacoesByProduto(Produto p) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery();
            Root<Aplicacao> from = query.from(Aplicacao.class);
            query.select(from);
            query.where(cb.equal(from.get(Aplicacao_.idProduto), p));
            List<Aplicacao> lista = (List<Aplicacao>) em.createQuery(query).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }

}
