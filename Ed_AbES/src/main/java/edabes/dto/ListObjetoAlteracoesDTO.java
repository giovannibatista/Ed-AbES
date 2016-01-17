package edabes.dto;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListObjetoAlteracoesDTO {

	private List<ObjetoAlteracoesDTO> dtoList;
	
	public ListObjetoAlteracoesDTO() {
	}

	public List<ObjetoAlteracoesDTO> getDtoList() {
		return dtoList;
	}

	public void setDtoList(List<ObjetoAlteracoesDTO> dtoList) {
		this.dtoList = dtoList;
	}
	
	
}
