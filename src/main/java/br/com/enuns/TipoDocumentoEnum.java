package br.com.enuns;


public enum TipoDocumentoEnum {
	RG(1),
	CPF(2),
	CNH(3),
	CERTIDAO_NASCIMENTO(4);
	
	private Integer id;
	
	TipoDocumentoEnum(Integer id){
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	
	public static TipoDocumentoEnum getEnum(Integer id){
		for (TipoDocumentoEnum obj : TipoDocumentoEnum.values()) {
			if(obj.getId().equals(id)){
				return obj;
			}
		}
		return null;
	}
	
}
