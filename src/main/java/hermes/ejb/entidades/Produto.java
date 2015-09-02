/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hermes.ejb.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByIdProduto", query = "SELECT p FROM Produto p WHERE p.idProduto = :idProduto"),
    @NamedQuery(name = "Produto.findByNome", query = "SELECT p FROM Produto p WHERE p.nome = :nome"),
    @NamedQuery(name = "Produto.findByMedidaInterna", query = "SELECT p FROM Produto p WHERE p.medidaInterna = :medidaInterna"),
    @NamedQuery(name = "Produto.findByLocalizacao", query = "SELECT p FROM Produto p WHERE p.localizacao = :localizacao"),
    @NamedQuery(name = "Produto.findByCodigo", query = "SELECT p FROM Produto p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Produto.findByMedidaExterna", query = "SELECT p FROM Produto p WHERE p.medidaExterna = :medidaExterna"),
    @NamedQuery(name = "Produto.findByFoto", query = "SELECT p FROM Produto p WHERE p.foto = :foto")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produto")
    private Long idProduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nome")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "medida_interna")
    private BigDecimal medidaInterna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "localizacao")
    private String localizacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "medida_externa")
    private BigDecimal medidaExterna;
    @Size(max = 2147483647)
    @Column(name = "foto")
    private String foto;
    @JoinColumn(name = "id_unidade", referencedColumnName = "id_unidade")
    @ManyToOne(optional = false)
    private Unidade idUnidade;
    @JoinColumn(name = "id_tipo_produto", referencedColumnName = "id_tipo_produto")
    @ManyToOne(optional = false)
    private TipoProduto idTipoProduto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private List<Aplicacao> aplicacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private List<ItemOrdemVenda> itemOrdemVendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private List<Descricao> descricaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private List<ItemOrdemFabricacao> itemOrdemFabricacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private List<OrdemDeCompra> ordemDeCompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private List<Estoque> estoqueList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private List<ItemOrdemServico> itemOrdemServicoList;

    public Produto() {
    }

    public Produto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Produto(Long idProduto, String nome, String localizacao, String codigo) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.localizacao = localizacao;
        this.codigo = codigo;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getMedidaInterna() {
        return medidaInterna;
    }

    public void setMedidaInterna(BigDecimal medidaInterna) {
        this.medidaInterna = medidaInterna;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getMedidaExterna() {
        return medidaExterna;
    }

    public void setMedidaExterna(BigDecimal medidaExterna) {
        this.medidaExterna = medidaExterna;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Unidade getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Unidade idUnidade) {
        this.idUnidade = idUnidade;
    }

    public TipoProduto getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(TipoProduto idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    @XmlTransient
    public List<Aplicacao> getAplicacaoList() {
        return aplicacaoList;
    }

    public void setAplicacaoList(List<Aplicacao> aplicacaoList) {
        this.aplicacaoList = aplicacaoList;
    }

    @XmlTransient
    public List<ItemOrdemVenda> getItemOrdemVendaList() {
        return itemOrdemVendaList;
    }

    public void setItemOrdemVendaList(List<ItemOrdemVenda> itemOrdemVendaList) {
        this.itemOrdemVendaList = itemOrdemVendaList;
    }

    @XmlTransient
    public List<Descricao> getDescricaoList() {
        return descricaoList;
    }

    public void setDescricaoList(List<Descricao> descricaoList) {
        this.descricaoList = descricaoList;
    }

    @XmlTransient
    public List<ItemOrdemFabricacao> getItemOrdemFabricacaoList() {
        return itemOrdemFabricacaoList;
    }

    public void setItemOrdemFabricacaoList(List<ItemOrdemFabricacao> itemOrdemFabricacaoList) {
        this.itemOrdemFabricacaoList = itemOrdemFabricacaoList;
    }

    @XmlTransient
    public List<OrdemDeCompra> getOrdemDeCompraList() {
        return ordemDeCompraList;
    }

    public void setOrdemDeCompraList(List<OrdemDeCompra> ordemDeCompraList) {
        this.ordemDeCompraList = ordemDeCompraList;
    }

    @XmlTransient
    public List<Estoque> getEstoqueList() {
        return estoqueList;
    }

    public void setEstoqueList(List<Estoque> estoqueList) {
        this.estoqueList = estoqueList;
    }

    @XmlTransient
    public List<ItemOrdemServico> getItemOrdemServicoList() {
        return itemOrdemServicoList;
    }

    public void setItemOrdemServicoList(List<ItemOrdemServico> itemOrdemServicoList) {
        this.itemOrdemServicoList = itemOrdemServicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "hermes.ejb.entidades.Produto[ idProduto=" + idProduto + " ]";
        return this.getNome();
    }
    
}
