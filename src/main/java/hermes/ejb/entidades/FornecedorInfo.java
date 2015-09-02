/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hermes.ejb.entidades;

import java.io.Serializable;
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
@Table(name = "fornecedor_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FornecedorInfo.findAll", query = "SELECT f FROM FornecedorInfo f"),
    @NamedQuery(name = "FornecedorInfo.findByIdFornecedorInfo", query = "SELECT f FROM FornecedorInfo f WHERE f.idFornecedorInfo = :idFornecedorInfo"),
    @NamedQuery(name = "FornecedorInfo.findByEndereco", query = "SELECT f FROM FornecedorInfo f WHERE f.endereco = :endereco"),
    @NamedQuery(name = "FornecedorInfo.findByTelefone", query = "SELECT f FROM FornecedorInfo f WHERE f.telefone = :telefone"),
    @NamedQuery(name = "FornecedorInfo.findByCelular", query = "SELECT f FROM FornecedorInfo f WHERE f.celular = :celular"),
    @NamedQuery(name = "FornecedorInfo.findByDthAlteracao", query = "SELECT f FROM FornecedorInfo f WHERE f.dthAlteracao = :dthAlteracao"),
    @NamedQuery(name = "FornecedorInfo.findByIdAtivo", query = "SELECT f FROM FornecedorInfo f WHERE f.idAtivo = :idAtivo"),
    @NamedQuery(name = "FornecedorInfo.findBySkype", query = "SELECT f FROM FornecedorInfo f WHERE f.skype = :skype"),
    @NamedQuery(name = "FornecedorInfo.findByEmail", query = "SELECT f FROM FornecedorInfo f WHERE f.email = :email"),
    @NamedQuery(name = "FornecedorInfo.findByCidade", query = "SELECT f FROM FornecedorInfo f WHERE f.cidade = :cidade"),
    @NamedQuery(name = "FornecedorInfo.findByEstado", query = "SELECT f FROM FornecedorInfo f WHERE f.estado = :estado")})
public class FornecedorInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fornecedor_info")
    private Long idFornecedorInfo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 200)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dth_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dthAlteracao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ativo")
    private boolean idAtivo;
    @Size(max = 200)
    @Column(name = "skype")
    private String skype;
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
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id_fornecedor")
    @ManyToOne(optional = false)
    private Fornecedor idFornecedor;

    public FornecedorInfo() {
    }

    public FornecedorInfo(Long idFornecedorInfo) {
        this.idFornecedorInfo = idFornecedorInfo;
    }

    public FornecedorInfo(Long idFornecedorInfo, String endereco, String telefone, Date dthAlteracao, boolean idAtivo, String cidade, String estado) {
        this.idFornecedorInfo = idFornecedorInfo;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dthAlteracao = dthAlteracao;
        this.idAtivo = idAtivo;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Long getIdFornecedorInfo() {
        return idFornecedorInfo;
    }

    public void setIdFornecedorInfo(Long idFornecedorInfo) {
        this.idFornecedorInfo = idFornecedorInfo;
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

    public Date getDthAlteracao() {
        return dthAlteracao;
    }

    public void setDthAlteracao(Date dthAlteracao) {
        this.dthAlteracao = dthAlteracao;
    }

    public boolean getIdAtivo() {
        return idAtivo;
    }

    public void setIdAtivo(boolean idAtivo) {
        this.idAtivo = idAtivo;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
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

    public Fornecedor getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Fornecedor idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFornecedorInfo != null ? idFornecedorInfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FornecedorInfo)) {
            return false;
        }
        FornecedorInfo other = (FornecedorInfo) object;
        if ((this.idFornecedorInfo == null && other.idFornecedorInfo != null) || (this.idFornecedorInfo != null && !this.idFornecedorInfo.equals(other.idFornecedorInfo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.FornecedorInfo[ idFornecedorInfo=" + idFornecedorInfo + " ]";
    }
    
}
