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
@Table(name = "tipo_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProduto.findAll", query = "SELECT t FROM TipoProduto t"),
    @NamedQuery(name = "TipoProduto.findByIdTipoProduto", query = "SELECT t FROM TipoProduto t WHERE t.idTipoProduto = :idTipoProduto"),
    @NamedQuery(name = "TipoProduto.findByDescricao", query = "SELECT t FROM TipoProduto t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "TipoProduto.findByAbreviacao", query = "SELECT t FROM TipoProduto t WHERE t.abreviacao = :abreviacao"),
    @NamedQuery(name = "TipoProduto.findByNome", query = "SELECT t FROM TipoProduto t WHERE t.nome = :nome")})
public class TipoProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_produto")
    private Long idTipoProduto;
    @Size(max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "abreviacao")
    private String abreviacao;
    @Size(max = 500)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoProduto")
    private List<Produto> produtoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoProduto")
    private List<ProdutoFabricado> produtoFabricadoList;
    @OneToMany(mappedBy = "idTipoProduto")
    private List<Equipamento> equipamentoList;

    public TipoProduto() {
    }

    public TipoProduto(Long idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public TipoProduto(Long idTipoProduto, String abreviacao) {
        this.idTipoProduto = idTipoProduto;
        this.abreviacao = abreviacao;
    }

    public Long getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(Long idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    @XmlTransient
    public List<ProdutoFabricado> getProdutoFabricadoList() {
        return produtoFabricadoList;
    }

    public void setProdutoFabricadoList(List<ProdutoFabricado> produtoFabricadoList) {
        this.produtoFabricadoList = produtoFabricadoList;
    }

    @XmlTransient
    public List<Equipamento> getEquipamentoList() {
        return equipamentoList;
    }

    public void setEquipamentoList(List<Equipamento> equipamentoList) {
        this.equipamentoList = equipamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoProduto != null ? idTipoProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProduto)) {
            return false;
        }
        TipoProduto other = (TipoProduto) object;
        if ((this.idTipoProduto == null && other.idTipoProduto != null) || (this.idTipoProduto != null && !this.idTipoProduto.equals(other.idTipoProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "hermes.ejb.entidades.TipoProduto[ idTipoProduto=" + idTipoProduto + " ]";
        return this.getNome();
    }
    
}
