package br.com.edabes.converter;

public interface Converter<M, D> {

    public D converteModelParaDTO(M model);

    public M converteDTOParaModel(D dto);

}
