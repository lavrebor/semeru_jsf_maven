package br.com.semeru.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author roberval
 */
@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable {
    
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue
    @Column(name="idpessoa",nullable=false)
    private Integer idPessoa;
    @Column(name="nome",nullable=false,length=80)
    private String nome;
    @Column(name="email",nullable=false,length=80)
    private String email;
    @Column(name="telefone",nullable=false,length=12)
    private String telefone;
    @Column(name="cpf",nullable=false,length=11)
    private String cpf;
    @Column(name="datanascimento",nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeNascimento;
    @Column(name="datacadastro",nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeCadastro;
    
    @OneToMany(mappedBy = "pessoa",fetch = FetchType.LAZY)
    @JoinColumn(name="PessoaSexo",
            foreignKey=@ForeignKey(value=ConstraintMode.CONSTRAINT,
            foreignKeyDefinition="FOREIGN KEY (idsexo) References sexo(idsexo)"))
    private List<Pessoa> pessoas;

    public Pessoa() {
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.idPessoa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.idPessoa, other.idPessoa);
    }
    
     
}
