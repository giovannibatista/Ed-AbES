package br.com.edabes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "UPLOAD_ARQUIVO_AUDIOS")
public class Audio {

    @Id
    @Column(name = "ID_ARQUIVO_AUDIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UPLOAD_ARQUIVO_AUDIOS_SEQ")
    @SequenceGenerator(name = "UPLOAD_ARQUIVO_AUDIOS_SEQ", sequenceName = "UPLOAD_ARQUIVO_AUDIOS_SEQ", allocationSize = 1)
    private Integer id;

    @Column(name = "arquivo")
    private String arquivo;

    @Column(name = "descricao")
    private String descricao;

    public Audio() {

    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getArquivo() {
	return arquivo;
    }

    public void setArquivo(String arquivo) {
	this.arquivo = arquivo;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

}
