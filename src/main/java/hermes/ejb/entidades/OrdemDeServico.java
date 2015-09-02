/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hermes.ejb.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author iury
 */
@Entity
@Table(name = "ordem_de_servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdemDeServico.findAll", query = "SELECT o FROM OrdemDeServico o"),
    @NamedQuery(name = "OrdemDeServico.findByIdOrdemServico", query = "SELECT o FROM OrdemDeServico o WHERE o.idOrdemServico = :idOrdemServico"),
    @NamedQuery(name = "OrdemDeServico.findByDthCriacao", query = "SELECT o FROM OrdemDeServico o WHERE o.dthCriacao = :dthCriacao"),
    @NamedQuery(name = "OrdemDeServico.findByDthFechamento", query = "SELECT o FROM OrdemDeServico o WHERE o.dthFechamento = :dthFechamento"),
    @NamedQuery(name = "OrdemDeServico.findByPago", query = "SELECT o FROM OrdemDeServico o WHERE o.pago = :pago"),
    @NamedQuery(name = "OrdemDeServico.findByValor", query = "SELECT o FROM OrdemDeServico o WHERE o.valor = :valor"),
    @NamedQuery(name = "OrdemDeServico.findByValorTotal", query = "SELECT o FROM OrdemDeServico o WHERE o.valorTotal = :valorTotal"),
    @NamedQuery(name = "OrdemDeServico.findByAcrescimo", query = "SELECT o FROM OrdemDeServico o WHERE o.acrescimo = :acrescimo"),
    @NamedQuery(name = "OrdemDeServico.findByObservacao", query = "SELECT o FROM OrdemDeServico o WHERE o.observacao = :observacao"),
    @NamedQuery(name = "OrdemDeServico.findByDesconto", query = "SELECT o FROM OrdemDeServico o WHERE o.desconto = :desconto"),
    @NamedQuery(name = "OrdemDeServico.findByJuros", query = "SELECT o FROM OrdemDeServico o WHERE o.juros = :juros"),
    @NamedQuery(name = "OrdemDeServico.findByDescricaoServico", query = "SELECT o FROM OrdemDeServico o WHERE o.descricaoServico = :descricaoServico"),
    @NamedQuery(name = "OrdemDeServico.findByDthVencimento", query = "SELECT o FROM OrdemDeServico o WHERE o.dthVencimento = :dthVencimento"),
    @NamedQuery(name = "OrdemDeServico.findByProblema", query = "SELECT o FROM OrdemDeServico o WHERE o.problema = :problema")})
public class OrdemDeServico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ordem_servico")
    private Long idOrdemServico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dth_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dthCriacao;
    @Column(name = "dth_fechamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dthFechamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pago")
    private boolean pago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Column(name = "acrescimo")
    private BigDecimal acrescimo;
    @Size(max = 2147483647)
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "desconto")
    private BigDecimal desconto;
    @Column(name = "juros")
    private BigDecimal juros;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao_servico")
    private String descricaoServico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dth_vencimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dthVencimento;
    @Size(max = 500)
    @Column(name = "problema")
    private String problema;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdemServico")
    private List<ParcelaOdemDeServico> parcelaOdemDeServicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdemServico")
    private List<ItemExternoOrdemServico> itemExternoOrdemServicoList;
    @JoinColumn(name = "id_vendedor", referencedColumnName = "id_vendedor")
    @ManyToOne(optional = false)
    private Vendedor idVendedor;
    @JoinColumn(name = "id_equipamento", referencedColumnName = "id_equipamento")
    @ManyToOne(optional = false)
    private Equipamento idEquipamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdemServico")
    private List<MecanicoOrdemServico> mecanicoOrdemServicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdemServico")
    private List<ItemOrdemServico> itemOrdemServicoList;

    public OrdemDeServico() {
    }

    public OrdemDeServico(Long idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }

    public OrdemDeServico(Long idOrdemServico, Date dthCriacao, boolean pago, BigDecimal valor, BigDecimal valorTotal, String descricaoServico, Date dthVencimento) {
        this.idOrdemServico = idOrdemServico;
        this.dthCriacao = dthCriacao;
        this.pago = pago;
        this.valor = valor;
        this.valorTotal = valorTotal;
        this.descricaoServico = descricaoServico;
        this.dthVencimento = dthVencimento;
    }

    public Long getIdOrdemServico() {
        return idOrdemServico;
    }

    public void setIdOrdemServico(Long idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }

    public Date getDthCriacao() {
        return dthCriacao;
    }

    public void setDthCriacao(Date dthCriacao) {
        this.dthCriacao = dthCriacao;
    }

    public Date getDthFechamento() {
        return dthFechamento;
    }

    public void setDthFechamento(Date dthFechamento) {
        this.dthFechamento = dthFechamento;
    }

    public boolean getPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(BigDecimal acrescimo) {
        this.acrescimo = acrescimo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getJuros() {
        return juros;
    }

    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public Date getDthVencimento() {
        return dthVencimento;
    }

    public void setDthVencimento(Date dthVencimento) {
        this.dthVencimento = dthVencimento;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    @XmlTransient
    public List<ParcelaOdemDeServico> getParcelaOdemDeServicoList() {
        return parcelaOdemDeServicoList;
    }

    public void setParcelaOdemDeServicoList(List<ParcelaOdemDeServico> parcelaOdemDeServicoList) {
        this.parcelaOdemDeServicoList = parcelaOdemDeServicoList;
    }

    @XmlTransient
    public List<ItemExternoOrdemServico> getItemExternoOrdemServicoList() {
        return itemExternoOrdemServicoList;
    }

    public void setItemExternoOrdemServicoList(List<ItemExternoOrdemServico> itemExternoOrdemServicoList) {
        this.itemExternoOrdemServicoList = itemExternoOrdemServicoList;
    }

    public Vendedor getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Vendedor idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Equipamento getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Equipamento idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    @XmlTransient
    public List<MecanicoOrdemServico> getMecanicoOrdemServicoList() {
        return mecanicoOrdemServicoList;
    }

    public void setMecanicoOrdemServicoList(List<MecanicoOrdemServico> mecanicoOrdemServicoList) {
        this.mecanicoOrdemServicoList = mecanicoOrdemServicoList;
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
        hash += (idOrdemServico != null ? idOrdemServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdemDeServico)) {
            return false;
        }
        OrdemDeServico other = (OrdemDeServico) object;
        if ((this.idOrdemServico == null && other.idOrdemServico != null) || (this.idOrdemServico != null && !this.idOrdemServico.equals(other.idOrdemServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.OrdemDeServico[ idOrdemServico=" + idOrdemServico + " ]";
    }
    
}
