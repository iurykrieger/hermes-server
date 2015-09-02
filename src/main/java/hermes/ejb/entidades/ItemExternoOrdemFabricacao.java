/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hermes.ejb.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iury
 */
@Entity
@Table(name = "item_externo_ordem_fabricacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemExternoOrdemFabricacao.findAll", query = "SELECT i FROM ItemExternoOrdemFabricacao i"),
    @NamedQuery(name = "ItemExternoOrdemFabricacao.findByIdItemExternoOrdemFabricacao", query = "SELECT i FROM ItemExternoOrdemFabricacao i WHERE i.idItemExternoOrdemFabricacao = :idItemExternoOrdemFabricacao"),
    @NamedQuery(name = "ItemExternoOrdemFabricacao.findByQuantidade", query = "SELECT i FROM ItemExternoOrdemFabricacao i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "ItemExternoOrdemFabricacao.findByNome", query = "SELECT i FROM ItemExternoOrdemFabricacao i WHERE i.nome = :nome"),
    @NamedQuery(name = "ItemExternoOrdemFabricacao.findByDescricao", query = "SELECT i FROM ItemExternoOrdemFabricacao i WHERE i.descricao = :descricao"),
    @NamedQuery(name = "ItemExternoOrdemFabricacao.findByCusto", query = "SELECT i FROM ItemExternoOrdemFabricacao i WHERE i.custo = :custo"),
    @NamedQuery(name = "ItemExternoOrdemFabricacao.findByValorVenda", query = "SELECT i FROM ItemExternoOrdemFabricacao i WHERE i.valorVenda = :valorVenda")})
public class ItemExternoOrdemFabricacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item_externo_ordem_fabricacao")
    private Long idItemExternoOrdemFabricacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private BigDecimal quantidade;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "custo")
    private BigDecimal custo;
    @Column(name = "valor_venda")
    private BigDecimal valorVenda;
    @JoinColumn(name = "id_ordem_fabricacao", referencedColumnName = "id_ordem_fabricacao")
    @ManyToOne(optional = false)
    private OrdemDeFabricacao idOrdemFabricacao;
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id_fornecedor")
    @ManyToOne
    private Fornecedor idFornecedor;

    public ItemExternoOrdemFabricacao() {
    }

    public ItemExternoOrdemFabricacao(Long idItemExternoOrdemFabricacao) {
        this.idItemExternoOrdemFabricacao = idItemExternoOrdemFabricacao;
    }

    public ItemExternoOrdemFabricacao(Long idItemExternoOrdemFabricacao, BigDecimal quantidade, String nome, String descricao, BigDecimal custo) {
        this.idItemExternoOrdemFabricacao = idItemExternoOrdemFabricacao;
        this.quantidade = quantidade;
        this.nome = nome;
        this.descricao = descricao;
        this.custo = custo;
    }

    public Long getIdItemExternoOrdemFabricacao() {
        return idItemExternoOrdemFabricacao;
    }

    public void setIdItemExternoOrdemFabricacao(Long idItemExternoOrdemFabricacao) {
        this.idItemExternoOrdemFabricacao = idItemExternoOrdemFabricacao;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
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

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public OrdemDeFabricacao getIdOrdemFabricacao() {
        return idOrdemFabricacao;
    }

    public void setIdOrdemFabricacao(OrdemDeFabricacao idOrdemFabricacao) {
        this.idOrdemFabricacao = idOrdemFabricacao;
    }

    public Fornecedor getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Fornecedor idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItemExternoOrdemFabricacao != null ? idItemExternoOrdemFabricacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemExternoOrdemFabricacao)) {
            return false;
        }
        ItemExternoOrdemFabricacao other = (ItemExternoOrdemFabricacao) object;
        if ((this.idItemExternoOrdemFabricacao == null && other.idItemExternoOrdemFabricacao != null) || (this.idItemExternoOrdemFabricacao != null && !this.idItemExternoOrdemFabricacao.equals(other.idItemExternoOrdemFabricacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.ItemExternoOrdemFabricacao[ idItemExternoOrdemFabricacao=" + idItemExternoOrdemFabricacao + " ]";
    }
    
}
