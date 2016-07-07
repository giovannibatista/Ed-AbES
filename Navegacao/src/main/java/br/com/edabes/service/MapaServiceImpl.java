package br.com.edabes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.edabes.converter.Converter;
import br.com.edabes.converter.MapaConverter;
import br.com.edabes.converter.MapaExportadoConverter;
import br.com.edabes.dao.MapaDAO;
import br.com.edabes.dao.MapaObjetoDAO;
import br.com.edabes.dto.MapaDTO;
import br.com.edabes.model.Mapa;
import br.com.edabes.model.MapaExportado;
import br.com.edabes.model.MapaObjeto;
import br.com.edabes.model.MapaObjetoExportado;
import br.com.edabes.utils.DateUtils;
import br.com.edabes.utils.FileUtils;

@Service
public class MapaServiceImpl implements MapaService {

    @Autowired
    private MapaDAO mapaDAO;

    @Autowired
    private MapaObjetoDAO mapaObjetoDAO;

    private Converter<Mapa, MapaDTO> mapaConverter;
    private Converter<MapaExportado, MapaDTO> mapaExportadoconverter;

    private final String mapaTreinamentoJson = "resources\\json\\mapaTreinamento.json";

    public MapaServiceImpl() {
	mapaConverter = new MapaConverter();
	mapaExportadoconverter = new MapaExportadoConverter();
    }

    public ArrayList<MapaDTO> listarMapas(MapaDTO mapaDTO) throws Exception {
	ArrayList<MapaDTO> mapasDTOs = new ArrayList<MapaDTO>();
	Mapa mapa = null;
	try {
	    mapa = mapaConverter.converteDTOParaModel(mapaDTO);
	    ArrayList<Mapa> mapasCriados = mapaDAO.listarMapasCriadosDoUsuario(mapa);

	    ArrayList<Mapa> mapasImportados = mapaDAO.listarMapasImportadosDoUsuario(mapa);

	    mapasCriados.forEach(m -> mapasDTOs.add(mapaConverter.converteModelParaDTO(m)));
	    mapasImportados.forEach(m -> mapasDTOs.add(mapaConverter.converteModelParaDTO(m)));

	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}
	return mapasDTOs;
    }

    public ArrayList<MapaDTO> listarMapasPublicos() throws Exception {
	ArrayList<MapaDTO> mapasDTOs = new ArrayList<MapaDTO>();
	try {
	    ArrayList<MapaExportado> mapas = mapaDAO.listarMapasPublicos();

	    mapas.forEach(m -> mapasDTOs.add(mapaExportadoconverter.converteModelParaDTO(m)));

	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}
	return mapasDTOs;
    }

    @Override
    public MapaDTO consultarMapa(MapaDTO consulta) {
	MapaDTO mapaDTO = new MapaDTO();
	try {
	    Mapa mapa = mapaDAO.consultarMapa(mapaConverter.converteDTOParaModel(consulta));
	    mapaDTO = mapaConverter.converteModelParaDTO(mapa);
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}
	return mapaDTO;
    }

    @Override
    public MapaDTO consultarMapaPublico(MapaDTO consulta) {
	MapaDTO mapaDTO = new MapaDTO();
	try {
	    MapaExportado mapa = mapaDAO.consultarMapaPublico(mapaExportadoconverter.converteDTOParaModel(consulta));
	    mapaDTO = mapaExportadoconverter.converteModelParaDTO(mapa);
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}
	return mapaDTO;
    }

    @Override
    public MapaDTO consultarMapaTreinamento() throws Exception {
	String mapa = "";
	MapaDTO mapaDTO = null;
	try {
	    FileUtils fileUtils = new FileUtils();
	    mapa = fileUtils.FileToString(mapaTreinamentoJson);
	    Gson gson = new Gson();
	    mapaDTO = gson.fromJson(mapa, MapaDTO.class);

	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}
	return mapaDTO;
    }

    @Override
    public void importarMapa(MapaDTO mapaDTO) {
	Mapa mapa = new Mapa();
	try {
	    mapa = mapaConverter.converteDTOParaModel(mapaDTO);
	    mapa.setNome(montaNomeMapaImportado(mapa.getNome()));
	    mapa.setId(0);

	    Integer idNovoMapa = mapaDAO.salvarMapa(mapa);
	    if (idNovoMapa > 0) {
		MapaObjetoExportado mapaObjeto = new MapaObjetoExportado();
		mapaObjeto.setIdMapa(mapaDTO.getId());

		List<MapaObjetoExportado> objetos = mapaObjetoDAO.carregarObjetosMapaPublico(mapaObjeto);
		for (MapaObjetoExportado mapaObjetoExportado : objetos) {

		    MapaObjeto objeto = new MapaObjeto();
		    objeto.setIdMapa(idNovoMapa);
		    objeto.setAltura(mapaObjetoExportado.getAltura());
		    objeto.setLargura(mapaObjetoExportado.getLargura());
		    objeto.setAngulo(mapaObjetoExportado.getAngulo());
		    objeto.setCoordenadaX(mapaObjetoExportado.getCoordenadaX());
		    objeto.setCoordenadaY(mapaObjetoExportado.getCoordenadaY());
		    objeto.setProfundidade(mapaObjetoExportado.getProfundidade());
		    objeto.setAudioDescricao(mapaObjetoExportado.getAudioDescricao());
		    objeto.setObjeto(mapaObjetoExportado.getObjeto());

		    mapaObjetoDAO.importarMapaObjeto(objeto);

		}

	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}

    }

    private String montaNomeMapaImportado(String nomeMapa) {
	String nomeMapaImportado = "";

	if (nomeMapa.length() < 70) {
	    nomeMapaImportado = nomeMapa + " importado em " + DateUtils.getDateFormatString();
	} else {
	    nomeMapaImportado = nomeMapa + DateUtils.getDateFormatString();
	}

	return nomeMapaImportado;
    }

}
