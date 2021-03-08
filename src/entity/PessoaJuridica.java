package entity;

public class PessoaJuridica extends Contribuinte{
	
	private Integer numFuncionarios;

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer numFuncionarios) {
		super(nome, rendaAnual);
		this.numFuncionarios = numFuncionarios;
	}


	public Integer getNumFuncionarios() {
		return numFuncionarios;
	}

	public void setNumFuncionarios(Integer numFuncionarios) {
		this.numFuncionarios = numFuncionarios;
	}

	@Override
	public Double taxa() {
		double impostoBasico = 0;
		
		if(getNumFuncionarios() > 10) {
			impostoBasico = getRendaAnual() * 0.14;
		}else {
			impostoBasico = getRendaAnual() * 0.16;
			
		}
		
		return impostoBasico;
	}

}
