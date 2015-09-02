/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hermes.ejb.entidades;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "mecanico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mecanico.findAll", query = "SELECT m FROM Mecanico m"),
    @NamedQuery(name = "Mecanico.findByIdMecanico", query = "SELECT m FROM Mecanico m WHERE m.idMecanico = :idMecanico"),
    @NamedQuery(name = "Mecanico.findByNome", query = "SELECT m FROM Mecanico m WHERE m.nome = :nome"),
    @NamedQuery(name = "Mecanico.findByCpf", query = "SELECT m FROM Mecanico m WHERE m.cpf = :cpf"),
    @NamedQuery(name = "Mecanico.findBySexo", query = "SELECT m FROM Mecanico m WHERE m.sexo = :sexo"),
    @NamedQuery(name = "Mecanico.findByDataNascimento", query = "SELECT m FROM Mecanico m WHERE m.dataNascimento = :dataNascimento")})
public class Mecanico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mecanico")
    private Long idMecanico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMecanico")
    private List<MecanicoInfo> mecanicoInfoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMecanico")
    private List<MecanicoOrdemFabricacao> mecanicoOrdemFabricacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMecanico")
    private List<MecanicoOrdemServico> mecanicoOrdemServicoList;

    public Mecanico() {
    }

    public Mecanico(Long idMecanico) {
        this.idMecanico = idMecanico;
    }

    public Mecanico(Long idMecanico, String nome, String cpf, String sexo) {
        this.idMecanico = idMecanico;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public Long getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(Long idMecanico) {
        this.idMecanico = idMecanico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @XmlTransient
    public List<MecanicoInfo> getMecanicoInfoList() {
        return mecanicoInfoList;
    }

    public void setMecanicoInfoList(List<MecanicoInfo> mecanicoInfoList) {
        this.mecanicoInfoList = mecanicoInfoList;
    }

    @XmlTransient
    public List<MecanicoOrdemFabricacao> getMecanicoOrdemFabricacaoList() {
        return mecanicoOrdemFabricacaoList;
    }

    public void setMecanicoOrdemFabricacaoList(List<MecanicoOrdemFabricacao> mecanicoOrdemFabricacaoList) {
        this.mecanicoOrdemFabricacaoList = mecanicoOrdemFabricacaoList;
    }

    @XmlTransient
    public List<MecanicoOrdemServico> getMecanicoOrdemServicoList() {
        return mecanicoOrdemServicoList;
    }

    public void setMecanicoOrdemServicoList(List<MecanicoOrdemServico> mecanicoOrdemServicoList) {
        this.mecanicoOrdemServicoList = mecanicoOrdemServicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMecanico != null ? idMecanico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mecanico)) {
            return false;
        }
        Mecanico other = (Mecanico) object;
        if ((this.idMecanico == null && other.idMecanico != null) || (this.idMecanico != null && !this.idMecanico.equals(other.idMecanico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "hermes.ejb.entidades.Mecanico[ idMecanico=" + idMecanico + " ]";
        return this.getNome();
    }
    
}
