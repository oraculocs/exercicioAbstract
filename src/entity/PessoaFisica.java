package entity;

public class PessoaFisica extends Contribuinte{
	
	private Double gastosSaude;
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	
	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	@Override
	public Double taxa() {
		
		double impostoBasico = 0;
		if(getRendaAnual() < 20000) {
			 impostoBasico = getRendaAnual() * 0.15;
		}else {
			impostoBasico = getRendaAnual() * 0.25;
		}
		
		impostoBasico = impostoBasico - getGastosSaude() * 0.5;
				
		if(impostoBasico < 0.0) {
			impostoBasico = 0.0;
		}
			
		return impostoBasico;
		
		
	}
	
	

}
