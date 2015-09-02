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
@Table(name = "ordem_de_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdemDeVenda.findAll", query = "SELECT o FROM OrdemDeVenda o"),
    @NamedQuery(name = "OrdemDeVenda.findByIdOrdemVenda", query = "SELECT o FROM OrdemDeVenda o WHERE o.idOrdemVenda = :idOrdemVenda"),
    @NamedQuery(name = "OrdemDeVenda.findByDthCriacao", query = "SELECT o FROM OrdemDeVenda o WHERE o.dthCriacao = :dthCriacao"),
    @NamedQuery(name = "OrdemDeVenda.findByDthFechamento", query = "SELECT o FROM OrdemDeVenda o WHERE o.dthFechamento = :dthFechamento"),
    @NamedQuery(name = "OrdemDeVenda.findByPago", query = "SELECT o FROM OrdemDeVenda o WHERE o.pago = :pago"),
    @NamedQuery(name = "OrdemDeVenda.findByValor", query = "SELECT o FROM OrdemDeVenda o WHERE o.valor = :valor"),
    @NamedQuery(name = "OrdemDeVenda.findByValorTotal", query = "SELECT o FROM OrdemDeVenda o WHERE o.valorTotal = :valorTotal"),
    @NamedQuery(name = "OrdemDeVenda.findByAcrescimo", query = "SELECT o FROM OrdemDeVenda o WHERE o.acrescimo = :acrescimo"),
    @NamedQuery(name = "OrdemDeVenda.findByObservacao", query = "SELECT o FROM OrdemDeVenda o WHERE o.observacao = :observacao"),
    @NamedQuery(name = "OrdemDeVenda.findByDesconto", query = "SELECT o FROM OrdemDeVenda o WHERE o.desconto = :desconto"),
    @NamedQuery(name = "OrdemDeVenda.findByJuros", query = "SELECT o FROM OrdemDeVenda o WHERE o.juros = :juros"),
    @NamedQuery(name = "OrdemDeVenda.findByDescricaoServico", query = "SELECT o FROM OrdemDeVenda o WHERE o.descricaoServico = :descricaoServico"),
    @NamedQuery(name = "OrdemDeVenda.findByDthVencimento", query = "SELECT o FROM OrdemDeVenda o WHERE o.dthVencimento = :dthVencimento")})
public class OrdemDeVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ordem_venda")
    private Long idOrdemVenda;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdemVenda")
    private List<ItemOrdemVenda> itemOrdemVendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdemVenda")
    private List<ItemFabricadoOrdemVenda> itemFabricadoOrdemVendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdemVenda")
    private List<ParcelaOrdemVenda> parcelaOrdemVendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdemVenda")
    private List<ItemExternoOrdemVenda> itemExternoOrdemVendaList;
    @JoinColumn(name = "id_vendedor", referencedColumnName = "id_vendedor")
    @ManyToOne(optional = false)
    private Vendedor idVendedor;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;

    public OrdemDeVenda() {
    }

    public OrdemDeVenda(Long idOrdemVenda) {
        this.idOrdemVenda = idOrdemVenda;
    }

    public OrdemDeVenda(Long idOrdemVenda, Date dthCriacao, boolean pago, BigDecimal valor, BigDecimal valorTotal, String descricaoServico, Date dthVencimento) {
        this.idOrdemVenda = idOrdemVenda;
        this.dthCriacao = dthCriacao;
        this.pago = pago;
        this.valor = valor;
        this.valorTotal = valorTotal;
        this.descricaoServico = descricaoServico;
        this.dthVencimento = dthVencimento;
    }

    public Long getIdOrdemVenda() {
        return idOrdemVenda;
    }

    public void setIdOrdemVenda(Long idOrdemVenda) {
        this.idOrdemVenda = idOrdemVenda;
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

    @XmlTransient
    public List<ItemOrdemVenda> getItemOrdemVendaList() {
        return itemOrdemVendaList;
    }

    public void setItemOrdemVendaList(List<ItemOrdemVenda> itemOrdemVendaList) {
        this.itemOrdemVendaList = itemOrdemVendaList;
    }

    @XmlTransient
    public List<ItemFabricadoOrdemVenda> getItemFabricadoOrdemVendaList() {
        return itemFabricadoOrdemVendaList;
    }

    public void setItemFabricadoOrdemVendaList(List<ItemFabricadoOrdemVenda> itemFabricadoOrdemVendaList) {
        this.itemFabricadoOrdemVendaList = itemFabricadoOrdemVendaList;
    }

    @XmlTransient
    public List<ParcelaOrdemVenda> getParcelaOrdemVendaList() {
        return parcelaOrdemVendaList;
    }

    public void setParcelaOrdemVendaList(List<ParcelaOrdemVenda> parcelaOrdemVendaList) {
        this.parcelaOrdemVendaList = parcelaOrdemVendaList;
    }

    @XmlTransient
    public List<ItemExternoOrdemVenda> getItemExternoOrdemVendaList() {
        return itemExternoOrdemVendaList;
    }

    public void setItemExternoOrdemVendaList(List<ItemExternoOrdemVenda> itemExternoOrdemVendaList) {
        this.itemExternoOrdemVendaList = itemExternoOrdemVendaList;
    }

    public Vendedor getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Vendedor idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdemVenda != null ? idOrdemVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdemDeVenda)) {
            return false;
        }
        OrdemDeVenda other = (OrdemDeVenda) object;
        if ((this.idOrdemVenda == null && other.idOrdemVenda != null) || (this.idOrdemVenda != null && !this.idOrdemVenda.equals(other.idOrdemVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.OrdemDeVenda[ idOrdemVenda=" + idOrdemVenda + " ]";
    }
    
}
