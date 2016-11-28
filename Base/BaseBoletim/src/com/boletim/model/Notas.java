package com.boletim.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on 06/11/2016.
 */
@XmlRootElement
public class Notas {

    private Disciplina disciplina;
    private double nota_um;
    private double nota_dois;
    private double sub_um;
    private double sub_dois;
    private double nota_final;
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public double getNota_um() {
		return nota_um;
	}
	public void setNota_um(double nota_um) {
		this.nota_um = nota_um;
	}
	public double getNota_dois() {
		return nota_dois;
	}
	public void setNota_dois(double nota_dois) {
		this.nota_dois = nota_dois;
	}
	public double getSub_um() {
		return sub_um;
	}
	public void setSub_um(double sub_um) {
		this.sub_um = sub_um;
	}
	public double getSub_dois() {
		return sub_dois;
	}
	public void setSub_dois(double sub_dois) {
		this.sub_dois = sub_dois;
	}
	public double getNota_final() {
		return nota_final;
	}
	public void setNota_final(double nota_final) {
		this.nota_final = nota_final;
	}
	@Override
	public String toString() {
		return "Notas [disciplina=" + disciplina + ", nota_um=" + nota_um + ", nota_dois=" + nota_dois + ", sub_um="
				+ sub_um + ", sub_dois=" + sub_dois + ", nota_final=" + nota_final + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		long temp;
		temp = Double.doubleToLongBits(nota_dois);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(nota_final);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(nota_um);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sub_dois);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sub_um);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notas other = (Notas) obj;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (Double.doubleToLongBits(nota_dois) != Double.doubleToLongBits(other.nota_dois))
			return false;
		if (Double.doubleToLongBits(nota_final) != Double.doubleToLongBits(other.nota_final))
			return false;
		if (Double.doubleToLongBits(nota_um) != Double.doubleToLongBits(other.nota_um))
			return false;
		if (Double.doubleToLongBits(sub_dois) != Double.doubleToLongBits(other.sub_dois))
			return false;
		if (Double.doubleToLongBits(sub_um) != Double.doubleToLongBits(other.sub_um))
			return false;
		return true;
	}

    
    
    
}
