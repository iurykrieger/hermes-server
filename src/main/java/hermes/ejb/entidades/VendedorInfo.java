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
@Table(name = "vendedor_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VendedorInfo.findAll", query = "SELECT v FROM VendedorInfo v"),
    @NamedQuery(name = "VendedorInfo.findByIdVendedorInfo", query = "SELECT v FROM VendedorInfo v WHERE v.idVendedorInfo = :idVendedorInfo"),
    @NamedQuery(name = "VendedorInfo.findByEndereco", query = "SELECT v FROM VendedorInfo v WHERE v.endereco = :endereco"),
    @NamedQuery(name = "VendedorInfo.findByTelefone", query = "SELECT v FROM VendedorInfo v WHERE v.telefone = :telefone"),
    @NamedQuery(name = "VendedorInfo.findByEnderecoDescricao", query = "SELECT v FROM VendedorInfo v WHERE v.enderecoDescricao = :enderecoDescricao"),
    @NamedQuery(name = "VendedorInfo.findByCelular", query = "SELECT v FROM VendedorInfo v WHERE v.celular = :celular"),
    @NamedQuery(name = "VendedorInfo.findByIdAtivo", query = "SELECT v FROM VendedorInfo v WHERE v.idAtivo = :idAtivo"),
    @NamedQuery(name = "VendedorInfo.findByCargaHoraria", query = "SELECT v FROM VendedorInfo v WHERE v.cargaHoraria = :cargaHoraria"),
    @NamedQuery(name = "VendedorInfo.findByEmail", query = "SELECT v FROM VendedorInfo v WHERE v.email = :email"),
    @NamedQuery(name = "VendedorInfo.findByCidade", query = "SELECT v FROM VendedorInfo v WHERE v.cidade = :cidade"),
    @NamedQuery(name = "VendedorInfo.findByEstado", query = "SELECT v FROM VendedorInfo v WHERE v.estado = :estado"),
    @NamedQuery(name = "VendedorInfo.findByUsuario", query = "SELECT v FROM VendedorInfo v WHERE v.usuario = :usuario"),
    @NamedQuery(name = "VendedorInfo.findBySenha", query = "SELECT v FROM VendedorInfo v WHERE v.senha = :senha"),
    @NamedQuery(name = "VendedorInfo.findByFoto", query = "SELECT v FROM VendedorInfo v WHERE v.foto = :foto"),
    @NamedQuery(name = "VendedorInfo.findByCep", query = "SELECT v FROM VendedorInfo v WHERE v.cep = :cep"),
    @NamedQuery(name = "VendedorInfo.findByDthAlteracao", query = "SELECT v FROM VendedorInfo v WHERE v.dthAlteracao = :dthAlteracao")})
public class VendedorInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vendedor_info")
    private Long idVendedorInfo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 2147483647)
    @Column(name = "endereco_descricao")
    private String enderecoDescricao;
    @Size(max = 200)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ativo")
    private boolean idAtivo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "carga_horaria")
    private BigDecimal cargaHoraria;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 500)
    @Column(name = "email")
    private String email;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "senha")
    private String senha;
    @Size(max = 200)
    @Column(name = "foto")
    private String foto;
    @Size(max = 200)
    @Column(name = "cep")
    private String cep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dth_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dthAlteracao;
    @JoinColumn(name = "id_vendedor", referencedColumnName = "id_vendedor")
    @ManyToOne(optional = false)
    private Vendedor idVendedor;

    public VendedorInfo() {
    }

    public VendedorInfo(Long idVendedorInfo) {
        this.idVendedorInfo = idVendedorInfo;
    }

    public VendedorInfo(Long idVendedorInfo, String endereco, String telefone, boolean idAtivo, BigDecimal cargaHoraria, String cidade, String estado, String usuario, String senha, Date dthAlteracao) {
        this.idVendedorInfo = idVendedorInfo;
        this.endereco = endereco;
        this.telefone = telefone;
        this.idAtivo = idAtivo;
        this.cargaHoraria = cargaHoraria;
        this.cidade = cidade;
        this.estado = estado;
        this.usuario = usuario;
        this.senha = senha;
        this.dthAlteracao = dthAlteracao;
    }

    public Long getIdVendedorInfo() {
        return idVendedorInfo;
    }

    public void setIdVendedorInfo(Long idVendedorInfo) {
        this.idVendedorInfo = idVendedorInfo;
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

    public String getEnderecoDescricao() {
        return enderecoDescricao;
    }

    public void setEnderecoDescricao(String enderecoDescricao) {
        this.enderecoDescricao = enderecoDescricao;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean getIdAtivo() {
        return idAtivo;
    }

    public void setIdAtivo(boolean idAtivo) {
        this.idAtivo = idAtivo;
    }

    public BigDecimal getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(BigDecimal cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Date getDthAlteracao() {
        return dthAlteracao;
    }

    public void setDthAlteracao(Date dthAlteracao) {
        this.dthAlteracao = dthAlteracao;
    }

    public Vendedor getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Vendedor idVendedor) {
        this.idVendedor = idVendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVendedorInfo != null ? idVendedorInfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendedorInfo)) {
            return false;
        }
        VendedorInfo other = (VendedorInfo) object;
        if ((this.idVendedorInfo == null && other.idVendedorInfo != null) || (this.idVendedorInfo != null && !this.idVendedorInfo.equals(other.idVendedorInfo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.VendedorInfo[ idVendedorInfo=" + idVendedorInfo + " ]";
    }
    
}
