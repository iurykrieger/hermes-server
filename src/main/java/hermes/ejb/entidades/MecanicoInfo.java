/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hermes.ejb.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iury
 */
@Entity
@Table(name = "mecanico_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MecanicoInfo.findAll", query = "SELECT m FROM MecanicoInfo m"),
    @NamedQuery(name = "MecanicoInfo.findByIdMecanicoInfo", query = "SELECT m FROM MecanicoInfo m WHERE m.idMecanicoInfo = :idMecanicoInfo"),
    @NamedQuery(name = "MecanicoInfo.findByValorHora", query = "SELECT m FROM MecanicoInfo m WHERE m.valorHora = :valorHora"),
    @NamedQuery(name = "MecanicoInfo.findByIdAtivo", query = "SELECT m FROM MecanicoInfo m WHERE m.idAtivo = :idAtivo"),
    @NamedQuery(name = "MecanicoInfo.findByEndereco", query = "SELECT m FROM MecanicoInfo m WHERE m.endereco = :endereco"),
    @NamedQuery(name = "MecanicoInfo.findByTelefone", query = "SELECT m FROM MecanicoInfo m WHERE m.telefone = :telefone"),
    @NamedQuery(name = "MecanicoInfo.findByCelular", query = "SELECT m FROM MecanicoInfo m WHERE m.celular = :celular"),
    @NamedQuery(name = "MecanicoInfo.findByCargaHoraria", query = "SELECT m FROM MecanicoInfo m WHERE m.cargaHoraria = :cargaHoraria"),
    @NamedQuery(name = "MecanicoInfo.findByEnderecoDescricao", query = "SELECT m FROM MecanicoInfo m WHERE m.enderecoDescricao = :enderecoDescricao"),
    @NamedQuery(name = "MecanicoInfo.findByDthAlteracao", query = "SELECT m FROM MecanicoInfo m WHERE m.dthAlteracao = :dthAlteracao"),
    @NamedQuery(name = "MecanicoInfo.findByEmail", query = "SELECT m FROM MecanicoInfo m WHERE m.email = :email"),
    @NamedQuery(name = "MecanicoInfo.findByFoto", query = "SELECT m FROM MecanicoInfo m WHERE m.foto = :foto"),
    @NamedQuery(name = "MecanicoInfo.findByCidade", query = "SELECT m FROM MecanicoInfo m WHERE m.cidade = :cidade"),
    @NamedQuery(name = "MecanicoInfo.findByEstado", query = "SELECT m FROM MecanicoInfo m WHERE m.estado = :estado"),
    @NamedQuery(name = "MecanicoInfo.findByCep", query = "SELECT m FROM MecanicoInfo m WHERE m.cep = :cep")})
public class MecanicoInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mecanico_info")
    private Long idMecanicoInfo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_hora")
    private BigDecimal valorHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ativo")
    private boolean idAtivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "endereco")
    private String endereco;
    @Size(max = 200)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 200)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Column(name = "carga_horaria")
    private BigDecimal cargaHoraria;
    @Size(max = 2147483647)
    @Column(name = "endereco_descricao")
    private String enderecoDescricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dth_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dthAlteracao;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 500)
    @Column(name = "email")
    private String email;
    @Size(max = 2147483647)
    @Column(name = "foto")
    private String foto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "estado")
    private String estado;
    @Size(max = 200)
    @Column(name = "cep")
    private String cep;
    @JoinColumn(name = "id_mecanico", referencedColumnName = "id_mecanico")
    @ManyToOne(optional = false)
    private Mecanico idMecanico;

    public MecanicoInfo() {
    }

    public MecanicoInfo(Long idMecanicoInfo) {
        this.idMecanicoInfo = idMecanicoInfo;
    }

    public MecanicoInfo(Long idMecanicoInfo, BigDecimal valorHora, boolean idAtivo, String endereco, BigDecimal cargaHoraria, Date dthAlteracao, String cidade, String estado) {
        this.idMecanicoInfo = idMecanicoInfo;
        this.valorHora = valorHora;
        this.idAtivo = idAtivo;
        this.endereco = endereco;
        this.cargaHoraria = cargaHoraria;
        this.dthAlteracao = dthAlteracao;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Long getIdMecanicoInfo() {
        return idMecanicoInfo;
    }

    public void setIdMecanicoInfo(Long idMecanicoInfo) {
        this.idMecanicoInfo = idMecanicoInfo;
    }

    public BigDecimal getValorHora() {
        return valorHora;
    }

    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    public boolean getIdAtivo() {
        return idAtivo;
    }

    public void setIdAtivo(boolean idAtivo) {
        this.idAtivo = idAtivo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public BigDecimal getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(BigDecimal cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getEnderecoDescricao() {
        return enderecoDescricao;
    }

    public void setEnderecoDescricao(String enderecoDescricao) {
        this.enderecoDescricao = enderecoDescricao;
    }

    public Date getDthAlteracao() {
        return dthAlteracao;
    }

    public void setDthAlteracao(Date dthAlteracao) {
        this.dthAlteracao = dthAlteracao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Mecanico getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(Mecanico idMecanico) {
        this.idMecanico = idMecanico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMecanicoInfo != null ? idMecanicoInfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MecanicoInfo)) {
            return false;
        }
        MecanicoInfo other = (MecanicoInfo) object;
        if ((this.idMecanicoInfo == null && other.idMecanicoInfo != null) || (this.idMecanicoInfo != null && !this.idMecanicoInfo.equals(other.idMecanicoInfo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.MecanicoInfo[ idMecanicoInfo=" + idMecanicoInfo + " ]";
    }
    
}
