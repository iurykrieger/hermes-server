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
@Table(name = "equipamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipamento.findAll", query = "SELECT e FROM Equipamento e"),
    @NamedQuery(name = "Equipamento.findByIdEquipamento", query = "SELECT e FROM Equipamento e WHERE e.idEquipamento = :idEquipamento"),
    @NamedQuery(name = "Equipamento.findByNome", query = "SELECT e FROM Equipamento e WHERE e.nome = :nome"),
    @NamedQuery(name = "Equipamento.findByMarca", query = "SELECT e FROM Equipamento e WHERE e.marca = :marca"),
    @NamedQuery(name = "Equipamento.findByDescricao", query = "SELECT e FROM Equipamento e WHERE e.descricao = :descricao")})
public class Equipamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_equipamento")
    private Long idEquipamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nome")
    private String nome;
    @Size(max = 200)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "id_tipo_produto", referencedColumnName = "id_tipo_produto")
    @ManyToOne
    private TipoProduto idTipoProduto;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipamento")
    private List<OrdemDeServico> ordemDeServicoList;

    public Equipamento() {
    }

    public Equipamento(Long idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public Equipamento(Long idEquipamento, String nome, String descricao) {
        this.idEquipamento = idEquipamento;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Long idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoProduto getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(TipoProduto idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @XmlTransient
    public List<OrdemDeServico> getOrdemDeServicoList() {
        return ordemDeServicoList;
    }

    public void setOrdemDeServicoList(List<OrdemDeServico> ordemDeServicoList) {
        this.ordemDeServicoList = ordemDeServicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipamento != null ? idEquipamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipamento)) {
            return false;
        }
        Equipamento other = (Equipamento) object;
        if ((this.idEquipamento == null && other.idEquipamento != null) || (this.idEquipamento != null && !this.idEquipamento.equals(other.idEquipamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "hermes.ejb.entidades.Equipamento[ idEquipamento=" + idEquipamento + " ]";
        return this.getNome();
    }
    
}
