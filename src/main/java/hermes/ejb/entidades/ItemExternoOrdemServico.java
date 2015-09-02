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
@Table(name = "item_externo_ordem_servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemExternoOrdemServico.findAll", query = "SELECT i FROM ItemExternoOrdemServico i"),
    @NamedQuery(name = "ItemExternoOrdemServico.findByIdItemExternoOrdemServico", query = "SELECT i FROM ItemExternoOrdemServico i WHERE i.idItemExternoOrdemServico = :idItemExternoOrdemServico"),
    @NamedQuery(name = "ItemExternoOrdemServico.findByQuantidade", query = "SELECT i FROM ItemExternoOrdemServico i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "ItemExternoOrdemServico.findByNome", query = "SELECT i FROM ItemExternoOrdemServico i WHERE i.nome = :nome"),
    @NamedQuery(name = "ItemExternoOrdemServico.findByDescricao", query = "SELECT i FROM ItemExternoOrdemServico i WHERE i.descricao = :descricao"),
    @NamedQuery(name = "ItemExternoOrdemServico.findByCusto", query = "SELECT i FROM ItemExternoOrdemServico i WHERE i.custo = :custo"),
    @NamedQuery(name = "ItemExternoOrdemServico.findByValorVenda", query = "SELECT i FROM ItemExternoOrdemServico i WHERE i.valorVenda = :valorVenda")})
public class ItemExternoOrdemServico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item_externo_ordem_servico")
    private Long idItemExternoOrdemServico;
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
    @Size(max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "custo")
    private BigDecimal custo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_venda")
    private BigDecimal valorVenda;
    @JoinColumn(name = "id_ordem_servico", referencedColumnName = "id_ordem_servico")
    @ManyToOne(optional = false)
    private OrdemDeServico idOrdemServico;
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id_fornecedor")
    @ManyToOne(optional = false)
    private Fornecedor idFornecedor;

    public ItemExternoOrdemServico() {
    }

    public ItemExternoOrdemServico(Long idItemExternoOrdemServico) {
        this.idItemExternoOrdemServico = idItemExternoOrdemServico;
    }

    public ItemExternoOrdemServico(Long idItemExternoOrdemServico, BigDecimal quantidade, String nome, BigDecimal custo, BigDecimal valorVenda) {
        this.idItemExternoOrdemServico = idItemExternoOrdemServico;
        this.quantidade = quantidade;
        this.nome = nome;
        this.custo = custo;
        this.valorVenda = valorVenda;
    }

    public Long getIdItemExternoOrdemServico() {
        return idItemExternoOrdemServico;
    }

    public void setIdItemExternoOrdemServico(Long idItemExternoOrdemServico) {
        this.idItemExternoOrdemServico = idItemExternoOrdemServico;
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

    public OrdemDeServico getIdOrdemServico() {
        return idOrdemServico;
    }

    public void setIdOrdemServico(OrdemDeServico idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
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
        hash += (idItemExternoOrdemServico != null ? idItemExternoOrdemServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemExternoOrdemServico)) {
            return false;
        }
        ItemExternoOrdemServico other = (ItemExternoOrdemServico) object;
        if ((this.idItemExternoOrdemServico == null && other.idItemExternoOrdemServico != null) || (this.idItemExternoOrdemServico != null && !this.idItemExternoOrdemServico.equals(other.idItemExternoOrdemServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.ItemExternoOrdemServico[ idItemExternoOrdemServico=" + idItemExternoOrdemServico + " ]";
    }
    
}
