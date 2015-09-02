/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hermes.ejb.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author iury
 */
@Entity
@Table(name = "produto_fabricado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdutoFabricado.findAll", query = "SELECT p FROM ProdutoFabricado p"),
    @NamedQuery(name = "ProdutoFabricado.findByIdProdutoFabricado", query = "SELECT p FROM ProdutoFabricado p WHERE p.idProdutoFabricado = :idProdutoFabricado"),
    @NamedQuery(name = "ProdutoFabricado.findByNome", query = "SELECT p FROM ProdutoFabricado p WHERE p.nome = :nome"),
    @NamedQuery(name = "ProdutoFabricado.findByDescricao", query = "SELECT p FROM ProdutoFabricado p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "ProdutoFabricado.findByFoto", query = "SELECT p FROM ProdutoFabricado p WHERE p.foto = :foto")})
public class ProdutoFabricado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produto_fabricado")
    private Long idProdutoFabricado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 2147483647)
    @Column(name = "foto")
    private String foto;
    @JoinColumn(name = "id_tipo_produto", referencedColumnName = "id_tipo_produto")
    @ManyToOne(optional = false)
    private TipoProduto idTipoProduto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProdutoFabricado")
    private List<ItemFabricadoOrdemVenda> itemFabricadoOrdemVendaList;
    @OneToMany(mappedBy = "idProdutoFabricado")
    private List<EstoqueProdutoFabricado> estoqueProdutoFabricadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProdutoFabricado")
    private List<OrdemDeFabricacao> ordemDeFabricacaoList;

    public ProdutoFabricado() {
    }

    public ProdutoFabricado(Long idProdutoFabricado) {
        this.idProdutoFabricado = idProdutoFabricado;
    }

    public ProdutoFabricado(Long idProdutoFabricado, String nome, String descricao) {
        this.idProdutoFabricado = idProdutoFabricado;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getIdProdutoFabricado() {
        return idProdutoFabricado;
    }

    public void setIdProdutoFabricado(Long idProdutoFabricado) {
        this.idProdutoFabricado = idProdutoFabricado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public TipoProduto getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(TipoProduto idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    @XmlTransient
    public List<ItemFabricadoOrdemVenda> getItemFabricadoOrdemVendaList() {
        return itemFabricadoOrdemVendaList;
    }

    public void setItemFabricadoOrdemVendaList(List<ItemFabricadoOrdemVenda> itemFabricadoOrdemVendaList) {
        this.itemFabricadoOrdemVendaList = itemFabricadoOrdemVendaList;
    }

    @XmlTransient
    public List<EstoqueProdutoFabricado> getEstoqueProdutoFabricadoList() {
        return estoqueProdutoFabricadoList;
    }

    public void setEstoqueProdutoFabricadoList(List<EstoqueProdutoFabricado> estoqueProdutoFabricadoList) {
        this.estoqueProdutoFabricadoList = estoqueProdutoFabricadoList;
    }

    @XmlTransient
    public List<OrdemDeFabricacao> getOrdemDeFabricacaoList() {
        return ordemDeFabricacaoList;
    }

    public void setOrdemDeFabricacaoList(List<OrdemDeFabricacao> ordemDeFabricacaoList) {
        this.ordemDeFabricacaoList = ordemDeFabricacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProdutoFabricado != null ? idProdutoFabricado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoFabricado)) {
            return false;
        }
        ProdutoFabricado other = (ProdutoFabricado) object;
        if ((this.idProdutoFabricado == null && other.idProdutoFabricado != null) || (this.idProdutoFabricado != null && !this.idProdutoFabricado.equals(other.idProdutoFabricado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.ProdutoFabricado[ idProdutoFabricado=" + idProdutoFabricado + " ]";
    }
    
}
